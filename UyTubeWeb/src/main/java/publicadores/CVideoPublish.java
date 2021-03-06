
package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import net.java.dev.jaxb.array.StringArray;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CVideoPublish", targetNamespace = "http://publicadores/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    net.java.dev.jaxb.array.ObjectFactory.class,
    publicadores.ObjectFactory.class
})
public interface CVideoPublish {


    /**
     * 
     * @param arg0
     * @return
     *     returns publicadores.DtElementoWeb
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicadores/CVideoPublish/obtenerVideoRequest", output = "http://publicadores/CVideoPublish/obtenerVideoResponse")
    public DtElementoWeb obtenerVideo(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns net.java.dev.jaxb.array.StringArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicadores/CVideoPublish/listarVideosDeUsuarioRequest", output = "http://publicadores/CVideoPublish/listarVideosDeUsuarioResponse")
    public StringArray listarVideosDeUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns publicadores.DtElementoWebArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicadores/CVideoPublish/listarVideosDeUsuarioWebRequest", output = "http://publicadores/CVideoPublish/listarVideosDeUsuarioWebResponse")
    public DtElementoWebArray listarVideosDeUsuarioWeb(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns net.java.dev.jaxb.array.StringArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicadores/CVideoPublish/listarVideosPublicosDeUsuarioRequest", output = "http://publicadores/CVideoPublish/listarVideosPublicosDeUsuarioResponse")
    public StringArray listarVideosPublicosDeUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns publicadores.DtElementoWebArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicadores/CVideoPublish/listarVideosPublicosDeUsuarioWebRequest", output = "http://publicadores/CVideoPublish/listarVideosPublicosDeUsuarioWebResponse")
    public DtElementoWebArray listarVideosPublicosDeUsuarioWeb(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @return
     *     returns publicadores.DtElementoUsuarioArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicadores/CVideoPublish/listarVideosPublicosRequest", output = "http://publicadores/CVideoPublish/listarVideosPublicosResponse")
    public DtElementoUsuarioArray listarVideosPublicos();

    /**
     * 
     * @return
     *     returns publicadores.DtElementoWebArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicadores/CVideoPublish/listarVideosPublicosWebRequest", output = "http://publicadores/CVideoPublish/listarVideosPublicosWebResponse")
    public DtElementoWebArray listarVideosPublicosWeb();

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicadores/CVideoPublish/existeVideoRequest", output = "http://publicadores/CVideoPublish/existeVideoResponse")
    public boolean existeVideo(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://publicadores/CVideoPublish/agregarCategoriaRequest", output = "http://publicadores/CVideoPublish/agregarCategoriaResponse")
    public void agregarCategoria(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://publicadores/CVideoPublish/valorarVideoRequest", output = "http://publicadores/CVideoPublish/valorarVideoResponse")
    public void valorarVideo(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        boolean arg1);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://publicadores/CVideoPublish/agregarVideoRequest", output = "http://publicadores/CVideoPublish/agregarVideoResponse")
    public void agregarVideo(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        DtFecha arg3,
        @WebParam(name = "arg4", partName = "arg4")
        int arg4,
        @WebParam(name = "arg5", partName = "arg5")
        String arg5);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://publicadores/CVideoPublish/modificarInfoVideoRequest", output = "http://publicadores/CVideoPublish/modificarInfoVideoResponse")
    public void modificarInfoVideo(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        DtFecha arg2,
        @WebParam(name = "arg3", partName = "arg3")
        int arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4,
        @WebParam(name = "arg5", partName = "arg5")
        boolean arg5);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://publicadores/CVideoPublish/responderComentarioRequest", output = "http://publicadores/CVideoPublish/responderComentarioResponse")
    public void responderComentario(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        DtFecha arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://publicadores/CVideoPublish/realizarComentarioRequest", output = "http://publicadores/CVideoPublish/realizarComentarioResponse")
    public void realizarComentario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        DtFecha arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2);

    /**
     * 
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicadores/CVideoPublish/cantidadGustaRequest", output = "http://publicadores/CVideoPublish/cantidadGustaResponse")
    public int cantidadGusta();

    /**
     * 
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicadores/CVideoPublish/cantidadNoGustaRequest", output = "http://publicadores/CVideoPublish/cantidadNoGustaResponse")
    public int cantidadNoGusta();

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://publicadores/CVideoPublish/setVidRequest", output = "http://publicadores/CVideoPublish/setVidResponse")
    public void setVid(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns publicadores.DtElementoWebArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicadores/CVideoPublish/busquedaRequest", output = "http://publicadores/CVideoPublish/busquedaResponse")
    public DtElementoWebArray busqueda(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        boolean arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicadores/CVideoPublish/obtenerIdVideoRequest", output = "http://publicadores/CVideoPublish/obtenerIdVideoResponse")
    public int obtenerIdVideo(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns publicadores.DtComentarioArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicadores/CVideoPublish/obtenerComentariosVideoRequest", output = "http://publicadores/CVideoPublish/obtenerComentariosVideoResponse")
    public DtComentarioArray obtenerComentariosVideo(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @return
     *     returns publicadores.DtValoracionArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicadores/CVideoPublish/obtenerValoracionVideoRequest", output = "http://publicadores/CVideoPublish/obtenerValoracionVideoResponse")
    public DtValoracionArray obtenerValoracionVideo();

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://publicadores/CVideoPublish/setUsrRequest", output = "http://publicadores/CVideoPublish/setUsrResponse")
    public void setUsr(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns publicadores.DtVideo
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicadores/CVideoPublish/obtenerInfoVideoRequest", output = "http://publicadores/CVideoPublish/obtenerInfoVideoResponse")
    public DtVideo obtenerInfoVideo(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

}
