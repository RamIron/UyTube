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
	
//	public void eliminarVideo(String nickV, String nomVid) {
//		for(Video v: videos) {
//			if(v.getCanal().getUsuario().getNickname() == nickV &&  v.getNombre() == nomVid){
//				videos.remove(v);
//				break;
//			}
//		}
//	}
	
	public void eliminarVideo(Video v) {
		videos.remove(v);
	}
	
//	public abstract boolean esParticular();
//	
	public abstract boolean isPublico();
//	
//	public abstract void setPublico(boolean publico);
	
	public List<DtVideoUsuario> listarVideos() {
		List<DtVideoUsuario> res = new ArrayList<DtVideoUsuario>();
		for(Video v: videos) {
			DtVideoUsuario vid = new DtVideoUsuario(v.getCanal().getUsuario().getNickname(), v.getNombre());
			res.add(vid);
		}
		return res;
	}
//	
//	public Map<Integer, DtComentario> obtenerComentariosVideo(String nickV, String nomVid) {
//		return null;
//	}/// ver si se usa jTree
//	
//	public DtVideo obtenerInfoVideo(String nickV, String nomVid) {
//		for(Video v: videos) {
//			if(v.getCanal().getUsuario().getNickname() == nickV &&  v.getNombre() == nomVid){
//				return new DtVideo(nomVid, v.getDescripcion(), v.getfPublicacion(), v.getDuracion(), v.getUrl(), v.isPublico());
//			}
//		}
//		return null;
//	}
//	
//	public List<DtValoracion> obtenerValoracionVideo(String nickV, String nomVid) {
//		for(Video v: videos) {
//			if(v.getCanal().getUsuario().getNickname() == nickV &&  v.getNombre() == nomVid){
//				return v.listarValoraciones();
//			}
//		}
//		return null;
//	}
//	
//	@Override
//	public DtElementoUsuario obtenerElemCategoria() {
//		return new DtElementoUsuario(this.getCanal().getUsuario().getNickname(), this.getNombre(), tipoElemento.LISTA);
//	}

}