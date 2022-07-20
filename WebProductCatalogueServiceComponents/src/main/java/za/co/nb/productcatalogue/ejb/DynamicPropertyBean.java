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

@Stateless
@TransactionAttribute(TransactionAttributeType.NEVER)
public class DynamicPropertyBean {

    private static final Log mLog = LogFactory.getLog(DynamicPropertyBean.class);

    @EJB(lookup = "java:global/SysSystemConfigurator/WebSystemConfigurator/PropertyServiceBean!za.co.nb.system.config.property.service.PropertyServiceRemote")
    PropertyServiceRemote propertyServiceRemote;


    public String getProperty(String key){
        mLog.debug("find key:"+key);
        try {
            PropertyResponse propertyResponse = propertyServiceRemote.get(parseProperty(key));
            mLog.debug("find propertyResponse:" + propertyResponse.getPropertyDTO());
            return propertyResponse.getPropertyDTO().getValue();
        }catch (PropertyNotFoundException pnfe){
            mLog.warn("PropertyNotFoundException:", pnfe);
            return "null";
        }
    }

    public String parseProperty(String key){
        mLog.debug("pre-parser:"+key);
        key =  key.substring(key.lastIndexOf("{")+1, key.indexOf("}"));
        mLog.debug("post-parser:["+key+"]");
        return key;
    }
}
