package za.co.nb.productcatalogue.ejb.file;


import org.junit.Assert;
import org.junit.Test;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ProductType;

public class SpecificationLoaderTest {

    @Test
    public void inheritanceTest() {
        SpecificationLoader specificationLoader = new SpecificationLoader();
        ProductType productType = specificationLoader.load("100");

        Assert.assertNotNull("productType - Object expected", productType);

        Assert.assertEquals("2 productAttribGroup expected", productType.getProductAttributeGroup().size(), 2);

        //overwriteProductAttrib
        Assert.assertEquals("productAttribGroup - overwrite expected", productType.getProductAttributeGroup().get(0).getAction(), "overwrite");
        Assert.assertEquals("productAttribGroup - clientInformationRequirement_VerifyIdentity expected", productType.getProductAttributeGroup().get(0).getAttributeGroupName(), "clientInformationRequirement_VerifyIdentity");
        Assert.assertEquals("productAttribGroup - overwrite 4 - items expected", productType.getProductAttributeGroup().get(0).getProductAttributes().size(), 4);

        //inheritProductAttrib
        Assert.assertEquals("productAttribGroup - inherit - productInformationRequirement_PresentOffer expected", productType.getProductAttributeGroup().get(1).getAttributeGroupName(), "productInformationRequirement_PresentOffer");
        Assert.assertEquals("productAttribGroup - inherit - 2 - items expected", productType.getProductAttributeGroup().get(1).getProductAttributes().size(), 2);
        Assert.assertEquals("3 features expected", productType.getFeatures().size(), 3);

        //overwriteFeature
        Assert.assertEquals("feature (1446) - overwrite expected", productType.getFeatures().get(1).getAction(), "overwrite");
        Assert.assertEquals("feature (1446) - overwrite - identifier 1446 expected", (long) productType.getFeatures().get(1).getFeatureIdentifier(), 1446);
        Assert.assertEquals("feature (1446) - Own Credit Insurance expected", productType.getFeatures().get(1).getName(), "Own Credit Insurance");
        Assert.assertEquals("feature (1446) - overwrite - 1 item expected", productType.getFeatures().get(1).getFeatureAttributeGroup().size(), 1);

        //inheritFeature
        Assert.assertEquals("feature (1445) - inherit - feature expected", (long) productType.getFeatures().get(2).getFeatureIdentifier(), 1445);
        Assert.assertEquals("feature (1445) - inherit - 1 item expected", productType.getFeatures().get(2).getFeatureAttributeGroup().size(), 1);

    }



}