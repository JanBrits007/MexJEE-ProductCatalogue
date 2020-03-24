package za.co.nb.productcatalogue.dao;

import java.util.List;

import javax.ejb.EJB;
import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import za.co.nb.productcatalogue.ejb.ProductSpecificationsServiceRemoteInterface;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ProductType;

public class ProductSpecificationsServiceDAO {

	private final Log mLog = LogFactory.getLog(getClass());

    @EJB
    private ProductSpecificationsServiceRemoteInterface productSpecificationsEJB;
    
	public String getProductSpecificationXMLStringByID(String pProductSpecificationID) throws Exception {
		mLog.debug("Trace 1 >>" + pProductSpecificationID + "<<");

		if(productSpecificationsEJB == null) {
			InitialContext context = new InitialContext();
			productSpecificationsEJB = (ProductSpecificationsServiceRemoteInterface)context.lookup(ProductSpecificationsServiceRemoteInterface.class.getName());
		}
		
		return productSpecificationsEJB.getProductSpecificationXMLStringByID(pProductSpecificationID);
	}

	public ProductType getProductSpecificationByIDAndArrangementID(String productSpecificationID, String arrangementID) throws Exception {
		mLog.debug("Trace 1 >>" + productSpecificationID + "<<,>>" + arrangementID + "<<");

		if(productSpecificationsEJB == null) {
			InitialContext context = new InitialContext();
			productSpecificationsEJB = (ProductSpecificationsServiceRemoteInterface)context.lookup(ProductSpecificationsServiceRemoteInterface.class.getName());
		}
		
		return productSpecificationsEJB.getProductSpecificationByIDAndArrangementID(productSpecificationID, arrangementID);
	}	

	public ProductType getProductSpecificationByIDAndCaseID(String productSpecificationID, String caseID) throws Exception {
		mLog.debug("Trace 1 >>" + productSpecificationID + "<<,>>" + caseID + "<<");
				
		if(productSpecificationsEJB == null) {
			InitialContext context = new InitialContext();
			productSpecificationsEJB = (ProductSpecificationsServiceRemoteInterface)context.lookup(ProductSpecificationsServiceRemoteInterface.class.getName());
		}
		
		return productSpecificationsEJB.getProductSpecificationByIDAndCaseID(productSpecificationID, caseID);
	}	
	
	public ProductType getProductSpecificationXMLByID(String pProductSpecificationID) throws Exception {
		mLog.debug("Trace 1 >>" + pProductSpecificationID + "<<");

		if(productSpecificationsEJB == null) {
			InitialContext context = new InitialContext();
			productSpecificationsEJB = (ProductSpecificationsServiceRemoteInterface)context.lookup(ProductSpecificationsServiceRemoteInterface.class.getName());
		}

		return productSpecificationsEJB.getProductSpecificationXMLByID(pProductSpecificationID);
	}
	
	public ProductType getProductSpecificationXMLByID(int pProductSpecificationID) throws Exception {
		mLog.debug("Trace 1 >>" + pProductSpecificationID + "<<");

		if(productSpecificationsEJB == null) {
			InitialContext context = new InitialContext();
			productSpecificationsEJB = (ProductSpecificationsServiceRemoteInterface)context.lookup(ProductSpecificationsServiceRemoteInterface.class.getName());
		}
		
		return productSpecificationsEJB.getProductSpecificationXMLByID(pProductSpecificationID);
	}

	public List<ProductType> getProductSpecificationXMLByID(List<Integer> pProductSpecificationIDs) throws Exception {
		mLog.debug("Trace 1 >>" + pProductSpecificationIDs + "<<");

		if(productSpecificationsEJB == null) {
			InitialContext context = new InitialContext();
			productSpecificationsEJB = (ProductSpecificationsServiceRemoteInterface)context.lookup(ProductSpecificationsServiceRemoteInterface.class.getName());
		}
		
		return productSpecificationsEJB.getProductSpecificationXMLByID(pProductSpecificationIDs);
	}
}
