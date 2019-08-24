package interfaces;

import java.util.ArrayList;
import java.util.Date;

import datatypes.DtComentario;
import datatypes.DtValoracion;
import datatypes.DtVideo;

public interface IVideo {

	 public void agregarCategoria(String nomV, String nomC);
	 
	 public void agregarVideo(String nick, String nomV, boolean publico, String desc, Date fPub, int dur, String url);
	 
	 public void agregarVideoPrivado(String nick, String nomV, String desc, Date fPub, int dur, String url);
	 
	 public void limpiarControlador();
	 
	 public ArrayList<String> listarVideosDeUsuario(String nick);
	 
	 public void modificarInfoVideo(String nomV, String desc, Date fecha, int dur, String url, boolean publico);
	 
	 public ArrayList<DtComentario> obtenerComentariosVideo(String nomVid);
	 
	 public ArrayList<DtVideo> obtenerInfoVideo(String nomVid);
	 
	 public ArrayList<DtValoracion> obtenerValoracionVideo();
	 
	 public void responderComentario(int idCom, String nick, Date fcom, String texto);
	 
	 public void realizarComentario(String nick, Date fCom, String texto);
	 
	 public void valorarVideo(String nomVid, String nickVal, boolean val);
	
}
