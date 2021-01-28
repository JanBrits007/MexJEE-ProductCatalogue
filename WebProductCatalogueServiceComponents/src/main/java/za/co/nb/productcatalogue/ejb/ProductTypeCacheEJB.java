package za.co.nb.productcatalogue.ejb;

import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ProductType;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.util.HashMap;

@Singleton
public class ProductTypeCacheEJB {

    private HashMap<String, ProductType> productTypeHashMap;

   // @Resource(name = "cache/productCatalogue")
   // DistributedObjectCache cache;

    @PostConstruct
    public void init(){
        productTypeHashMap = new HashMap<>();
    }



    public void put(String key, ProductType productType){

        //cache.put(key, productType);
        productTypeHashMap.put(key, productType);
    }

    public ProductType  get(String key){

       //return (ProductType) cache.get(key);
       return productTypeHashMap.get(key);
    }

    public boolean contains(String key){
        //return cache.containsKey(key);
        return productTypeHashMap.containsKey(key);
    }


    public void invalidate(){

        //cache.clear();
        productTypeHashMap.clear();
    }
}
