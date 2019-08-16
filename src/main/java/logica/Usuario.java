package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario {
	
	private String nickname;
	private String nombre;
	private String apellido;
	private Date fNac;
	private String imagen;
	private String correoE;
	private Canal canal;
	private List<Valoracion> valoracion = new ArrayList<>();

	//Constructores
	public Usuario() {
		super();
	}
	
	public Usuario(String nickname, String nombre, String apellido, Date fNac, String imagen, String correoE) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fNac = fNac;
		this.imagen = imagen;
		this.correoE = correoE;
	}

	//Getters y Setters
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getfNac() {
		return fNac;
	}

	public void setfNac(Date fNac) {
		this.fNac = fNac;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getCorreoE() {
		return correoE;
	}

	public void setCorreoE(String correoE) {
		this.correoE = correoE;
	}

	
	//Operaciones
	public void agregarCanal(nick:String, desc:String, public:bool) {
		
	}
	
	public void agregarCategoriaALista(nomL: String, cat:Categoria) {
		
	}
	
	public void agregarCategoriaVideo(nomV:String, cat:Categoria) {
		
	}
	
	public void agregarLista(lista: ListaReproduccion) {
		
	}
	
	public void agregarLista(nomL: String, public: bool) {
		
	}
	
	public void agregarNombreCanal(nomC:String) {
		
	}
	
	public void agregarSeguidor(u:usuario) {
		
	}
	
	public void agregarSeguidor(u1:Usuario) {
		
	}
	public void agregarValoracion(val:Valoracion) {
		
	}
	
	public void agregarVideo(nomV:String, desc:String, fPub:Date, dur:int, url:String) {
		
	}
	
	public void agregarVideo(nomV:String, public:bool, desc:String, fPub:Date, dur:int, url:String) {
		
	}
	
	public void dejarSeguirUsuario(u2:Usuario) {
		
	}
	
	public void eliminarVideoDeLista(nomVid:String, nomList:String) {
		
	}
	
	public boolean existeListaDefecto(nomL: String) {
		
	}
	
	public boolean existeListaParticular(nomL: String) {
		
	}
	
	//public QUE TIPO DE RETORNO TIENE listarListasDeUsuario():Set(String) {}         
	
	//public QUE TIPO DE RETORNO TIENE listarListasParticulares():Set(String) {}
	
	//public QUE TIPO DE RETORNO TIENE listarVideosdeLista(nomList:String):Set(String) {}
	
	public void modificarInfoCanal(nomC:String, descC:String, public:bool) {
		
	}
	
	public void obtenerCanalU(u:Usuario) {
		
	}
	
	public DtVideo obtenerInfoVideo(nomVid:String) {}
	
	public DtLista obtenerListaDeUsuario(nomList:String) {}
	
	public DtListaRep obtenerListaDeUsuario(nomList:String) {}
	
	public void quitarSeguidor(u1:Usuario) {
		
	}
	
	public void seguirUsuario(u2:Usuario) {
		
	}
	
	public void valorarVideo(nomVid:String, uVal:Usuario, val:bool) {
		
	}
	
	//public QUE TIPO DE RETORNO TIENE listarSeguidores(nick:String):Set(String) {}
	
	//public QUE TIPO DE RETORNO TIENE listarSeguidos(nick:String):Set(String) {}
	
	public void agregarVideoLista(v:Video, nomList:String) {
		
	}
	
	public void obtenerVideo(nomVid:String):Video {
		
	}
	
	public void agregarVideoLista(v:Video, nomList:String) {
		
	}
	
	public Video obtenerVideo(nomVid:String) {
		
	}
	
}

