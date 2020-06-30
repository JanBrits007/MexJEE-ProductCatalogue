
package za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FeeTier_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeeTier_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tierType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tierTo" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="tierFrom" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeeTier_Type", propOrder = {
    "tierType",
    "tierTo",
    "tierFrom"
})
public class FeeTierType {

    @XmlElement(required = true)
    protected String tierType;
    protected Float tierTo;
    protected Float tierFrom;

    /**
     * Gets the value of the tierType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTierType() {
        return tierType;
    }

    /**
     * Sets the value of the tierType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTierType(String value) {
        this.tierType = value;
    }

    /**
     * Gets the value of the tierTo property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getTierTo() {
        return tierTo;
    }

    /**
     * Sets the value of the tierTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setTierTo(Float value) {
        this.tierTo = value;
    }

    /**
     * Gets the value of the tierFrom property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getTierFrom() {
        return tierFrom;
    }

    /**
     * Sets the value of the tierFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setTierFrom(Float value) {
        this.tierFrom = value;
    }

}
