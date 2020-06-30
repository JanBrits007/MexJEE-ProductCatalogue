
package za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * Identifies an Asset that can be used as a resource. This includes Bank Assets and assets offered as Collateral.
 * 
 * <p>Java class for ResourceItem_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResourceItem_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="resourceItemType" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}CodeDescription_Type" minOccurs="0"/>
 *         &lt;element name="resourceItemIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="resourceItemName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResourceItem_Type", propOrder = {
    "resourceItemType",
    "resourceItemIdentifier",
    "resourceItemName"
})
public class ResourceItemType {

    protected CodeDescriptionType resourceItemType;
    protected String resourceItemIdentifier;
    protected String resourceItemName;

    /**
     * Gets the value of the resourceItemType property.
     * 
     * @return
     *     possible object is
     *     {@link CodeDescriptionType }
     *     
     */
    public CodeDescriptionType getResourceItemType() {
        return resourceItemType;
    }

    /**
     * Sets the value of the resourceItemType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeDescriptionType }
     *     
     */
    public void setResourceItemType(CodeDescriptionType value) {
        this.resourceItemType = value;
    }

    /**
     * Gets the value of the resourceItemIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResourceItemIdentifier() {
        return resourceItemIdentifier;
    }

    /**
     * Sets the value of the resourceItemIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResourceItemIdentifier(String value) {
        this.resourceItemIdentifier = value;
    }

    /**
     * Gets the value of the resourceItemName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResourceItemName() {
        return resourceItemName;
    }

    /**
     * Sets the value of the resourceItemName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResourceItemName(String value) {
        this.resourceItemName = value;
    }

}
