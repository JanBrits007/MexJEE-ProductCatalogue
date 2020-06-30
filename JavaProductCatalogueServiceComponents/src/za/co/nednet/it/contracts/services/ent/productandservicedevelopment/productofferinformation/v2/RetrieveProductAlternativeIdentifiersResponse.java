
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
 *         &lt;element name="productAlternativeIdentifiers" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}ProductAlternativeIdentifier" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="characteristicSets" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="identifiers" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Identifier_Type" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="characteristics" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Characteristic_Type" maxOccurs="unbounded" minOccurs="0"/>
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
    "productAlternativeIdentifiers",
    "characteristicSets",
    "resultSet"
})
@XmlRootElement(name = "RetrieveProductAlternativeIdentifiersResponse")
public class RetrieveProductAlternativeIdentifiersResponse {

    protected BigInteger productIdentifier;
    protected List<ProductAlternativeIdentifier> productAlternativeIdentifiers;
    protected List<RetrieveProductAlternativeIdentifiersResponse.CharacteristicSets> characteristicSets;
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
     * {@link RetrieveProductAlternativeIdentifiersResponse.CharacteristicSets }
     * 
     * 
     */
    public List<RetrieveProductAlternativeIdentifiersResponse.CharacteristicSets> getCharacteristicSets() {
        if (characteristicSets == null) {
            characteristicSets = new ArrayList<RetrieveProductAlternativeIdentifiersResponse.CharacteristicSets>();
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
        "characteristics"
    })
    public static class CharacteristicSets {

        protected List<IdentifierType> identifiers;
        protected List<CharacteristicType> characteristics;

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

    }

}
