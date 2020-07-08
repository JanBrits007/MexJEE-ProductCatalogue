package za.co.nb.productcatalogue.cases.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import za.co.nb.onboarding.casemanagement.dto.BusinessCaseHeader;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.sql.DataSource;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class BusinessCaseDAO {

	private final Log mLog = LogFactory.getLog(getClass());
	private static final boolean useDBCache = true;
	private static final String JNDI = "jdbc/productCatalogue";
	
	private static Map<String, BusinessCaseHeader> businessCaseCache = new HashMap<String, BusinessCaseHeader>();
	

	public BusinessCaseHeader retrieveBusinessCase(String caseID) {
		mLog.debug("Trace 1 >>" + caseID + "<<");

		if(!useDBCache) {
			return businessCaseCache.get(caseID);
		}
		else {
			try {
				return retrieveCachedBusinessCaseDetailsFromDB(caseID);
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	private Connection getDBConnection() throws Exception {
		mLog.debug("Trace 1 >>" + JNDI + "<<");

		Connection vConnection = null;
		
		try {
			mLog.debug("Trace 2");

			Object objref = lookupObject(JNDI);//mInitialContext.lookup(pJndiName);
			DataSource vDataSource = (DataSource)PortableRemoteObject.narrow(objref, DataSource.class);
			vConnection = vDataSource.getConnection();

			mLog.debug("Trace 3");
		} catch (Exception e) {
			mLog.error(e);
			throw e;
		}
		
		mLog.debug("Trace 4");
		
		return vConnection;
	}
	
	private void cleanupConnection(Connection pConnection, ResultSet pResultSet, PreparedStatement pPreparedStatement) {
		mLog.debug("Trace 1");

		try {
			if(pResultSet != null && !pResultSet.isClosed()) {
				mLog.debug("Trace 2");
				pResultSet.close();
			}
			
			if(pPreparedStatement != null && !pPreparedStatement.isClosed()) {
				mLog.debug("Trace 3");
				pPreparedStatement.close();
			}
			
			if(pConnection != null && !pConnection.isClosed()) {
				mLog.debug("Trace 4");
				pConnection.close();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			mLog.error(e);
		}		
		
		mLog.debug("Trace 5");
	}

	private Object lookupObject(String pJNDI) throws NamingException {
		mLog.debug("Trace 1");

		Object objref = null;
		Context vInitialContext = new InitialContext();
		try {
			mLog.debug("Trace 2");

			objref = vInitialContext.lookup("cell/persistent/" + pJNDI);
		}
		catch(Exception e) {
			mLog.debug("Trace 3");

			try {
				mLog.debug("Trace 4");

				objref = vInitialContext.lookup("node/persistent/" + pJNDI);
			}
			catch(Exception e2) {
				mLog.debug("Trace 5");
				
				objref = vInitialContext.lookup(pJNDI);					
			}
		}

		mLog.debug("Trace 6");
		
		return objref;
	}

	private BusinessCaseHeader retrieveCachedBusinessCaseDetailsFromDB(String caseID) throws Exception {
		mLog.debug("Trace 1");

		PreparedStatement vPreparedStatement = null;
		ResultSet vResultSet = null;
		Connection vConnection = null;

		Object result = null;

		try {
			mLog.debug("Trace 2");

			vConnection = getDBConnection();

			mLog.debug("Trace 3");

			try {
				mLog.debug("Trace 4");

				vPreparedStatement = vConnection.prepareStatement("select CASEDETS from CASECACHE where TXID = ? WITH UR");
				vPreparedStatement.setString(1, caseID);
				vResultSet = vPreparedStatement.executeQuery();

				if(vResultSet != null && vResultSet.next()) {
					Clob vClob = vResultSet.getClob("CASEDETS");
					String JSON =  vClob.getSubString(1,(int)vClob.length());

					mLog.debug("Trace 5 >>" + JSON + "<<");

					// Unmarshall the response to the object.
					ObjectMapper objectMapper = new ObjectMapper();
					result = objectMapper.readValue(JSON, BusinessCaseHeader.class);
				}
				else {
					// Nothing cached.
				}
			}
			catch(Exception e) {
				mLog.debug("Trace 7");
				e.printStackTrace();
			}
		}
		catch(Exception e) {
			mLog.debug("Trace 8");
			mLog.error(e);
			throw e;
		}
		finally {
			mLog.debug("Trace 9");

			cleanupConnection(vConnection, vResultSet, vPreparedStatement);
		}

		mLog.debug("Trace 10");

		return (BusinessCaseHeader)result;
	}
	

}
