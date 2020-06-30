
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
    "resourceItemDetails",
    "characteristicSets",
    "resultSet"
})
@XmlRootElement(name = "RetrieveProductResourceItemsResponse")
public class RetrieveProductResourceItemsResponse {

    protected BigInteger productIdentifier;
    protected List<RetrieveProductResourceItemsResponse.ResourceItemDetails> resourceItemDetails;
    protected List<RetrieveProductResourceItemsResponse.CharacteristicSets> characteristicSets;
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
     * {@link RetrieveProductResourceItemsResponse.ResourceItemDetails }
     * 
     * 
     */
    public List<RetrieveProductResourceItemsResponse.ResourceItemDetails> getResourceItemDetails() {
        if (resourceItemDetails == null) {
            resourceItemDetails = new ArrayList<RetrieveProductResourceItemsResponse.ResourceItemDetails>();
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
     * {@link RetrieveProductResourceItemsResponse.CharacteristicSets }
     * 
     * 
     */
    public List<RetrieveProductResourceItemsResponse.CharacteristicSets> getCharacteristicSets() {
        if (characteristicSets == null) {
            characteristicSets = new ArrayList<RetrieveProductResourceItemsResponse.CharacteristicSets>();
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
        "resourceItemDetails"
    })
    public static class CharacteristicSets {

        protected List<IdentifierType> identifiers;
        protected List<CharacteristicType> characteristics;
        protected List<RetrieveProductResourceItemsResponse.CharacteristicSets.ResourceItemDetails> resourceItemDetails;

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
         * {@link RetrieveProductResourceItemsResponse.CharacteristicSets.ResourceItemDetails }
         * 
         * 
         */
        public List<RetrieveProductResourceItemsResponse.CharacteristicSets.ResourceItemDetails> getResourceItemDetails() {
            if (resourceItemDetails == null) {
                resourceItemDetails = new ArrayList<RetrieveProductResourceItemsResponse.CharacteristicSets.ResourceItemDetails>();
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
