package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

public class ManejadorComentario {

	private static ManejadorComentario instancia = null;
	private Map<Integer, Comentario> comentarios = new HashMap();
	
	private ManejadorComentario(){}
	
	public static ManejadorComentario getInstancia() {
		if (instancia == null)
			instancia = new ManejadorComentario();
		return instancia;
	}
	public void agregarComentario(Comentario comentario) {
		Conexion conexion=Conexion.getInstancia();
		EntityManager em =conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(comentario);
		em.getTransaction().commit();
	}
	public Comentario buscarComentario (int id){
		Conexion conexion=Conexion.getInstancia();
		EntityManager em =conexion.getEntityManager();
		return em.find(Comentario.class, id);
	}
}

	
	
