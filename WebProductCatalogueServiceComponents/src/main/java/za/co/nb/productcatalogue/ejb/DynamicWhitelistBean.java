package za.co.nb.productcatalogue.ejb;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import za.co.nb.common.helper.namespacebinding.CachedNameSpaceBindingHelper;
import za.co.nb.system.config.whitelist.dto.StaffResponse;
import za.co.nb.system.config.whitelist.service.WhitelistServiceRemote;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
@TransactionAttribute(TransactionAttributeType.NEVER)
public class DynamicWhitelistBean {

    private final Log mLog = LogFactory.getLog(getClass());

    @EJB(lookup = "java:global/SysSystemConfigurator/WebSystemConfigurator/WhitelistServiceBean!za.co.nb.system.config.whitelist.service.WhitelistServiceRemote")
    WhitelistServiceRemote whitelistServiceRemote;



    private String environment;

    @PostConstruct
    public void init(){
        environment = CachedNameSpaceBindingHelper.getNameSpaceBinding("ENVIRONMENT","ETE");
    }

    public String getStaffList(String productId){
        mLog.debug("find whitelist product:"+productId);
        StaffResponse productStaff = whitelistServiceRemote.getProductStaff(productId, environment);
        return productStaff.getProductStaff().getStaffList();
    }

}
