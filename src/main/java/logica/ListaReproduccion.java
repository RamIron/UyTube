package logica;

import java.util.*;
import javax.persistence.*;
import java.util.Map;

import datatypes.DtComentario;
import datatypes.DtElementoUsuario;
import datatypes.DtVideo;
import datatypes.DtVideoUsuario;
import datatypes.tipoElemento;
import datatypes.DtValoracion;

@Entity
@MappedSuperclass
public abstract class ListaReproduccion extends Elemento {
	
	//Atributos
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Video> videos;
	
	//Constructores
	public ListaReproduccion() {
		super();
		videos = new ArrayList<Video>();
	}

	public ListaReproduccion(String nombre, Canal canal) {
		super(nombre, canal);
		videos = new ArrayList<Video>();
	}

	public ListaReproduccion(String nombre) {
		super(nombre);
		videos = new ArrayList<Video>();
	}
	
	//Operaciones
	public void agregarVideo(Video v) {
		videos.add(v);
		
	}
	
	public void eliminarVideo(String nickV, String nomVid) {
		for(Video v: videos) {
			if(v.getCanal().getUsuario().getNickname() == nickV &&  v.getNombre() == nomVid){
				videos.remove(v);
				break;
			}
		}
	}
	
	public abstract boolean esParticular();
	
	public abstract boolean esPublico();
	
	public List<DtVideoUsuario> listarVideos() {
		List<DtVideoUsuario> res = new ArrayList<DtVideoUsuario>();
		for(Video v: videos) {
			DtVideoUsuario vid = new DtVideoUsuario(v.getCanal().getUsuario().getNickname(), v.getNombre());
			res.add(vid);
		}
		return res;
	}
	
	public Map<Integer, DtComentario> obtenerComentariosVideo(String nickV, String nomVid) {
		return null;
	}/// ver si se usa jTree
	
	public DtVideo obtenerInfoVideo(String nickV, String nomVid) {
		for(Video v: videos) {
			if(v.getCanal().getUsuario().getNickname() == nickV &&  v.getNombre() == nomVid){
				return new DtVideo(nomVid, v.getDescripcion(), v.getfPublicacion(), v.getDuracion(), v.getUrl(), v.isPublico());
			}
		}
		return null;
	}
	
	public List<DtValoracion> obtenerValoracionVideo(String nickV, String nomVid) {
		for(Video v: videos) {
			if(v.getCanal().getUsuario().getNickname() == nickV &&  v.getNombre() == nomVid){
				return v.listarValoraciones();
			}
		}
		return null;
	}
	
	@Override
	public DtElementoUsuario obtenerElemCategoria() {
		return new DtElementoUsuario(this.getCanal().getUsuario().getNickname(), this.getNombre(), tipoElemento.LISTA);
	}
}