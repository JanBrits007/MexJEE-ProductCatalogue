package za.co.nb.productcatalogue.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import za.co.nb.productcatalogue.dao.ProductSpecificationsServiceDAO;
import za.co.nb.productcatalogue.exception.InvalidAttributeException;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.FeatureAttributeGroupType;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.FeatureAttributesType;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.FeaturesType;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ProductAttributeGroupType;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ProductType;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ProductattributesType;

public class ProductSpecificationUtil {

	private final Log mLog = LogFactory.getLog(getClass());

	public String getProductOrFeatureAttributeValue(String productID, String attributeGroup, String attributeName) throws Exception {
		mLog.debug("Trace 1");
		
		// First get the product spec.
		ProductSpecificationsServiceDAO dao = new ProductSpecificationsServiceDAO();
		ProductType productSpecification = dao.getProductSpecificationXMLByID(productID);

		mLog.debug("Trace 2");
		
		return getProductOrFeatureAttributeValue(productSpecification, attributeGroup, attributeName);
	}

	public String getProductOrFeatureAttributeValue(ProductType productSpecification, String attributeGroup, String attributeName) throws InvalidAttributeException {
		mLog.debug("Trace 1 >>" + attributeGroup + "<<,>>" + attributeName + "<<");
		
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
						
						return attribute.getValue();
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
							
							return attribute.getValue();
						}
					}
				}
			}
		}
		
		mLog.debug("Trace 11");
		
		// Didn't find the attribute.
		throw new InvalidAttributeException("Invalid product specification attribute for product ID " + productSpecification.getProductIdentifier() + " with attribute group " + attributeGroup + " and attribute name " + attributeName);
	}
}
