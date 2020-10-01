package za.co.nb.productcatalogue.services.rest.resources.cache;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import za.co.nb.productcatalogue.dao.AbstractProductCatalogueDAO;
import za.co.nb.productcatalogue.dao.dto.CachedCatalogueDetails;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Schedule;
import javax.ejb.Schedules;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ProductCatalogueCache  extends AbstractProductCatalogueDAO {

    private final Log mLog = LogFactory.getLog(getClass());

    private Map<String, CachedCatalogueDetails> catalogueCache;


    @PostConstruct
    public void init(){
       catalogueCache = new ConcurrentHashMap<String, CachedCatalogueDetails>();
    }


    public Map<String, CachedCatalogueDetails> getCatalogueCache(){
        return catalogueCache;
    }

    @Schedules({
        @Schedule(hour = "1", minute = "5", second = "0", persistent = false),
        @Schedule(hour = "7", minute = "5", second = "0", persistent = false)
    })
    public void updateCache() {
        mLog.debug("pre-updateCache");
        updateProductCatalogueCache();
    }


    public void updateProductCatalogueCache(){

        for(String productId : catalogueCache.keySet()){

            try {

                String catalogueString = retrieveRatesInjectedProductCatalog(productId);
                putToCache(productId, catalogueString);
                mLog.debug ("## ProductCacheUpdated ##: "+productId);

            }catch(Exception e){
                mLog.error("Could not reload cache, product:"+productId, e);
            }

        }
    }

    @Lock(LockType.READ)
    public void putToCache(String productId, String catalogueString){

        CachedCatalogueDetails cachedCatalogue = new CachedCatalogueDetails();
        cachedCatalogue.setCacheDateTime(new Date());
        cachedCatalogue.setCatalogueContent(catalogueString);
        catalogueCache.put(productId, cachedCatalogue);
    }

    public void invalidate(){
        catalogueCache.clear();
        mLog.debug("## ProductCatalogue CLEARED ##");
    }

    @Lock(LockType.WRITE)
    public void reload(){
        updateProductCatalogueCache();
        mLog.debug("## ProductCatalogue RELOADED ##");
    }


}
