package za.co.nb.productcatalogue.ejb.file;

import za.co.nb.productcatalogue.ejb.ProductTypeJaxbContext;
import za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1.FeatureAttributeGroupType;
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
        insertInheritedFeature(child);
        insertInheritedFeatureAttribGroup(child);
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
        }
    }


    private void insertInheritedFeature(ProductType child) {

        for(FeaturesType featuresType :child.getFeatures()){

            if(featuresType.getInheritFromFiles() != null){
                ProductType parent = loadFile(featuresType.getInheritFromFiles());
                for(FeaturesType parentFeature :parent.getFeatures()){
                    if(featuresType.getFeatureIdentifier().toString().equals(parentFeature.getFeatureIdentifier().toString())){
                        featuresType.getFeatureAttributeGroup().addAll(parentFeature.getFeatureAttributeGroup());
                        featuresType.getFeatureFulfilment().addAll(parentFeature.getFeatureFulfilment());
                        featuresType.getFeatureGrouping().addAll(parentFeature.getFeatureGrouping());
                        break;
                    }
                }

            }
        }
    }


    private void insertInheritedFeatureAttribGroup(ProductType child) {

        for(FeaturesType featuresType :child.getFeatures()){

            List<FeatureAttributeGroupType> tempFeatureAttributeGroups = new ArrayList<>(featuresType.getFeatureAttributeGroup());
            for(FeatureAttributeGroupType featureAttributeGroupType : tempFeatureAttributeGroups){

                if(featureAttributeGroupType.getInheritFromFiles() != null){

                    if(featureAttributeGroupType.getAction() != null)
                        throw new RuntimeException("Both InheritFromFiles and Action cannot be populated, FeatureAttributeGroupType:"+featureAttributeGroupType.getAttributeGroupName());

                    ProductType parent = loadFile(featureAttributeGroupType.getInheritFromFiles());

                    for(FeaturesType parentFeature :parent.getFeatures()){
                        if(featuresType.getFeatureIdentifier().toString().equals(parentFeature.getFeatureIdentifier().toString())){

                            List<FeatureAttributeGroupType> tempParentFeatureAttributeGroups = new ArrayList<>(parentFeature.getFeatureAttributeGroup());
                            for(FeatureAttributeGroupType parentFeatureAttributeGroupType : tempParentFeatureAttributeGroups){

                                if(parentFeatureAttributeGroupType.getAttributeGroupName().equals(featureAttributeGroupType.getAttributeGroupName())){
                                    featuresType.getFeatureAttributeGroup().remove(featureAttributeGroupType);
                                    featuresType.getFeatureAttributeGroup().add(parentFeatureAttributeGroupType);
                                    parentFeature.getFeatureAttributeGroup().remove(parentFeatureAttributeGroupType);
                                    break;
                                }
                            }
                        }
                    }
                }
            }

        }
    }



    private void insertProductAttributeGroup(ProductType child, ProductType parent){

        List<ProductAttributeGroupType> tempChildProductAttributeGroup = new ArrayList<>(child.getProductAttributeGroup());

        List<String> productAttributeGroupIndex = getProductAttributeGroupIndex(tempChildProductAttributeGroup);
        for(ProductAttributeGroupType productAttributeGroup :tempChildProductAttributeGroup){

            List<ProductAttributeGroupType> tempParentProductAttributeGroup = new ArrayList<>(parent.getProductAttributeGroup());
            for(ProductAttributeGroupType productAttributeGroupParent :tempParentProductAttributeGroup) {

                if (!productAttributeGroupIndex.contains(productAttributeGroupParent.getAttributeGroupName()))
                    addProductAttribGroup(child, parent, null, productAttributeGroupParent);
                else
                    addProductAttribGroup(child, parent, productAttributeGroup, productAttributeGroupParent);

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
                    addFeature(child, parent, null, featureTypeParent);
                else
                    addFeature(child, parent,featuresType, featureTypeParent);

            }
        }
    }

    private void addProductAttribGroup(ProductType child, ProductType parent, ProductAttributeGroupType productAttributeGroup, ProductAttributeGroupType productAttributeGroupParent) {

        if(productAttributeGroup == null){
            addToChildProductAttrib(child, parent, productAttributeGroupParent);
        }else if(productAttributeGroupParent.getAttributeGroupName().equals(productAttributeGroup.getAttributeGroupName()))
           if (productAttributeGroup.getAction() == null && productAttributeGroup.getInheritFromFiles() == null){
               ProductAttributeGroupType productAttributeGroupType = child.getProductAttributeGroup().get(child.getProductAttributeGroup().indexOf(productAttributeGroup));
               productAttributeGroupType.getProductAttributes().addAll(productAttributeGroupParent.getProductAttributes());
           }else if (productAttributeGroup.getAction() != null){
                   if (productAttributeGroup.getInheritFromFiles() != null)
                       throw new RuntimeException("Both InheritFromFiles and Action cannot be populated, ProductAttributeGroup:"+productAttributeGroup.getAttributeGroupName());

                   if (!(productAttributeGroup.getAction().equals("overwrite") || productAttributeGroup.getAction().equals("override"))) {
                       addToChildProductAttrib(child, parent, productAttributeGroupParent);
                   }
           }
    }

    private void addToChildProductAttrib(ProductType child, ProductType parent, ProductAttributeGroupType productAttributeGroupParent) {
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

    private void addFeature(ProductType child, ProductType parent, FeaturesType featuresType, FeaturesType featureTypeParent) {

        if(featuresType == null){
            addToChildFeature(child, parent, featureTypeParent);
        }else if(featureTypeParent.getFeatureIdentifier().toString().equals(featuresType.getFeatureIdentifier().toString()))
            if(featuresType.getAction() == null && featuresType.getInheritFromFiles() == null) {
                FeaturesType feature = child.getFeatures().get(child.getFeatures().indexOf(featuresType));

                feature.getFeatureGrouping().addAll(featureTypeParent.getFeatureGrouping());
                feature.getFeatureFulfilment().addAll(featureTypeParent.getFeatureFulfilment());
                addFeatureAttributeGroup(featureTypeParent, feature);


            }else if(featuresType.getAction() != null) {

                if (featuresType.getInheritFromFiles() != null)
                    throw new RuntimeException("Both InheritFromFiles and Action cannot be populated, FeaturesType:"+featuresType.getFeatureIdentifier());

                if (!(featuresType.getAction().equals("overwrite") || featuresType.getAction().equals("override"))) {
                    addToChildFeature(child, parent, featureTypeParent);
                }
            }

    }

    private void addFeatureAttributeGroup(FeaturesType featureTypeParent, FeaturesType feature) {
        for(FeatureAttributeGroupType featureAttributeGroupType : feature.getFeatureAttributeGroup()){

            List<FeatureAttributeGroupType> tempFeatureAttributeGroupTypes = new ArrayList<>(featureTypeParent.getFeatureAttributeGroup());
                for(FeatureAttributeGroupType parentFeatureAttributeGroupType  :tempFeatureAttributeGroupTypes)
                    if(featureAttributeGroupType.getAttributeGroupName().equals(parentFeatureAttributeGroupType.getAttributeGroupName()))
                        if(featureAttributeGroupType.getAction() != null && (featureAttributeGroupType.getAction().equals("overwrite") || featureAttributeGroupType.getAction().equals("override")))
                            featureTypeParent.getFeatureAttributeGroup().remove(parentFeatureAttributeGroupType);

        }
        feature.getFeatureAttributeGroup().addAll(featureTypeParent.getFeatureAttributeGroup());
    }

    private void addToChildFeature(ProductType child, ProductType parent, FeaturesType featureTypeParent) {
        child.getFeatures().add(featureTypeParent);
        parent.getFeatures().remove(featureTypeParent);
    }


}
