package za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jws.WebService;
import javax.xml.ws.Holder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import za.co.nb.productcatalogue.ejb.ProductSpecificationsEJB;


@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
@WebService(endpointInterface = "za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.IChannelProductCatalogue", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1", serviceName = "ChannelProductCatalogue", portName = "ChannelProductCatalogueSOAPBindingPort")
public class ChannelProductCatalogueSOAPBindingImpl {

	@EJB
	private ProductSpecificationsEJB productSpecificationsBean;

	private static final Log mLog = LogFactory.getLog(ChannelProductCatalogueSOAPBindingImpl.class);

	public void retrieveProducts(String productCategoryID, String productFamilyID, String productLinesID, Holder<ResultSetType> resultSet, Holder<ProductCatalogueType> productCatalogue) {
		return;
	}

	public void getProductHierarchy(String productCatalogueID, Holder<ResultSetType> resultSet, Holder<ProductCatalogueType> productCatalogue) {
		return;
	}

	public void getProduct(List<Integer> productIdentifier,Holder<ResultSetType> resultSet, Holder<List<ProductType>> product) {
		mLog.debug("Trace 1");

		try {
			List<ProductType> producttype = productSpecificationsBean.getProductSpecificationXMLByID(productIdentifier);

			if (producttype != null && producttype.size() > 0) {
				mLog.debug("Trace 2");
				resultSet.value = createResult("R00", "Success");
				product.value = producttype;
			} else {
				mLog.debug("Trace 3");
				resultSet.value = createResult("R01", "No Record Found.");
			}
		} catch (Exception e) {
			mLog.error(e);
			resultSet.value = createResult("R01", e.getMessage());
		}
		
		mLog.debug("Trace 4");
		
		return;
	}

	public MaintainCatalogueResponseType maintainCatalogue(MaintainCatalogueRequestType maintainCatalogueRequest) throws Exception {
		mLog.debug("Trace 1");
		throw new Exception("This functionality has been deprecated. All product specifications now reside in the source code repo, in order to support version management.");
	}

	public GetProductMappingResponseType getProductMapping(GetProductMappingRequestType getProductMappingRequest) {
		mLog.debug("Trace 1");

		GetProductMappingResponseType getProductMappingResponseType = new GetProductMappingResponseType();
		List<ProductMappingDetailsResp> productMappingDetailsResp = new ArrayList<ProductMappingDetailsResp>();

		try {
			for (int i = 0; i < getProductMappingRequest.getEnterpriseProductId().size(); i++) {
				ProductMappingDetailsResp productMappingDetailsRespTemp = new ProductMappingDetailsResp();
				ProductType productType = getProductSpecificationByProductID(getProductMappingRequest.getEnterpriseProductId().get(i));
				
				List<ProductAttributeGroupType> attribGroup = productType.getProductAttributeGroup();
				
				if (attribGroup != null) {
					mLog.debug("Trace 2");

					for (ProductAttributeGroupType vProductAttributeGroupType : attribGroup) {
						mLog.debug("Trace 3");
						
						if (vProductAttributeGroupType.getAttributeGroupName().equalsIgnoreCase("productCodeMappings") || vProductAttributeGroupType.getAttributeGroupName().startsWith("productCodeMappings")) {
							mLog.debug("Trace 4");
							
							// Found the correct group.
							for (ProductattributesType attributes : vProductAttributeGroupType.getProductAttributes()) {
								mLog.debug("Trace 5");
								
								if (attributes.getAttributeName().equalsIgnoreCase("Siyaka_ProductCode") || attributes.getAttributeName().startsWith("Siyaka_ProductCode")) {
									mLog.debug("Trace 6");
									
									productMappingDetailsRespTemp.setEnterpriseProductId(getProductMappingRequest.getEnterpriseProductId().get(i));
									
									productMappingDetailsRespTemp.setMappedProductId(attributes.getValue());
									productMappingDetailsResp.add(productMappingDetailsRespTemp);
									break;
								}
							}
						}
					}
				}
			}

		} catch (Exception e) {
			return null;
		}

		mLog.debug("Trace 7");
		
		getProductMappingResponseType.setProductMappingDetailsResp(productMappingDetailsResp);
		
		return getProductMappingResponseType;
	}

	private ProductType getProductSpecificationByProductID(String pProductID) throws Exception {
		mLog.debug("Trace 1");

		// First check the cache.
		return productSpecificationsBean.getProductSpecificationXMLByID(new Integer(pProductID));
	}
	
	public void getProductByArrangementID(Integer productIdentifier, String arrangementID, Holder<ResultSetType> resultSet, Holder<ProductType> product) {
		mLog.debug("Trace 1");

		try {
			ProductType productType = productSpecificationsBean.getProductSpecificationByIDAndArrangementID("" + productIdentifier, arrangementID);

			if (productType != null) {
				mLog.debug("Trace 2");
				resultSet.value = createResult("R00", "Success");
				product.value = productType;
			} else {
				mLog.debug("Trace 3");
				resultSet.value = createResult("R01", "No Record Found.");
			}
		} catch (Exception e) {
			mLog.error(e);
			resultSet.value = createResult("R01", e.getMessage());
		}
		
		mLog.debug("Trace 4");
		
		return;
	}

	public void getProductByArrangementIDs(List<Integer> productIdentifiers, List<String> arrangementIDs, Holder<ResultSetType> resultSet, Holder<List<ProductType>> productSpecifications) {
		mLog.debug("Trace 1");
		
		for(int i=0; i< productIdentifiers.size(); i++) {
			mLog.debug("Trace 2 >>" + productIdentifiers.get(i) + "<<");
			
			try {
				Holder<ProductType> productSpecificationHolder = new Holder<ProductType>(); 
				
				getProductByArrangementID(productIdentifiers.get(i), arrangementIDs.get(i), resultSet, productSpecificationHolder);

				if(!resultSet.value.getResultCode().equalsIgnoreCase("R00")) {
					mLog.debug("Trace 3");
					// We have an error.
					return;
				}
				
				mLog.debug("Trace 4");
				
				if(productSpecifications.value == null) {
					mLog.debug("Trace 5");
					productSpecifications.value = new ArrayList<ProductType>();
				}
				
				productSpecifications.value.add(productSpecificationHolder.value);
			} catch (Exception e) {
				mLog.error(e);
				resultSet.value = createResult("R01", e.getMessage());
			}
		}
	}

	private ResultSetType createResult(String code, String reason) {
		ResultSetType resultSetType = new ResultSetType();
		resultSetType.setResultCode(code);
		resultSetType.setResultDescription(reason);
		return resultSetType;
	}
}