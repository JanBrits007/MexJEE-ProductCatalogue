
package za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FeatureGroup_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeatureGroup_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="featureGroupIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="featureGroupName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeatureGroup_Type", propOrder = {
    "featureGroupIdentifier",
    "featureGroupName"
})
public class FeatureGroupType {

    protected String featureGroupIdentifier;
    protected String featureGroupName;

    /**
     * Gets the value of the featureGroupIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeatureGroupIdentifier() {
        return featureGroupIdentifier;
    }

    /**
     * Sets the value of the featureGroupIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeatureGroupIdentifier(String value) {
        this.featureGroupIdentifier = value;
    }

    /**
     * Gets the value of the featureGroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeatureGroupName() {
        return featureGroupName;
    }

    /**
     * Sets the value of the featureGroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeatureGroupName(String value) {
        this.featureGroupName = value;
    }

}
