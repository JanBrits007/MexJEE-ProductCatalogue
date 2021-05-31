package za.co.nb.productcatalogue.ejb;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import za.co.nb.system.config.property.dto.PropertyResponse;
import za.co.nb.system.config.property.service.PropertyServiceRemote;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
@TransactionAttribute(TransactionAttributeType.NEVER)
public class DynamicPropertyBean {

    private final Log mLog = LogFactory.getLog(getClass());

    @EJB(lookup = "java:global/SysSystemConfigurator/WebSystemConfigurator/PropertyServiceBean!za.co.nb.system.config.property.service.PropertyServiceRemote")
    PropertyServiceRemote propertyServiceRemote;


    public String getProperty(String key){
        mLog.debug("find key:"+key);
        PropertyResponse propertyResponse = propertyServiceRemote.get(parseProperty(key));
        mLog.debug("find propertyResponse:"+propertyResponse.getPropertyDTO());
        return propertyResponse.getPropertyDTO().getValue();
    }

    public String parseProperty(String key){
        mLog.debug("pre-parser:"+key);
        key =  key.substring(key.lastIndexOf("{")+1, key.indexOf("}"));
        mLog.debug("post-parser:["+key+"]");
        return key;
    }
}
