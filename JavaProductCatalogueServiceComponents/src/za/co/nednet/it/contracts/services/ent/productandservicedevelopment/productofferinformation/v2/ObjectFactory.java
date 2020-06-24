
package za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SystemCode_QNAME = new QName("http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", "systemCode");
    private final static QName _SystemName_QNAME = new QName("http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", "systemName");
    private final static QName _FeeIdentifier_QNAME = new QName("http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", "feeIdentifier");
    private final static QName _ProductIdentifier_QNAME = new QName("http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", "productIdentifier");
    private final static QName _Description_QNAME = new QName("http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", "description");
    private final static QName _FieldValue_QNAME = new QName("http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", "fieldValue");
    private final static QName _FieldName_QNAME = new QName("http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", "fieldName");
    private final static QName _SystemId_QNAME = new QName("http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", "systemId");
    private final static QName _FeatureIdentifier_QNAME = new QName("http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", "featureIdentifier");
    private final static QName _SourceSystem_QNAME = new QName("http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", "sourceSystem");
    private final static QName _Code_QNAME = new QName("http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", "code");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RetrieveProductFeesResponse }
     * 
     */
    public RetrieveProductFeesResponse createRetrieveProductFeesResponse() {
        return new RetrieveProductFeesResponse();
    }

    /**
     * Create an instance of {@link RetrieveProductConditions }
     * 
     */
    public RetrieveProductConditions createRetrieveProductConditions() {
        return new RetrieveProductConditions();
    }

    /**
     * Create an instance of {@link RetrieveProductInterestRates }
     * 
     */
    public RetrieveProductInterestRates createRetrieveProductInterestRates() {
        return new RetrieveProductInterestRates();
    }

    /**
     * Create an instance of {@link RetrieveProductOfferInformationResponse }
     * 
     */
    public RetrieveProductOfferInformationResponse createRetrieveProductOfferInformationResponse() {
        return new RetrieveProductOfferInformationResponse();
    }

    /**
     * Create an instance of {@link RetrieveProductInterestRatesResponse }
     * 
     */
    public RetrieveProductInterestRatesResponse createRetrieveProductInterestRatesResponse() {
        return new RetrieveProductInterestRatesResponse();
    }

    /**
     * Create an instance of {@link RetrieveProductAlternativeIdentifiersResponse }
     * 
     */
    public RetrieveProductAlternativeIdentifiersResponse createRetrieveProductAlternativeIdentifiersResponse() {
        return new RetrieveProductAlternativeIdentifiersResponse();
    }

    /**
     * Create an instance of {@link RetrieveProductFeaturesResponse }
     * 
     */
    public RetrieveProductFeaturesResponse createRetrieveProductFeaturesResponse() {
        return new RetrieveProductFeaturesResponse();
    }

    /**
     * Create an instance of {@link RetrieveProductResourceItemsResponse }
     * 
     */
    public RetrieveProductResourceItemsResponse createRetrieveProductResourceItemsResponse() {
        return new RetrieveProductResourceItemsResponse();
    }

    /**
     * Create an instance of {@link FeatureAlternativeIdentifier }
     * 
     */
    public FeatureAlternativeIdentifier createFeatureAlternativeIdentifier() {
        return new FeatureAlternativeIdentifier();
    }

    /**
     * Create an instance of {@link RetrieveProductResourceItemsResponse.CharacteristicSets }
     * 
     */
    public RetrieveProductResourceItemsResponse.CharacteristicSets createRetrieveProductResourceItemsResponseCharacteristicSets() {
        return new RetrieveProductResourceItemsResponse.CharacteristicSets();
    }

    /**
     * Create an instance of {@link RetrieveProductInterestRatesResponse.CharacteristicSets }
     * 
     */
    public RetrieveProductInterestRatesResponse.CharacteristicSets createRetrieveProductInterestRatesResponseCharacteristicSets() {
        return new RetrieveProductInterestRatesResponse.CharacteristicSets();
    }

    /**
     * Create an instance of {@link RetrieveProductOfferInformationResponse.CharacteristicSets }
     * 
     */
    public RetrieveProductOfferInformationResponse.CharacteristicSets createRetrieveProductOfferInformationResponseCharacteristicSets() {
        return new RetrieveProductOfferInformationResponse.CharacteristicSets();
    }

    /**
     * Create an instance of {@link RetrieveProductOfferInformationResponse.ProductRateConditions }
     * 
     */
    public RetrieveProductOfferInformationResponse.ProductRateConditions createRetrieveProductOfferInformationResponseProductRateConditions() {
        return new RetrieveProductOfferInformationResponse.ProductRateConditions();
    }

    /**
     * Create an instance of {@link ProductAlternativeIdentifier }
     * 
     */
    public ProductAlternativeIdentifier createProductAlternativeIdentifier() {
        return new ProductAlternativeIdentifier();
    }

    /**
     * Create an instance of {@link ConditionType }
     * 
     */
    public ConditionType createConditionType() {
        return new ConditionType();
    }

    /**
     * Create an instance of {@link ConditionType.ConditionValues }
     * 
     */
    public ConditionType.ConditionValues createConditionTypeConditionValues() {
        return new ConditionType.ConditionValues();
    }

    /**
     * Create an instance of {@link RetrieveProductFeesResponse.CharacteristicsSets }
     * 
     */
    public RetrieveProductFeesResponse.CharacteristicsSets createRetrieveProductFeesResponseCharacteristicsSets() {
        return new RetrieveProductFeesResponse.CharacteristicsSets();
    }

    /**
     * Create an instance of {@link RetrieveProductFeatures }
     * 
     */
    public RetrieveProductFeatures createRetrieveProductFeatures() {
        return new RetrieveProductFeatures();
    }

    /**
     * Create an instance of {@link RetrieveProductFeesResponse.FeeDetails }
     * 
     */
    public RetrieveProductFeesResponse.FeeDetails createRetrieveProductFeesResponseFeeDetails() {
        return new RetrieveProductFeesResponse.FeeDetails();
    }

    /**
     * Create an instance of {@link ResultSet }
     * 
     */
    public ResultSet createResultSet() {
        return new ResultSet();
    }

    /**
     * Create an instance of {@link RetrieveProductFees }
     * 
     */
    public RetrieveProductFees createRetrieveProductFees() {
        return new RetrieveProductFees();
    }

    /**
     * Create an instance of {@link FeeIdentifierType }
     * 
     */
    public FeeIdentifierType createFeeIdentifierType() {
        return new FeeIdentifierType();
    }

    /**
     * Create an instance of {@link CodeDescriptionType }
     * 
     */
    public CodeDescriptionType createCodeDescriptionType() {
        return new CodeDescriptionType();
    }

    /**
     * Create an instance of {@link CharacteristicType }
     * 
     */
    public CharacteristicType createCharacteristicType() {
        return new CharacteristicType();
    }

    /**
     * Create an instance of {@link RetrieveProductResourceItems }
     * 
     */
    public RetrieveProductResourceItems createRetrieveProductResourceItems() {
        return new RetrieveProductResourceItems();
    }

    /**
     * Create an instance of {@link RetrieveProductConditions.ConditionFilters }
     * 
     */
    public RetrieveProductConditions.ConditionFilters createRetrieveProductConditionsConditionFilters() {
        return new RetrieveProductConditions.ConditionFilters();
    }

    /**
     * Create an instance of {@link RetrieveProductConditionsResponse }
     * 
     */
    public RetrieveProductConditionsResponse createRetrieveProductConditionsResponse() {
        return new RetrieveProductConditionsResponse();
    }

    /**
     * Create an instance of {@link RetrieveProductInterestRates.InterestRates }
     * 
     */
    public RetrieveProductInterestRates.InterestRates createRetrieveProductInterestRatesInterestRates() {
        return new RetrieveProductInterestRates.InterestRates();
    }

    /**
     * Create an instance of {@link ProductNameType }
     * 
     */
    public ProductNameType createProductNameType() {
        return new ProductNameType();
    }

    /**
     * Create an instance of {@link RetrieveProductOfferInformationResponse.ProductFeatureDetails }
     * 
     */
    public RetrieveProductOfferInformationResponse.ProductFeatureDetails createRetrieveProductOfferInformationResponseProductFeatureDetails() {
        return new RetrieveProductOfferInformationResponse.ProductFeatureDetails();
    }

    /**
     * Create an instance of {@link RetrieveProductOfferInformationResponse.ResourceItemDetails }
     * 
     */
    public RetrieveProductOfferInformationResponse.ResourceItemDetails createRetrieveProductOfferInformationResponseResourceItemDetails() {
        return new RetrieveProductOfferInformationResponse.ResourceItemDetails();
    }

    /**
     * Create an instance of {@link RetrieveProductOfferInformation }
     * 
     */
    public RetrieveProductOfferInformation createRetrieveProductOfferInformation() {
        return new RetrieveProductOfferInformation();
    }

    /**
     * Create an instance of {@link RetrieveProductAlternativeIdentifiers }
     * 
     */
    public RetrieveProductAlternativeIdentifiers createRetrieveProductAlternativeIdentifiers() {
        return new RetrieveProductAlternativeIdentifiers();
    }

    /**
     * Create an instance of {@link SystemType }
     * 
     */
    public SystemType createSystemType() {
        return new SystemType();
    }

    /**
     * Create an instance of {@link RetrieveProductInterestRatesResponse.InterestRateDetails }
     * 
     */
    public RetrieveProductInterestRatesResponse.InterestRateDetails createRetrieveProductInterestRatesResponseInterestRateDetails() {
        return new RetrieveProductInterestRatesResponse.InterestRateDetails();
    }

    /**
     * Create an instance of {@link RetrieveProductAlternativeIdentifiersResponse.CharacteristicSets }
     * 
     */
    public RetrieveProductAlternativeIdentifiersResponse.CharacteristicSets createRetrieveProductAlternativeIdentifiersResponseCharacteristicSets() {
        return new RetrieveProductAlternativeIdentifiersResponse.CharacteristicSets();
    }

    /**
     * Create an instance of {@link RetrieveProductFeaturesResponse.FeatureDetails }
     * 
     */
    public RetrieveProductFeaturesResponse.FeatureDetails createRetrieveProductFeaturesResponseFeatureDetails() {
        return new RetrieveProductFeaturesResponse.FeatureDetails();
    }

    /**
     * Create an instance of {@link RetrieveProductResourceItemsResponse.ResourceItemDetails }
     * 
     */
    public RetrieveProductResourceItemsResponse.ResourceItemDetails createRetrieveProductResourceItemsResponseResourceItemDetails() {
        return new RetrieveProductResourceItemsResponse.ResourceItemDetails();
    }

    /**
     * Create an instance of {@link PricingPlanType }
     * 
     */
    public PricingPlanType createPricingPlanType() {
        return new PricingPlanType();
    }

    /**
     * Create an instance of {@link PlasticDocumentType }
     * 
     */
    public PlasticDocumentType createPlasticDocumentType() {
        return new PlasticDocumentType();
    }

    /**
     * Create an instance of {@link FeatureGroupType }
     * 
     */
    public FeatureGroupType createFeatureGroupType() {
        return new FeatureGroupType();
    }

    /**
     * Create an instance of {@link InterestRateType }
     * 
     */
    public InterestRateType createInterestRateType() {
        return new InterestRateType();
    }

    /**
     * Create an instance of {@link IdentifierType }
     * 
     */
    public IdentifierType createIdentifierType() {
        return new IdentifierType();
    }

    /**
     * Create an instance of {@link FeeTierType }
     * 
     */
    public FeeTierType createFeeTierType() {
        return new FeeTierType();
    }

    /**
     * Create an instance of {@link FeeType }
     * 
     */
    public FeeType createFeeType() {
        return new FeeType();
    }

    /**
     * Create an instance of {@link InterestTierType }
     * 
     */
    public InterestTierType createInterestTierType() {
        return new InterestTierType();
    }

    /**
     * Create an instance of {@link FeatureIdentificationType }
     * 
     */
    public FeatureIdentificationType createFeatureIdentificationType() {
        return new FeatureIdentificationType();
    }

    /**
     * Create an instance of {@link RateType }
     * 
     */
    public RateType createRateType() {
        return new RateType();
    }

    /**
     * Create an instance of {@link FeeAmountType }
     * 
     */
    public FeeAmountType createFeeAmountType() {
        return new FeeAmountType();
    }

    /**
     * Create an instance of {@link FeeParameterType }
     * 
     */
    public FeeParameterType createFeeParameterType() {
        return new FeeParameterType();
    }

    /**
     * Create an instance of {@link RateIdentifierType }
     * 
     */
    public RateIdentifierType createRateIdentifierType() {
        return new RateIdentifierType();
    }

    /**
     * Create an instance of {@link ResourceItemType }
     * 
     */
    public ResourceItemType createResourceItemType() {
        return new ResourceItemType();
    }

    /**
     * Create an instance of {@link AmountType }
     * 
     */
    public AmountType createAmountType() {
        return new AmountType();
    }

    /**
     * Create an instance of {@link PricingDiscriminatorType }
     * 
     */
    public PricingDiscriminatorType createPricingDiscriminatorType() {
        return new PricingDiscriminatorType();
    }

    /**
     * Create an instance of {@link FeatureAlternativeIdentifier.FeatureKeys }
     * 
     */
    public FeatureAlternativeIdentifier.FeatureKeys createFeatureAlternativeIdentifierFeatureKeys() {
        return new FeatureAlternativeIdentifier.FeatureKeys();
    }

    /**
     * Create an instance of {@link RetrieveProductResourceItemsResponse.CharacteristicSets.ResourceItemDetails }
     * 
     */
    public RetrieveProductResourceItemsResponse.CharacteristicSets.ResourceItemDetails createRetrieveProductResourceItemsResponseCharacteristicSetsResourceItemDetails() {
        return new RetrieveProductResourceItemsResponse.CharacteristicSets.ResourceItemDetails();
    }

    /**
     * Create an instance of {@link RetrieveProductInterestRatesResponse.CharacteristicSets.InterestRates }
     * 
     */
    public RetrieveProductInterestRatesResponse.CharacteristicSets.InterestRates createRetrieveProductInterestRatesResponseCharacteristicSetsInterestRates() {
        return new RetrieveProductInterestRatesResponse.CharacteristicSets.InterestRates();
    }

    /**
     * Create an instance of {@link RetrieveProductOfferInformationResponse.CharacteristicSets.InterestRates }
     * 
     */
    public RetrieveProductOfferInformationResponse.CharacteristicSets.InterestRates createRetrieveProductOfferInformationResponseCharacteristicSetsInterestRates() {
        return new RetrieveProductOfferInformationResponse.CharacteristicSets.InterestRates();
    }

    /**
     * Create an instance of {@link RetrieveProductOfferInformationResponse.CharacteristicSets.FeeDetails }
     * 
     */
    public RetrieveProductOfferInformationResponse.CharacteristicSets.FeeDetails createRetrieveProductOfferInformationResponseCharacteristicSetsFeeDetails() {
        return new RetrieveProductOfferInformationResponse.CharacteristicSets.FeeDetails();
    }

    /**
     * Create an instance of {@link RetrieveProductOfferInformationResponse.CharacteristicSets.ResourceItemDetails }
     * 
     */
    public RetrieveProductOfferInformationResponse.CharacteristicSets.ResourceItemDetails createRetrieveProductOfferInformationResponseCharacteristicSetsResourceItemDetails() {
        return new RetrieveProductOfferInformationResponse.CharacteristicSets.ResourceItemDetails();
    }

    /**
     * Create an instance of {@link RetrieveProductOfferInformationResponse.ProductRateConditions.InterestRates }
     * 
     */
    public RetrieveProductOfferInformationResponse.ProductRateConditions.InterestRates createRetrieveProductOfferInformationResponseProductRateConditionsInterestRates() {
        return new RetrieveProductOfferInformationResponse.ProductRateConditions.InterestRates();
    }

    /**
     * Create an instance of {@link RetrieveProductOfferInformationResponse.ProductRateConditions.FeeDetails }
     * 
     */
    public RetrieveProductOfferInformationResponse.ProductRateConditions.FeeDetails createRetrieveProductOfferInformationResponseProductRateConditionsFeeDetails() {
        return new RetrieveProductOfferInformationResponse.ProductRateConditions.FeeDetails();
    }

    /**
     * Create an instance of {@link ProductAlternativeIdentifier.ProductKeys }
     * 
     */
    public ProductAlternativeIdentifier.ProductKeys createProductAlternativeIdentifierProductKeys() {
        return new ProductAlternativeIdentifier.ProductKeys();
    }

    /**
     * Create an instance of {@link ConditionType.ConditionValues.ConditionValue }
     * 
     */
    public ConditionType.ConditionValues.ConditionValue createConditionTypeConditionValuesConditionValue() {
        return new ConditionType.ConditionValues.ConditionValue();
    }

    /**
     * Create an instance of {@link RetrieveProductFeesResponse.CharacteristicsSets.FeeDetails }
     * 
     */
    public RetrieveProductFeesResponse.CharacteristicsSets.FeeDetails createRetrieveProductFeesResponseCharacteristicsSetsFeeDetails() {
        return new RetrieveProductFeesResponse.CharacteristicsSets.FeeDetails();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", name = "systemCode")
    public JAXBElement<String> createSystemCode(String value) {
        return new JAXBElement<String>(_SystemCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", name = "systemName")
    public JAXBElement<String> createSystemName(String value) {
        return new JAXBElement<String>(_SystemName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeeIdentifierType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", name = "feeIdentifier")
    public JAXBElement<FeeIdentifierType> createFeeIdentifier(FeeIdentifierType value) {
        return new JAXBElement<FeeIdentifierType>(_FeeIdentifier_QNAME, FeeIdentifierType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", name = "productIdentifier")
    public JAXBElement<BigInteger> createProductIdentifier(BigInteger value) {
        return new JAXBElement<BigInteger>(_ProductIdentifier_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", name = "description")
    public JAXBElement<String> createDescription(String value) {
        return new JAXBElement<String>(_Description_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", name = "fieldValue")
    public JAXBElement<String> createFieldValue(String value) {
        return new JAXBElement<String>(_FieldValue_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", name = "fieldName")
    public JAXBElement<String> createFieldName(String value) {
        return new JAXBElement<String>(_FieldName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", name = "systemId")
    public JAXBElement<String> createSystemId(String value) {
        return new JAXBElement<String>(_SystemId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", name = "featureIdentifier")
    public JAXBElement<String> createFeatureIdentifier(String value) {
        return new JAXBElement<String>(_FeatureIdentifier_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SystemType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", name = "sourceSystem")
    public JAXBElement<SystemType> createSourceSystem(SystemType value) {
        return new JAXBElement<SystemType>(_SourceSystem_QNAME, SystemType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2", name = "code")
    public JAXBElement<String> createCode(String value) {
        return new JAXBElement<String>(_Code_QNAME, String.class, null, value);
    }

}
