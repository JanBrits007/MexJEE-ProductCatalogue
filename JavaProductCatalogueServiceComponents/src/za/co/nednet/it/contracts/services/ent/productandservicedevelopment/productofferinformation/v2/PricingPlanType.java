
package za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PricingPlan_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PricingPlan_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pricingPlanIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pricingPlanCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pricingPlanName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pricingPlanType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="effectiveDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="pricingDiscriminators" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}PricingDiscriminator_Type" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PricingPlan_Type", propOrder = {
    "pricingPlanIdentifier",
    "pricingPlanCode",
    "pricingPlanName",
    "pricingPlanType",
    "effectiveDate",
    "endDate",
    "pricingDiscriminators"
})
public class PricingPlanType {

    @XmlElement(required = true)
    protected String pricingPlanIdentifier;
    protected String pricingPlanCode;
    protected String pricingPlanName;
    protected String pricingPlanType;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar effectiveDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;
    protected List<PricingDiscriminatorType> pricingDiscriminators;

    /**
     * Gets the value of the pricingPlanIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPricingPlanIdentifier() {
        return pricingPlanIdentifier;
    }

    /**
     * Sets the value of the pricingPlanIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPricingPlanIdentifier(String value) {
        this.pricingPlanIdentifier = value;
    }

    /**
     * Gets the value of the pricingPlanCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPricingPlanCode() {
        return pricingPlanCode;
    }

    /**
     * Sets the value of the pricingPlanCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPricingPlanCode(String value) {
        this.pricingPlanCode = value;
    }

    /**
     * Gets the value of the pricingPlanName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPricingPlanName() {
        return pricingPlanName;
    }

    /**
     * Sets the value of the pricingPlanName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPricingPlanName(String value) {
        this.pricingPlanName = value;
    }

    /**
     * Gets the value of the pricingPlanType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPricingPlanType() {
        return pricingPlanType;
    }

    /**
     * Sets the value of the pricingPlanType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPricingPlanType(String value) {
        this.pricingPlanType = value;
    }

    /**
     * Gets the value of the effectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Sets the value of the effectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEffectiveDate(XMLGregorianCalendar value) {
        this.effectiveDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the pricingDiscriminators property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pricingDiscriminators property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPricingDiscriminators().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PricingDiscriminatorType }
     * 
     * 
     */
    public List<PricingDiscriminatorType> getPricingDiscriminators() {
        if (pricingDiscriminators == null) {
            pricingDiscriminators = new ArrayList<PricingDiscriminatorType>();
        }
        return this.pricingDiscriminators;
    }

}
