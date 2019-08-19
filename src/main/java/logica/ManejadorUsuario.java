package logica;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.EntityManager;

public class ManejadorUsuario {
	
	private static ManejadorUsuario instancia = null;
	
	private Map <String, Usuario> usuario = new HashMap<String, Usuario>();
	
	private ManejadorUsuario() {}
	
	public static ManejadorUsuario getInstancia() {
		if (instancia == null)
			instancia = new ManejadorUsuario();
		return instancia;
	}
	
	public void agregarUsuario(Usuario u) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
	}
	
	public Usuario buscarUsuario(String nickname){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		return em.find(Usuario.class, nickname);
	}
	
	public boolean existeUsuario(String nickname) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		if ( em.find(Usuario.class, nickname) == null)
			return true;
		else
			return false;
	}
	
	
	public Usuario obtenerUsuario(String nickname) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Usuario usr = em.find(Usuario.class, nickname);		
		
		return usr;
	}
}
