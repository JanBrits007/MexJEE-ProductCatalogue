
package za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * Identifies a Documentation Item that has been created on a resin-based synthetic Material; for example, overhead transparency or a plastic ID card.
 * 
 * <p>Java class for PlasticDocument_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PlasticDocument_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="plasticDocumentIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fileLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlasticDocument_Type", propOrder = {
    "plasticDocumentIdentifier",
    "fileLocation"
})
public class PlasticDocumentType {

    @XmlElement(required = true)
    protected String plasticDocumentIdentifier;
    protected String fileLocation;

    /**
     * Gets the value of the plasticDocumentIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlasticDocumentIdentifier() {
        return plasticDocumentIdentifier;
    }

    /**
     * Sets the value of the plasticDocumentIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlasticDocumentIdentifier(String value) {
        this.plasticDocumentIdentifier = value;
    }

    /**
     * Gets the value of the fileLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileLocation() {
        return fileLocation;
    }

    /**
     * Sets the value of the fileLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileLocation(String value) {
        this.fileLocation = value;
    }

}
