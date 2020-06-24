package za.co.nb.system.config.plm.environment;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJBHome;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.sql.DataSource;

import za.co.nb.system.config.plm.environment.ServiceLocator;
import za.co.nb.system.config.environment.ServiceLocatorException;



/**
 * @author staigerr
 *
 */
public class ServiceLocator {
	
	private static final String IIOP_ADDRESS_LIST_KEY_SUFFIX = "IIOPAddressList";	
	private static final String CSS_FW_IIOP_ADDRESS_LIST_KEY = "CSSFramework" + IIOP_ADDRESS_LIST_KEY_SUFFIX;
	private static ServiceLocator mServiceLocator;
	private static final boolean mCacheEnabled = true;
	
	private Map mCache = Collections.synchronizedMap(new HashMap());
	private InitialContext mInitialContext = null;
	//private transient Log mLog = LogService.getLogger(getClass());
	
	//private String mIIOPAddressList = null;
	
	/**
	 * @throws ServiceLocatorException
	 */
	private ServiceLocator() throws ServiceLocatorException {
		try {
			mInitialContext = new InitialContext();
		} catch(NamingException ne) {
			throw new ServiceLocatorException("Unable to create InitialContext");
		}
	}
	
	/**
	 * Returns the instance of ServiceLocator class
	 * 
	 * @return
	 * @throws ServiceLocatorException
	 */
	public static ServiceLocator getInstance() throws ServiceLocatorException {
		if (mServiceLocator == null) {
			mServiceLocator = new ServiceLocator();
		}
		
		return mServiceLocator;
	}

	private InitialContext getInitialContext() throws Exception {
		//mLog.debug("Trace 1");
		if(mInitialContext == null) {
			//mLog.debug("Trace 2 - Using cached initial context");
			mInitialContext = new InitialContext();
		}
		
		//mLog.debug("Trace 3");
		return mInitialContext;
	}
	
	public Object lookupObject(String pJNDI) throws NamingException {
		Object objref = null;
		try {
			objref = mInitialContext.lookup("cell/persistent/" + pJNDI);
		}
		catch(Exception e) {
			try {
				objref = mInitialContext.lookup("node/persistent/" + pJNDI);
			}
			catch(Exception e2) {
				objref = mInitialContext.lookup(pJNDI);				
			}
		}
		
		return objref;
	}
	
	private String getIIOPAddressList(String pUID) throws ServiceLocatorException {
		//mLog.debug("Trace 1");
		try {
			String vIIOPAddressList = null;
			
			// First we check whether there is a specific address list for this BD.
			Object objref;
			
			try {
				objref = getInitialContext().lookup(pUID + IIOP_ADDRESS_LIST_KEY_SUFFIX);
			} catch (NamingException e) {
				try {
					objref = getInitialContext().lookup(CSS_FW_IIOP_ADDRESS_LIST_KEY);
				}
				catch(NamingException ne) {
					// We can't lookup the IIOP address list, so we'll assume that an indirect is defined.
					return "";
				}
			}
			
			vIIOPAddressList = (String)PortableRemoteObject.narrow(objref, String.class);
	
			//mLog.debug("Trace 1 - IIOPAddressList for >>" + pUID + "<< is >>" + vIIOPAddressList + "<<");;

			return vIIOPAddressList;
		}
		catch(Exception e) {
			//e.printStackTrace();
			//mLog.error(e);
			throw new ServiceLocatorException("Unable to determine IIOP address list for >>" + pUID + "<<");
		}
	}
	
	/**
	 * Returns the DataSource object for requested JNDI name
	 * Throws ServiceLocatorException If Any Error 
	 * occurs in lookup
	 * 
	 * @param pJndiName
	 * @return
	 * @throws ServiceLocatorException
	 */
	public DataSource getDataSource(String pJndiName) throws ServiceLocatorException {
		//mLog.debug("Trace 1 - JNDIName is >>" + pJndiName + "<<");
		DataSource vDataSource = null;
		
		try {
			if(mCacheEnabled) {
				// Look in the cache for the service class.
				vDataSource = (DataSource)mCache.get(pJndiName);
			//	mLog.debug("Trace 2 - Datasource returned from cache is >>" + vDataSource + "<<");
			}
			
			if(vDataSource == null) {
				Object objref = lookupObject(pJndiName);//mInitialContext.lookup(pJndiName);
				vDataSource = (DataSource)PortableRemoteObject.narrow(objref, DataSource.class);
				
				if(mCacheEnabled) {
				//	mLog.debug("Trace 3 - Putting datasource in cache");
					mCache.put(pJndiName, vDataSource);
				}
			}
			
			return vDataSource;
		} catch(NamingException ex) {
			throw new ServiceLocatorException("Unable to locate Data Source for >>" + pJndiName + "<<");
		}
	}
	
	/**
	 * Returns the EJBHome object for requested service 
	 * pClass. Throws ServiceLocatorException If Any Error 
	 * occurs in lookup
	 * @param pJndiHomeName
	 * @param pClass
	 * @return
	 * @throws ServiceLocatorException
	 */
	public EJBHome getRemoteHome(String pUID, Class pClass) throws ServiceLocatorException {
		//mLog.debug("Trace 1 - UID is >>" + pUID + "<<");
		EJBHome vEJBHome = null;
		
		try {
			if(mCacheEnabled) {
				// Look in the cache for the service class.
				vEJBHome = (EJBHome)mCache.get(pUID);
			//	mLog.debug("Trace 2 - EJB Home returned from cache is >>" + vEJBHome + "<<");
			}
			
			if(vEJBHome == null) {
				String vJNDI = "CSS" + getIIOPAddressList(pUID) + pUID + "Home";
				//mLog.debug("Trace 1 - Looking up remote home for >>" + pUID + "<< at >>" + vJNDI + "<<");;

				Object objref = lookupObject(vJNDI);//mInitialContext.lookup("cell/persistent/" + vJNDI);
				
				vEJBHome = (EJBHome)PortableRemoteObject.narrow(objref, pClass);
				
				if(mCacheEnabled) {
					mCache.put(pUID, vEJBHome);
				}
			}
			
			return vEJBHome;
		} catch(NamingException ex) {
			//mLog.error(ex);//ex.printStackTrace();
			throw new ServiceLocatorException("Unable to locate REMOTE EJB Home for >>" + pUID + "<<");
		}
	}
	
	public String getString(String jndiName) throws ServiceLocatorException {

		String stringBinding = null;
		try {
			/*if(mCacheEnabled) {
				stringBinding = (String) mCache.get(jndiName);
			}
			*/
			if(stringBinding == null) {
				Object objref = lookupObject(jndiName);
				stringBinding = (String) PortableRemoteObject.narrow(objref, String.class);
				
				/*if(mCacheEnabled) {
					mCache.put(jndiName, stringBinding);
				}*/
			}
			
			return stringBinding;
		} catch(NamingException ex) {
			throw new ServiceLocatorException("Unable to locate String Binding for >>" + jndiName + "<<");
		}
	}
	
	public String getServiceString(String serviceStr) throws ServiceLocatorException {
		serviceStr = "service/" + serviceStr;
		return getString(serviceStr);
		
	}
/*
	public EJBHome getLocalHome(String pUID) throws ServiceLocatorException {
		EJBHome vEJBHome = null;
		
		try {
			if(mCacheEnabled) {
				// Look in the cache for the service class.
				vEJBHome = (EJBHome)mCache.get(pUID);
			}

			if(vEJBHome == null) {
				LocalHumanTaskManagerHome taskHome = (LocalHumanTaskManagerHome)mInitialContext.lookup("java:comp/env/ejb/LocalHumanTaskManagerHome");
				
				
				
				String vJNDI = "java:comp/env/ejb/css/" + pUID + "Home"; //java:comp/env/ejb/HumanTaskManagerHome
				Object objref = mInitialContext.lookup(vJNDI);
				vEJBHome = (EJBHome)objref;
				//vEJBHome = (EJBHome)PortableRemoteObject.narrow(objref, pClass);				
			}
			
			return vEJBHome;
		} catch(NamingException ex) {
			mLog.error(ex);//ex.printStackTrace();
			throw new ServiceLocatorException("Unable to locate LOCAL EJB Home for >>" + pUID + "<<");
		}
	}
*/	
}