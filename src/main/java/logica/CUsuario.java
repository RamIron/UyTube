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

import datatypes.DtCanal;
import datatypes.DtUsuario;
import interfaces.IUsuario;

public class CUsuario implements IUsuario {
	public Usuario usr;
	public Canal can;
	
	//Operaciones
	@Override 
	public void agregarCanal() {
		usr.agregarCanal();
		this.can = this.usr.getCanal();
	}
	
	
	@Override 
	public void agregarUsuario(String nick, String nom, String ape, Calendar fechaN, String email) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
	
		try {
			Usuario usuario = new Usuario(nick, nom, ape, fechaN, email);
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
			this.usr = usuario;
		} catch (Exception e){
			if(e instanceof RollbackException)
				if(em.getTransaction().isActive())
					em.getTransaction().rollback();
			throw new IllegalArgumentException("Hubo un error inesperado");
		}	
	}
	
	@Override 
	public void dejarDeSeguirUsuario(String seguidor, String seguido) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();

		if(em.find(Usuario.class, seguidor) != null) { //Si el usuario existe
			if(em.find(Usuario.class, seguido) != null) { //Si el segundo usuario existe
				em.getTransaction().begin();
				Usuario USeguidor = em.find(Usuario.class, seguidor);
				Usuario USeguido = em.find(Usuario.class, seguido);
				em.persist(USeguidor);
				em.persist(USeguido);
				USeguidor.dejarSeguirUsuario(USeguido);
				USeguido.agregarSeguidor(USeguidor);
				em.getTransaction().commit();
			}else {
				throw new java.lang.RuntimeException("No existe un usuario con ese nick");
			}
		}else {
			throw new java.lang.RuntimeException("No existe un usuario con ese nick");
		}
	}
	
	@Override 
	public boolean existeEmail(String email) {
		return false;
	}
	
	@Override 
	public boolean existeNickname(String nick) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		if(em.find(Usuario.class, nick) == null){//Si no existe el nickname en la base
			return false;
		}else {
			return true;
		}
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
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		TypedQuery<String> consulta = em.createQuery("SELECT u.nickname FROM Usuario u", String.class);
	    List<String> usuarios = consulta.getResultList();
	    
	    return usuarios;
	}
	
	@Override 
	public void modificarImagen(String img) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		try {
			this.usr.setImagen(img);
			em.getTransaction().begin();
			em.persist(this.usr);
			em.getTransaction().commit();
		}catch (Exception e){
			if(e instanceof RollbackException)
				if(em.getTransaction().isActive())
					em.getTransaction().rollback();
			throw new IllegalArgumentException("Hubo un error inesperado");
		}
	}
	
	@Override 
	public void modificarInfoCanal(String nomC, String descC, boolean publico) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(this.can);
			this.can.setNombre(nomC);
			this.can.setDescripcion(descC);
			this.can.setPublico(publico);
			em.getTransaction().commit();
		}catch (Exception e){
			if(e instanceof RollbackException)
				if(em.getTransaction().isActive())
					em.getTransaction().rollback();
			throw new IllegalArgumentException("Hubo un error inesperado");
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
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		if(em.find(Usuario.class, seguidor) != null) { //Si el usuario existe
			if(em.find(Usuario.class, seguido) != null) { //Si el segundo usuario existe
				try {
					em.getTransaction().begin();
					Usuario USeguidor = em.find(Usuario.class, seguidor);
					Usuario USeguido = em.find(Usuario.class, seguido);
					em.persist(USeguidor);
					em.persist(USeguido);
					USeguidor.seguirUsuario(USeguido);
					USeguido.agregarSeguidor(USeguidor);
					em.getTransaction().commit();
				}catch (Exception e){
					if(e instanceof RollbackException)
						if(em.getTransaction().isActive())
							em.getTransaction().rollback();
					throw new IllegalArgumentException("Hubo un error inesperado");
				}	
			}else {
				throw new java.lang.RuntimeException("No existe un usuario con ese nick");
			}
		}else {
			throw new java.lang.RuntimeException("No existe un usuario con ese nick");
		}
	}

}