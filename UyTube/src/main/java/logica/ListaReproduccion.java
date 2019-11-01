package logica;

import java.util.*;
import javax.persistence.*;


import datatypes.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class ListaReproduccion extends Elemento {
	
	//Atributos
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Video> videos = new ArrayList<Video>();
	
	//Constructores
	public ListaReproduccion() {
		super();
	}

	public ListaReproduccion(String nombre, Canal canal) {
		super(nombre, canal);
	}

	public ListaReproduccion(String nombre) {
		super(nombre);
	}

	public List<Video> getVideos() {
		return videos;
	}


	//Operaciones
	public void agregarVideo(Video v) {
		videos.add(v);
	}
	
	public void eliminarVideo(Video v) {
		videos.remove(v);
	}

	public abstract boolean isPublico();

	public List<DtVideoUsuario> listarVideos() {
		List<DtVideoUsuario> res = new ArrayList<DtVideoUsuario>();
		for(Video v: videos) {
			DtVideoUsuario vid = new DtVideoUsuario(v.getCanal().getUsuario().getNickname(), v.getNombre());
			res.add(vid);
		}
		return res;
	}

	public List<DtElementoWeb> listarVideosWeb() {
		List<DtElementoWeb> res = new ArrayList<DtElementoWeb>();
		for(Video v: videos) {
			if(!videos.isEmpty()) {
				DtElementoWeb vid = new DtElementoWeb(v.getCanal().getUsuario().getNickname(), v.getNombre(), tipoElemento.VIDEO, v.getUrl());
				res.add(vid);
			}
		}
		return res;
	}

	public void sacarCategoria(){
		if(this.categoria != null) {
			this.categoria.quitarElemento(this);
			this.categoria = null;
		}
	}

	public void eliminarVideos(){
		/*for(Video v: this.videos){
			this.videos.remove(v);
		}*/
		this.videos.clear();
		this.videos = null;
	}

	public void quitarVideo(Video vid){
		this.videos.remove(vid);
	}

}
