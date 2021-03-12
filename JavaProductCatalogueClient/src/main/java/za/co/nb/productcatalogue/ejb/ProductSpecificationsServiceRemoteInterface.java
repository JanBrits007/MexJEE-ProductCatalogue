package za.co.nb.productcatalogue.ejb;

import za.co.nb.productcatalogue.exception.InvalidAttributeException;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ProductType;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ProductSpecificationsServiceRemoteInterface {

	public String getProductSpecificationXMLStringByID(String pProductSpecificationID) throws Exception;

	public ProductType getProductSpecificationByIDAndArrangementID(String productSpecificationID, String arrangementID) throws Exception;

	public ProductType getProductSpecificationByIDAndCaseID(String productSpecificationID, String caseID) throws Exception;

	public ProductType getProductSpecificationXMLByID(String pProductSpecificationID) throws Exception;

	public ProductType getProductSpecificationXMLByID(int pProductSpecificationID) throws Exception;
	
	public List<ProductType> getProductSpecificationXMLByID(List<Integer> pProductSpecificationID) throws Exception;

    String crossSellProductSubstitution(ProductType productSpec, String initiatingStaffNBNumber, String environment) throws InvalidAttributeException;

}
