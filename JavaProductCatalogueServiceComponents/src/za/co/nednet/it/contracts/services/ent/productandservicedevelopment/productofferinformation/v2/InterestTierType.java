
package za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * A value of RATE RANGE TYPE. Identifies a rate range as being tiered. The rate associated with a range is applied to that portion of the loan specified by the range. For example, Range 0 - 10,000 5% 10,000 - 50,000 4% 50,000 + 3% For a loan of 30,000 ZAR, a tiered range will apply a 5% charge to the first 10,000 and 4% to the remaining 20,000.
 * 
 * <p>Java class for InterestTier_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InterestTier_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="interestTierType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="interestTierFrom" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="interestTierTo" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InterestTier_Type", propOrder = {
    "interestTierType",
    "interestTierFrom",
    "interestTierTo"
})
public class InterestTierType {

    @XmlElement(required = true)
    protected String interestTierType;
    protected Float interestTierFrom;
    protected Float interestTierTo;

    /**
     * Gets the value of the interestTierType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterestTierType() {
        return interestTierType;
    }

    /**
     * Sets the value of the interestTierType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterestTierType(String value) {
        this.interestTierType = value;
    }

    /**
     * Gets the value of the interestTierFrom property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getInterestTierFrom() {
        return interestTierFrom;
    }

    /**
     * Sets the value of the interestTierFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setInterestTierFrom(Float value) {
        this.interestTierFrom = value;
    }

    /**
     * Gets the value of the interestTierTo property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getInterestTierTo() {
        return interestTierTo;
    }

    /**
     * Sets the value of the interestTierTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setInterestTierTo(Float value) {
        this.interestTierTo = value;
    }

}
