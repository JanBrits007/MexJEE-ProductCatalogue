
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
 *         &lt;element name="interestRateDetails" maxOccurs="unbounded" minOccurs="0">
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
    "interestRateDetails",
    "characteristicSets",
    "resultSet"
})
@XmlRootElement(name = "RetrieveProductInterestRatesResponse")
public class RetrieveProductInterestRatesResponse {

    protected BigInteger productIdentifier;
    protected String featureIdentifier;
    protected List<RetrieveProductInterestRatesResponse.InterestRateDetails> interestRateDetails;
    protected List<RetrieveProductInterestRatesResponse.CharacteristicSets> characteristicSets;
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
     * Gets the value of the interestRateDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the interestRateDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInterestRateDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RetrieveProductInterestRatesResponse.InterestRateDetails }
     * 
     * 
     */
    public List<RetrieveProductInterestRatesResponse.InterestRateDetails> getInterestRateDetails() {
        if (interestRateDetails == null) {
            interestRateDetails = new ArrayList<RetrieveProductInterestRatesResponse.InterestRateDetails>();
        }
        return this.interestRateDetails;
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
     * {@link RetrieveProductInterestRatesResponse.CharacteristicSets }
     * 
     * 
     */
    public List<RetrieveProductInterestRatesResponse.CharacteristicSets> getCharacteristicSets() {
        if (characteristicSets == null) {
            characteristicSets = new ArrayList<RetrieveProductInterestRatesResponse.CharacteristicSets>();
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
        "interestRates"
    })
    public static class CharacteristicSets {

        protected List<IdentifierType> identifiers;
        protected List<CharacteristicType> characteristics;
        protected List<RetrieveProductInterestRatesResponse.CharacteristicSets.InterestRates> interestRates;

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
         * {@link RetrieveProductInterestRatesResponse.CharacteristicSets.InterestRates }
         * 
         * 
         */
        public List<RetrieveProductInterestRatesResponse.CharacteristicSets.InterestRates> getInterestRates() {
            if (interestRates == null) {
                interestRates = new ArrayList<RetrieveProductInterestRatesResponse.CharacteristicSets.InterestRates>();
            }
            return this.interestRates;
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
    public static class InterestRateDetails {

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
