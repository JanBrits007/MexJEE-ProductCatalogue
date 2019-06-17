package za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.Holder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import za.co.nb.productcatalogue.dao.ProductSpecificationsServiceDAO;
import za.co.nb.productcatlogue.JSONValidator.JSONValidation;
import za.co.nb.productcatlogue.XMLValidator.XMLValidation;
import za.co.nedbank.cr1.common.helper.mLog;

//@Stateless
@javax.jws.WebService(endpointInterface = "za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.IChannelProductCatalogue", targetNamespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1", serviceName = "ChannelProductCatalogue", portName = "ChannelProductCatalogueSOAPBindingPort")
public class ChannelProductCatalogueSOAPBindingImpl {

	private ProductSpecificationsServiceDAO mProductSpecificationsDAO;
	private Map<String, ProductType> mProductSpecificationLookupTable;

	private final Log log = LogFactory.getLog(getClass());

	private ProductSpecificationsServiceDAO getProductSpecificationsDAO() {
		if (mProductSpecificationsDAO == null) {
			mProductSpecificationsDAO = new ProductSpecificationsServiceDAO();
		}

		return mProductSpecificationsDAO;
	}

	public void retrieveProducts(String productCategoryID,
			String productFamilyID, String productLinesID,
			Holder<ResultSetType> resultSet,
			Holder<ProductCatalogueType> productCatalogue) {
		// TODO Auto-generated method stub
		return;
	}

	public void getProductHierarchy(String productCatalogueID,
			Holder<ResultSetType> resultSet,
			Holder<ProductCatalogueType> productCatalogue) {
		// TODO Auto-generated method stub
		return;
	}

	private ResultSetType createResult(String code, String reason) {
		ResultSetType resultSetType = new ResultSetType();
		resultSetType.setResultCode(code);
		resultSetType.setResultDescription(reason);
		return resultSetType;
	}

	private ResultSetType createResult(String code, Exception e) {
		e.printStackTrace();
		return createResult(code, "Failed: " + e.getMessage());
	}

	public void getProduct(List<Integer> productIdentifier,
			Holder<ResultSetType> resultSet, Holder<List<ProductType>> product) {
		try {
			List<ProductType> producttype = getProductSpecificationsDAO()
					.getProductSpecificationXMLByID(productIdentifier);
			if (producttype != null && producttype.size() > 0) {
				resultSet.value = createResult("R00", "Success");
				product.value = producttype;
			} else {

				resultSet.value = createResult("R01", "No Record Found.");
			}
		} catch (Exception e) {
			log.trace(e.getMessage());
			e.printStackTrace();
			resultSet.value = createResult("R01", e.getMessage());
		}
		return;
	}

	public MaintainCatalogueResponseType maintainCatalogue(
			MaintainCatalogueRequestType maintainCatalogueRequest) {

		MaintainCatalogueResponseType response = new MaintainCatalogueResponseType();

		XMLValidation xmlValidation = new XMLValidation();

		JSONValidation jsonvalidation = new JSONValidation();

		try {

			boolean isvalidxml = xmlValidation.validateMethod(maintainCatalogueRequest);
			boolean isvalidjson = jsonvalidation.jsonValidateMethod(maintainCatalogueRequest);
			if(maintainCatalogueRequest.getJsonData()!=null&&maintainCatalogueRequest.getJsonData().length()>0&&maintainCatalogueRequest.getXmlData()!=null&&maintainCatalogueRequest.getXmlData().length()>0){
			if(!isvalidjson&&!isvalidxml){
				response.setResponseString("invalid json and invalid xml");
				return response;
			}
			else if(!isvalidxml){
				response.setResponseString("invalid xml");
				return response;
			}
			else if(!isvalidjson){
				response.setResponseString("invalid json");
				return response;
			}}
			else if(maintainCatalogueRequest.getJsonData()!=null&&maintainCatalogueRequest.getJsonData().length()>0&&maintainCatalogueRequest.getXmlData().length()<=0){
				if(!isvalidjson){
					response.setResponseString("invalid json");
					return response;
				}
			}
			else if(maintainCatalogueRequest.getXmlData()!=null&&maintainCatalogueRequest.getXmlData().length()>0&&maintainCatalogueRequest.getJsonData().length()<=0 ){
				if(!isvalidxml){
					response.setResponseString("invalid xml");
					return response;
				}
			}
			else if(maintainCatalogueRequest.getJsonData().length()<=0 && maintainCatalogueRequest.getXmlData().length()<=0)
				{
				response.setResponseString("invalid json and invalid xml");
				return response;
				}
			response.setResponseString(getProductSpecificationsDAO()
					.maintainCatalogueOperations(maintainCatalogueRequest));
		} catch (Exception e) {
			mLog.debug("exception thrown for new requirement ");
			e.printStackTrace();
			return null;
		}
		return response;
	}

	public GetProductMappingResponseType getProductMapping(
			GetProductMappingRequestType getProductMappingRequest) {
		// TODO Auto-generated method stub
		GetProductMappingResponseType getProductMappingResponseType = new GetProductMappingResponseType();
		List<ProductMappingDetailsResp> productMappingDetailsResp = new ArrayList<ProductMappingDetailsResp>();
		try {
			for (int i = 0; i < getProductMappingRequest
					.getEnterpriseProductId().size(); i++) {
				ProductMappingDetailsResp productMappingDetailsRespTemp = new ProductMappingDetailsResp();
				ProductType productType = getProductSpecificationByProductID(getProductMappingRequest
						.getEnterpriseProductId().get(i));
				List<ProductAttributeGroupType> attribGroup = productType
						.getProductAttributeGroup();
				if (attribGroup != null) {

					for (ProductAttributeGroupType vProductAttributeGroupType : attribGroup) {
						if (vProductAttributeGroupType.getAttributeGroupName()
								.equalsIgnoreCase("productCodeMappings")
								|| vProductAttributeGroupType
										.getAttributeGroupName().startsWith(
												"productCodeMappings")) {
							// Found the correct group.

							for (ProductattributesType attributes : vProductAttributeGroupType
									.getProductAttributes()) {
								if (attributes.getAttributeName()
										.equalsIgnoreCase("Siyaka_ProductCode")
										|| attributes.getAttributeName()
												.startsWith(
														"Siyaka_ProductCode")) {
									productMappingDetailsRespTemp
											.setEnterpriseProductId(getProductMappingRequest
													.getEnterpriseProductId()
													.get(i));
									productMappingDetailsRespTemp
											.setMappedProductId(attributes
													.getValue());
									productMappingDetailsResp
											.add(productMappingDetailsRespTemp);
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
		getProductMappingResponseType
				.setProductMappingDetailsResp(productMappingDetailsResp);
		return getProductMappingResponseType;
	}

	private ProductType getProductSpecificationByProductID(String pProductID)
			throws Exception {
		List<Integer> productStr = new ArrayList<Integer>();
		if (mProductSpecificationLookupTable == null) {
			mProductSpecificationLookupTable = new LinkedHashMap<String, ProductType>();
		}

		// First check the cache.
		ProductType vProductSpecification = mProductSpecificationLookupTable
				.get(pProductID);

		if (vProductSpecification == null) {
			productStr.add(Integer.parseInt(pProductID));

			List<ProductType> vIndexedProductSpecification = getProductSpecificationsDAO()
					.getProductSpecificationXMLByID(productStr);
			ProductType productType = vIndexedProductSpecification.get(0);
			String productIdentifier = productType.getProductIdentifier()
					.toString();
			mProductSpecificationLookupTable.put(productIdentifier,
					vIndexedProductSpecification.get(0));

			if (pProductID.equalsIgnoreCase(productIdentifier)) {
				// We've hit the correct product specification.
				vProductSpecification = vIndexedProductSpecification.get(0);
			}

		}

		return vProductSpecification;
	}
}