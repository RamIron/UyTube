package logica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import Manejadores.ManejadorUsuario;
import datatypes.DtCanal;
import datatypes.DtUsuario;
import interfaces.IUsuario;

public class CUsuario implements IUsuario {
	public Usuario usr;
	public Canal can;
	
	//Operaciones
	@Override 
	public void agregarCanal() {
		try {
			ManejadorUsuario mU = ManejadorUsuario.getInstancia();
			usr.agregarCanal();
			this.can = this.usr.getCanal();
			mU.modificaDatosUsuario(this.usr);
		} catch (Exception e){
			throw e;
		}	
	}

	
	@Override 
	public void agregarUsuario(String nick, String nom, String ape, Calendar fechaN, String email) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		try {
			Usuario usuario = new Usuario(nick, nom, ape, fechaN, email);
			mU.agregarUsuario(usuario);
			this.usr = usuario;
		} catch (Exception e){
			throw e;
		}	
	}
	
	
	@Override 
	public void dejarDeSeguirUsuario(String seguidor, String seguido) {		
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		
		if(mU.existeUsuario(seguidor)) { //Si el usuario existe
			if(mU.existeUsuario(seguido)) { //Si el segundo usuario existe
				try {
					Usuario USeguidor = mU.obtenerUsuario(seguidor);
					Usuario USeguido = mU.obtenerUsuario(seguido);
					USeguidor.dejarSeguirUsuario(USeguido);
					USeguido.quitarSeguidor(USeguidor);
					mU.modificaDatosUsuario(USeguidor);
					mU.modificaDatosUsuario(USeguido);
				} catch (Exception e){
					throw e;
				}
			}else {
				throw new java.lang.RuntimeException("No existe un usuario con nick: " + seguido);
			}
		}else {
			throw new java.lang.RuntimeException("No existe un usuario con nick: " + seguidor);
		}
	}
	
	@Override 
	public boolean existeEmail(String email) {
		return false;
	}
	
	@Override 
	public boolean existeNickname(String nick) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		return mU.existeUsuario(nick);
	}
	
	@Override
	public void limpiarControlador() { //Operacion para utilizar al final de cada caso de uso
		this.can = null;
		this.usr = null;
	}
	
	@Override 
	public List<String> listarSeguidores() {
		List<String> dtSeguidores = this.usr.listarSeguidores();
		return dtSeguidores;
	}
	
	@Override 
	public List<String> listarSeguidos() {
		List<String> dtSeguidos = this.usr.listarSeguidos();
		return dtSeguidos;
	}
	
	@Override 
	public List<String> listarUsuarios() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
	    return mU.listarUsuarios();
	}
	
	@Override 
	public void modificarImagen(String img) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		this.usr.setImagen(img);
		mU.modificaDatosUsuario(this.usr);
	}
	
//	@Override 
//	public void modificarInfoCanal(String nomC, String descC, boolean publico) {
//		Conexion conexion = Conexion.getInstancia();
//		EntityManager em = conexion.getEntityManager();
//		try {
//			em.getTransaction().begin();
//			em.persist(this.can);
//			this.can.setNombre(nomC);
//			this.can.setDescripcion(descC);
//			this.can.setPublico(publico);
//			em.getTransaction().commit();
//		}catch (Exception e){
//			if(e instanceof RollbackException)
//				if(em.getTransaction().isActive())
//					em.getTransaction().rollback();
//			throw new IllegalArgumentException("Hubo un error inesperado");
//		}	
//	}
	
	@Override 
	public void modificarInfoCanal(String nomC, String descC, boolean publico) {
		try {
			ManejadorUsuario mU = ManejadorUsuario.getInstancia();
			this.can.setNombre(nomC);
			this.can.setDescripcion(descC);
			this.can.setPublico(publico);
			mU.modificaDatosUsuario(this.usr);
		} catch (Exception e){
			throw e;
		}	
	}
	
	@Override 
	public void modificarInfoUsuario(String nick, String nomU, String apeU, Calendar fNacU, String imagen) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		try {
			this.usr = em.find(Usuario.class, nick);
			em.getTransaction().begin();
			em.persist(this.usr);
			this.usr.setNombre(nomU);
			this.usr.setApellido(apeU);
			this.usr.setfNac(fNacU);
			this.usr.setImagen(imagen);
			em.getTransaction().commit();
		}catch (Exception e){
			if(e instanceof RollbackException)
				if(em.getTransaction().isActive())
					em.getTransaction().rollback();
			throw new IllegalArgumentException("Hubo un error inesperado");
		}	
		
	}
	
	@Override 
	public DtCanal obtenerInfoCanal() {
//		DtCanal dtCan = usr.obtenerInfoCanal();
//		return dtCan;
		return null;
	}
	
	@Override 
	public DtUsuario obtenerInfoUsuario(String nick) {
//		Conexion conexion = Conexion.getInstancia();
//		EntityManager em = conexion.getEntityManager();
//		if(em.find(Usuario.class, nick) != null) {
//			this.usr = em.find(Usuario.class, nick);
//			DtUsuario dtUsr = new DtUsuario(usr.getNickname(), usr.getNombre(), usr.getApellido(), usr.getfNac(), usr.getImagen(), usr.getCorreoE());
//			return dtUsr;
//		}else {
//			throw new java.lang.RuntimeException("No existe un usuario con ese nick");
//		}
		return null;
	}
	
	
	@Override 
	public void seguirUsuario(String seguidor, String seguido) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		
		if(mU.existeUsuario(seguidor)) { //Si el usuario existe
			if(mU.existeUsuario(seguido)) { //Si el segundo usuario existe
				try {
					Usuario USeguidor = mU.obtenerUsuario(seguidor);
					Usuario USeguido = mU.obtenerUsuario(seguido);
					USeguidor.seguirUsuario(USeguido);
					USeguido.agregarSeguidor(USeguidor);
					mU.modificaDatosUsuario(USeguidor);
					mU.modificaDatosUsuario(USeguido);
				} catch (Exception e){
					throw e;
				}
			}else {
				throw new java.lang.RuntimeException("No existe un usuario con nick: " + seguido);
			}
		}else {
			throw new java.lang.RuntimeException("No existe un usuario con nick: " + seguidor);
		}
	}

}