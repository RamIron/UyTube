package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.persistence.EntityManager;

import datatypes.DtComentario;
import datatypes.DtValoracion;
import datatypes.DtVideo;
import interfaces.IVideo;

public class CVideo implements IVideo {
	public Usuario usr;
	public Video vid;
	
	//Operaciones
	@Override 
	public void agregarCategoria(String nomV, String nomC) {}
	
	@Override 
	public void agregarVideo(String nick, String nomV, boolean publico, String desc, Date fPub, int dur, String url) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		if(em.find(Usuario.class, nick) != null) {
			this.usr = em.find(Usuario.class, nick);
			this.usr.agregarVideo(nomV, publico, desc, fPub, dur, url);
		}
		em.close();
	}
	
	@Override	
	public void agregarVideoPrivado(String nick, String nomV, String desc, Date fPub, int dur, String url) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		if(em.find(Usuario.class, nick) != null) {
			this.usr = em.find(Usuario.class, nick);
			this.usr.agregarVideo(nomV, publico, desc, fPub, dur, url);
		}
	}
	
	@Override
	public void limpiarControlador() { //Operacion para utilizar al final de cada caso de uso
		this.vid = null;
		this.usr = null;
	}
	
	@Override
	public ArrayList<String> listarVideosDeUsuario(String nick) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		if(em.find(Usuario.class, nick) != null) {
			this.usr = em.find(Usuario.class, nick);
			ArrayList<String> videos = this.usr.listarVideosDeUsuario();
			return videos;
		}else {
			throw new java.lang.RuntimeException("No existe un usuario con ese nick");
		}
		
	}
	
	@Override 
	public void modificarInfoVideo(String nomV, String desc, Date fecha, int dur, String url, boolean publico) {}
	
	@Override 
	public ArrayList<DtComentario> obtenerComentariosVideo(String nomVid) {
		ArrayList<DtComentario> dtComentarios = this.usr.obtenerComentariosVideo(nomVid);
		return dtComentarios;
	}
	
	@Override 
	public ArrayList<DtVideo> obtenerInfoVideo(String nomVid) {
		return null;
	}
	
	@Override 
	public ArrayList<DtValoracion> obtenerValoracionVideo() {
		return null;
	}
	
	@Override 
	public void responderComentario(int idCom, String nick, Date fcom, String texto) {}
	
	@Override 
	public void realizarComentario(String nick, Date fCom, String texto) {}
	
	@Override 
	public void valorarVideo(String nomVid, String nickVal, boolean val) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		if(em.find(Usuario.class, nickVal) != null) {
			Usuario usrVal = em.find(Usuario.class, nickVal);
			this.usr.valorarVideo(nomVid, usrVal, val);
		}else {
			throw new java.lang.RuntimeException("No existe un usuario con ese nick");
		}
	}
}
