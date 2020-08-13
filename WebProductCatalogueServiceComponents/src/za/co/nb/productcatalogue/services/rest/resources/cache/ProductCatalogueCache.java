package za.co.nb.productcatalogue.services.rest.resources.cache;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import za.co.nb.productcatalogue.dao.AbstractProductCatalogueDAO;
import za.co.nb.productcatalogue.dao.ProductCataloguesDAO;
import za.co.nb.productcatalogue.dao.dto.CachedCatalogueDetails;
import za.co.nb.productcatalogue.dao.dto.CatalogueCache;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Schedule;
import javax.ejb.Schedules;
import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class ProductCatalogueCache  extends AbstractProductCatalogueDAO {

    private final Log mLog = LogFactory.getLog(getClass());


    @PostConstruct
    public void init(){
       catalogueCache = new HashMap<String, CachedCatalogueDetails>();
    }


    @Lock(LockType.READ)
    @Produces
    @CatalogueCache
    @ApplicationScoped
    public Map<String, CachedCatalogueDetails> getCatalogueCache(){
        return catalogueCache;
    }

    @Lock(LockType.WRITE)
    @Schedules({
        @Schedule(hour = "1", minute = "5", second = "0", persistent = false),
        @Schedule(hour = "7", minute = "5", second = "0", persistent = false)
    })
    public void updateCache() {
        mLog.debug("pre-updateCache");
        updateProductCatalogueCache();
    }


}
