//
// Generated By:JAX-WS RI IBM 2.2.1-11/25/2013 11:48 AM(foreman)- (JAXB RI IBM 2.2.3-11/25/2013 12:35 PM(foreman)-)
//


package za.co.nednet.it.contracts.services.ent.productandservicedevelopment.channelproductcatalogue.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetProductMappingResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetProductMappingResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProductMappingDetailsResp" type="{http://contracts.it.nednet.co.za/services/ent/productandservicedevelopment/ChannelProductCatalogue/v1}ProductMappingDetailsResp" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetProductMappingResponseType", propOrder = {
    "productMappingDetailsResp"
})
public class GetProductMappingResponseType {

    @XmlElement(name = "ProductMappingDetailsResp")
    protected List<ProductMappingDetailsResp> productMappingDetailsResp;

    /**
     * Gets the value of the productMappingDetailsResp property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productMappingDetailsResp property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductMappingDetailsResp().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductMappingDetailsResp }
     * 
     * 
     */
    public List<ProductMappingDetailsResp> getProductMappingDetailsResp() {
        if (productMappingDetailsResp == null) {
            productMappingDetailsResp = new ArrayList<ProductMappingDetailsResp>();
        }
        return this.productMappingDetailsResp;
    }
    
    public void setProductMappingDetailsResp(List<ProductMappingDetailsResp> productMappingDetailsResp) {
        this.productMappingDetailsResp = productMappingDetailsResp;
    }

}
