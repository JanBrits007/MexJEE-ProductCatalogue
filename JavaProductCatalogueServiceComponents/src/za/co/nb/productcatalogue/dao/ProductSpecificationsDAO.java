package za.co.nb.productcatalogue.dao;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import za.co.nb.productcatalogue.dto.ProductSpecificationHeadersListWrapperJSON;
import za.co.nb.productcatalogue.dto.ProductSpecificationJSON;

public class ProductSpecificationsDAO {

	private final Log mLog = LogFactory.getLog(getClass());
	//private static final String JNDI = "jdbc/bpmexdb";
	private static final String JNDI = "jdbc/productCatalogue";
	private static int mUniquenessCounter = 0;
	private static Map<String,ProductSpecificationJSON> psCache = new ConcurrentHashMap<String,ProductSpecificationJSON>();
	private static Map<String,ProductSpecificationHeadersListWrapperJSON> pshCache = new ConcurrentHashMap<String,ProductSpecificationHeadersListWrapperJSON>();
	private Object lookupObject(String pJNDI) throws NamingException {
		Object objref = null;
		Context vInitialContext = new InitialContext();
		try {
			objref = vInitialContext.lookup("cell/persistent/" + pJNDI);
		}
		catch(Exception e) {
			try {
				objref = vInitialContext.lookup("node/persistent/" + pJNDI);
			}
			catch(Exception e2) {
				objref = vInitialContext.lookup(pJNDI);					
			}
		}
		
		return objref;
	}
	
	private Connection getDBConnection() throws Exception {
		mLog.debug("Trace 1 >>" + JNDI + "<<");

		Connection vConnection = null;
		
		try {
			Object objref = lookupObject(JNDI);//mInitialContext.lookup(pJndiName);
			DataSource vDataSource = (DataSource)PortableRemoteObject.narrow(objref, DataSource.class);
			vConnection = vDataSource.getConnection();

			mLog.debug("Trace 2");
		} catch (Exception e) {
			mLog.error(e);
			throw e;
		}
		
		return vConnection;
	}
	
	private void cleanupConnection(Connection pConnection, ResultSet pResultSet, PreparedStatement pPreparedStatement) {
		try {
			if(pResultSet != null && !pResultSet.isClosed()) {
				pResultSet.close();
			}
			
			if(pPreparedStatement != null && !pPreparedStatement.isClosed()) {
				pPreparedStatement.close();
			}
			
			if(pConnection != null && !pConnection.isClosed()) {
				pConnection.close();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			mLog.error(e);
		}		
	}

	public String createProductSpecificationJSON(String pCustomerXML, String pName, String pLastName, Calendar pDateOfBirth, String pIDType, String pIDNumber, String pCustomerType, String pRequiredCustomerUID) throws Exception {
		PreparedStatement vPreparedStatement = null;
		ResultSet vResultSet = null;
		Connection vConnection = null;

		String vCustomerUID;
		
		if(pRequiredCustomerUID == null) {
			vCustomerUID = "" + (new Date().getTime() + mUniquenessCounter++);
		}
		else {
			vCustomerUID = pRequiredCustomerUID;
		}
		
		try {
			vConnection = getDBConnection();
			
			vPreparedStatement = vConnection.prepareStatement("insert into CUSTOMERS values (?,?,?,?,?,?,?,?)");
			vPreparedStatement.setString(1, vCustomerUID);
			vPreparedStatement.setString(2, pName);
			vPreparedStatement.setString(3, pLastName);
			
			if(pDateOfBirth != null) {
				vPreparedStatement.setDate(4, new java.sql.Date(pDateOfBirth.getTime().getTime()));				
			}
			else {
				vPreparedStatement.setDate(4, null);				
			}
			
			vPreparedStatement.setBytes(5, pCustomerXML.getBytes());
			vPreparedStatement.setString(6, pIDType);
			vPreparedStatement.setString(7, pIDNumber);
			vPreparedStatement.setString(8, pCustomerType);
			vPreparedStatement.execute();
		}
		catch(Exception e) {
			mLog.error(e);
			throw e;
		}
		finally {
			cleanupConnection(vConnection, vResultSet, vPreparedStatement);
		}
		
		return vCustomerUID;
	}

	private void populateDatabase() throws Exception {
		PreparedStatement vPreparedStatement = null;
		ResultSet vResultSet = null;
		Connection vConnection = null;

		try {
			vConnection = getDBConnection();
			
			vPreparedStatement = vConnection.prepareStatement("insert into PRODUCTSPECS values (?, ?, ?, ?, ?)");
			vPreparedStatement.setString(1, "123");
			vPreparedStatement.setString(2, "{'a':'aaa'}");
			vPreparedStatement.setString(3, "{'a':'aaa'}");
			vPreparedStatement.setString(4, "{'a':'aaa'}");
			vPreparedStatement.setString(5, "{'a':'aaa'}");
			vPreparedStatement.executeUpdate();
		}
		catch(Exception e) {
			mLog.error(e);
			throw e;
		}
		finally {
			cleanupConnection(vConnection, vResultSet, vPreparedStatement);
		}
	}
	
	public ProductSpecificationJSON getProductSpecificationJSONByID(String pProductSpecificationID) throws Exception {
		mLog.debug("Trace 1 >>" + pProductSpecificationID + "<<");

		if(pProductSpecificationID.equalsIgnoreCase("create")) {
			populateDatabase();
			return null;
		}
		if(psCache.containsKey(pProductSpecificationID)){
			mLog.debug("using cached ProductSpecificationJSON value for " + pProductSpecificationID);
			return psCache.get(pProductSpecificationID);
		}
		PreparedStatement vPreparedStatement = null;
		ResultSet vResultSet = null;
		Connection vConnection = null;
		String vProductSpecificationHeaderJSON = "";
		String vProductSpecificationDetailsJSON = "";
		
		try {
			vConnection = getDBConnection();
			
			vPreparedStatement = vConnection.prepareStatement("select JSONHEADER, JSONDETAILS from PRODUCTSPECS where ID = ?");
			vPreparedStatement.setString(1, pProductSpecificationID);
			vResultSet = vPreparedStatement.executeQuery();
			
			if(vResultSet != null && vResultSet.next()) {
				Clob vClob = vResultSet.getClob("JSONHEADER");
				vProductSpecificationHeaderJSON =  vClob.getSubString(1,(int)vClob.length());

				vClob = vResultSet.getClob("JSONDETAILS");
				vProductSpecificationDetailsJSON =  vClob.getSubString(1,(int)vClob.length());
			}
		}
		catch(Exception e) {
			mLog.error(e);
			throw e;
		}
		finally {
			cleanupConnection(vConnection, vResultSet, vPreparedStatement);
		}
		
		mLog.debug("Trace 2");
		mLog.debug("Trace 3 >>" + vProductSpecificationHeaderJSON.length() + "<<");
		mLog.debug("Trace 4 >>" + vProductSpecificationHeaderJSON + "<<");
		mLog.debug("Trace 5 >>" + vProductSpecificationDetailsJSON.length() + "<<");
		mLog.debug("Trace 6 >>" + vProductSpecificationDetailsJSON + "<<");
		
		ProductSpecificationJSON vProductSpecificationJSON = new ProductSpecificationJSON();
		vProductSpecificationJSON.setHeader(vProductSpecificationHeaderJSON);
		vProductSpecificationJSON.setmDetails(vProductSpecificationDetailsJSON);
		psCache.put(pProductSpecificationID, vProductSpecificationJSON);
		return vProductSpecificationJSON;
	}


	public ProductSpecificationHeadersListWrapperJSON getProductSpecificationJSONHeadersByParentCategoryID(String pParentCategoryID) throws Exception {
		mLog.debug("Trace 1 >>" + pParentCategoryID + "<<");
		if(pshCache.containsKey(pParentCategoryID)){
			return pshCache.get(pParentCategoryID);
		}
		PreparedStatement vPreparedStatement = null;
		ResultSet vResultSet = null;
		Connection vConnection = null;

		ProductSpecificationHeadersListWrapperJSON vProductSpecificationHeadersListWrapperJSON = new ProductSpecificationHeadersListWrapperJSON();
		
		try {
			vConnection = getDBConnection();
			
			vPreparedStatement = vConnection.prepareStatement("SELECT PRODUCTSPECS.JSONHEADER FROM PRODCATINDEX, PRODUCTSPECS WHERE PRODCATINDEX.CATID = ? AND PRODCATINDEX.PRODSPECID = PRODUCTSPECS.ID");
			vPreparedStatement.setString(1, pParentCategoryID);
			vResultSet = vPreparedStatement.executeQuery();

			mLog.debug("Trace 1.1");
			
			while(vResultSet != null && vResultSet.next()) {
				mLog.debug("Trace 1.2");
				
				Clob vClob = vResultSet.getClob("JSONHEADER");
				String vProductSpecificationHeaderJSON =  vClob.getSubString(1,(int)vClob.length());

				vProductSpecificationHeadersListWrapperJSON.getHeaders().add(vProductSpecificationHeaderJSON);
			}
		}
		catch(Exception e) {
			mLog.error(e);
			throw e;
		}
		finally {
			cleanupConnection(vConnection, vResultSet, vPreparedStatement);
		}
		
		mLog.debug("Trace 2");
		mLog.debug("Trace 3 >>" + vProductSpecificationHeadersListWrapperJSON + "<<");
		pshCache.put(pParentCategoryID,vProductSpecificationHeadersListWrapperJSON);
		return vProductSpecificationHeadersListWrapperJSON;
	}
	
	public void maintainProductSpecificationJSON(String pCustomerUID, String pCustomerXML, String pName, String pLastName, Calendar pDateOfBirth, String pIDType, String pIDNumber, String pCustomerType) throws Exception, Throwable {
		mLog.debug("Trace 1 >>" + pCustomerUID + "<<,>>" + pName + "<<,>>" + pLastName + "<<,>>" + pDateOfBirth + "<<,>>" + pIDType + "<<,>>" + pIDNumber + "<<,>>" + pCustomerType + "<<,>>" + pCustomerXML + "<<");
		PreparedStatement vPreparedStatement = null;
		ResultSet vResultSet = null;
		Connection vConnection = null;

		mLog.debug("Trace 2");

		if(pDateOfBirth != null) {
			mLog.debug("Trace 2.1 >>" + pCustomerUID + "<<,>>" + pName + "<<,>>" + pLastName + "<<,>>" + pDateOfBirth.getTimeInMillis() + "<<,>>" + pIDType + "<<,>>" + pIDNumber + "<<,>>" + pCustomerType + "<<");
		}
		else {
			mLog.debug("Trace 2.1 >>" + pCustomerUID + "<<,>>" + pName + "<<,>>" + pLastName + "<<,>>" + pIDType + "<<,>>" + pIDNumber + "<<,>>" + pCustomerType + "<<");			
		}
		
		mLog.debug("Trace 2.2 >>" + pCustomerXML.length() + "<<");
		mLog.debug("Trace 2.3 >>" + pCustomerXML + "<<");

		try {
			mLog.debug("Trace 3");
			vConnection = getDBConnection();
			
			mLog.debug("Trace 4");
			vPreparedStatement = vConnection.prepareStatement("update CUSTOMERS set NAME=?, LAST_NAME=?, DATE_OF_BIRTH=?, DATA=?, ID_TYPE=?, ID_NUMBER=?, CUSTOMER_TYPE=? where UID=?");
			mLog.debug("Trace 5");
			vPreparedStatement.setString(1, pName);
			mLog.debug("Trace 6");
			vPreparedStatement.setString(2, pLastName);
			mLog.debug("Trace 7");
			
			if(pDateOfBirth != null) {
				vPreparedStatement.setDate(3, new java.sql.Date(pDateOfBirth.getTime().getTime()));				
			}
			else {
				vPreparedStatement.setDate(3, null);				
			}

			mLog.debug("Trace 8");
			vPreparedStatement.setBytes(4, pCustomerXML.getBytes());
			mLog.debug("Trace 9");
			vPreparedStatement.setString(5, pIDType);
			mLog.debug("Trace 10");
			vPreparedStatement.setString(6, pIDNumber);
			mLog.debug("Trace 11");
			vPreparedStatement.setString(7, pCustomerType);
			mLog.debug("Trace 12");
			vPreparedStatement.setString(8, pCustomerUID);
			mLog.debug("Trace 13");
			vPreparedStatement.executeUpdate();
			mLog.debug("Trace 14");
		}
		catch(Throwable e) {
			mLog.error(e);
			throw e;
		}
		finally {
			mLog.debug("Trace 12");
			cleanupConnection(vConnection, vResultSet, vPreparedStatement);
		}
		mLog.debug("Trace 13");
	}
	
	public void debugDatabaseContents() {
		PreparedStatement vPreparedStatement = null;
		ResultSet vResultSet = null;
		Connection vConnection = null;
		int count = 0;
		
		try {
			mLog.debug("PRODUCTSPECS TABLE CONTENTS ARE :");
			
			vConnection = getDBConnection();
			
			String vSQL = "select * from PRODUCTSPECS"; 
			
			vPreparedStatement = vConnection.prepareStatement(vSQL);
			vResultSet = vPreparedStatement.executeQuery();
			
			if(vResultSet != null && vResultSet.next()) {
				mLog.debug("ProductSpecification[" + count++ + "]: " + vResultSet.getString(1) + "," + vResultSet.getString(2) + "," + vResultSet.getString(3) + "," + vResultSet.getString(4));
			}
		}
		catch(Exception e) {
			mLog.error(e);
		}
		finally {
			cleanupConnection(vConnection, vResultSet, vPreparedStatement);
		}
	}
}
