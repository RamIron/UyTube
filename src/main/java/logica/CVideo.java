package logica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;

import Manejadores.ManejadorUsuario;
import datatypes.DtComentario;
import datatypes.DtValoracion;
import datatypes.DtVideo;
import interfaces.IVideo;

public class CVideo implements IVideo {
	public Usuario usr;
	public Video vid;
	
	//Operaciones
	@Override 
	public void agregarCategoria(String nomC) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		if(em.find(Categoria.class, nomC) != null) {
			try {
				Categoria cat = em.find(Categoria.class, nomC);
			    cat.agregarElemento(this.vid);
			    System.out.println("Llega aca");
			} catch (Exception e){
				if(e instanceof RollbackException)
					if(em.getTransaction().isActive())
						em.getTransaction().rollback();
				throw new IllegalArgumentException("Hubo un error inesperado");
			}
		}else {
			throw new java.lang.RuntimeException("No existe una categoria con ese nombre");
		}
	}
	
//	@Override 
//	public void agregarVideo(String nick, String nomV, String desc, Calendar fPub, int dur, String url) {
//		Conexion conexion = Conexion.getInstancia();
//		EntityManager em = conexion.getEntityManager();
//		if(em.find(Usuario.class, nick) != null) {
//			try {
//				this.usr = em.find(Usuario.class, nick);
//				this.vid = this.usr.getCanal().agregarVideo(nomV, desc, fPub, dur, url);
//			} catch (Exception e){
//				if(e instanceof RollbackException)
//					if(em.getTransaction().isActive())
//						em.getTransaction().rollback();
//				throw new IllegalArgumentException("Hubo un error inesperado");
//			}
//			
//		}else {
//			throw new java.lang.RuntimeException("No existe un usuario con ese nick");
//		}
//	}
	
	@Override 
	public void agregarVideo(String nick, String nomV, String desc, Calendar fPub, int dur, String url) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		if(mU.existeUsuario(nick)) {
			this.usr = mU.obtenerUsuario(nick);
			this.vid = this.usr.getCanal().agregarVideo(nomV, desc, fPub, dur, url);
			mU.modificaDatosUsuario(this.usr);
		}else {
			throw new java.lang.RuntimeException("No existe un usuario con ese nick");
		}
	}
	
	
	@Override
	public void limpiarControlador() { //Operacion para utilizar al final de cada caso de uso
		this.vid = null;
		this.usr = null;
	}
	
	@Override
	public List<String> listarVideosDeUsuario(String nick) {
		/*Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		if(em.find(Usuario.class, nick) != null) {
			this.usr = em.find(Usuario.class, nick);
			ArrayList<String> videos = this.usr.listarVideosDeUsuario();
			return videos;
		}else {
			throw new java.lang.RuntimeException("No existe un usuario con ese nick");
		}*/
		return null;
	}
	
	@Override 
	public void modificarInfoVideo(String nomV, String desc, Calendar fecha, int dur, String url, boolean publico) {}
	
	@Override 
	public List<DtComentario> obtenerComentariosVideo(String nomVid) {
//		List<DtComentario> dtComentarios = this.usr.obtenerComentariosVideo(nomVid);
//		return dtComentarios;
		return null;
	}
	
	@Override 
	public List<DtVideo> obtenerInfoVideo(String nomVid) {
		return null;
	}
	
	@Override 
	public List<DtValoracion> obtenerValoracionVideo() {
		return null;
	}
	
	@Override 
	public void responderComentario(int idCom, String nick, Calendar fcom, String texto) {}
	
	@Override 
	public void realizarComentario(String nick, Calendar fCom, String texto) {}
	

	@Override 
	public void valorarVideo(String nomVid, String nickVal, boolean val) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		
		Usuario ramiro = mU.obtenerUsuario("ram");
		Video v = ramiro.getCanal().obtenerVideo();
		
		if(em.find(Usuario.class, nickVal) != null) {
			Usuario usrVal = em.find(Usuario.class, nickVal);
			ramiro.getCanal().valorarVideo(v, usrVal, true);
		}else {
			throw new java.lang.RuntimeException("No existe un usuario con ese nick");
		}
	}
}