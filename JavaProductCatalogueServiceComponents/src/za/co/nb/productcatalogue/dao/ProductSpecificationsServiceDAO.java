package za.co.nb.productcatalogue.dao;

import java.io.ByteArrayInputStream;
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
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import za.co.nb.productcatalogue.dto.ProductSpecificationJSON;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ProductType;

public class ProductSpecificationsServiceDAO {

	private final Log mLog = LogFactory.getLog(getClass());
	//private static final String JNDI = "jdbc/CSSBPMS"; 
	private static final String JNDI = "jdbc/productCatalogue";
	private static int mUniquenessCounter = 0;
	private static Map<Integer,ProductType> ptCache = new ConcurrentHashMap<Integer,ProductType>();
	
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
	
	public ProductType  getProductSpecificationXMLByID(int pProductSpecificationID) throws Exception {
		mLog.debug("Trace 1 >>" + pProductSpecificationID + "<<");
		if(ptCache.containsKey(pProductSpecificationID)){
			return ptCache.get(pProductSpecificationID);
		}
		
		PreparedStatement vPreparedStatement = null;
		ResultSet vResultSet = null;
		Connection vConnection = null;
		za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ObjectFactory objectFactory = new za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ObjectFactory(); 
		mLog.debug("Trace 2 >>" + pProductSpecificationID + "<<");
		ProductType prdType = objectFactory.createProductType();
		try {
			vConnection = getDBConnection();
			
			vPreparedStatement = vConnection.prepareStatement("select XMLHEADER, XMLDETAILS from PRODUCTSPECS where ID = ?");
			vPreparedStatement.setInt(1, pProductSpecificationID);
			vResultSet = vPreparedStatement.executeQuery();
			mLog.debug("Trace 3 >>");
			if(vResultSet != null && vResultSet.next()) {
				Clob vClob = vResultSet.getClob("XMLDETAILS");
				String xmlString =  vClob.getSubString(1,(int)vClob.length());
				mLog.debug("Trace 2 >>" + xmlString + "<<");
				JAXBContext jaxbContext = JAXBContext.newInstance("za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1");
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				Object schemaObject = JAXBIntrospector.getValue(unmarshaller.unmarshal(new ByteArrayInputStream(xmlString.getBytes())));
				
				prdType = (ProductType)schemaObject;				
			}
		}
		catch(Exception e) {
			//mLog.error(e);
			mLog.debug("Exception from product cache"+e);
			throw e;
		}
		finally {
			cleanupConnection(vConnection, vResultSet, vPreparedStatement);
		}
		ptCache.put(pProductSpecificationID, prdType);
		return prdType;
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
