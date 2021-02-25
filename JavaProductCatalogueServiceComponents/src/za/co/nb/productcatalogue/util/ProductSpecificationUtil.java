package za.co.nb.productcatalogue.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import za.co.nb.productcatalogue.dao.ProductSpecificationsServiceDAO;
import za.co.nb.productcatalogue.exception.InvalidAttributeException;
import za.co.nb.productcatalogue.exception.InvalidAttributeGroupException;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.FeatureAttributeGroupType;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.FeatureAttributesType;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.FeaturesType;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ProductAttributeGroupType;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ProductType;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ProductattributesType;

import java.util.ArrayList;
import java.util.List;

public class ProductSpecificationUtil {

	private final Log mLog = LogFactory.getLog(getClass());

	public ProductAttributeGroupType getProductAttributeGroupValues(ProductType productSpecification, String attributeGroupName) throws InvalidAttributeGroupException {
		mLog.debug("Trace 1");
		
		// First look in product attribute groups.
		for(ProductAttributeGroupType productAttributeGroup : productSpecification.getProductAttributeGroup()) {
			mLog.debug("Trace 2 >>" + productAttributeGroup.getAttributeGroupName() + "<<");
			
			// Now look for the attribute group.
			if(productAttributeGroup.getAttributeGroupName().equalsIgnoreCase(attributeGroupName)) {
				mLog.debug("Trace 3");
				// Found it.
				return productAttributeGroup;
			}
		}

		throw new InvalidAttributeGroupException("Invalid attribute group " + attributeGroupName + ". Check the product specification for product ID " + productSpecification.getProductIdentifier());
	}
	
	public String getProductOrFeatureAttributeValue(String productID, String attributeGroup, String attributeName) throws InvalidAttributeException {
		mLog.debug("Trace 1");
		
		// First get the product spec.
		ProductSpecificationsServiceDAO dao = new ProductSpecificationsServiceDAO();
		
		ProductType productSpecification;
		
		try {
			productSpecification = dao.getProductSpecificationXMLByID(productID);
		}
		catch(Exception e) {
			e.printStackTrace();
			
			throw new InvalidAttributeException("Unable to retrieve product spec for ID " + productID);
		}

		mLog.debug("Trace 2");
		
		return getProductOrFeatureAttributeValue(productSpecification, attributeGroup, attributeName);
	}

	public String getProductOrFeatureAttributeValue(ProductType productSpecification, String attributeGroup, String attributeName) throws InvalidAttributeException {
		mLog.debug("Trace 1 >>" + attributeGroup + "<<,>>" + attributeName + "<<");

		List<String> values = getProductOrFeatureAttributeValues(productSpecification, attributeGroup, attributeName);

		// We can return only one. Return the first one.
		return values.get(0);
	}

	public ProductattributesType getProductAttributes(ProductType productSpecification, String attributeGroup, String attributeName) throws InvalidAttributeException {

		for(ProductAttributeGroupType productAttributeGroup :productSpecification.getProductAttributeGroup()) {

			if (productAttributeGroup.getAttributeGroupName().equalsIgnoreCase(attributeGroup)) {
				return productAttributeGroup.getProductAttributes()
						.stream()
						.filter(productAttributes -> productAttributes.getAttributeName().equals(attributeName)).findAny()
						.orElseThrow(() -> new InvalidAttributeException("Invalid product specification attribute for product ID " + productSpecification.getProductIdentifier() + " with attribute group " + attributeGroup + " and attribute name " + attributeName));
			}
		}

		throw new InvalidAttributeException("Invalid product specification attribute for product ID " + productSpecification.getProductIdentifier() + " with attribute group " + attributeGroup + " and attribute name " + attributeName);
	}

	public List<String> getProductOrFeatureAttributeValues(ProductType productSpecification, String attributeGroup, String attributeName) throws InvalidAttributeException {
		mLog.debug("Trace 1 >>" + attributeGroup + "<<,>>" + attributeName + "<<");
		
		List<String> values = new ArrayList<String>();
		
		// First look in product attribute groups.
		for(ProductAttributeGroupType productAttributeGroup : productSpecification.getProductAttributeGroup()) {
			mLog.debug("Trace 2 >>" + productAttributeGroup.getAttributeGroupName() + "<<");
			
			// Now look for the attribute group.
			if(productAttributeGroup.getAttributeGroupName().equalsIgnoreCase(attributeGroup)) {
				mLog.debug("Trace 3");
				// Found it.
				// Now find the attribute.
				for(ProductattributesType attribute : productAttributeGroup.getProductAttributes()) {
					mLog.debug("Trace 4 >>" + attribute.getAttributeName() + "<<");

					if(attribute.getAttributeName().equalsIgnoreCase(attributeName)) {
						// Found it.
						mLog.debug("Trace 5");
						
						values.add(attribute.getValue());
					}
				}
			}
		}
		
		// Didn't find it on product level. Look in features.
		for(FeaturesType feature : productSpecification.getFeatures()) {
			mLog.debug("Trace 6 >>" + feature.getFeatureIdentifier() + "<<");

			for(FeatureAttributeGroupType featureAttributeGroup : feature.getFeatureAttributeGroup()) {
				mLog.debug("Trace 7 >>" + featureAttributeGroup.getAttributeGroupName() + "<<");
				
				// Now look for the attribute group.
				if(featureAttributeGroup.getAttributeGroupName().equalsIgnoreCase(attributeGroup)) {
					mLog.debug("Trace 8");
					// Found it.
					// Now find the attribute.
					for(FeatureAttributesType attribute : featureAttributeGroup.getFeatureAttributes()) {
						mLog.debug("Trace 9 >>" + attribute.getAttributeName() + "<<");

						if(attribute.getAttributeName().equalsIgnoreCase(attributeName)) {
							// Found it.
							mLog.debug("Trace 10");
							
							values.add(attribute.getValue());
						}
					}
				}
			}
		}
		
		mLog.debug("Trace 11");

		if(values.size() == 0) {
			mLog.debug("Trace 12");
			// Didn't find the attribute.
			throw new InvalidAttributeException("Invalid product specification attribute for product ID " + productSpecification.getProductIdentifier() + " with attribute group " + attributeGroup + " and attribute name " + attributeName);
		}
		else {
			mLog.debug("Trace 13");
			return values;
		}
	}

	public String getAttributeValueForProductComponent(String componentID, ProductType productSpecification, String attributeGroup, String attributeName) throws InvalidAttributeException {
		mLog.debug("Trace 1 >>" + componentID + "<<,>>" + attributeGroup + "<<,>>" + attributeName + "<<");
		
		// First look in product attribute groups.
		if(productSpecification.getProductIdentifier() != null && productSpecification.getProductIdentifier().toString().trim().equalsIgnoreCase(componentID.trim())) {
			// This component ID matches the product ID.
			for(ProductAttributeGroupType productAttributeGroup : productSpecification.getProductAttributeGroup()) {
				mLog.debug("Trace 2 >>" + productAttributeGroup.getAttributeGroupName() + "<<");
				
				// Now look for the attribute group.
				if(productAttributeGroup.getAttributeGroupName().equalsIgnoreCase(attributeGroup)) {
					mLog.debug("Trace 3");
					// Found it.
					// Now find the attribute.
					for(ProductattributesType attribute : productAttributeGroup.getProductAttributes()) {
						mLog.debug("Trace 4 >>" + attribute.getAttributeName() + "<<");

						if(attribute.getAttributeName().equalsIgnoreCase(attributeName)) {
							// Found it.
							mLog.debug("Trace 5");
							
							return attribute.getValue();
						}
					}
				}
			}
		}
		
		// Didn't find it on product level. Look in features.
		for(FeaturesType feature : productSpecification.getFeatures()) {
			mLog.debug("Trace 6 >>" + feature.getFeatureIdentifier() + "<<");

			if(feature.getFeatureIdentifier() != null && feature.getFeatureIdentifier().toString().trim().equalsIgnoreCase(componentID.trim())) {
				// Feature matches the component ID.
				for(FeatureAttributeGroupType featureAttributeGroup : feature.getFeatureAttributeGroup()) {
					mLog.debug("Trace 7 >>" + featureAttributeGroup.getAttributeGroupName() + "<<");

					// Now look for the attribute group.
					if(featureAttributeGroup.getAttributeGroupName().equalsIgnoreCase(attributeGroup)) {
						mLog.debug("Trace 8");
						// Found it.
						// Now find the attribute.
						for(FeatureAttributesType attribute : featureAttributeGroup.getFeatureAttributes()) {
							mLog.debug("Trace 9 >>" + attribute.getAttributeName() + "<<");

							if(attribute.getAttributeName().equalsIgnoreCase(attributeName)) {
								// Found it.
								mLog.debug("Trace 10");

								return attribute.getValue();
							}
						}
					}
				}
			}
		}
		
		mLog.debug("Trace 11");
		
		// Didn't find the attribute.
		throw new InvalidAttributeException("Invalid product specification attribute for product ID " + productSpecification.getProductIdentifier() + " with attribute group " + attributeGroup + " and attribute name " + attributeName);
	}
	
	
	public String getProductAttributeValue(ProductType productSpecification, String attributeGroup, String attributeName) throws InvalidAttributeException {
		mLog.debug("Trace 1 >>" + attributeGroup + "<<,>>" + attributeName + "<<");
		String productAttributeValue = "";
		// Let's look in product attribute groups.
		for(ProductAttributeGroupType productAttributeGroup : productSpecification.getProductAttributeGroup()) {
			mLog.debug("Trace 2 >>" + productAttributeGroup.getAttributeGroupName() + "<<");
			
			// Now look for the attribute group.
			if(productAttributeGroup.getAttributeGroupName().equalsIgnoreCase(attributeGroup)) {
				mLog.debug("Trace 3");
				// Found it.
				// Now find the attribute.
				for(ProductattributesType attribute : productAttributeGroup.getProductAttributes()) {
					mLog.debug("Trace 4 >>" + attribute.getAttributeName() + "<<");

					if(attribute.getAttributeName().equalsIgnoreCase(attributeName)) {
						// Found it.
						mLog.debug("Trace 5");
						
						productAttributeValue = attribute.getValue();
					}
				}
			}
		}
		mLog.debug("Trace 6");
		
		return productAttributeValue;
	}
		
	public String getFeatureAttributeValue(ProductType productSpecification, String attributeGroup, String attributeName,int featureID) throws InvalidAttributeException {
		mLog.debug("Trace 1 >>" + attributeGroup + "<<,>>" + attributeName + "<<");
		
		String featureAttributeValue = "";
		// Let's look in feature attribute groups.
		for(FeaturesType feature : productSpecification.getFeatures()) {
			mLog.debug("Trace 6 >>" + feature.getFeatureIdentifier() + "<<");
			
			if(feature.getFeatureIdentifier() == featureID){
				
				for(FeatureAttributeGroupType featureAttributeGroup : feature.getFeatureAttributeGroup()) {
					mLog.debug("Trace 7 >>" + featureAttributeGroup.getAttributeGroupName() + "<<");
					
					// Now look for the attribute group.
					if(featureAttributeGroup.getAttributeGroupName().equalsIgnoreCase(attributeGroup)) {
						mLog.debug("Trace 8");
						// Found it.
						// Now find the attribute.
						for(FeatureAttributesType attribute : featureAttributeGroup.getFeatureAttributes()) {
							mLog.debug("Trace 9 >>" + attribute.getAttributeName() + "<<");

							if(attribute.getAttributeName().equalsIgnoreCase(attributeName)) {
								// Found it.
								mLog.debug("Trace 10");
								
								featureAttributeValue = attribute.getValue();
							}
						}
					}
				}
			}
			
		}
		mLog.debug("Trace 6");
		
		return featureAttributeValue;
	}
}
