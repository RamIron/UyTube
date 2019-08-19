package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

public class ManejadorCategoria {
	
	private static ManejadorCategoria instancia = null;
	
	private List<Categoria> categorias = new ArrayList<Categoria>();
	
	private ManejadorCategoria(){}
	
	public static ManejadorCategoria getInstancia() {
		if (instancia == null)
			instancia = new ManejadorCategoria();
		return instancia;
	}
	
	public void agregarCategoria(Categoria c) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
	}
	
	public Categoria buscarCategoria(String nomC){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		return em.find(Categoria.class, nomC);
	}

}
