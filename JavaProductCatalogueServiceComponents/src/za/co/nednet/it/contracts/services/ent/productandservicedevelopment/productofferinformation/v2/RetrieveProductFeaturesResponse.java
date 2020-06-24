
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
 *         &lt;element name="featureDetails" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="featureIdentification" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeatureIdentification_Type"/>
 *                   &lt;element name="featureAlternativeIdentifiers" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeatureAlternativeIdentifier" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="featureGroup" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeatureGroup_Type" minOccurs="0"/>
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
    "featureDetails",
    "resultSet"
})
@XmlRootElement(name = "RetrieveProductFeaturesResponse")
public class RetrieveProductFeaturesResponse {

    protected BigInteger productIdentifier;
    protected List<RetrieveProductFeaturesResponse.FeatureDetails> featureDetails;
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
     * Gets the value of the featureDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the featureDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeatureDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RetrieveProductFeaturesResponse.FeatureDetails }
     * 
     * 
     */
    public List<RetrieveProductFeaturesResponse.FeatureDetails> getFeatureDetails() {
        if (featureDetails == null) {
            featureDetails = new ArrayList<RetrieveProductFeaturesResponse.FeatureDetails>();
        }
        return this.featureDetails;
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
     *         &lt;element name="featureIdentification" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeatureIdentification_Type"/>
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
    public static class FeatureDetails {

        @XmlElement(required = true)
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

}
