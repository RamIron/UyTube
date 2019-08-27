package logica;

import java.util.*;
import javax.persistence.*;

import datatypes.*;


@Entity
public class Canal {

	private String nombre;
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="PUBLICO")
	private Boolean publico;
	
	@OneToOne
	private Usuario usuario;
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
	private List <Video> videos = new ArrayList<Video>();
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
	private List <ListaReproduccion> listas = new ArrayList<ListaReproduccion>();
	
	
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getPublico() {
		return publico;
	}

	public void setPublico(Boolean publico) {
		this.publico = publico;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public List<ListaReproduccion> getListas() {
		return listas;
	}

	
//	
//	//Operaciones
//	public void agregarCategoriaALista(String nomL, Categoria cat) {
//		Conexion conexion = Conexion.getInstancia();
//		EntityManager em = conexion.getEntityManager();
//		Map<String, ListaReproduccion> listas = this.getListas();
//		ListaReproduccion listaRep = listas.get(nomL);
//		if(listaRep instanceof Particular) { //me fijo si la lista es particular o no
//			((Particular) listaRep).modificarCategoria(cat.getNombre());
//		}
//		try {
//			em.getTransaction().begin();
//			em.persist(listaRep);
//			em.getTransaction().commit();
//			} catch (Exception e){
//				if(e instanceof RollbackException)
//					if(em.getTransaction().isActive())
//						em.getTransaction().rollback();
//				throw new IllegalArgumentException("Hubo un error inesperado");
//			}
//			finally { 
//				em.close();
//			}
//		
//	}
	
	public void agregarCategoriaVideo(String nomV, Categoria cat) {
		/*Video v = this.videos.get(nomV);
		v.setCategoria(cat);*/
	}
	
	public void agregarListaParticular(String nomL, boolean publico) {
		/*Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		Particular lisPar = new Particular(nomL, this, publico);
		this.listas.add(lisPar);
		em.persist(lisPar);
		em.getTransaction().commit();*/
	}
	
	public void agregarListaDefecto(String nomL) {
		/*System.out.println("Entra al canal: " + this.getNombre());
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		PorDefecto def = new PorDefecto(nomL, this);
		this.listas.add(def);
		em.persist(def);
		em.getTransaction().commit();*/
	}
	
	public Video agregarVideo(String nomV, String desc, Calendar fPub, int dur, String url) {
		Boolean publico = false;
		Video v = new Video(nomV, desc, fPub, dur, url, publico, this);
		return v;
	}
	
//	public void agregarVideoLista(Video v, String nomList) {
//		
//	}
//	
//	public void eliminarVideoDeLista(Video v, String nomList) {}
//	
//	//public boolean existeListaDefecto(String nomL) {}
//	
//	//public boolean existeListaParticular(String nomL) {}
//	
//	public ArrayList<String> listarListasDeUsuario() {}
//	
//	public ArrayList<String> listarListasParticulares() {}
//	
//	public ArrayList<String> listarVideosdeLista(String nomList) {}
//	
//	public ArrayList<DtComentario> obtenerComentariosVideo(String nomVid) {
//		Video v= this.videos.get(nomVid);
//		ArrayList<DtComentario> dtComentarios = v.obtenerComentariosVideo();
//		return dtComentarios;
//	}
//	
//	public DtVideo obtenerInfoVideo(String nomVid) {
//		Video v= this.videos.get(nomVid);
//		DtVideo dtVid = new DtVideo(v.getNombre(), v.getDescripcion(), v.getfPublicacion(), v.getDuracion(), v.getUrl(), v.isPublico());
//		return dtVid;
//	}
//	
//	public DtListaRep obtenerListaDeUsuario(String nomList) {}
//	
//	public String obtenerUsuarioCanal() {
//		return this.usuario.getNickname();
//	}
//	
//	public Video obtenerVideo(String nomVid) {
//		Video v= this.videos.get(nomVid);
//		return v;
//	}
//	
	public void valorarVideo(Video v, Usuario uVal, boolean val) {
		v.valorarVideo(val, uVal, v);
	}
	
	public Video obtenerVideo() {
		Video v= this.videos.get(0);
		return v;
	}
}