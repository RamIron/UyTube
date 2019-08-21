package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import datatypes.DtListaRep;


@Entity
public class Canal {

	private String nombre;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="PUBLICO")
	private Boolean publico;
	
	@Id
	@OneToOne
	private Usuario usuario;
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
	private Map <String ,Video> videos = new HashMap<String, Video>();
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
	private Map <String,ListaReproduccion> lista = new HashMap<String, ListaReproduccion>();
	
	
	//Constructores
	public Canal() {
		super();
	}

	public Canal(String nombre, String descripcion, boolean publico) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.publico = publico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isPublico() {
		return publico;
	}

	public void setPublico(boolean publico) {
		this.publico = publico;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Map<String, ListaReproduccion> getLista() {
		return lista;
	}
	
	
	//Operaciones
	public void agregarCategoriaALista(String nomL, Categoria cat) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Map<String, ListaReproduccion> listas = this.getLista();
		ListaReproduccion listaRep = listas.get(nomL);
		if(listaRep instanceof Particular) { //me fijo si la lista es particular o no
			((Particular) listaRep).modificarCategoria(cat.getNombre());
		}
		try {
			em.getTransaction().begin();
			em.persist(listaRep);
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
		
	}
	
	public void agregarCategoriaVideo(String nomV, Categoria cat) {}
	
	public void agregarLista(ListaReproduccion lista) {}
	
	public void agregarLista(String nomL, boolean publico) {}
	
	public void agregarVideo(String nomV, String desc, Date fPub, int dur, String url) {}
	
	public void eliminarVideoDeLista(Video v, String nomList) {}
	
	//public boolean existeListaDefecto(String nomL) {}
	
	//public boolean existeListaParticular(String nomL) {}
	
	public ArrayList<String> listarListasDeUsuario() {}
	
	public ArrayList<String> listarListasParticulares() {}
	
	public ArrayList<String> listarVideosdeLista(String nomList) {}
	
	public DtListaRep obtenerListaDeUsuario(String nomList) {}
	
	public String obtenerUsuarioCanal() {}
	
	public void valorarVideo(String nomVid, Usuario uVal, boolean val) {}
	
	public Video obtenerVideo(String nomVid) {}
	
	public void agregarVideoLista(Video v, String nomList) {}*/
}
