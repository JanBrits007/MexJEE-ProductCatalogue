//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vIBM 2.2.3-11/28/2011 06:21 AM(foreman)- 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.07.13 at 02:48:21 PM CAT 
//


package za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for productAttributeGroupType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="productAttributeGroupType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="attributeGroupName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="productAttributes" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1}ProductattributesType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productAttributeGroupType", propOrder = {
    "attributeGroupName",
    "productAttributes"
})
public class ProductAttributeGroupType implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4964320937880653851L;
	@XmlElement(required = true)
    protected String attributeGroupName;
    protected List<ProductattributesType> productAttributes;

    /**
     * Gets the value of the attributeGroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttributeGroupName() {
        return attributeGroupName;
    }

    /**
     * Sets the value of the attributeGroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttributeGroupName(String value) {
        this.attributeGroupName = value;
    }

    /**
     * Gets the value of the productAttributes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productAttributes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductAttributes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductattributesType }
     * 
     * 
     */
    public List<ProductattributesType> getProductAttributes() {
        if (productAttributes == null) {
            productAttributes = new ArrayList<ProductattributesType>();
        }
        return this.productAttributes;
    }

}
