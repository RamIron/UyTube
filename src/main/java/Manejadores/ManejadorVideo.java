/*package Manejadores;

//import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;

import logica.Categoria;
import logica.Conexion;
import logica.Usuario;
import logica.Video;

public class ManejadorVideo {
	private static ManejadorVideo instancia = null;
	
	private ManejadorVideo(){}
	
	public static ManejadorVideo getInstancia() {
		if (instancia == null)
			instancia = new ManejadorVideo();
		return instancia;
	}
	
	public void agregarVideo(Video video) {
		Conexion conexion=Conexion.getInstancia();
		EntityManager em =conexion.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(video);
			em.getTransaction().commit();
			System.out.println("Ya esta en la base de datos");
		} catch (Exception e){
			if(e instanceof RollbackException)
				if(em.getTransaction().isActive())
					em.getTransaction().rollback();
			throw new IllegalArgumentException("Hubo un error inesperado");
		}
	}
	
	public void modificarVideo(Video video) {
		Conexion conexion=Conexion.getInstancia();
		EntityManager em =conexion.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(video);
			em.getTransaction().commit();
		} catch (Exception e){
			if(e instanceof RollbackException)
				if(em.getTransaction().isActive())
					em.getTransaction().rollback();
			throw new IllegalArgumentException("Hubo un error inesperado");
		}
	}
	
}*/
