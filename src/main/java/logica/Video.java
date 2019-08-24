package logica;

import java.util.*;
import javax.persistence.*;
import datatypes.DtComentario;
import datatypes.DtElementoUsuario;
import datatypes.DtValoracion;
import datatypes.tipoElemento;

@Entity
@DiscriminatorValue("V")
public class Video extends Elemento {
	//Atributos
	private String descripcion;
	private Date fPublicacion;
	private Integer duracion;
	private String url;
	
	private boolean publico;
		
//	@OneToMany(mappedBy="video",cascade=CascadeType.ALL,orphanRemoval=true)
//	private List<Valoracion> valoraciones = new ArrayList<Valoracion>();
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Comentario> comentarios = new ArrayList<Comentario>();
	
	
	//Constructores
	public Video() {
		super();
	}

	public Video(String nombre, String descripcion, Date fPublicacion, Integer duracion, String url, boolean publico) {
		super(nombre);
		this.descripcion = descripcion;
		this.fPublicacion = fPublicacion;
		this.duracion = duracion;
		this.url = url;
		this.publico = publico;
	}
	
	public Video(String nombre, String descripcion, Date fPublicacion, Integer duracion, String url, boolean publico, Canal canal) {
		super(nombre, canal);
		this.descripcion = descripcion;
		this.fPublicacion = fPublicacion;
		this.duracion = duracion;
		this.url = url;
		this.publico = publico;
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		canal.getVideos().add(this);
		em.persist(canal);
		em.persist(this);
		em.getTransaction().commit();
		
	}

	//Getters & Setters
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getfPublicacion() {
		return fPublicacion;
	}

	public void setfPublicacion(Date fPublicacion) {
		this.fPublicacion = fPublicacion;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isPublico() {
		return publico;
	}

	public void setPublico(boolean publico) {
		this.publico = publico;
	}

//	public List<Valoracion> getValoraciones() {
//		return valoraciones;
//	}
//
//	public List<Comentario> getComentarios() {
//		return comentarios;
//	}
//
//	
	
	//Operaciones
	
	public void crearComentario(Usuario uC, Date fCom, String texto) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		Comentario c = new Comentario(fCom, texto, uC);
		comentarios.add(c);
		em.persist(c);
		em.persist(this);
		em.getTransaction().commit();
	}
	
//	public void crearRespuesta(int idCom, Usuario uC, Date fCom, String texto) {
//		//hay que buscar en la lista general de comentarios
//		Comentario c = comentarios.get(idCom);
//		c.crearRespuesta(uC, fCom, texto);
//		
//	}
		
//	public List<DtValoracion> listarValoraciones() {
//		List<DtValoracion> res = new ArrayList<DtValoracion>();
//		for(Valoracion val: valoraciones) {
//			DtValoracion v = new DtValoracion(val.getUsuario().getNickname(), val.isGusta());
//			res.add(v);
//		}
//		return res;
//	}
//	
//	public ArrayList<DtComentario> obtenerComentariosVideo() {
//		return null;
//	}  ///esto debe ser un jTree
//	
//	public DtElementoUsuario obtenerElemCategoria() {
//		DtElementoUsuario res = new DtElementoUsuario(this.getCanal().getUsuario().getNickname(), this.getNombre(), tipoElemento.VIDEO);
//		return res;
//	}
//	
//	public void valorar(Usuario uVal, boolean val) {
//		Valoracion v = new Valoracion(val, uVal, this);
//		uVal.agregarValoracion(v);
//		this.valoraciones.add(v);
//	}
}