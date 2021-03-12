package za.co.nb.productcatalogue.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import za.co.nb.productcatalogue.ejb.ProductSpecificationsServiceRemoteInterface;
import za.co.nb.productcatalogue.exception.InvalidAttributeException;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ProductType;

import javax.naming.InitialContext;
import java.util.List;

public class ProductSpecificationsServiceDAO {

    private final Log mLog = LogFactory.getLog(getClass());

    private ProductSpecificationsServiceRemoteInterface productSpecificationsEJB;

    public String getProductSpecificationXMLStringByID(String pProductSpecificationID) throws Exception {
        mLog.debug("Trace 1 >>" + pProductSpecificationID + "<<");

        if (productSpecificationsEJB == null) {
            mLog.debug("Trace 2");
            InitialContext context = new InitialContext();
            productSpecificationsEJB = (ProductSpecificationsServiceRemoteInterface) context.lookup("java:global/SysProductCatalogueServiceComponents/WebProductCatalogueServiceComponents/ProductSpecificationsEJB!za.co.nb.productcatalogue.ejb.ProductSpecificationsServiceRemoteInterface");
        }

        return productSpecificationsEJB.getProductSpecificationXMLStringByID(pProductSpecificationID);
    }

    public ProductType getProductSpecificationByIDAndArrangementID(String productSpecificationID, String arrangementID) throws Exception {
        mLog.debug("Trace 1 >>" + productSpecificationID + "<<,>>" + arrangementID + "<<");

        if (productSpecificationsEJB == null) {
            mLog.debug("Trace 2");
            InitialContext context = new InitialContext();
            productSpecificationsEJB = (ProductSpecificationsServiceRemoteInterface) context.lookup("java:global/SysProductCatalogueServiceComponents/WebProductCatalogueServiceComponents/ProductSpecificationsEJB!za.co.nb.productcatalogue.ejb.ProductSpecificationsServiceRemoteInterface");
        }

        return productSpecificationsEJB.getProductSpecificationByIDAndArrangementID(productSpecificationID, arrangementID);
    }

    public ProductType getProductSpecificationByIDAndCaseID(String productSpecificationID, String caseID) throws Exception {
        mLog.debug("Trace 1 >>" + productSpecificationID + "<<,>>" + caseID + "<<");

        if (productSpecificationsEJB == null) {
            mLog.debug("Trace 2");
            InitialContext context = new InitialContext();
            productSpecificationsEJB = (ProductSpecificationsServiceRemoteInterface) context.lookup("java:global/SysProductCatalogueServiceComponents/WebProductCatalogueServiceComponents/ProductSpecificationsEJB!za.co.nb.productcatalogue.ejb.ProductSpecificationsServiceRemoteInterface");
        }

        return productSpecificationsEJB.getProductSpecificationByIDAndCaseID(productSpecificationID, caseID);
    }

    public ProductType getProductSpecificationXMLByID(String pProductSpecificationID) throws Exception {
        mLog.debug("Trace 1 >>" + pProductSpecificationID + "<<");

        if (productSpecificationsEJB == null) {
            mLog.debug("Trace 2");
            InitialContext context = new InitialContext();
            productSpecificationsEJB = (ProductSpecificationsServiceRemoteInterface) context.lookup("java:global/SysProductCatalogueServiceComponents/WebProductCatalogueServiceComponents/ProductSpecificationsEJB!za.co.nb.productcatalogue.ejb.ProductSpecificationsServiceRemoteInterface");
        }

        return productSpecificationsEJB.getProductSpecificationXMLByID(pProductSpecificationID);
    }

    public ProductType getProductSpecificationXMLByID(int pProductSpecificationID) throws Exception {
        mLog.debug("Trace 1 >>" + pProductSpecificationID + "<<");

        if (productSpecificationsEJB == null) {
            mLog.debug("Trace 2");
            InitialContext context = new InitialContext();
            productSpecificationsEJB = (ProductSpecificationsServiceRemoteInterface) context.lookup("java:global/SysProductCatalogueServiceComponents/WebProductCatalogueServiceComponents/ProductSpecificationsEJB!za.co.nb.productcatalogue.ejb.ProductSpecificationsServiceRemoteInterface");
        }

        return productSpecificationsEJB.getProductSpecificationXMLByID(pProductSpecificationID);
    }

    public List<ProductType> getProductSpecificationXMLByID(List<Integer> pProductSpecificationIDs) throws Exception {
        mLog.debug("Trace 1 >>" + pProductSpecificationIDs + "<<");

        if (productSpecificationsEJB == null) {
            mLog.debug("Trace 2");
            InitialContext context = new InitialContext();
//			productSpecificationsEJB = (ProductSpecificationsServiceRemoteInterface)context.lookup(ProductSpecificationsServiceRemoteInterface.class.getName());
            productSpecificationsEJB = (ProductSpecificationsServiceRemoteInterface) context.lookup("java:global/SysProductCatalogueServiceComponents/WebProductCatalogueServiceComponents/ProductSpecificationsEJB!za.co.nb.productcatalogue.ejb.ProductSpecificationsServiceRemoteInterface");
        }

        return productSpecificationsEJB.getProductSpecificationXMLByID(pProductSpecificationIDs);
    }

    public String crossSellProductSubstitution(ProductType productSpec, String initiatingStaffNBNumber, String environment) throws InvalidAttributeException {
        return productSpecificationsEJB.crossSellProductSubstitution(productSpec, initiatingStaffNBNumber, environment);
    }
}
