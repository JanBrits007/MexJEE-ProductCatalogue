package za.co.nb.productcatalogue.dao;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import za.co.nb.productcatalogue.dto.ProductCatalogueJSON;

public class ProductCataloguesDAO {

	private final Log mLog = LogFactory.getLog(getClass());
	//private static final String JNDI = "jdbc/bpmexdb";
	private static final String JNDI = "jdbc/productCatalogue";

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

	private void populateDatabase() throws Exception {
		PreparedStatement vPreparedStatement = null;
		ResultSet vResultSet = null;
		Connection vConnection = null;

		try {
			vConnection = getDBConnection();
			
			vPreparedStatement = vConnection.prepareStatement("insert into PRODCATALOGUES values (?, ?, ?)");
			vPreparedStatement.setString(1, "SALESCAT1");
			vPreparedStatement.setString(2, "{'a':'aaa'}");
			vPreparedStatement.setString(3, "{'a':'aaa'}");
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
	
	public String getProductCatalogueJSONByID(String pProductCatalogueID) throws Exception {
		mLog.debug("Trace 1 >>" + pProductCatalogueID + "<<");

		if(pProductCatalogueID.equalsIgnoreCase("create")) {
			populateDatabase();
			return null;
		}
		
		PreparedStatement vPreparedStatement = null;
		ResultSet vResultSet = null;
		Connection vConnection = null;
		String vProductCatalogueDetailsJSON = "";
		
		try {
			vConnection = getDBConnection();
			
			vPreparedStatement = vConnection.prepareStatement("select JSONDETAILS from PRODCATALOGUES where ID = ?");
			vPreparedStatement.setString(1, pProductCatalogueID);
			vResultSet = vPreparedStatement.executeQuery();
			
			if(vResultSet != null && vResultSet.next()) {
				Clob vClob = vResultSet.getClob("JSONDETAILS");
				vProductCatalogueDetailsJSON =  vClob.getSubString(1,(int)vClob.length());
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
		mLog.debug("Trace 3 >>" + vProductCatalogueDetailsJSON.length() + "<<");
		
		ProductCatalogueJSON vProductCatalogueJSON = new ProductCatalogueJSON();
		vProductCatalogueJSON.setCatalogue(vProductCatalogueDetailsJSON.toString());
		
		return vProductCatalogueDetailsJSON;
	}
}
