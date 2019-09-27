package interfaces;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import datatypes.DtComentario;
import datatypes.DtElementoUsuario;
import datatypes.DtValoracion;
import datatypes.DtVideo;

public interface IVideo {

	 public void agregarCategoria(String nomC);
	 
	 public void agregarVideo(String nick, String nomV, String desc, Calendar fPub, int dur, String url);
	 
	 public void limpiarControlador();
	 
	 public List<String> listarVideosDeUsuario(String nick);
	 
	 public List<String> listarVideosPublicosDeUsuario(String nick);

    List<DtElementoUsuario> listarVideosPublicos();

    public void modificarInfoVideo(String nomV, String desc, Calendar fecha, int dur, String url, boolean publico);
	 
	 public List<DtComentario> obtenerComentariosVideo(String nomVid);
	 
	 public DtVideo obtenerInfoVideo(String nomVid);

	public List<DtValoracion> obtenerValoracionVideo();
	 
	 public void responderComentario(int idCom, String nick, Calendar fcom, String texto);
	 
	 public void realizarComentario(String nick, Calendar fCom, String texto);
	 
	 public void valorarVideo(String nickVal, boolean val);
	 
	 public Boolean existeVideo(String nick, String nomV);

	Integer cantidadGusta();

	Integer cantidadNoGusta();

	public void setUsr(String usr);

	 public void setVid(String vid);
	
}
