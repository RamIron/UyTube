package logica;

import java.util.Date;
import java.util.Map;

import datatypes.DtComentario;
import datatypes.DtElementoUsuario;
import datatypes.DtValoracion;

public class Video extends Elemento {
	private String descripcion;
	private Date fPublicacion;
	private Integer duracion;
	private String url;
	private boolean publico;
	private Categoria categoria;
	private Map<Integer, Valoracion> valoraciones;
	private Map<Integer, Comentario> comentarios;
	
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

	public Map<Integer, Valoracion> getValoraciones() {
		return valoraciones;
	}

	public void setValoraciones(Map<Integer, Valoracion> valoraciones) {
		this.valoraciones = valoraciones;
	}

	public Map<Integer, Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Map<Integer, Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	
	//Operaciones
	
	public void crearComentario(Usuario uC, Date fCom, String texto) {}
	
	public void crearRespuesta(int idCom, Usuario uC, Date fCom, String texto) {}
	
	public Map<String, DtValoracion> listarValoraciones(){
		return null;
	}
	
	public DtComentario obtenerComentariosVideo() {
		return null;
	}
	
	public DtElementoUsuario obtenerElemCategoria() {
		return null;
	}
	
	public void valorar(Usuario uVal, boolean val) {}
}
