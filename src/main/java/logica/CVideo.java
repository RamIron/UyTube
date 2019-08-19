package logica;

import java.util.ArrayList;
import java.util.Date;
import datatypes.DtComentario;
import datatypes.DtValoracion;
import datatypes.DtVideo;
import interfaces.IVideo;

public class CVideo implements IVideo {
	public Usuario usr;
	public Video vid;
	
	//Operaciones
	 public void agregarCategoria(String nomV, String nomC) {}
	 
	 public void agregarVideo(String nick, String nomV, boolean publico, String desc, Date fPub, int dur, String url) {}
	 
	 public void agregarVideoPrivado(String nick, String nomV, String desc, Date fPub, int dur, String url) {}
	 
	 public ArrayList<String> listarVideosDeUsuario(String nick) {
		return null;
	 }
	 
	 public void modificarInfoVideo(String nomV, String desc, Date fecha, int dur, String url, boolean publico) {}
	 
	 public ArrayList<DtComentario> obtenerComentariosVideo() {
		return null;
	}
	 
	 public ArrayList<DtVideo> obtenerInfoVideo(String nomVid) {
		return null;
	}
	 
	 public ArrayList<DtValoracion> obtenerValoracionVideo() {
		return null;
	}
	 
	 public void responderComentario(int idCom, String nick, Date fcom, String texto) {}
	 
	 public void realizarComentario(String nick, Date fCom, String texto) {}
	 
	 public void valorarVideo(String nomVid, String nickVal, boolean val) {}
}
