package za.co.nb.productcatalogue.ejb;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import za.co.nb.common.helper.namespacebinding.CachedNameSpaceBindingHelper;
import za.co.nb.system.config.property.service.PropertyServiceRemote;
import za.co.nb.system.config.whitelist.dto.StaffResponse;
import za.co.nb.system.config.whitelist.service.WhitelistServiceRemote;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.naming.InitialContext;

@Stateless
@TransactionAttribute(TransactionAttributeType.NEVER)
public class DynamicWhitelistBean {

    private static final Log mLog = LogFactory.getLog(DynamicWhitelistBean.class);

    private WhitelistServiceRemote whitelistServiceRemote;



    private String environment;

    @PostConstruct
    public void init(){
        environment = CachedNameSpaceBindingHelper.getNameSpaceBinding("ENVIRONMENT","ETE");
    }

    public String getStaffList(String productId){
        mLog.debug("find whitelist product:"+productId);
        try {
            if (whitelistServiceRemote == null) {
                InitialContext context = new InitialContext();
                try {
                    whitelistServiceRemote = (WhitelistServiceRemote) context.lookup("java:global/SysSystemConfigurator/WebSystemConfigurator/WhitelistServiceBean!za.co.nb.system.config.whitelist.service.WhitelistServiceRemote");
                } catch (Exception e) {
                    whitelistServiceRemote = (WhitelistServiceRemote) context.lookup("java:global/SysIndividualProductOnboardingManagement/WebSystemConfigurator/WhitelistServiceBean!za.co.nb.system.config.whitelist.service.WhitelistServiceRemote");
                }
            }
            StaffResponse productStaff = whitelistServiceRemote.getProductStaff(productId, environment);
            return productStaff.getProductStaff().getStaffList();
        } catch (Exception e) {
            throw new RuntimeException("Unable to lookup property:"+e.getMessage(), e);
        }
    }

}
