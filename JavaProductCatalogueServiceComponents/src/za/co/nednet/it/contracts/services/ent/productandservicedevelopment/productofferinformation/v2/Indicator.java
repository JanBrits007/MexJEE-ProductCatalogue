
package za.co.nednet.it.contracts.services.ent.productandservicedevelopment.productofferinformation.v2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Indicator.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Indicator">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Y"/>
 *     &lt;enumeration value="N"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Indicator")
@XmlEnum
public enum Indicator {

    Y,
    N;

    public String value() {
        return name();
    }

    public static Indicator fromValue(String v) {
        return valueOf(v);
    }

}
