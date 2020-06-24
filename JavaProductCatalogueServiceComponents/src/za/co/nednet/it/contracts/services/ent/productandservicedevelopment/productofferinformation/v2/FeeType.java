
package za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 * Single defintion of a service fee. ServiceFee is an extention of FeeCondition
 * 
 * <p>Java class for Fee_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Fee_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="feeType" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}CodeDescription_Type"/>
 *         &lt;element name="isMandatory" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="feeBaseAmount" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="feeUnit" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="feePercentage" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Percentage" minOccurs="0"/>
 *         &lt;element name="feeDiscountPercentage" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Percentage" minOccurs="0"/>
 *         &lt;element name="isDefaultFee" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="feeMinimumLimit" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="feeMaximumLimit" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="chargingBasis" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}CodeDescription_Type" minOccurs="0"/>
 *         &lt;element name="effectiveDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="feeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Fee_Type", propOrder = {
    "feeType",
    "isMandatory",
    "feeBaseAmount",
    "feeUnit",
    "feePercentage",
    "feeDiscountPercentage",
    "isDefaultFee",
    "feeMinimumLimit",
    "feeMaximumLimit",
    "chargingBasis",
    "effectiveDate",
    "endDate",
    "feeDescription"
})
public class FeeType {

    @XmlElement(required = true)
    protected CodeDescriptionType feeType;
    protected Boolean isMandatory;
    protected Float feeBaseAmount;
    protected Float feeUnit;
    protected BigDecimal feePercentage;
    protected BigDecimal feeDiscountPercentage;
    protected Boolean isDefaultFee;
    protected Float feeMinimumLimit;
    protected Float feeMaximumLimit;
    protected CodeDescriptionType chargingBasis;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar effectiveDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;
    protected String feeDescription;

    /**
     * Gets the value of the feeType property.
     * 
     * @return
     *     possible object is
     *     {@link CodeDescriptionType }
     *     
     */
    public CodeDescriptionType getFeeType() {
        return feeType;
    }

    /**
     * Sets the value of the feeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeDescriptionType }
     *     
     */
    public void setFeeType(CodeDescriptionType value) {
        this.feeType = value;
    }

    /**
     * Gets the value of the isMandatory property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsMandatory() {
        return isMandatory;
    }

    /**
     * Sets the value of the isMandatory property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsMandatory(Boolean value) {
        this.isMandatory = value;
    }

    /**
     * Gets the value of the feeBaseAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getFeeBaseAmount() {
        return feeBaseAmount;
    }

    /**
     * Sets the value of the feeBaseAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setFeeBaseAmount(Float value) {
        this.feeBaseAmount = value;
    }

    /**
     * Gets the value of the feeUnit property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getFeeUnit() {
        return feeUnit;
    }

    /**
     * Sets the value of the feeUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setFeeUnit(Float value) {
        this.feeUnit = value;
    }

    /**
     * Gets the value of the feePercentage property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFeePercentage() {
        return feePercentage;
    }

    /**
     * Sets the value of the feePercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFeePercentage(BigDecimal value) {
        this.feePercentage = value;
    }

    /**
     * Gets the value of the feeDiscountPercentage property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFeeDiscountPercentage() {
        return feeDiscountPercentage;
    }

    /**
     * Sets the value of the feeDiscountPercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFeeDiscountPercentage(BigDecimal value) {
        this.feeDiscountPercentage = value;
    }

    /**
     * Gets the value of the isDefaultFee property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsDefaultFee() {
        return isDefaultFee;
    }

    /**
     * Sets the value of the isDefaultFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsDefaultFee(Boolean value) {
        this.isDefaultFee = value;
    }

    /**
     * Gets the value of the feeMinimumLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getFeeMinimumLimit() {
        return feeMinimumLimit;
    }

    /**
     * Sets the value of the feeMinimumLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setFeeMinimumLimit(Float value) {
        this.feeMinimumLimit = value;
    }

    /**
     * Gets the value of the feeMaximumLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getFeeMaximumLimit() {
        return feeMaximumLimit;
    }

    /**
     * Sets the value of the feeMaximumLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setFeeMaximumLimit(Float value) {
        this.feeMaximumLimit = value;
    }

    /**
     * Gets the value of the chargingBasis property.
     * 
     * @return
     *     possible object is
     *     {@link CodeDescriptionType }
     *     
     */
    public CodeDescriptionType getChargingBasis() {
        return chargingBasis;
    }

    /**
     * Sets the value of the chargingBasis property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeDescriptionType }
     *     
     */
    public void setChargingBasis(CodeDescriptionType value) {
        this.chargingBasis = value;
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
     * Gets the value of the feeDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeDescription() {
        return feeDescription;
    }

    /**
     * Sets the value of the feeDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeDescription(String value) {
        this.feeDescription = value;
    }

}
