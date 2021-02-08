package za.co.nb.productcatalogue.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ArrangementMetricsDAO {

	private final Log mLog = LogFactory.getLog(getClass());
	
	// We use the same database as product catalogue.
	private static final String JNDI = "jdbc/productCatalogue";

	private static final String SQL_CASEID_BY_ARRANGEMENT_ID = "SELECT CASEID FROM BPMF.CASEMI WHERE ARRID1=? " +
			"UNION " +
			"SELECT CASEID FROM BPMF.CASEMI WHERE ARRID2=? " +
			"UNION " +
			"SELECT CASEID FROM BPMF.CASEMI WHERE ARRID3=? " +
			"UNION " +
			"SELECT CASEID FROM BPMF.CASEMI WHERE ARRID4=? " +
			"UNION " +
			"SELECT CASEID FROM BPMF.CASEMI WHERE ARRID5=? " +
			"UNION " +
			"SELECT CASEID FROM BPMF.CASEMI WHERE ARRID6=? ";


	private static Map<String, String> arrangementsToCaseIDCacheMap = new HashMap<String, String>();
	
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
	
	private Connection getDBConnection() throws Exception {
		mLog.debug("Trace 1 >>" + JNDI + "<<");

		Connection vConnection = null;
		
		try {
			mLog.debug("Trace 2");

			Object objref = lookupObject(JNDI);;
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
	
	public String retrieveCaseIDByArrangementID(String arrangementID) throws Exception {
		mLog.debug("Trace 1.0 >>" + arrangementID + "<<,>>" + arrangementsToCaseIDCacheMap.keySet().size() + "<<");

		// First check whether the mapping is in the in-memory cache.
		String caseID = arrangementsToCaseIDCacheMap.get(arrangementID);

		mLog.debug("Trace 1.1 >>" + caseID + "<<");
		
		if(caseID != null) {
			mLog.debug("Trace 1.2 >>" + caseID + "<<");
			// Found it in the cache.
			return caseID;
		}
		
		PreparedStatement vPreparedStatement = null;
		ResultSet vResultSet = null;
		Connection vConnection = null;

		try {
			mLog.debug("Trace 2");

			vConnection = getDBConnection();
			
			mLog.debug("Trace 3");
			
			vPreparedStatement = vConnection.prepareStatement(SQL_CASEID_BY_ARRANGEMENT_ID);
			vPreparedStatement.setString(1, arrangementID);
			vPreparedStatement.setString(2, arrangementID);
			vPreparedStatement.setString(3, arrangementID);
			vPreparedStatement.setString(4, arrangementID);
			vPreparedStatement.setString(5, arrangementID);
			vPreparedStatement.setString(6, arrangementID);
			vResultSet = vPreparedStatement.executeQuery();

			mLog.debug("Trace 4");

			if(vResultSet.next()) {
				String dbCaseID = vResultSet.getString("CASEID");
				
				mLog.debug("Trace 5 >>" + arrangementID + "<<,>>" + dbCaseID + "<<");
				
				// Put the case ID in the map.
				arrangementsToCaseIDCacheMap.put(arrangementID, dbCaseID);
				
				return dbCaseID;
			}
		}
		finally {
			mLog.debug("Trace 6");
			cleanupConnection(vConnection, vResultSet, vPreparedStatement);			
		}
		
		// Problem.
		mLog.debug("Trace 7");

		return null;
	}
}
