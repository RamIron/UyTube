package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import datatypes.DtElementoUsuario;
import interfaces.ICategoria;

public class CCategoria implements ICategoria {
	public Categoria cat;
	
	//Operaciones
	public boolean existeCategoria(String nomC) {
		return false;
	}
	
	public void altaCategoria(String nomC) {}
	
	public ArrayList<DtElementoUsuario> listarElemCategoria(String nomC) {
		return null;
	}
	
	public ArrayList<String> listarCategorias() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query consulta = em.createQuery("SELECT * FROM Categorias c", Categoria.class);
	    List<Categoria> categorias = consulta.getResultList();
	    ArrayList<String> nomCats = new ArrayList<String>();
	    String nomC;
	    for(Categoria c : categorias) {
			nomC = c.getNombre();
			nomCats.add(nomC);
		}
	    return nomCats;
	}
	
}
