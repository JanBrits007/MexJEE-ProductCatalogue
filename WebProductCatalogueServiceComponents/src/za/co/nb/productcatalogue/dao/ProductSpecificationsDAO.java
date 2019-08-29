package za.co.nb.productcatalogue.dao;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.sql.DataSource;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;

import za.co.nb.productcatalogue.config.Environment;
import za.co.nb.productcatalogue.dto.ProductSpecificationHeadersListWrapperJSON;
import za.co.nb.productcatalogue.dto.ProductSpecificationJSON;

public class ProductSpecificationsDAO {

	private final Log mLog = LogFactory.getLog(getClass());
	// private static final String JNDI = "jdbc/CSSBPMS";
	private static final String JNDI = "jdbc/productCatalogue";
	private static int mUniquenessCounter = 0;
	private URL url = null;
	private InputStream inputStream = null;
	private String path = "/za/co/nb/productcatalogue";

	private Object lookupObject(String pJNDI) throws NamingException {
		Object objref = null;
		Context vInitialContext = new InitialContext();
		try {
			objref = vInitialContext.lookup("cell/persistent/" + pJNDI);
		} catch (Exception e) {
			try {
				objref = vInitialContext.lookup("node/persistent/" + pJNDI);
			} catch (Exception e2) {
				objref = vInitialContext.lookup(pJNDI);
			}
		}

		return objref;
	}

	private Connection getDBConnection() throws Exception {
		mLog.debug("Trace 1 >>" + JNDI + "<<");

		Connection vConnection = null;

		try {
			Object objref = lookupObject(JNDI);// mInitialContext.lookup(pJndiName);
			DataSource vDataSource = (DataSource) PortableRemoteObject.narrow(
					objref, DataSource.class);
			vConnection = vDataSource.getConnection();

			mLog.debug("Trace 2");
		} catch (Exception e) {
			mLog.error(e);
			throw e;
		}

		return vConnection;
	}

	private void cleanupConnection(Connection pConnection,
			ResultSet pResultSet, PreparedStatement pPreparedStatement) {
		try {
			if (pResultSet != null && !pResultSet.isClosed()) {
				pResultSet.close();
			}

			if (pPreparedStatement != null && !pPreparedStatement.isClosed()) {
				pPreparedStatement.close();
			}

			if (pConnection != null && !pConnection.isClosed()) {
				pConnection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			mLog.error(e);
		}
	}

	public String createProductSpecificationJSON(String pCustomerXML,
			String pName, String pLastName, Calendar pDateOfBirth,
			String pIDType, String pIDNumber, String pCustomerType,
			String pRequiredCustomerUID) throws Exception {
		PreparedStatement vPreparedStatement = null;
		ResultSet vResultSet = null;
		Connection vConnection = null;

		String vCustomerUID;

		if (pRequiredCustomerUID == null) {
			vCustomerUID = "" + (new Date().getTime() + mUniquenessCounter++);
		} else {
			vCustomerUID = pRequiredCustomerUID;
		}

		try {
			vConnection = getDBConnection();

			vPreparedStatement = vConnection
					.prepareStatement("insert into CUSTOMERS values (?,?,?,?,?,?,?,?)");
			vPreparedStatement.setString(1, vCustomerUID);
			vPreparedStatement.setString(2, pName);
			vPreparedStatement.setString(3, pLastName);

			if (pDateOfBirth != null) {
				vPreparedStatement.setDate(4, new java.sql.Date(pDateOfBirth
						.getTime().getTime()));
			} else {
				vPreparedStatement.setDate(4, null);
			}

			vPreparedStatement.setBytes(5, pCustomerXML.getBytes());
			vPreparedStatement.setString(6, pIDType);
			vPreparedStatement.setString(7, pIDNumber);
			vPreparedStatement.setString(8, pCustomerType);
			vPreparedStatement.execute();
		} catch (Exception e) {
			mLog.error(e);
			throw e;
		} finally {
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

			vPreparedStatement = vConnection
					.prepareStatement("insert into PRODUCTSPECS values (?, ?, ?, ?, ?)");
			vPreparedStatement.setString(1, "123");
			vPreparedStatement.setString(2, "{'a':'aaa'}");
			vPreparedStatement.setString(3, "{'a':'aaa'}");
			vPreparedStatement.setString(4, "{'a':'aaa'}");
			vPreparedStatement.setString(5, "{'a':'aaa'}");
			vPreparedStatement.executeUpdate();
		} catch (Exception e) {
			mLog.error(e);
			throw e;
		} finally {
			cleanupConnection(vConnection, vResultSet, vPreparedStatement);
		}
	}

	public String getProductSpecificationJSONByID(String pProductSpecificationID)
			throws Exception {
		mLog.debug("Trace 1 >>" + pProductSpecificationID + "<<");

		if (pProductSpecificationID.equalsIgnoreCase("create")) {
			populateDatabase();
			return null;
		}

		PreparedStatement vPreparedStatement = null;
		ResultSet vResultSet = null;
		Connection vConnection = null;
		String vProductSpecificationHeaderJSON = "";
		String vProductSpecificationDetailsJSON = "";
		if(pProductSpecificationID.equalsIgnoreCase("all")){
			
			String result=getProductSpecAllJson(pProductSpecificationID);
			return result;
		
		}else if(pProductSpecificationID.equalsIgnoreCase("allxml")){
			
			String result=getProductSpecAllXml(pProductSpecificationID);
			return result;
		}
		else if(pProductSpecificationID.contains("xmlid")){
			String xmlString = null;
			try {
				vConnection = getDBConnection();

				vPreparedStatement = vConnection
						.prepareStatement("select XMLDETAILS from PRODUCTSPECS where ID = ?");
				String id = pProductSpecificationID.replaceAll("xmlid","").trim(); 
				vPreparedStatement.setString(1,id);
				vResultSet = vPreparedStatement.executeQuery();

				if (vResultSet != null && vResultSet.next()) {

					Clob vClob = vResultSet.getClob("XMLDETAILS");
					xmlString = vClob.getSubString(1,
							(int) vClob.length());
					
				}
				return xmlString;
			} catch (Exception e) {
				mLog.error(e);
				throw e;
			} finally {
				cleanupConnection(vConnection, vResultSet, vPreparedStatement);
			}
			
		}
		else{

		if (Environment.useDB) {
			try {
				vConnection = getDBConnection();

				vPreparedStatement = vConnection
						.prepareStatement("select JSONDETAILS from PRODUCTSPECS where ID = ?");
				vPreparedStatement.setString(1, pProductSpecificationID);
				vResultSet = vPreparedStatement.executeQuery();

				if (vResultSet != null && vResultSet.next()) {

					Clob vClob = vResultSet.getClob("JSONDETAILS");
					vProductSpecificationDetailsJSON = vClob.getSubString(1,
							(int) vClob.length());
				}
			} catch (Exception e) {
				mLog.error(e);
				throw e;
			} finally {
				cleanupConnection(vConnection, vResultSet, vPreparedStatement);
			}
		} else {
			try {
				/*inputStream = this.getClass().getResourceAsStream(path+"/productspecs/jsonfiles/"+pProductSpecificationID+".json");	
				
				
				vProductSpecificationDetailsJSON= IOUtils.toString(inputStream);*/

				// vProductCatalogueDetailsJSON= IOUtils.toString(inputStream);
				 String jsonpath = "/WEB-INF/productspecs/"+pProductSpecificationID+".json";
					InputStream jsonobj = JSONObject.class.getResourceAsStream(jsonpath);
					
					
					
					vProductSpecificationDetailsJSON = IOUtils.toString(jsonobj);
				//vProductSpecificationDetailsJSON = IOUtils.toString(is);
			} catch (Exception e) {
				mLog.error(e.getMessage());
				e.printStackTrace();
				throw e;
			}
		}

		mLog.debug("Trace 2");
		mLog.debug("Trace 3 >>" + vProductSpecificationHeaderJSON.length()
				+ "<<");
		mLog.debug("Trace 4 >>" + vProductSpecificationHeaderJSON + "<<");
		mLog.debug("Trace 5 >>" + vProductSpecificationDetailsJSON.length()
				+ "<<");
		mLog.debug("Trace 6 >>" + vProductSpecificationDetailsJSON + "<<");

		ProductSpecificationJSON vProductSpecificationJSON = new ProductSpecificationJSON();
		vProductSpecificationJSON.setHeader(vProductSpecificationHeaderJSON);
		vProductSpecificationJSON.setmDetails(vProductSpecificationDetailsJSON);

		return vProductSpecificationDetailsJSON;}
	}

	public void maintainProductSpecificationJSON(String pCustomerUID,
			String pCustomerXML, String pName, String pLastName,
			Calendar pDateOfBirth, String pIDType, String pIDNumber,
			String pCustomerType) throws Exception, Throwable {
		mLog.debug("Trace 1 >>" + pCustomerUID + "<<,>>" + pName + "<<,>>"
				+ pLastName + "<<,>>" + pDateOfBirth + "<<,>>" + pIDType
				+ "<<,>>" + pIDNumber + "<<,>>" + pCustomerType + "<<,>>"
				+ pCustomerXML + "<<");
		PreparedStatement vPreparedStatement = null;
		ResultSet vResultSet = null;
		Connection vConnection = null;

		mLog.debug("Trace 2");

		if (pDateOfBirth != null) {
			mLog.debug("Trace 2.1 >>" + pCustomerUID + "<<,>>" + pName
					+ "<<,>>" + pLastName + "<<,>>"
					+ pDateOfBirth.getTimeInMillis() + "<<,>>" + pIDType
					+ "<<,>>" + pIDNumber + "<<,>>" + pCustomerType + "<<");
		} else {
			mLog.debug("Trace 2.1 >>" + pCustomerUID + "<<,>>" + pName
					+ "<<,>>" + pLastName + "<<,>>" + pIDType + "<<,>>"
					+ pIDNumber + "<<,>>" + pCustomerType + "<<");
		}

		mLog.debug("Trace 2.2 >>" + pCustomerXML.length() + "<<");
		mLog.debug("Trace 2.3 >>" + pCustomerXML + "<<");

		try {
			mLog.debug("Trace 3");
			vConnection = getDBConnection();

			mLog.debug("Trace 4");
			vPreparedStatement = vConnection
					.prepareStatement("update CUSTOMERS set NAME=?, LAST_NAME=?, DATE_OF_BIRTH=?, DATA=?, ID_TYPE=?, ID_NUMBER=?, CUSTOMER_TYPE=? where UID=?");
			mLog.debug("Trace 5");
			vPreparedStatement.setString(1, pName);
			mLog.debug("Trace 6");
			vPreparedStatement.setString(2, pLastName);
			mLog.debug("Trace 7");

			if (pDateOfBirth != null) {
				vPreparedStatement.setDate(3, new java.sql.Date(pDateOfBirth
						.getTime().getTime()));
			} else {
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
		} catch (Throwable e) {
			mLog.error(e);
			throw e;
		} finally {
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

			if (vResultSet != null && vResultSet.next()) {
				mLog.debug("ProductSpecification[" + count++ + "]: "
						+ vResultSet.getString(1) + ","
						+ vResultSet.getString(2) + ","
						+ vResultSet.getString(3) + ","
						+ vResultSet.getString(4));
			}
		} catch (Exception e) {
			mLog.error(e);
		} finally {
			cleanupConnection(vConnection, vResultSet, vPreparedStatement);
		}
	}
	
	public String getProductSpecAllJson(String id)
			throws Exception, FileNotFoundException{
		mLog.debug("Trace 1 >> <<");
        PreparedStatement vPreparedStatement = null;
		ResultSet vResultSet = null;
		Connection vConnection = null;
		String vProductCatalogueDetailsJSON = "";

		  try {
				vConnection = getDBConnection();

				vPreparedStatement = vConnection
						.prepareStatement("select ID,JSONDETAILS  from PRODUCTSPECS");
		 vResultSet = vPreparedStatement.executeQuery();
				 Map<String,String> arr = new HashMap<String,String>();
				 JSONObject json = null;
				if (vResultSet != null && vResultSet.next()) {
					String vClob = vResultSet.getString("JSONDETAILS");
					
					vProductCatalogueDetailsJSON = vClob;
					String fileContent = vProductCatalogueDetailsJSON;
				    
				    while(vResultSet.next()){
						String jsonnew = vResultSet.getString("JSONDETAILS").toString();
					  String jsonid = vResultSet.getString("ID");
						arr.put(jsonid,jsonnew);
						}
				   String mapString = convertToString(arr);
				    return mapString;
				    }
		  }catch (Exception e) {
				mLog.error(e.getMessage());
				e.printStackTrace();
				throw e;
			} 
		  finally {
				cleanupConnection(vConnection, vResultSet, vPreparedStatement);
			}
		 return  vProductCatalogueDetailsJSON;
		 }
	
	public String getProductSpecAllXml(String id)
			throws Exception, FileNotFoundException{
		mLog.debug("Trace 1 >> <<");
        PreparedStatement vPreparedStatement = null;
		ResultSet vResultSet = null;
		Connection vConnection = null;
		String vProductCatalogueDetailsXML = "";

		  try {
				vConnection = getDBConnection();

				vPreparedStatement = vConnection
						.prepareStatement("select ID,XMLDETAILS  from PRODUCTSPECS");
		 vResultSet = vPreparedStatement.executeQuery();
				 Map<String,String> arr = new HashMap<String,String>();
				 JSONObject json = null;
				if (vResultSet != null && vResultSet.next()) {
					String vClob = vResultSet.getString("XMLDETAILS");
					
					vProductCatalogueDetailsXML = vClob;
					String fileContent = vProductCatalogueDetailsXML;
				    
				    while(vResultSet.next()){
						String xmlnew = vResultSet.getString("XMLDETAILS").toString();
					  String xmlid = vResultSet.getString("ID");
						arr.put(xmlid,xmlnew);
						}
				   String mapString = convertToString(arr);
				    return mapString;
				    }
		  }catch (Exception e) {
				mLog.error(e.getMessage());
				e.printStackTrace();
				throw e;
			} 
		  finally {
				cleanupConnection(vConnection, vResultSet, vPreparedStatement);
			}
		 return  vProductCatalogueDetailsXML;
		 }
	
	public String convertToString(Map<String,String> map) {
		StringBuilder mapAsString = new StringBuilder("{");
	    for (String key : map.keySet()) {
	        mapAsString.append(key + "=" + map.get(key) + ", ");
	    }
	    mapAsString.delete(mapAsString.length()-2, mapAsString.length()).append("}");
	    return mapAsString.toString();
	}
}
