package logica;

import java.util.*;
import javax.persistence.*;
import datatypes.DtComentario;
import datatypes.DtElementoUsuario;
import datatypes.DtValoracion;
import datatypes.tipoElemento;

@Entity
public class Video extends Elemento {
	//Atributos
	private String descripcion;
	private Date fPublicacion;
	private Integer duracion;
	private String url;
	
	private boolean publico;
	
	@ManyToOne
	private Categoria categoria;
	
	@OneToMany(mappedBy="video",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Valoracion> valoraciones;
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
	private Map<Integer, Comentario> comentarios; //evaluar como hacer esto
	
	
	//Constructores
	public Video() {
		super();
		this.valoraciones = new ArrayList<Valoracion>();
		this.comentarios = new HashMap<Integer, Comentario>();
	}

	public Video(String nombre, String descripcion, Date fPublicacion, Integer duracion, String url, boolean publico) {
		super(nombre);
		this.descripcion = descripcion;
		this.fPublicacion = fPublicacion;
		this.duracion = duracion;
		this.url = url;
		this.publico = publico;
		this.valoraciones = new ArrayList<Valoracion>();
		this.comentarios = new HashMap<Integer, Comentario>();
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	//Operaciones
	
	public void crearComentario(Usuario uC, Date fCom, String texto) {
		Comentario c = new Comentario(fCom,texto,uC);
		comentarios.put(c.getId(), c);
	}
	
	public void crearRespuesta(int idCom, Usuario uC, Date fCom, String texto) {
		Comentario c = comentarios.get(idCom);
		c.crearRespuesta(uC, fCom, texto);
		
	}
		
	public List<DtValoracion> listarValoraciones() {
		List<DtValoracion> res = new ArrayList<DtValoracion>();
		for(Valoracion val: valoraciones) {
			DtValoracion v = new DtValoracion(val.getUsuario().getNickname(), val.isGusta());
			res.add(v);
		}
		return res;
	}
	
	public ArrayList<DtComentario> obtenerComentariosVideo() {
		return null;
	}  ///esto debe ser un jTree
	
	public DtElementoUsuario obtenerElemCategoria() {
		DtElementoUsuario res = new DtElementoUsuario(this.getCanal().getUsuario().getNickname(), this.getNombre(), tipoElemento.VIDEO);
		return res;
	}
	
	public void valorar(Usuario uVal, boolean val) {
		Valoracion v = new Valoracion(val, uVal, this);
		uVal.agregarValoracion(v);
		this.valoraciones.add(v);
	}
}
