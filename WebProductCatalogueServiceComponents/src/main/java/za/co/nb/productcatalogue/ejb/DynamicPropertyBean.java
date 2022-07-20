package za.co.nb.productcatalogue.ejb;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import za.co.nb.common.error.PropertyNotFoundException;
import za.co.nb.system.config.property.dto.PropertyResponse;
import za.co.nb.system.config.property.service.PropertyServiceRemote;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.naming.InitialContext;

@Stateless
@TransactionAttribute(TransactionAttributeType.NEVER)
public class DynamicPropertyBean {

    private static final Log mLog = LogFactory.getLog(DynamicPropertyBean.class);

    private PropertyServiceRemote propertyServiceRemote;


    public String getProperty(String key){
        mLog.debug("find key:"+key);
        try {
            if (propertyServiceRemote == null) {
                InitialContext context = new InitialContext();
                try {
                    propertyServiceRemote = (PropertyServiceRemote) context.lookup("java:global/SysSystemConfigurator/WebSystemConfigurator/PropertyServiceBean!za.co.nb.system.config.property.service.PropertyServiceRemote");
                } catch (Exception e) {
                    propertyServiceRemote = (PropertyServiceRemote) context.lookup("java:global/SysIndividualProductOnboardingManagement/WebSystemConfigurator/PropertyServiceBean!za.co.nb.system.config.property.service.PropertyServiceRemote");
                }
            }
            PropertyResponse propertyResponse = propertyServiceRemote.get(parseProperty(key));
            mLog.debug("find propertyResponse:" + propertyResponse.getPropertyDTO());
            return propertyResponse.getPropertyDTO().getValue();
        }catch (PropertyNotFoundException pnfe){
            mLog.warn("PropertyNotFoundException:", pnfe);
            return "null";
        } catch (Exception e) {
            throw new RuntimeException("Unable to lookup property", e);
        }
    }

    public String parseProperty(String key){
        mLog.debug("pre-parser:"+key);
        key =  key.substring(key.lastIndexOf("{")+1, key.indexOf("}"));
        mLog.debug("post-parser:["+key+"]");
        return key;
    }
}
