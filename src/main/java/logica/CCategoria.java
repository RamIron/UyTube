package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import datatypes.DtElementoUsuario;
import interfaces.ICategoria;

public class CCategoria implements ICategoria {
	public Categoria cat;
	
	//Operaciones
	@Override 
	public boolean existeCategoria(String nomC) {
		return false;
		//NO SE NECESITA
	}
	
	@Override 
	public void altaCategoria(String nomC) throws IllegalArgumentException {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		if(em.find(Categoria.class, nomC) == null) { //si no existe la categoria
			try {
				Categoria cat = new Categoria(nomC);
				em.getTransaction().begin();
				em.persist(cat);
				em.getTransaction().commit();
			} catch (Exception e){
				if(e instanceof RollbackException)
					if(em.getTransaction().isActive())
						em.getTransaction().rollback();
				throw new IllegalArgumentException("Hubo un error inesperado");
			}
		} else {
			throw new IllegalArgumentException("Ya existe una categoria con el nombre ingresado");
		}
	}
	
	@Override 
	public List<DtElementoUsuario> listarElemCategoria(String nomC) {
//		Conexion conexion = Conexion.getInstancia();
//		EntityManager em = conexion.getEntityManager();
//		if(em.find(Categoria.class, nomC) != null) { //veo si existe o no la categoria
//			this.cat = em.find(Categoria.class, nomC);
//			List<DtElementoUsuario> elementos = this.cat.obtenerElemCategoria();
//			em.close();
//			return elementos;	
//		} else {
//			throw new IllegalArgumentException("No se encontro una categoria con ese nombre");
//		}
		return null;
	}
	
	@Override //Esta sobreescrito en la interfaz
	public List<String> listarCategorias() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		TypedQuery<String> consulta = em.createQuery("SELECT c.nombre FROM Categoria c", String.class);
	    List<String> categorias = consulta.getResultList();
	 
	    return categorias;
	}
	
}