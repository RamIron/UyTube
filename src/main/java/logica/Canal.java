package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.*;

import datatypes.DtComentario;
import datatypes.DtListaRep;
import datatypes.DtVideo;


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
	private Map <String,ListaReproduccion> listas = new HashMap<String, ListaReproduccion>();
	
	
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

	public Map<String, ListaReproduccion> getListas() {
		return listas;
	}
	
	public Map<String, Video> getVideos() {
		return videos;
	}
	
	//Operaciones
	public void agregarCategoriaALista(String nomL, Categoria cat) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Map<String, ListaReproduccion> listas = this.getListas();
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
	
	public void agregarCategoriaVideo(String nomV, Categoria cat) {
		Video v = this.videos.get(nomV);
		v.setCategoria(cat);
	}
	
	public void agregarLista(ListaReproduccion lista) {
		this.listas.put(lista.getNombre(), lista);
	}
	
	public void agregarLista(String nomL, boolean publico) {
		
	}
	
	public void agregarVideo(String nomV, String desc, Boolean publico, Date fPub, int dur, String url) {
		Video v = new Video(nomV, desc, fPub, dur, url, publico);
		this.videos.put(nomV, v);
	}
	
	public void agregarVideoLista(Video v, String nomList) {
		
	}
	
	public void eliminarVideoDeLista(Video v, String nomList) {}
	
	//public boolean existeListaDefecto(String nomL) {}
	
	//public boolean existeListaParticular(String nomL) {}
	
	public ArrayList<String> listarListasDeUsuario() {}
	
	public ArrayList<String> listarListasParticulares() {}
	
	public ArrayList<String> listarVideosdeLista(String nomList) {}
	
	public ArrayList<DtComentario> obtenerComentariosVideo(String nomVid) {
		Video v= this.videos.get(nomVid);
		ArrayList<DtComentario> dtComentarios = v.obtenerComentariosVideo();
		return dtComentarios;
	}
	
	public DtVideo obtenerInfoVideo(String nomVid) {
		Video v= this.videos.get(nomVid);
		DtVideo dtVid = new DtVideo(v.getNombre(), v.getDescripcion(), v.getfPublicacion(), v.getDuracion(), v.getUrl(), v.isPublico());
		return dtVid;
	}
	
	public DtListaRep obtenerListaDeUsuario(String nomList) {}
	
	public String obtenerUsuarioCanal() {
		return this.usuario.getNickname();
	}
	
	public Video obtenerVideo(String nomVid) {
		Video v= this.videos.get(nomVid);
		return v;
	}
	
	public void valorarVideo(String nomVid, Usuario uVal, boolean val) {
		Video v= this.videos.get(nomVid);
		v.valorar(uVal, val);
	}
}
