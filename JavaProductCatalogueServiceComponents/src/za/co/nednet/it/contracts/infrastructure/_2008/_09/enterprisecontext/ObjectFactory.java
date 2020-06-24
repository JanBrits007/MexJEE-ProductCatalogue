
package za.co.nednet.it.contracts.infrastructure._2008._09.enterprisecontext;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the za.co.nednet.it.contracts.infrastructure._2008._09.enterprisecontext package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EnterpriseContext_QNAME = new QName("http://contracts.it.nednet.co.za/Infrastructure/2008/09/EnterpriseContext", "EnterpriseContext");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: za.co.nednet.it.contracts.infrastructure._2008._09.enterprisecontext
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EnterpriseContextType }
     * 
     */
    public EnterpriseContextType createEnterpriseContextType() {
        return new EnterpriseContextType();
    }

    /**
     * Create an instance of {@link InstrumentationInfoType }
     * 
     */
    public InstrumentationInfoType createInstrumentationInfoType() {
        return new InstrumentationInfoType();
    }

    /**
     * Create an instance of {@link RequestOriginatorType }
     * 
     */
    public RequestOriginatorType createRequestOriginatorType() {
        return new RequestOriginatorType();
    }

    /**
     * Create an instance of {@link ContextInfoType }
     * 
     */
    public ContextInfoType createContextInfoType() {
        return new ContextInfoType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnterpriseContextType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://contracts.it.nednet.co.za/Infrastructure/2008/09/EnterpriseContext", name = "EnterpriseContext")
    public JAXBElement<EnterpriseContextType> createEnterpriseContext(EnterpriseContextType value) {
        return new JAXBElement<EnterpriseContextType>(_EnterpriseContext_QNAME, EnterpriseContextType.class, null, value);
    }

}
