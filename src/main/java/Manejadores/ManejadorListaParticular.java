/*package Manejadores;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;

import logica.Conexion;
import logica.Particular;
import logica.Video;

public class ManejadorListaParticular {
	private static ManejadorListaParticular instancia = null;
	
	private ManejadorListaParticular(){}
	
	public static ManejadorListaParticular getInstancia() {
		if (instancia == null)
			instancia = new ManejadorListaParticular();
		return instancia;
	}
	
	public void agregarListaParticular(Particular particular) {
		Conexion conexion=Conexion.getInstancia();
		EntityManager em =conexion.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(particular);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e){
			if(e instanceof RollbackException)
				if(em.getTransaction().isActive())
					em.getTransaction().rollback();
			throw new IllegalArgumentException("Hubo un error inesperado");
		}
	}
	
	public void modificarListaParticular(Particular particular) {
		Conexion conexion=Conexion.getInstancia();
		EntityManager em =conexion.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(particular);
			em.getTransaction().commit();
		} catch (Exception e){
			if(e instanceof RollbackException)
				if(em.getTransaction().isActive())
					em.getTransaction().rollback();
			throw new IllegalArgumentException("Hubo un error inesperado");
		}
	}
}*/
