package Manejadores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import logica.Comentario;
import logica.Conexion;
import logica.Usuario;

public class ManejadorUsuario {
	private static ManejadorUsuario instancia = null;
	
	private ManejadorUsuario(){}
	
	public static ManejadorUsuario getInstancia() {
		if (instancia == null)
			instancia = new ManejadorUsuario();
		return instancia;
	}
	
	public boolean existeUsuario(String nick) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		if(em.find(Usuario.class, nick) == null){//Si no existe el nickname en la base
			//em.close();
			return false;
		}else {
			//em.close();
			return true;
		}
	}
	
	public void agregarUsuario(Usuario usuario) {
		Conexion conexion=Conexion.getInstancia();
		EntityManager em =conexion.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
			//em.close();
		} catch (Exception e){
			if(e instanceof RollbackException)
				if(em.getTransaction().isActive())
					em.getTransaction().rollback();
			throw new IllegalArgumentException("Hubo un error inesperado");
		}
	}
	
	public Usuario obtenerUsuario(String nickname){
		Conexion conexion=Conexion.getInstancia();
		EntityManager em =conexion.getEntityManager();
		Usuario usuario = em.find(Usuario.class, nickname);
		//em.close();
		return usuario;
	}
	
	public List<String> listarUsuarios(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		TypedQuery<String> consulta = em.createQuery("SELECT u.nickname FROM Usuario u", String.class);
	    List<String> usuarios = consulta.getResultList();
	    //em.close();
	    return usuarios;
	}
	
	public void modificaDatosUsuario(Usuario usuario) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
			//em.close();
		}catch (Exception e){
			if(e instanceof RollbackException)
				if(em.getTransaction().isActive())
					em.getTransaction().rollback();
			throw new IllegalArgumentException("Hubo un error inesperado");
		}
	}
}