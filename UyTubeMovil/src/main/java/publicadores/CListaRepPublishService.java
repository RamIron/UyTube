
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
@WebServiceClient(name = "CListaRepPublishService", targetNamespace = "http://publicadores/", wsdlLocation = "http://127.0.0.1:16000/Lista?wsdl")
public class CListaRepPublishService
    extends Service
{

    private final static URL CLISTAREPPUBLISHSERVICE_WSDL_LOCATION;
    private final static WebServiceException CLISTAREPPUBLISHSERVICE_EXCEPTION;
    private final static QName CLISTAREPPUBLISHSERVICE_QNAME = new QName("http://publicadores/", "CListaRepPublishService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://127.0.0.1:16000/Lista?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CLISTAREPPUBLISHSERVICE_WSDL_LOCATION = url;
        CLISTAREPPUBLISHSERVICE_EXCEPTION = e;
    }

    public CListaRepPublishService() {
        super(__getWsdlLocation(), CLISTAREPPUBLISHSERVICE_QNAME);
    }

    public CListaRepPublishService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CLISTAREPPUBLISHSERVICE_QNAME, features);
    }

    public CListaRepPublishService(URL wsdlLocation) {
        super(wsdlLocation, CLISTAREPPUBLISHSERVICE_QNAME);
    }

    public CListaRepPublishService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CLISTAREPPUBLISHSERVICE_QNAME, features);
    }

    public CListaRepPublishService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CListaRepPublishService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CListaRepPublish
     */
    @WebEndpoint(name = "CListaRepPublishPort")
    public CListaRepPublish getCListaRepPublishPort() {
        return super.getPort(new QName("http://publicadores/", "CListaRepPublishPort"), CListaRepPublish.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CListaRepPublish
     */
    @WebEndpoint(name = "CListaRepPublishPort")
    public CListaRepPublish getCListaRepPublishPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://publicadores/", "CListaRepPublishPort"), CListaRepPublish.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CLISTAREPPUBLISHSERVICE_EXCEPTION!= null) {
            throw CLISTAREPPUBLISHSERVICE_EXCEPTION;
        }
        return CLISTAREPPUBLISHSERVICE_WSDL_LOCATION;
    }

}
