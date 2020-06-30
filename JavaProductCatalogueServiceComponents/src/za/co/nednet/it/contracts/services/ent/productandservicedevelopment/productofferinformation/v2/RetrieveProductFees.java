
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
 *         &lt;element name="fees" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}FeeIdentifier_Type" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}productIdentifier" minOccurs="0"/>
 *         &lt;element ref="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}featureIdentifier" minOccurs="0"/>
 *         &lt;element name="channelType" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}CodeDescription_Type" minOccurs="0"/>
 *         &lt;element name="productLine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="characteristicFilters" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Characteristic_Type" maxOccurs="unbounded" minOccurs="0"/>
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
    "fees",
    "productIdentifier",
    "featureIdentifier",
    "channelType",
    "productLine",
    "characteristicFilters"
})
@XmlRootElement(name = "RetrieveProductFees")
public class RetrieveProductFees {

    @XmlElement(required = true)
    protected List<FeeIdentifierType> fees;
    protected BigInteger productIdentifier;
    protected String featureIdentifier;
    protected CodeDescriptionType channelType;
    protected String productLine;
    protected List<CharacteristicType> characteristicFilters;

    /**
     * Gets the value of the fees property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fees property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFees().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FeeIdentifierType }
     * 
     * 
     */
    public List<FeeIdentifierType> getFees() {
        if (fees == null) {
            fees = new ArrayList<FeeIdentifierType>();
        }
        return this.fees;
    }

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
     * Gets the value of the channelType property.
     * 
     * @return
     *     possible object is
     *     {@link CodeDescriptionType }
     *     
     */
    public CodeDescriptionType getChannelType() {
        return channelType;
    }

    /**
     * Sets the value of the channelType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeDescriptionType }
     *     
     */
    public void setChannelType(CodeDescriptionType value) {
        this.channelType = value;
    }

    /**
     * Gets the value of the productLine property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductLine() {
        return productLine;
    }

    /**
     * Sets the value of the productLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductLine(String value) {
        this.productLine = value;
    }

    /**
     * Gets the value of the characteristicFilters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the characteristicFilters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCharacteristicFilters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CharacteristicType }
     * 
     * 
     */
    public List<CharacteristicType> getCharacteristicFilters() {
        if (characteristicFilters == null) {
            characteristicFilters = new ArrayList<CharacteristicType>();
        }
        return this.characteristicFilters;
    }

}
