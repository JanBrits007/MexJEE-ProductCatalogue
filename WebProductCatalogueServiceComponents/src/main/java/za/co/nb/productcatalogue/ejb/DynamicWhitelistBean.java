package za.co.nb.productcatalogue.ejb;

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

    @EJB(lookup = "java:global/SysSystemConfigurator/WebSystemConfigurator/WhitelistServiceBean!za.co.nb.system.config.whitelist.service.WhitelistServiceRemote")
    WhitelistServiceRemote whitelistServiceRemote;

    private String environment;

    @PostConstruct
    public void init(){
        environment = CachedNameSpaceBindingHelper.getNameSpaceBinding("ENVIRONMENT","ETE");
    }

    public String getStaffList(String productId){
        StaffResponse productStaff = whitelistServiceRemote.getProductStaff(productId, environment);
        return productStaff.getProductStaff().getStaffList();
    }

}
