
package za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}productIdentifier" minOccurs="0"/>
 *         &lt;element name="productNames" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}ProductName_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="productAlternativeIdentifiers" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}ProductAlternativeIdentifier" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="productConditions" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Condition_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="productFeatureDetails" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="featureIdentification" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeatureIdentification_Type" minOccurs="0"/>
 *                   &lt;element name="featureAlternativeIdentifiers" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeatureAlternativeIdentifier" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="featureGroup" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeatureGroup_Type" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="productRateConditions" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="interestRates" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="interestRate" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}InterestRate_Type"/>
 *                             &lt;element name="rateParameters" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Characteristic_Type" maxOccurs="unbounded" minOccurs="0"/>
 *                             &lt;element name="interestTiers" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}InterestTier_Type" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="feeDetails" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="feeIdentifier" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeeIdentifier_Type"/>
 *                             &lt;element name="feeParameters" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeeParameter_Type" maxOccurs="unbounded" minOccurs="0"/>
 *                             &lt;element name="fee" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Fee_Type" minOccurs="0"/>
 *                             &lt;element name="feeTotal" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeeAmount_Type" minOccurs="0"/>
 *                             &lt;element name="feeTiers" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeeTier_Type" maxOccurs="unbounded" minOccurs="0"/>
 *                             &lt;element name="pricingPlan" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}PricingPlan_Type" maxOccurs="unbounded" minOccurs="0"/>
 *                             &lt;element name="referenceRateType" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Rate_Type" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="resourceItemDetails" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="resourceItem" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}ResourceItem_Type"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="characteristicSets" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="identifiers" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Identifier_Type" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="characteristics" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Characteristic_Type" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="interestRates" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="interestRate" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}InterestRate_Type"/>
 *                             &lt;element name="rateParameters" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Characteristic_Type" maxOccurs="unbounded" minOccurs="0"/>
 *                             &lt;element name="interestTiers" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}InterestTier_Type" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="feeDetails" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="feeIdentifier" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeeIdentifier_Type"/>
 *                             &lt;element name="feeParameters" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeeParameter_Type" maxOccurs="unbounded" minOccurs="0"/>
 *                             &lt;element name="fee" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Fee_Type" minOccurs="0"/>
 *                             &lt;element name="feeTotal" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeeAmount_Type" minOccurs="0"/>
 *                             &lt;element name="feeTiers" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeeTier_Type" maxOccurs="unbounded" minOccurs="0"/>
 *                             &lt;element name="referenceRateType" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Rate_Type" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="resourceItemDetails" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="resourceItem" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}ResourceItem_Type"/>
 *                             &lt;element name="plasticDocument" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}PlasticDocument_Type" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}resultSet"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "productIdentifier",
    "productNames",
    "productAlternativeIdentifiers",
    "productConditions",
    "productFeatureDetails",
    "productRateConditions",
    "resourceItemDetails",
    "characteristicSets",
    "resultSet"
})
@XmlRootElement(name = "RetrieveProductOfferInformationResponse")
public class RetrieveProductOfferInformationResponse {

    protected BigInteger productIdentifier;
    protected List<ProductNameType> productNames;
    protected List<ProductAlternativeIdentifier> productAlternativeIdentifiers;
    protected List<ConditionType> productConditions;
    protected List<RetrieveProductOfferInformationResponse.ProductFeatureDetails> productFeatureDetails;
    protected RetrieveProductOfferInformationResponse.ProductRateConditions productRateConditions;
    protected List<RetrieveProductOfferInformationResponse.ResourceItemDetails> resourceItemDetails;
    protected List<RetrieveProductOfferInformationResponse.CharacteristicSets> characteristicSets;
    @XmlElement(required = true)
    protected ResultSet resultSet;

    /**
     * Gets the value of the productIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getProductIdentifier() {
        return productIdentifier;
    }

    /**
     * Sets the value of the productIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setProductIdentifier(BigInteger value) {
        this.productIdentifier = value;
    }

    /**
     * Gets the value of the productNames property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productNames property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductNames().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductNameType }
     * 
     * 
     */
    public List<ProductNameType> getProductNames() {
        if (productNames == null) {
            productNames = new ArrayList<ProductNameType>();
        }
        return this.productNames;
    }

    /**
     * Gets the value of the productAlternativeIdentifiers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productAlternativeIdentifiers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductAlternativeIdentifiers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductAlternativeIdentifier }
     * 
     * 
     */
    public List<ProductAlternativeIdentifier> getProductAlternativeIdentifiers() {
        if (productAlternativeIdentifiers == null) {
            productAlternativeIdentifiers = new ArrayList<ProductAlternativeIdentifier>();
        }
        return this.productAlternativeIdentifiers;
    }

    /**
     * Gets the value of the productConditions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productConditions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductConditions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConditionType }
     * 
     * 
     */
    public List<ConditionType> getProductConditions() {
        if (productConditions == null) {
            productConditions = new ArrayList<ConditionType>();
        }
        return this.productConditions;
    }

    /**
     * Gets the value of the productFeatureDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productFeatureDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductFeatureDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RetrieveProductOfferInformationResponse.ProductFeatureDetails }
     * 
     * 
     */
    public List<RetrieveProductOfferInformationResponse.ProductFeatureDetails> getProductFeatureDetails() {
        if (productFeatureDetails == null) {
            productFeatureDetails = new ArrayList<RetrieveProductOfferInformationResponse.ProductFeatureDetails>();
        }
        return this.productFeatureDetails;
    }

    /**
     * Gets the value of the productRateConditions property.
     * 
     * @return
     *     possible object is
     *     {@link RetrieveProductOfferInformationResponse.ProductRateConditions }
     *     
     */
    public RetrieveProductOfferInformationResponse.ProductRateConditions getProductRateConditions() {
        return productRateConditions;
    }

    /**
     * Sets the value of the productRateConditions property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetrieveProductOfferInformationResponse.ProductRateConditions }
     *     
     */
    public void setProductRateConditions(RetrieveProductOfferInformationResponse.ProductRateConditions value) {
        this.productRateConditions = value;
    }

    /**
     * Gets the value of the resourceItemDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resourceItemDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResourceItemDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RetrieveProductOfferInformationResponse.ResourceItemDetails }
     * 
     * 
     */
    public List<RetrieveProductOfferInformationResponse.ResourceItemDetails> getResourceItemDetails() {
        if (resourceItemDetails == null) {
            resourceItemDetails = new ArrayList<RetrieveProductOfferInformationResponse.ResourceItemDetails>();
        }
        return this.resourceItemDetails;
    }

    /**
     * Gets the value of the characteristicSets property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the characteristicSets property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCharacteristicSets().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RetrieveProductOfferInformationResponse.CharacteristicSets }
     * 
     * 
     */
    public List<RetrieveProductOfferInformationResponse.CharacteristicSets> getCharacteristicSets() {
        if (characteristicSets == null) {
            characteristicSets = new ArrayList<RetrieveProductOfferInformationResponse.CharacteristicSets>();
        }
        return this.characteristicSets;
    }

    /**
     * Gets the value of the resultSet property.
     * 
     * @return
     *     possible object is
     *     {@link ResultSet }
     *     
     */
    public ResultSet getResultSet() {
        return resultSet;
    }

    /**
     * Sets the value of the resultSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultSet }
     *     
     */
    public void setResultSet(ResultSet value) {
        this.resultSet = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="identifiers" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Identifier_Type" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="characteristics" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Characteristic_Type" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="interestRates" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="interestRate" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}InterestRate_Type"/>
     *                   &lt;element name="rateParameters" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Characteristic_Type" maxOccurs="unbounded" minOccurs="0"/>
     *                   &lt;element name="interestTiers" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}InterestTier_Type" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="feeDetails" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="feeIdentifier" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeeIdentifier_Type"/>
     *                   &lt;element name="feeParameters" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeeParameter_Type" maxOccurs="unbounded" minOccurs="0"/>
     *                   &lt;element name="fee" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Fee_Type" minOccurs="0"/>
     *                   &lt;element name="feeTotal" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeeAmount_Type" minOccurs="0"/>
     *                   &lt;element name="feeTiers" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeeTier_Type" maxOccurs="unbounded" minOccurs="0"/>
     *                   &lt;element name="referenceRateType" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Rate_Type" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="resourceItemDetails" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="resourceItem" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}ResourceItem_Type"/>
     *                   &lt;element name="plasticDocument" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}PlasticDocument_Type" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "identifiers",
        "characteristics",
        "interestRates",
        "feeDetails",
        "resourceItemDetails"
    })
    public static class CharacteristicSets {

        protected List<IdentifierType> identifiers;
        protected List<CharacteristicType> characteristics;
        protected List<RetrieveProductOfferInformationResponse.CharacteristicSets.InterestRates> interestRates;
        protected List<RetrieveProductOfferInformationResponse.CharacteristicSets.FeeDetails> feeDetails;
        protected List<RetrieveProductOfferInformationResponse.CharacteristicSets.ResourceItemDetails> resourceItemDetails;

        /**
         * Gets the value of the identifiers property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the identifiers property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getIdentifiers().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link IdentifierType }
         * 
         * 
         */
        public List<IdentifierType> getIdentifiers() {
            if (identifiers == null) {
                identifiers = new ArrayList<IdentifierType>();
            }
            return this.identifiers;
        }

        /**
         * Gets the value of the characteristics property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the characteristics property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCharacteristics().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CharacteristicType }
         * 
         * 
         */
        public List<CharacteristicType> getCharacteristics() {
            if (characteristics == null) {
                characteristics = new ArrayList<CharacteristicType>();
            }
            return this.characteristics;
        }

        /**
         * Gets the value of the interestRates property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the interestRates property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInterestRates().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link RetrieveProductOfferInformationResponse.CharacteristicSets.InterestRates }
         * 
         * 
         */
        public List<RetrieveProductOfferInformationResponse.CharacteristicSets.InterestRates> getInterestRates() {
            if (interestRates == null) {
                interestRates = new ArrayList<RetrieveProductOfferInformationResponse.CharacteristicSets.InterestRates>();
            }
            return this.interestRates;
        }

        /**
         * Gets the value of the feeDetails property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the feeDetails property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFeeDetails().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link RetrieveProductOfferInformationResponse.CharacteristicSets.FeeDetails }
         * 
         * 
         */
        public List<RetrieveProductOfferInformationResponse.CharacteristicSets.FeeDetails> getFeeDetails() {
            if (feeDetails == null) {
                feeDetails = new ArrayList<RetrieveProductOfferInformationResponse.CharacteristicSets.FeeDetails>();
            }
            return this.feeDetails;
        }

        /**
         * Gets the value of the resourceItemDetails property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the resourceItemDetails property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getResourceItemDetails().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link RetrieveProductOfferInformationResponse.CharacteristicSets.ResourceItemDetails }
         * 
         * 
         */
        public List<RetrieveProductOfferInformationResponse.CharacteristicSets.ResourceItemDetails> getResourceItemDetails() {
            if (resourceItemDetails == null) {
                resourceItemDetails = new ArrayList<RetrieveProductOfferInformationResponse.CharacteristicSets.ResourceItemDetails>();
            }
            return this.resourceItemDetails;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="feeIdentifier" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeeIdentifier_Type"/>
         *         &lt;element name="feeParameters" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeeParameter_Type" maxOccurs="unbounded" minOccurs="0"/>
         *         &lt;element name="fee" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Fee_Type" minOccurs="0"/>
         *         &lt;element name="feeTotal" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeeAmount_Type" minOccurs="0"/>
         *         &lt;element name="feeTiers" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeeTier_Type" maxOccurs="unbounded" minOccurs="0"/>
         *         &lt;element name="referenceRateType" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Rate_Type" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "feeIdentifier",
            "feeParameters",
            "fee",
            "feeTotal",
            "feeTiers",
            "referenceRateType"
        })
        public static class FeeDetails {

            @XmlElement(required = true)
            protected FeeIdentifierType feeIdentifier;
            protected List<FeeParameterType> feeParameters;
            protected FeeType fee;
            protected FeeAmountType feeTotal;
            protected List<FeeTierType> feeTiers;
            protected RateType referenceRateType;

            /**
             * Gets the value of the feeIdentifier property.
             * 
             * @return
             *     possible object is
             *     {@link FeeIdentifierType }
             *     
             */
            public FeeIdentifierType getFeeIdentifier() {
                return feeIdentifier;
            }

            /**
             * Sets the value of the feeIdentifier property.
             * 
             * @param value
             *     allowed object is
             *     {@link FeeIdentifierType }
             *     
             */
            public void setFeeIdentifier(FeeIdentifierType value) {
                this.feeIdentifier = value;
            }

            /**
             * Gets the value of the feeParameters property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the feeParameters property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getFeeParameters().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link FeeParameterType }
             * 
             * 
             */
            public List<FeeParameterType> getFeeParameters() {
                if (feeParameters == null) {
                    feeParameters = new ArrayList<FeeParameterType>();
                }
                return this.feeParameters;
            }

            /**
             * Gets the value of the fee property.
             * 
             * @return
             *     possible object is
             *     {@link FeeType }
             *     
             */
            public FeeType getFee() {
                return fee;
            }

            /**
             * Sets the value of the fee property.
             * 
             * @param value
             *     allowed object is
             *     {@link FeeType }
             *     
             */
            public void setFee(FeeType value) {
                this.fee = value;
            }

            /**
             * Gets the value of the feeTotal property.
             * 
             * @return
             *     possible object is
             *     {@link FeeAmountType }
             *     
             */
            public FeeAmountType getFeeTotal() {
                return feeTotal;
            }

            /**
             * Sets the value of the feeTotal property.
             * 
             * @param value
             *     allowed object is
             *     {@link FeeAmountType }
             *     
             */
            public void setFeeTotal(FeeAmountType value) {
                this.feeTotal = value;
            }

            /**
             * Gets the value of the feeTiers property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the feeTiers property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getFeeTiers().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link FeeTierType }
             * 
             * 
             */
            public List<FeeTierType> getFeeTiers() {
                if (feeTiers == null) {
                    feeTiers = new ArrayList<FeeTierType>();
                }
                return this.feeTiers;
            }

            /**
             * Gets the value of the referenceRateType property.
             * 
             * @return
             *     possible object is
             *     {@link RateType }
             *     
             */
            public RateType getReferenceRateType() {
                return referenceRateType;
            }

            /**
             * Sets the value of the referenceRateType property.
             * 
             * @param value
             *     allowed object is
             *     {@link RateType }
             *     
             */
            public void setReferenceRateType(RateType value) {
                this.referenceRateType = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="interestRate" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}InterestRate_Type"/>
         *         &lt;element name="rateParameters" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Characteristic_Type" maxOccurs="unbounded" minOccurs="0"/>
         *         &lt;element name="interestTiers" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}InterestTier_Type" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "interestRate",
            "rateParameters",
            "interestTiers"
        })
        public static class InterestRates {

            @XmlElement(required = true)
            protected InterestRateType interestRate;
            protected List<CharacteristicType> rateParameters;
            protected List<InterestTierType> interestTiers;

            /**
             * Gets the value of the interestRate property.
             * 
             * @return
             *     possible object is
             *     {@link InterestRateType }
             *     
             */
            public InterestRateType getInterestRate() {
                return interestRate;
            }

            /**
             * Sets the value of the interestRate property.
             * 
             * @param value
             *     allowed object is
             *     {@link InterestRateType }
             *     
             */
            public void setInterestRate(InterestRateType value) {
                this.interestRate = value;
            }

            /**
             * Gets the value of the rateParameters property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the rateParameters property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getRateParameters().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link CharacteristicType }
             * 
             * 
             */
            public List<CharacteristicType> getRateParameters() {
                if (rateParameters == null) {
                    rateParameters = new ArrayList<CharacteristicType>();
                }
                return this.rateParameters;
            }

            /**
             * Gets the value of the interestTiers property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the interestTiers property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getInterestTiers().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link InterestTierType }
             * 
             * 
             */
            public List<InterestTierType> getInterestTiers() {
                if (interestTiers == null) {
                    interestTiers = new ArrayList<InterestTierType>();
                }
                return this.interestTiers;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="resourceItem" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}ResourceItem_Type"/>
         *         &lt;element name="plasticDocument" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}PlasticDocument_Type" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "resourceItem",
            "plasticDocument"
        })
        public static class ResourceItemDetails {

            @XmlElement(required = true)
            protected ResourceItemType resourceItem;
            protected List<PlasticDocumentType> plasticDocument;

            /**
             * Gets the value of the resourceItem property.
             * 
             * @return
             *     possible object is
             *     {@link ResourceItemType }
             *     
             */
            public ResourceItemType getResourceItem() {
                return resourceItem;
            }

            /**
             * Sets the value of the resourceItem property.
             * 
             * @param value
             *     allowed object is
             *     {@link ResourceItemType }
             *     
             */
            public void setResourceItem(ResourceItemType value) {
                this.resourceItem = value;
            }

            /**
             * Gets the value of the plasticDocument property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the plasticDocument property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getPlasticDocument().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link PlasticDocumentType }
             * 
             * 
             */
            public List<PlasticDocumentType> getPlasticDocument() {
                if (plasticDocument == null) {
                    plasticDocument = new ArrayList<PlasticDocumentType>();
                }
                return this.plasticDocument;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="featureIdentification" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeatureIdentification_Type" minOccurs="0"/>
     *         &lt;element name="featureAlternativeIdentifiers" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeatureAlternativeIdentifier" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="featureGroup" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeatureGroup_Type" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "featureIdentification",
        "featureAlternativeIdentifiers",
        "featureGroup"
    })
    public static class ProductFeatureDetails {

        protected FeatureIdentificationType featureIdentification;
        protected List<FeatureAlternativeIdentifier> featureAlternativeIdentifiers;
        protected FeatureGroupType featureGroup;

        /**
         * Gets the value of the featureIdentification property.
         * 
         * @return
         *     possible object is
         *     {@link FeatureIdentificationType }
         *     
         */
        public FeatureIdentificationType getFeatureIdentification() {
            return featureIdentification;
        }

        /**
         * Sets the value of the featureIdentification property.
         * 
         * @param value
         *     allowed object is
         *     {@link FeatureIdentificationType }
         *     
         */
        public void setFeatureIdentification(FeatureIdentificationType value) {
            this.featureIdentification = value;
        }

        /**
         * Gets the value of the featureAlternativeIdentifiers property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the featureAlternativeIdentifiers property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFeatureAlternativeIdentifiers().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FeatureAlternativeIdentifier }
         * 
         * 
         */
        public List<FeatureAlternativeIdentifier> getFeatureAlternativeIdentifiers() {
            if (featureAlternativeIdentifiers == null) {
                featureAlternativeIdentifiers = new ArrayList<FeatureAlternativeIdentifier>();
            }
            return this.featureAlternativeIdentifiers;
        }

        /**
         * Gets the value of the featureGroup property.
         * 
         * @return
         *     possible object is
         *     {@link FeatureGroupType }
         *     
         */
        public FeatureGroupType getFeatureGroup() {
            return featureGroup;
        }

        /**
         * Sets the value of the featureGroup property.
         * 
         * @param value
         *     allowed object is
         *     {@link FeatureGroupType }
         *     
         */
        public void setFeatureGroup(FeatureGroupType value) {
            this.featureGroup = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="interestRates" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="interestRate" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}InterestRate_Type"/>
     *                   &lt;element name="rateParameters" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Characteristic_Type" maxOccurs="unbounded" minOccurs="0"/>
     *                   &lt;element name="interestTiers" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}InterestTier_Type" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="feeDetails" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="feeIdentifier" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeeIdentifier_Type"/>
     *                   &lt;element name="feeParameters" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeeParameter_Type" maxOccurs="unbounded" minOccurs="0"/>
     *                   &lt;element name="fee" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Fee_Type" minOccurs="0"/>
     *                   &lt;element name="feeTotal" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeeAmount_Type" minOccurs="0"/>
     *                   &lt;element name="feeTiers" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeeTier_Type" maxOccurs="unbounded" minOccurs="0"/>
     *                   &lt;element name="pricingPlan" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}PricingPlan_Type" maxOccurs="unbounded" minOccurs="0"/>
     *                   &lt;element name="referenceRateType" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Rate_Type" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "interestRates",
        "feeDetails"
    })
    public static class ProductRateConditions {

        protected List<RetrieveProductOfferInformationResponse.ProductRateConditions.InterestRates> interestRates;
        protected List<RetrieveProductOfferInformationResponse.ProductRateConditions.FeeDetails> feeDetails;

        /**
         * Gets the value of the interestRates property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the interestRates property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInterestRates().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link RetrieveProductOfferInformationResponse.ProductRateConditions.InterestRates }
         * 
         * 
         */
        public List<RetrieveProductOfferInformationResponse.ProductRateConditions.InterestRates> getInterestRates() {
            if (interestRates == null) {
                interestRates = new ArrayList<RetrieveProductOfferInformationResponse.ProductRateConditions.InterestRates>();
            }
            return this.interestRates;
        }

        /**
         * Gets the value of the feeDetails property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the feeDetails property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFeeDetails().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link RetrieveProductOfferInformationResponse.ProductRateConditions.FeeDetails }
         * 
         * 
         */
        public List<RetrieveProductOfferInformationResponse.ProductRateConditions.FeeDetails> getFeeDetails() {
            if (feeDetails == null) {
                feeDetails = new ArrayList<RetrieveProductOfferInformationResponse.ProductRateConditions.FeeDetails>();
            }
            return this.feeDetails;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="feeIdentifier" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeeIdentifier_Type"/>
         *         &lt;element name="feeParameters" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeeParameter_Type" maxOccurs="unbounded" minOccurs="0"/>
         *         &lt;element name="fee" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Fee_Type" minOccurs="0"/>
         *         &lt;element name="feeTotal" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeeAmount_Type" minOccurs="0"/>
         *         &lt;element name="feeTiers" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeeTier_Type" maxOccurs="unbounded" minOccurs="0"/>
         *         &lt;element name="pricingPlan" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}PricingPlan_Type" maxOccurs="unbounded" minOccurs="0"/>
         *         &lt;element name="referenceRateType" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Rate_Type" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "feeIdentifier",
            "feeParameters",
            "fee",
            "feeTotal",
            "feeTiers",
            "pricingPlan",
            "referenceRateType"
        })
        public static class FeeDetails {

            @XmlElement(required = true)
            protected FeeIdentifierType feeIdentifier;
            protected List<FeeParameterType> feeParameters;
            protected FeeType fee;
            protected FeeAmountType feeTotal;
            protected List<FeeTierType> feeTiers;
            protected List<PricingPlanType> pricingPlan;
            protected RateType referenceRateType;

            /**
             * Gets the value of the feeIdentifier property.
             * 
             * @return
             *     possible object is
             *     {@link FeeIdentifierType }
             *     
             */
            public FeeIdentifierType getFeeIdentifier() {
                return feeIdentifier;
            }

            /**
             * Sets the value of the feeIdentifier property.
             * 
             * @param value
             *     allowed object is
             *     {@link FeeIdentifierType }
             *     
             */
            public void setFeeIdentifier(FeeIdentifierType value) {
                this.feeIdentifier = value;
            }

            /**
             * Gets the value of the feeParameters property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the feeParameters property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getFeeParameters().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link FeeParameterType }
             * 
             * 
             */
            public List<FeeParameterType> getFeeParameters() {
                if (feeParameters == null) {
                    feeParameters = new ArrayList<FeeParameterType>();
                }
                return this.feeParameters;
            }

            /**
             * Gets the value of the fee property.
             * 
             * @return
             *     possible object is
             *     {@link FeeType }
             *     
             */
            public FeeType getFee() {
                return fee;
            }

            /**
             * Sets the value of the fee property.
             * 
             * @param value
             *     allowed object is
             *     {@link FeeType }
             *     
             */
            public void setFee(FeeType value) {
                this.fee = value;
            }

            /**
             * Gets the value of the feeTotal property.
             * 
             * @return
             *     possible object is
             *     {@link FeeAmountType }
             *     
             */
            public FeeAmountType getFeeTotal() {
                return feeTotal;
            }

            /**
             * Sets the value of the feeTotal property.
             * 
             * @param value
             *     allowed object is
             *     {@link FeeAmountType }
             *     
             */
            public void setFeeTotal(FeeAmountType value) {
                this.feeTotal = value;
            }

            /**
             * Gets the value of the feeTiers property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the feeTiers property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getFeeTiers().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link FeeTierType }
             * 
             * 
             */
            public List<FeeTierType> getFeeTiers() {
                if (feeTiers == null) {
                    feeTiers = new ArrayList<FeeTierType>();
                }
                return this.feeTiers;
            }

            /**
             * Gets the value of the pricingPlan property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the pricingPlan property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getPricingPlan().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link PricingPlanType }
             * 
             * 
             */
            public List<PricingPlanType> getPricingPlan() {
                if (pricingPlan == null) {
                    pricingPlan = new ArrayList<PricingPlanType>();
                }
                return this.pricingPlan;
            }

            /**
             * Gets the value of the referenceRateType property.
             * 
             * @return
             *     possible object is
             *     {@link RateType }
             *     
             */
            public RateType getReferenceRateType() {
                return referenceRateType;
            }

            /**
             * Sets the value of the referenceRateType property.
             * 
             * @param value
             *     allowed object is
             *     {@link RateType }
             *     
             */
            public void setReferenceRateType(RateType value) {
                this.referenceRateType = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="interestRate" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}InterestRate_Type"/>
         *         &lt;element name="rateParameters" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Characteristic_Type" maxOccurs="unbounded" minOccurs="0"/>
         *         &lt;element name="interestTiers" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}InterestTier_Type" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "interestRate",
            "rateParameters",
            "interestTiers"
        })
        public static class InterestRates {

            @XmlElement(required = true)
            protected InterestRateType interestRate;
            protected List<CharacteristicType> rateParameters;
            protected List<InterestTierType> interestTiers;

            /**
             * Gets the value of the interestRate property.
             * 
             * @return
             *     possible object is
             *     {@link InterestRateType }
             *     
             */
            public InterestRateType getInterestRate() {
                return interestRate;
            }

            /**
             * Sets the value of the interestRate property.
             * 
             * @param value
             *     allowed object is
             *     {@link InterestRateType }
             *     
             */
            public void setInterestRate(InterestRateType value) {
                this.interestRate = value;
            }

            /**
             * Gets the value of the rateParameters property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the rateParameters property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getRateParameters().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link CharacteristicType }
             * 
             * 
             */
            public List<CharacteristicType> getRateParameters() {
                if (rateParameters == null) {
                    rateParameters = new ArrayList<CharacteristicType>();
                }
                return this.rateParameters;
            }

            /**
             * Gets the value of the interestTiers property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the interestTiers property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getInterestTiers().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link InterestTierType }
             * 
             * 
             */
            public List<InterestTierType> getInterestTiers() {
                if (interestTiers == null) {
                    interestTiers = new ArrayList<InterestTierType>();
                }
                return this.interestTiers;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="resourceItem" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}ResourceItem_Type"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "resourceItem"
    })
    public static class ResourceItemDetails {

        @XmlElement(required = true)
        protected ResourceItemType resourceItem;

        /**
         * Gets the value of the resourceItem property.
         * 
         * @return
         *     possible object is
         *     {@link ResourceItemType }
         *     
         */
        public ResourceItemType getResourceItem() {
            return resourceItem;
        }

        /**
         * Sets the value of the resourceItem property.
         * 
         * @param value
         *     allowed object is
         *     {@link ResourceItemType }
         *     
         */
        public void setResourceItem(ResourceItemType value) {
            this.resourceItem = value;
        }

    }

}
