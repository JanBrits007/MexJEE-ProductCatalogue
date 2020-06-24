
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
 *         &lt;element ref="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}featureIdentifier" minOccurs="0"/>
 *         &lt;element name="feeDetails" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}feeIdentifier"/>
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
 *         &lt;element name="characteristicsSets" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="identifiers" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Identifier_Type" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="characteristics" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Characteristic_Type" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="feeDetails" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element ref="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}feeIdentifier"/>
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
    "featureIdentifier",
    "feeDetails",
    "characteristicsSets",
    "resultSet"
})
@XmlRootElement(name = "RetrieveProductFeesResponse")
public class RetrieveProductFeesResponse {

    protected BigInteger productIdentifier;
    protected String featureIdentifier;
    protected List<RetrieveProductFeesResponse.FeeDetails> feeDetails;
    protected List<RetrieveProductFeesResponse.CharacteristicsSets> characteristicsSets;
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
     * Gets the value of the featureIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeatureIdentifier() {
        return featureIdentifier;
    }

    /**
     * Sets the value of the featureIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeatureIdentifier(String value) {
        this.featureIdentifier = value;
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
     * {@link RetrieveProductFeesResponse.FeeDetails }
     * 
     * 
     */
    public List<RetrieveProductFeesResponse.FeeDetails> getFeeDetails() {
        if (feeDetails == null) {
            feeDetails = new ArrayList<RetrieveProductFeesResponse.FeeDetails>();
        }
        return this.feeDetails;
    }

    /**
     * Gets the value of the characteristicsSets property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the characteristicsSets property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCharacteristicsSets().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RetrieveProductFeesResponse.CharacteristicsSets }
     * 
     * 
     */
    public List<RetrieveProductFeesResponse.CharacteristicsSets> getCharacteristicsSets() {
        if (characteristicsSets == null) {
            characteristicsSets = new ArrayList<RetrieveProductFeesResponse.CharacteristicsSets>();
        }
        return this.characteristicsSets;
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
     *         &lt;element name="feeDetails" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element ref="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}feeIdentifier"/>
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
        "feeDetails"
    })
    public static class CharacteristicsSets {

        protected List<IdentifierType> identifiers;
        protected List<CharacteristicType> characteristics;
        protected List<RetrieveProductFeesResponse.CharacteristicsSets.FeeDetails> feeDetails;

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
         * {@link RetrieveProductFeesResponse.CharacteristicsSets.FeeDetails }
         * 
         * 
         */
        public List<RetrieveProductFeesResponse.CharacteristicsSets.FeeDetails> getFeeDetails() {
            if (feeDetails == null) {
                feeDetails = new ArrayList<RetrieveProductFeesResponse.CharacteristicsSets.FeeDetails>();
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
         *         &lt;element ref="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}feeIdentifier"/>
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
     *         &lt;element ref="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}feeIdentifier"/>
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

}
