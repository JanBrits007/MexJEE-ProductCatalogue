
package za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * Product Alternative Identifier identifies the various additional identifiers given to a specific product to support a Financial Institution's business activities. These could be be business defined identifiers or system defined identifiers
 * 
 * <p>Java class for ProductAlternativeIdentifier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProductAlternativeIdentifier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="productIDType" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}CodeDescription_Type"/>
 *         &lt;element name="productKeys" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}fieldName"/>
 *                   &lt;element ref="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}fieldValue"/>
 *                   &lt;element name="sequence" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}sourceSystem" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductAlternativeIdentifier", propOrder = {
    "productIDType",
    "productKeys",
    "sourceSystem"
})
public class ProductAlternativeIdentifier {

    @XmlElement(required = true)
    protected CodeDescriptionType productIDType;
    protected List<ProductAlternativeIdentifier.ProductKeys> productKeys;
    protected SystemType sourceSystem;

    /**
     * Gets the value of the productIDType property.
     * 
     * @return
     *     possible object is
     *     {@link CodeDescriptionType }
     *     
     */
    public CodeDescriptionType getProductIDType() {
        return productIDType;
    }

    /**
     * Sets the value of the productIDType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeDescriptionType }
     *     
     */
    public void setProductIDType(CodeDescriptionType value) {
        this.productIDType = value;
    }

    /**
     * Gets the value of the productKeys property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productKeys property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductKeys().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductAlternativeIdentifier.ProductKeys }
     * 
     * 
     */
    public List<ProductAlternativeIdentifier.ProductKeys> getProductKeys() {
        if (productKeys == null) {
            productKeys = new ArrayList<ProductAlternativeIdentifier.ProductKeys>();
        }
        return this.productKeys;
    }

    /**
     * Gets the value of the sourceSystem property.
     * 
     * @return
     *     possible object is
     *     {@link SystemType }
     *     
     */
    public SystemType getSourceSystem() {
        return sourceSystem;
    }

    /**
     * Sets the value of the sourceSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link SystemType }
     *     
     */
    public void setSourceSystem(SystemType value) {
        this.sourceSystem = value;
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
     *         &lt;element ref="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}fieldName"/>
     *         &lt;element ref="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ProductOfferInformation/v2}fieldValue"/>
     *         &lt;element name="sequence" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
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
        "fieldName",
        "fieldValue",
        "sequence"
    })
    public static class ProductKeys {

        @XmlElement(required = true)
        protected String fieldName;
        @XmlElement(required = true)
        protected String fieldValue;
        protected BigInteger sequence;

        /**
         * Gets the value of the fieldName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFieldName() {
            return fieldName;
        }

        /**
         * Sets the value of the fieldName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFieldName(String value) {
            this.fieldName = value;
        }

        /**
         * Gets the value of the fieldValue property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFieldValue() {
            return fieldValue;
        }

        /**
         * Sets the value of the fieldValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFieldValue(String value) {
            this.fieldValue = value;
        }

        /**
         * Gets the value of the sequence property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getSequence() {
            return sequence;
        }

        /**
         * Sets the value of the sequence property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setSequence(BigInteger value) {
            this.sequence = value;
        }

    }

}
