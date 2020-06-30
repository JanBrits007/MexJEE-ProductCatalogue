
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
 * Interest Rate specifies the percentage amount to be paid for the use of money. For example, as a return on capital investment or to be repaid as the price of a loan.
 * 
 * <p>Java class for InterestRate_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InterestRate_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rate" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Rate_Type"/>
 *         &lt;element name="creditDebitIndicator" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="referenceRateType" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Rate_Type" minOccurs="0"/>
 *         &lt;element name="effectiveInterestRate" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Percentage" minOccurs="0"/>
 *         &lt;element name="spreadRate" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}Percentage" minOccurs="0"/>
 *         &lt;element name="interestRateDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="effectiveDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="interestCalculationBasis" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InterestRate_Type", propOrder = {
    "rate",
    "creditDebitIndicator",
    "referenceRateType",
    "effectiveInterestRate",
    "spreadRate",
    "interestRateDescription",
    "effectiveDate",
    "endDate",
    "interestCalculationBasis"
})
public class InterestRateType {

    @XmlElement(required = true)
    protected RateType rate;
    @XmlElement(required = true)
    protected String creditDebitIndicator;
    protected RateType referenceRateType;
    protected BigDecimal effectiveInterestRate;
    protected BigDecimal spreadRate;
    protected String interestRateDescription;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar effectiveDate;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endDate;
    protected String interestCalculationBasis;

    /**
     * Gets the value of the rate property.
     * 
     * @return
     *     possible object is
     *     {@link RateType }
     *     
     */
    public RateType getRate() {
        return rate;
    }

    /**
     * Sets the value of the rate property.
     * 
     * @param value
     *     allowed object is
     *     {@link RateType }
     *     
     */
    public void setRate(RateType value) {
        this.rate = value;
    }

    /**
     * Gets the value of the creditDebitIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditDebitIndicator() {
        return creditDebitIndicator;
    }

    /**
     * Sets the value of the creditDebitIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditDebitIndicator(String value) {
        this.creditDebitIndicator = value;
    }

    /**
     * Gets the value of the referenceRateType property.
     * 
     * @return
     *     possible object is
     *     {@link RateType }
     *     
     */
    public RateType getReferenceRateType() {
        return referenceRateType;
    }

    /**
     * Sets the value of the referenceRateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link RateType }
     *     
     */
    public void setReferenceRateType(RateType value) {
        this.referenceRateType = value;
    }

    /**
     * Gets the value of the effectiveInterestRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEffectiveInterestRate() {
        return effectiveInterestRate;
    }

    /**
     * Sets the value of the effectiveInterestRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEffectiveInterestRate(BigDecimal value) {
        this.effectiveInterestRate = value;
    }

    /**
     * Gets the value of the spreadRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSpreadRate() {
        return spreadRate;
    }

    /**
     * Sets the value of the spreadRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSpreadRate(BigDecimal value) {
        this.spreadRate = value;
    }

    /**
     * Gets the value of the interestRateDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterestRateDescription() {
        return interestRateDescription;
    }

    /**
     * Sets the value of the interestRateDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterestRateDescription(String value) {
        this.interestRateDescription = value;
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
     * Gets the value of the interestCalculationBasis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterestCalculationBasis() {
        return interestCalculationBasis;
    }

    /**
     * Sets the value of the interestCalculationBasis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterestCalculationBasis(String value) {
        this.interestCalculationBasis = value;
    }

}
