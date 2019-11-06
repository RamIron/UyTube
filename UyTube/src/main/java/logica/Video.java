package logica;

import java.util.*;
import javax.persistence.*;

import datatypes.*;

@Entity
@DiscriminatorValue("V")
@NamedNativeQueries({
		@NamedNativeQuery(name = "buscarVideoNombre", query = "SELECT c.usuario_nickname, e.nombre, v.url from video v \n" +
				"\t\t\t\tinner join elemento e on e.id = v.id inner join canal c \n" +
				"\t\t\t\ton c.id = e.canal_id\n" +
				"\t\t\t\twhere c.publico = true \n" +
				"\t\t\t\tand v.publico = true \n" +
				"\t\t\t\tand e.nombre like (?)\n" +
				"\t\t\t\torder by e.nombre asc"),
		@NamedNativeQuery(name = "buscarVideoFecha", query = "SELECT c.usuario_nickname, e.nombre, v.url from video v \n" +
				"\t\t\t\tinner join elemento e on e.id = v.id inner join canal c \n" +
				"\t\t\t\ton c.id = e.canal_id\n" +
				"\t\t\t\twhere c.publico = true \n" +
				"\t\t\t\tand v.publico = true \n" +
				"\t\t\t\tand e.nombre like (?)\n" +
				"\t\t\t\torder by v.fpublicacion desc")
})
public class Video extends Elemento {
	//Atributos
	private String descripcion;
	private Calendar fPublicacion;
	private Integer duracion;
	private String url;
	
	private boolean publico;
		
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Valoracion> valoraciones = new ArrayList<Valoracion>();
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Comentario> comentarios = new ArrayList<Comentario>();
	
	
	//Constructores
	public Video() {
		super();
	}
	
	public Video(String nombre, String descripcion, Calendar fPublicacion, Integer duracion, String url, boolean publico, Canal canal) {
		super(nombre, canal);
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

	public Calendar getfPublicacion() {
		return fPublicacion;
	}

	public void setfPublicacion(Calendar fPublicacion) {
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

	public List<Valoracion> getValoraciones() {
		return valoraciones;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	
	
	//Operaciones
	
	public void crearComentario(Usuario uC, Calendar fCom, String texto) {
		Comentario c = new Comentario(fCom, texto, uC);
		comentarios.add(c);
	}

		
	public List<DtValoracion> listarValoraciones() {
		List<DtValoracion> res = new ArrayList<DtValoracion>();
		for(Valoracion val: valoraciones) {
			DtValoracion v = new DtValoracion(val.getUsuario().getNickname(), val.isGusta());
			res.add(v);
		}
		return res;
	}
	
	public List<DtComentario> obtenerComentariosVideo() {
		List<DtComentario> dtComs = new ArrayList<DtComentario>();
		for(Comentario c : this.comentarios) {	
			if(!c.getRespuestas().isEmpty()) {
				DtComentario dtC = new DtComentario(c.getId(), c.getUsuario().getNickname(), c.getFecha(),c.getTexto(), c.listarRespuestas());	
				dtComs.add(dtC);
			} else {
				DtComentario dtC = new DtComentario(c.getId(), c.getUsuario().getNickname(), c.getFecha(),c.getTexto());
				dtComs.add(dtC);
			}
		}
		return dtComs;
	} 

	public DtElementoUsuario obtenerElemCategoria() {
		DtElementoUsuario video = new DtElementoUsuario(this.getCanal().getUsuario().getNickname(), this.getNombre(), tipoElemento.VIDEO);
		return video;
	}
	
	
	public void valorarVideo(boolean gusta, Usuario usrVal) {
		boolean existe = false;
		for(Valoracion vals : this.valoraciones) {
			if(usrVal.equals(vals.getUsuario())) {
				existe = true;
				vals.setGusta(gusta);
				vals.setUsuario(usrVal);
			}
		}
		if(!existe) {
			Valoracion val = new Valoracion(gusta, usrVal);
			this.valoraciones.add(val);
		}
	}

	public void eliminarValoraciones(){
		for(Valoracion v: this.valoraciones){
			v.setUsuario(null);
		}
		this.valoraciones.clear();
	}

	public void sacarCategoria(){
		if(this.categoria != null) {
			this.categoria.quitarElemento(this);
			this.categoria = null;
		}
	}

	public void eliminarComentarios(){
		for(Comentario c: this.comentarios){
			c.eliminarRespuestas();
		}
		this.comentarios.clear();
	}

	public void eliminarValoracion(Integer i){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();

		TypedQuery<Valoracion> consulta = em.createQuery("FROM Valoracion v where v.id=:param", Valoracion.class);
		consulta.setParameter("param", i);
		Valoracion v = consulta.getSingleResult();

		v.setUsuario(null);
		this.valoraciones.remove(v);
	}

	public void eliminarComentario(Comentario c){
		c.eliminarRespuestas();
		this.comentarios.remove(c);
	}
}