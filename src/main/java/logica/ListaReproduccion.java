package logica;

import java.util.ArrayList;
import java.util.Map;

import datatypes.DtComentario;
import datatypes.DtVideo;
import datatypes.DtValoracion;

public abstract class ListaReproduccion extends Elemento {
	
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
	
	//Operaciones
	/*public void agregarVideo(Video v) {}
	
	public void eliminarVideo(String nomVid) {}
	
	public boolean esParticular() {}
	
	public boolean esPublico() {}
	
	public ArrayList<String> listarVideos() {}
	
	public Map<Integer, DtComentario> obtenerComentariosVideo(String nomVid) {}
	
	public DtVideo obtenerInfoVideo1(String nomVid) {}
	
	public Map<String, DtValoracion> obtenerValoracionVideo(String nomVid) {}*/
	
}