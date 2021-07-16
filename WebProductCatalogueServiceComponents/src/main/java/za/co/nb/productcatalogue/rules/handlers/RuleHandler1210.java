package za.co.nb.productcatalogue.rules.handlers;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import za.co.nb.productcatalogue.exceptions.BusinessRuleExecutionException;

public class RuleHandler1210 extends BaseProductSpecificationRuleHandler {

	private final Log mLog = LogFactory.getLog(getClass());

    private Object lookupObject(String pJNDI) throws NamingException {
        mLog.debug("Trace 1");

        Object objref = null;
        Context vInitialContext = new InitialContext();
        try {
            mLog.debug("Trace 2");

            objref = vInitialContext.lookup("cell/persistent/" + pJNDI);
        } catch (Exception e) {
            mLog.debug("Trace 3");

            try {
                mLog.debug("Trace 4");

                objref = vInitialContext.lookup("node/persistent/" + pJNDI);
            } catch (Exception e2) {
                mLog.debug("Trace 5");

                objref = vInitialContext.lookup(pJNDI);
            }
        }

        mLog.debug("Trace 6");

        return objref;
    }
	
	@Override
	public String executeBusinessRules(String productIDToSubstitute, String caseID) throws BusinessRuleExecutionException {
		mLog.debug("Trace 1 >>" + productIDToSubstitute + "<<,>>" + caseID + "<<");
        return productIDToSubstitute;

	}

}
