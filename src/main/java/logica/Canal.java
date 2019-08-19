package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import datatypes.DtListaRep;

@Entity
public class Canal {
	@Id
	private String nombre;
	private String descripcion;
	private Boolean publico;
	@OneToOne
	private Usuario usuario;
	private Map <String ,Video> videos = new HashMap<String, Video>();
	private Map <String,ListaReproduccion> lista = new HashMap<String, ListaReproduccion>();
		
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
	
	//Operaciones
	/*public void agregarCategoriaALista(String nomL, Categoria cat) {}
	
	public void agregarCategoriaVideo(String nomV, Categoria cat) {}
	
	public void agregarLista(ListaReproduccion lista) {}
	
	public void agregarLista(String nomL, boolean publico) {}
	
	public void agregarVideo(String nomV, String desc, Date fPub, int dur, String url) {}
	
	public void eliminarVideoDeLista(Video v, String nomList) {}
	
	public boolean existeListaDefecto(String nomL) {}
	
	public boolean existeListaParticular(String nomL) {}
	
	public ArrayList<String> listarListasDeUsuario() {}
	
	public ArrayList<String> listarListasParticulares() {}
	
	public ArrayList<String> listarVideosdeLista(String nomList) {}
	
	public DtListaRep obtenerListaDeUsuario(String nomList) {}
	
	public String obtenerUsuarioCanal() {}
	
	public void valorarVideo(String nomVid, Usuario uVal, boolean val) {}
	
	public Video obtenerVideo(String nomVid) {}
	
	public void agregarVideoLista(Video v, String nomList) {}*/
}
