package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;
import configuraciones.WebServiceConfiguracion;
import datatypes.DtCanal;
import datatypes.DtCanalWeb;
import datatypes.DtUsuario;
import datatypes.DtUsuarioWeb;
import interfaces.IUsuario;
import interfaces.UFactory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class CUsuarioPublish {
    private UFactory usrFactory;
    private IUsuario iUsr;
//    private WebServiceConfiguracion configuracion;
    private Endpoint endpoint;

    public CUsuarioPublish() {
        this.usrFactory = UFactory.getInstancia();
        this.iUsr = this.usrFactory.getIUsuario();
//        try {
//            configuracion = new WebServiceConfiguracion();
//        } catch (Exception ex) {
//
//        }
    }

    @WebMethod(exclude = true)
    public void publicar() {
        endpoint = Endpoint.publish("http://" + "127.0.0.1" + ":" + "16000" + "/Usuario", this);
        System.out.println("WebService de ControladorUsuario publicado en: "+ "http://" + "127.0.0.1" + ":" + "16000" + "/Usuario" + "?wsdl");
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
        return endpoint;
    }

    //MÉTODOS QUE VAMOS A PUBLICAR
    @WebMethod
    public void agregarCanal() {
        iUsr.agregarCanal();
    }

    //si la categoria esta vacia en canal se le agrega, si ya tiene una categoria se pisa.
    //si recibe null en nomCat deja al canal sin categoria
    @WebMethod
    public void modificarCatCanal(String nick, String nomCat) {
        iUsr.modificarCatCanal(nick, nomCat);
    }

    @WebMethod
    public void agregarUsuario(String nick, String nom, String ape, Calendar fechaN, String email) {
        iUsr.agregarUsuario(nick, nom, ape, fechaN, email);
    }

    @WebMethod
    public void dejarDeSeguirUsuario(String seguidor, String seguido) {
        iUsr.dejarDeSeguirUsuario(seguidor, seguido);
    }

    @WebMethod
    public Boolean existeEmail(String email) {
        return iUsr.existeEmail(email);
    }

    @WebMethod
    public Boolean existeNickname(String nick) {
        return iUsr.existeNickname(nick);
    }

    @WebMethod
    public String[] listarSeguidores() {
        List<String> seguidores = iUsr.listarSeguidores();
        int i = 0;
        String[] ret = new String[seguidores.size()];
        for(String s : seguidores) {
            ret[i]=s;
            i++;
        }
        return ret;
    }

    @WebMethod
    public String[] listarSeguidos() {
        List<String> seguidos = iUsr.listarSeguidos();
        int i = 0;
        String[] ret = new String[seguidos.size()];
        for(String s : seguidos) {
            ret[i]=s;
            i++;
        }
        return ret;
    }

    @WebMethod
    public String[] listarUsuarios() {
        List<String> usrs = iUsr.listarUsuarios();
        int i = 0;
        String[] ret = new String[usrs.size()];
        for(String u : usrs) {
            ret[i]=u;
            i++;
        }
        return ret;
    }

    @WebMethod
    public void modificarImagen(String img) {
        iUsr.modificarImagen(img);
    }

    @WebMethod
    public void modificarContrasena(String pass) {
        iUsr.modificarContrasena(pass);
    }


    @WebMethod
    public void modificarInfoCanal(String nomC, String descC, boolean publico) {
        iUsr.modificarInfoCanal(nomC, descC, publico);
    }

    @WebMethod
    public void modificarInfoUsuario(String nomU, String apeU, Calendar fNacU, String imagen) {
        iUsr.modificarInfoUsuario(nomU, apeU, fNacU, imagen);
    }

    @WebMethod
    public DtCanal obtenerInfoCanal() {
        return iUsr.obtenerInfoCanal();
    }

    @WebMethod
    public DtUsuario obtenerInfoUsuario(String nick) {
        return iUsr.obtenerInfoUsuario(nick);
    }

    public Boolean esCanalPublico(String nick) {
        return iUsr.esCanalPublico(nick);
    }

    @WebMethod
    public void seguirUsuario(String seguidor, String seguido) {
        iUsr.seguirUsuario(seguidor, seguido);
    }


    //Retorna: 0-> si no coincide los datos
    //		   1-> si coincide con nickname
    //		   2-> si coincide con email
    @WebMethod
    public Integer iniciarSesion(String nick, String pass){
        return iUsr.iniciarSesion(nick, pass);
    }

    @WebMethod
    public DtUsuarioWeb obtenerUsuarioWebNick(String nickname){
        return iUsr.obtenerUsuarioWebNick(nickname);
    }

    @WebMethod
    public DtUsuarioWeb obtenerUsuarioWebEmail(String email){
        return iUsr.obtenerUsuarioWebEmail(email);
    }

    @WebMethod
    public DtUsuarioWeb[] listarUsuariosWeb() {
        List<DtUsuarioWeb> dtUsr = iUsr.listarUsuariosWeb();
        int i = 0;
        DtUsuarioWeb[] ret = new DtUsuarioWeb[dtUsr.size()];
        for(DtUsuarioWeb u : dtUsr) {
            ret[i]=u;
            i++;
        }
        return ret;
    }

    public DtUsuarioWeb[] listarNickFotoWeb(String[] seguidores){
        List<String> listaSeg = new ArrayList<String>();
        for (int i=0; i< seguidores.length; i++){
            listaSeg.add(seguidores[i]);
        }
        List<DtUsuarioWeb> dtUsr = iUsr.listarNickFotoWeb(listaSeg);
        int i = 0;
        DtUsuarioWeb[] ret = new DtUsuarioWeb[dtUsr.size()];
        for(DtUsuarioWeb u : dtUsr) {
            ret[i]=u;
            i++;
        }
        return ret;
    }

    @WebMethod
    public DtCanalWeb[] busqueda(String query, Boolean ordFecha){
        List<DtCanalWeb> dtCan = iUsr.busqueda(query, ordFecha);
        int i = 0;
        DtCanalWeb[] ret = new DtCanalWeb[dtCan.size()];
        for(DtCanalWeb c : dtCan) {
            ret[i]=c;
            i++;
        }
        return ret;
    }
}
