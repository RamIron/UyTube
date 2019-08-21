package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;

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
		if(em.find(Categoria.class, nomC) == null) { //asi ya veo si existe o no la categoria
			Categoria cat = new Categoria(nomC);
			try {
				em.getTransaction().begin();
				em.persist(cat);
				em.getTransaction().commit();
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
			throw new IllegalArgumentException("Ya existe una categoria con el nombre ingresado");
		}
	}
	
	@Override 
	public List<DtElementoUsuario> listarElemCategoria(String nomC) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		if(em.find(Categoria.class, nomC) != null) { //veo si existe o no la categoria
			this.cat = em.find(Categoria.class, nomC);
			List<DtElementoUsuario> elementos = this.cat.obtenerElemCategoria();
			em.close();
			return elementos;	
		} else {
			throw new IllegalArgumentException("No se encontro una categoria con ese nombre");
		}
	}
	
	@Override //Esta sobreescrito en la interfaz
	public List<String> listarCategorias() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query consulta = em.createQuery("SELECT c.nombre FROM Categorias c", String.class);
	    List<String> categorias = consulta.getResultList();
	    em.close();
	    return categorias;
	}
	
}
