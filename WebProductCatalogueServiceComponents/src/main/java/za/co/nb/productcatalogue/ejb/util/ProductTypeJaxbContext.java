package za.co.nb.productcatalogue.ejb.util;

import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ProductType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class ProductTypeJaxbContext {

    private static JAXBContext jaxbContext;

    public static JAXBContext getJAXBContext() throws JAXBException {
        if(jaxbContext == null) {
            jaxbContext = JAXBContext.newInstance(ProductType.class);
        }

        return jaxbContext;
    }
}
