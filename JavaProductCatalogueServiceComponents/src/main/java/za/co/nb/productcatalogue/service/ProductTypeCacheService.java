package za.co.nb.productcatalogue.service;

import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ProductType;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ProductTypeCacheService {

    private static ConcurrentHashMap<String, ProductType> productTypeHashMap = new ConcurrentHashMap<>();;
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
