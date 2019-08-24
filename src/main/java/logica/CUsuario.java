package logica;

import java.util.ArrayList;
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
	public void agregarCanal(String desc, boolean publico) {
		usr.agregarCanal(desc, publico);
		this.can = this.usr.getCanal();
	}
	
	@Override 
	public void agregarNombreCanal(String nomC) {
		this.agregarNombreCanal(nomC);
	}
	
	@Override 
	public void agregarUsuario(String nick, String nom, String ape, Date fechaN, String email) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		if(em.find(Usuario.class, nick) == null) { //Si no existe un usuario con ese nick
			Usuario usuario = new Usuario(nick, nom, ape, fechaN, email);
			try {
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
			finally { 
				em.close();
			}
		} else {
			throw new IllegalArgumentException("Ya existe un usuario con ese nick");
		}
		
	}
	
	@Override 
	public void dejarDeSeguirUsuario(String seguidor, String seguido) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		if(em.find(Usuario.class, seguidor) != null) { //Si el usuario existe
			if(em.find(Usuario.class, seguido) != null) { //Si el segundo usuario existe
				Usuario USeguidor = em.find(Usuario.class, seguidor);
				Usuario USeguido = em.find(Usuario.class, seguido);
				USeguidor.seguirUsuario(USeguido);
				USeguido.agregarSeguidor(USeguidor);
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
			em.close();
			return false;
		}else {
			em.close();
			return true;
		}
	}
	
	@Override
	public void limpiarControlador() { //Operacion para utilizar al final de cada caso de uso
		this.can = null;
		this.usr = null;
	}
	
	@Override 
	public ArrayList<String> listarSeguidores() {
		ArrayList<String> dtSeguidores = this.usr.listarSeguidores();
		return dtSeguidores;
	}
	
	@Override 
	public ArrayList<String> listarSeguidos() {
		ArrayList<String> dtSeguidos = this.usr.listarSeguidos();
		return dtSeguidos;
	}
	
	@Override 
	public List<String> listarUsuarios() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query consulta = em.createQuery("SELECT u.nombre FROM Usuarios u", String.class);
	    List<String> usuarios = consulta.getResultList();
	    em.close();
	    return usuarios;
	}
	
	@Override 
	public void modificarImagen(String img) {
		this.usr.setImagen(img);
	}
	
	@Override 
	public void modificarInfoCanal(String nomC, String descC, boolean publico) {
		this.usr.modificarInfoCanal(nomC, descC, publico);
	}
	
	@Override 
	public void modificarInfoUsuario(String nick, String nomU, String apeU, Date fNacU, String imagen) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		if(em.find(Usuario.class, nick) != null) {
			this.usr = em.find(Usuario.class, nick);
			this.usr.setNombre(nomU);
			this.usr.setApellido(apeU);
			this.usr.setfNac(fNacU);
			this.usr.setImagen(imagen);
		}else {
			throw new java.lang.RuntimeException("No existe un usuario con ese nick");
		}
		
	}
	
	@Override 
	public DtCanal obtenerInfoCanal() {
		DtCanal dtCan = usr.obtenerInfoCanal();
		return dtCan;
	}
	
	@Override 
	public DtUsuario obtenerInfoUsuario(String nick) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		if(em.find(Usuario.class, nick) != null) {
			this.usr = em.find(Usuario.class, nick);
			DtUsuario dtUsr = new DtUsuario(usr.getNickname(), usr.getNombre(), usr.getApellido(), usr.getfNac(), usr.getImagen(), usr.getCorreoE());
			return dtUsr;
		}else {
			throw new java.lang.RuntimeException("No existe un usuario con ese nick");
		}
	}
	
	@Override 
	public void seguirUsuario(String seguidor, String seguido) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		if(em.find(Usuario.class, seguidor) != null) { //Si el usuario existe
			if(em.find(Usuario.class, seguido) != null) { //Si el segundo usuario existe
				Usuario USeguidor = em.find(Usuario.class, seguidor);
				Usuario USeguido = em.find(Usuario.class, seguido);
				USeguidor.seguirUsuario(USeguido);
				USeguido.agregarSeguidor(USeguidor);
			}else {
				throw new java.lang.RuntimeException("No existe un usuario con ese nick");
			}
		}else {
			throw new java.lang.RuntimeException("No existe un usuario con ese nick");
		}
	}

}