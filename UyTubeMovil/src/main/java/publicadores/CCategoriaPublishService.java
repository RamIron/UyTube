
package publicadores;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CCategoriaPublishService", targetNamespace = "http://publicadores/", wsdlLocation = "http://127.0.0.1:16000/Categoria?wsdl")
public class CCategoriaPublishService
    extends Service
{

    private final static URL CCATEGORIAPUBLISHSERVICE_WSDL_LOCATION;
    private final static WebServiceException CCATEGORIAPUBLISHSERVICE_EXCEPTION;
    private final static QName CCATEGORIAPUBLISHSERVICE_QNAME = new QName("http://publicadores/", "CCategoriaPublishService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://127.0.0.1:16000/Categoria?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CCATEGORIAPUBLISHSERVICE_WSDL_LOCATION = url;
        CCATEGORIAPUBLISHSERVICE_EXCEPTION = e;
    }

    public CCategoriaPublishService() {
        super(__getWsdlLocation(), CCATEGORIAPUBLISHSERVICE_QNAME);
    }

    public CCategoriaPublishService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CCATEGORIAPUBLISHSERVICE_QNAME, features);
    }

    public CCategoriaPublishService(URL wsdlLocation) {
        super(wsdlLocation, CCATEGORIAPUBLISHSERVICE_QNAME);
    }

    public CCategoriaPublishService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CCATEGORIAPUBLISHSERVICE_QNAME, features);
    }

    public CCategoriaPublishService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CCategoriaPublishService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CCategoriaPublish
     */
    @WebEndpoint(name = "CCategoriaPublishPort")
    public CCategoriaPublish getCCategoriaPublishPort() {
        return super.getPort(new QName("http://publicadores/", "CCategoriaPublishPort"), CCategoriaPublish.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CCategoriaPublish
     */
    @WebEndpoint(name = "CCategoriaPublishPort")
    public CCategoriaPublish getCCategoriaPublishPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://publicadores/", "CCategoriaPublishPort"), CCategoriaPublish.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CCATEGORIAPUBLISHSERVICE_EXCEPTION!= null) {
            throw CCATEGORIAPUBLISHSERVICE_EXCEPTION;
        }
        return CCATEGORIAPUBLISHSERVICE_WSDL_LOCATION;
    }

}
