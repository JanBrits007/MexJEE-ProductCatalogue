package za.co.nb.productcatalogue.ejb.util;


import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ProductType;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

public class SpecificationLoaderTest {


    @Test
    public void rrbInheritanceTest() throws JAXBException, IOException {
        ProductTypeLoader specificationLoader = new ProductTypeLoader();

        String productId = "80";
        InputStream inputStream = ProductTypeLoader.class.getResourceAsStream("/productspecs/rrb/" + productId + ".xml");
        String xmlString = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());
        ProductType productType = specificationLoader.load(xmlString);

        Marshaller marshaller = ProductTypeJaxbContext.getJAXBContext().createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter sw = new StringWriter();
        marshaller.marshal(productType, sw);
        System.out.println(sw);
    }

    @Test
    public void inheritanceTest() throws JAXBException, IOException {
        ProductTypeLoader specificationLoader = new ProductTypeLoader();

        String productId = "100";
        InputStream inputStream = ProductTypeLoader.class.getResourceAsStream("/productspecs/" + productId + ".xml");
        String xmlString = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());
        ProductType productType = specificationLoader.load(xmlString);

        Assert.assertNotNull("productType - Object expected", productType);
        Assert.assertEquals("4 productAttribGroup expected",  4, productType.getProductAttributeGroup().size());

        //overwriteProductAttrib
        Assert.assertEquals("productAttribGroup - overwrite expected",  "overwrite", productType.getProductAttributeGroup().get(0).getAction());
        Assert.assertEquals("productAttribGroup - clientInformationRequirement_VerifyIdentity expected" ,"clientInformationRequirement_VerifyIdentity", productType.getProductAttributeGroup().get(0).getAttributeGroupName());
        Assert.assertEquals("productAttribGroup - overwrite 4 - items expected", 4, productType.getProductAttributeGroup().get(0).getProductAttributes().size());


        Assert.assertEquals("productAttribGroup - inherit - DEFAULT - PresentOfferSelection expected", "PresentOfferSelection", productType.getProductAttributeGroup().get(2).getAttributeGroupName());
        Assert.assertEquals("productAttribGroup - inherit - DEFAULT - PresentOfferSelection - 2 - items expected", 2, productType.getProductAttributeGroup().get(2).getProductAttributes().size());


        //inheritProductAttrib
        Assert.assertEquals("productAttribGroup - inherit - productInformationRequirement_PresentOffer expected", "productInformationRequirement_PresentOffer", productType.getProductAttributeGroup().get(3).getAttributeGroupName());
        Assert.assertEquals("productAttribGroup - inherit - 2 - items expected", 2, productType.getProductAttributeGroup().get(3).getProductAttributes().size());
        Assert.assertEquals("5 features expected", 6, productType.getFeatures().size());

        Assert.assertEquals("productAttribGroup - inherit - CreditDetails - expected", "CreditDetails", productType.getProductAttributeGroup().get(1).getAttributeGroupName());
        Assert.assertEquals("productAttribGroup - inherit - CreditDetails - 2 - items expected", 2, productType.getProductAttributeGroup().get(1).getProductAttributes().size());

        //overwriteFeature
        Assert.assertEquals("feature (1446) - overwrite expected", "overwrite", productType.getFeatures().get(1).getAction());
        Assert.assertEquals("feature (1446) - overwrite - identifier 1446 expected", 1446, (long) productType.getFeatures().get(1).getFeatureIdentifier());
        Assert.assertEquals("feature (1446) - Own Credit Insurance expected", "Own Credit Insurance", productType.getFeatures().get(1).getName());
        Assert.assertEquals("feature (1446) - overwrite - 1 item expected", 1, productType.getFeatures().get(1).getFeatureAttributeGroup().size());

        //inheritFeature
        Assert.assertEquals("feature (1333) - inherit - feature expected", 1333, (long) productType.getFeatures().get(4).getFeatureIdentifier());
        Assert.assertEquals("feature (1333) - inherit - 2 item expected", 2, productType.getFeatures().get(4).getFeatureAttributeGroup().size());
        Assert.assertEquals("feature (1333) - overwrite - featureAttributeGroup - productInformationRequirement_PresentOffer expected", "productInformationRequirement_PresentOffer", productType.getFeatures().get(4).getFeatureAttributeGroup().get(0).getAttributeGroupName());
        Assert.assertEquals("feature (1333) - overwrite - featureAttributeGroup - productInformationRequirement_PresentOffer - 1 item expected", 1, productType.getFeatures().get(4).getFeatureAttributeGroup().get(0).getFeatureAttributes().size());
        Assert.assertTrue("feature (1333) - overwrite - featureAttributeGroup - productInformationRequirement_PresentOffer - ValueAddedServiceConfiguration expected", productType.getFeatures().get(4).getFeatureAttributeGroup().get(0).getFeatureAttributes().get(0).getAttributeName().contains("ValueAddedServiceConfiguration"));

        Assert.assertEquals("feature (1333) - inherit - featureAttributeGroup - SystemRelated expected", "SystemRelated", productType.getFeatures().get(4).getFeatureAttributeGroup().get(1).getAttributeGroupName());
        Assert.assertEquals("feature (1333) - inherit - featureAttributeGroup - SystemRelated - 1 item expected", 1, productType.getFeatures().get(4).getFeatureAttributeGroup().get(1).getFeatureAttributes().size());
        Assert.assertTrue("feature (1333) - inherit - featureAttributeGroup - SystemRelated - StraightThroughProcess expected", productType.getFeatures().get(4).getFeatureAttributeGroup().get(1).getFeatureAttributes().get(0).getAttributeName().contains("StraightThroughProcess"));



        Assert.assertEquals("feature (1445) - inherit - feature expected", 1445, (long) productType.getFeatures().get(5).getFeatureIdentifier());
        Assert.assertEquals("feature (1445) - inherit - 1 item expected", 1, productType.getFeatures().get(5).getFeatureAttributeGroup().size());

        Assert.assertEquals("feature (9063) - inherit - DEFAULT - feature expected", 9063, (long) productType.getFeatures().get(3).getFeatureIdentifier());
        Assert.assertEquals("feature (9063) - inherit - DEFAULT - 1 item expected", 1, productType.getFeatures().get(3).getFeatureAttributeGroup().size());

        Assert.assertEquals("feature (9062) - inherit - feature expected", 9062, (long) productType.getFeatures().get(2).getFeatureIdentifier());
        Assert.assertEquals("feature (9062) - inherit - 6 item expected", 6, productType.getFeatures().get(2).getFeatureAttributeGroup().size());

        Marshaller marshaller = ProductTypeJaxbContext.getJAXBContext().createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter sw = new StringWriter();
        marshaller.marshal(productType, sw);

    }



}