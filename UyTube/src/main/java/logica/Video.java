package logica;

import java.util.*;
import javax.persistence.*;

import datatypes.*;

@Entity
@DiscriminatorValue("V")
public class Video extends Elemento {
	//Atributos
	private String descripcion;
	private Calendar fPublicacion;
	private Integer duracion;
	private String url;
	
	private boolean publico;
		
	@OneToMany(/*mappedBy="video",*/cascade=CascadeType.ALL,orphanRemoval=true)
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
	
//	public void crearRespuesta(int idCom, Usuario uC, Calendar fCom, String texto) {
//		//hay que buscar en la lista general de comentarios
//		Comentario c = comentarios.get(idCom);
//		c.crearRespuesta(uC, fCom, texto);
//		
//	}
		
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

//	public DtElementoWeb obtenerVideoWeb() {
//		DtElementoWeb video = new DtElementoWeb(this.getCanal().getUsuario().getNickname(), this.getNombre(), tipoElemento.VIDEO, this.getUrl());
//		return video;
//	}
	
	
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
}