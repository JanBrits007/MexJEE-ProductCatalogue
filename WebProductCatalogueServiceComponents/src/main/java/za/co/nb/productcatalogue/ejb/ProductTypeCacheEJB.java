package za.co.nb.productcatalogue.ejb;

import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ProductType;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.util.HashMap;

@Singleton
public class ProductTypeCacheEJB {

    private HashMap<String, ProductType> productTypeHashMap;

    @PostConstruct
    public void init(){
        productTypeHashMap = new HashMap<>();
    }

    public void put(String key, ProductType productType){
        productTypeHashMap.put(key, productType);
    }

    public ProductType  get(String key){
        return productTypeHashMap.get(key);
    }

    public boolean contains(String key){
        return productTypeHashMap.containsKey(key);
    }


    public void invalidate(){
        productTypeHashMap.clear();
    }
}
