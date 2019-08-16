package logica;

import java.util.ArrayList;
import java.util.List;

public class Canal {

	private String nombre;
	private String descripcion;
	private boolean publico;
	private Usuario usuario;
	private List<Video> videos = new ArrayList<>();
	private List<ListaReproduccion> listaRep = new ArrayList<>();
	
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
	public void agregarCategoriaALista(nomL: String, cat:Categoria) {
		
	}
	
	public void agregarCategoriaVideo(nomV:String, cat:Categoria) {
		
	}
	
	public void agregarLista(lista: ListaReproduccion) {
		
	}
	
	public void agregarLista(nomL: String, public: bool) {
		
	}
	
	public void agregarVideo(nomV:String, desc:String, fPub:Date, dur:int, url:String) {
		
	}
	
	public void eliminarVideoDeLista(v:Video, nomList:String) {
		
	}
	
	public void existeListaDefecto( nomL: String):bool {
		
	}
	
	public boolean existeListaParticular( nomL: String) {
		
	}
	
	public void listarListasDeUsuario():Set(String) {
		
	}
	
	public void listarListasParticulares():Set(String) {
		
	}
	
	//public QUE TIPO DE RETORNO TIENE listarVideosdeLista(nomList:String):Set(String) {
		
	}
	
	public DtLista obtenerListaDeUsuario(nomList:String) {
		
	}
	
	public DtListaRep obtenerListaDeUsuario(nomList:String) {
		
	}
	
	public String obtenerUsuarioCanal():String {
		
	}
	
	public void valorarVideo(nomVid:String, uVal:Usuario, val:bool) {
		
	}
	
	public Video obtenerVideo(nomVid:String): {
		
	}
	
	public void agregarVideoLista(v:Video, nomList:String) {
		
	}
	
	
	
	
	
	
	
	
}
