package za.co.nb.productcatalogue.ejb.file;

import za.co.nb.productcatalogue.ejb.ProductTypeJaxbContext;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.FeaturesType;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ProductAttributeGroupType;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ProductType;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.ProductattributesType;

import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SpecificationLoader {

    public ProductType load(String productID) {
        ProductType productType = loadFile(productID);
        loadParent(productType);
        return productType;
    }

    private ProductType loadFile(String productID){
        try{
            InputStream inputStream = SpecificationLoader.class.getResourceAsStream("/productspecs/" + productID + ".xml");
            Unmarshaller unmarshaller = ProductTypeJaxbContext.getJAXBContext().createUnmarshaller();

            return (ProductType) unmarshaller.unmarshal(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to find specification XML file for product ID " + productID);
        }

    }

    private void loadParent(ProductType productType){
        loadProductInheritance(productType);
    }


    private void loadProductInheritance(ProductType child){
        if(child.getInheritFromFiles() == null)
            return;

            if(child.getInheritFromFiles().trim().isEmpty())
                throw new RuntimeException("productTpe.inheritanceFromFiles property cannot be empty");

        ProductType parent = load(child.getInheritFromFiles());
        insertProductAttributeGroup(child, parent);
        insertInheritedProductAttributeGroup(child);

        insertFeature(child, parent);
    }

    private void insertInheritedProductAttributeGroup(ProductType child) {

        for(ProductAttributeGroupType productAttributeGroup :child.getProductAttributeGroup()){

            if(productAttributeGroup.getInheritFromFiles() != null){
                ProductType parent = loadFile(productAttributeGroup.getInheritFromFiles());
                for(ProductAttributeGroupType parentProductAttributeGroupType :parent.getProductAttributeGroup()){
                    if(productAttributeGroup.getAttributeGroupName().equals(parentProductAttributeGroupType.getAttributeGroupName())){
                        productAttributeGroup.getProductAttributes().addAll(parentProductAttributeGroupType.getProductAttributes());
                        break;
                    }
                }

            }

            /*
            for(ProductattributesType productAttribute :productAttributeGroup.getProductAttributes()){
                if(productAttribute.getInheritFromFiles() != null){
                    ProductType productType = loadFile(productAttribute.getInheritFromFiles());
                }

            }*/

        }
    }


    private void insertProductAttributeGroup(ProductType child, ProductType parent){

        List<ProductAttributeGroupType> tempChildProductAttributeGroup = new ArrayList<>(child.getProductAttributeGroup());

        List<String> productAttributeGroupIndex = getProductAttributeGroupIndex(tempChildProductAttributeGroup);
        for(ProductAttributeGroupType productAttributeGroup :tempChildProductAttributeGroup){

            List<ProductAttributeGroupType> tempParentProductAttributeGroup = new ArrayList<>(parent.getProductAttributeGroup());
            for(ProductAttributeGroupType productAttributeGroupParent :tempParentProductAttributeGroup) {

                if (!productAttributeGroupIndex.contains(productAttributeGroupParent.getAttributeGroupName()))
                    addProductAttribGroup(child, parent, productAttributeGroupParent);
                else
                    if(productAttributeGroupParent.getAttributeGroupName().equals(productAttributeGroup.getAttributeGroupName()))
                        if(productAttributeGroup.getAction() != null){
                            if(productAttributeGroup.getInheritFromFiles() != null)
                                throw new RuntimeException("Both ACTION and INHERIT_FROM_FILES cannot be populated");

                            if(! (productAttributeGroup.getAction().equals("overwrite") || productAttributeGroup.getAction().equals("override"))  )
                                addProductAttribGroup(child, parent, productAttributeGroupParent);
                        }
            }
        }

    }

    private void insertFeature(ProductType child, ProductType parent){

        List<FeaturesType> tempChildFeaturesTypes = new ArrayList<>(child.getFeatures());

        List<String> featureIndex = getFeatureIndex(tempChildFeaturesTypes);
        for(FeaturesType featuresType :tempChildFeaturesTypes){
            List<FeaturesType> tempParentFeaturesTypes = new ArrayList<>(parent.getFeatures());
            for(FeaturesType featureTypeParent :tempParentFeaturesTypes) {

                if (!featureIndex.contains(featureTypeParent.getFeatureIdentifier().toString()))
                    addFeature(child, parent, featureTypeParent);
                else
                    if(featureTypeParent.getFeatureIdentifier().toString().equals(featuresType.getFeatureIdentifier().toString()))
                        if(featuresType.getAction() != null){

                            if(featuresType.getInheritFromFiles() != null)
                                throw new RuntimeException("Both ACTION and INHERIT_FROM_FILES cannot be populated");

                            if( !(featuresType.getAction().equals("overwrite")|| featuresType.getAction().equals("override")) )
                                addFeature(child, parent, featureTypeParent);
                        }
            }
        }
    }

    private void addProductAttribGroup(ProductType child, ProductType parent, ProductAttributeGroupType productAttributeGroupParent) {
        child.getProductAttributeGroup().add(productAttributeGroupParent);
        parent.getProductAttributeGroup().remove(productAttributeGroupParent);
    }

    private List<String> getProductAttributeGroupIndex(List<ProductAttributeGroupType> productAttributeGroupTypes) {
        List<String> index = new ArrayList<>();
        for (ProductAttributeGroupType productAttributeGroup :productAttributeGroupTypes)
            index.add(productAttributeGroup.getAttributeGroupName());

        return index;
    }

    private List<String> getFeatureIndex(List<FeaturesType> featuresTypes) {
        List<String> index = new ArrayList<>();
        for (FeaturesType featuresType :featuresTypes)
            index.add(String.valueOf(featuresType.getFeatureIdentifier()));

        return index;
    }

    private void addFeature(ProductType child, ProductType parent, FeaturesType featureTypeParent) {
        child.getFeatures().add(featureTypeParent);
        parent.getFeatures().remove(featureTypeParent);
    }





}
