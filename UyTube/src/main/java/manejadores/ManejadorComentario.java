package manejadores;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;

import logica.Comentario;
import logica.Conexion;
import logica.Usuario;

public class ManejadorComentario {

	private static ManejadorComentario instancia = null;
	
	private ManejadorComentario(){}
	
	public static ManejadorComentario getInstancia() {
		if (instancia == null)
			instancia = new ManejadorComentario();
		return instancia;
	}

	public Comentario obtenerComentario(Integer id) {
		Conexion conexion=Conexion.getInstancia();
		EntityManager em =conexion.getEntityManager();
		Comentario comentario = em.find(Comentario.class, id);
		//em.close();
		return comentario;
	}
	
	public boolean existeComentario(Integer id) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		if(em.find(Comentario.class, id) == null){
			//em.close();
			return false;
		}else {
			//em.close();
			return true;
		}
	}
	
	public void modificarComentario(Comentario comentario) {
		Conexion conexion=Conexion.getInstancia();
		EntityManager em =conexion.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(comentario);
			em.getTransaction().commit();
			//em.close();
		} catch (Exception e){
			if(e instanceof RollbackException)
				if(em.getTransaction().isActive())
					em.getTransaction().rollback();
			throw new IllegalArgumentException("Hubo un error inesperado");
		}
	}
}
