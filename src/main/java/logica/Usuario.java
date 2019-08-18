package logica;

import java.util.*;
//import datatypes.DtVideo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="USUARIOS")
public class Usuario {
	
	@Id //Siempre tenenos que tener un atributo Id
	@Column(name="NICKNAME") 
	private String nickname;
	@Column(name="NOMBRE")
	private String nombre;
	@Column(name="APELLIDO")
	private String apellido;
	@Column(name="FECHA DE NACIMIENTO")
	private Date fNac;
	@Column(name="IMAGEN")
	private String imagen;
	@Column(name="CORREO ELECTRONICO")
	private String correoE;
	@OneToOne(mappedBy="canal", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY) /* no se si 
	es mapedBy="canal" o mappedBy="usuario"*/
	private Canal canal;
	//falta @OneToMany
	private ArrayList<Valoracion> valoraciones;

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
	/*public void agregarCanal(String nick, String desc, Boolean publico) {}
	
	public void agregarCategoriaALista(String nomL, Categoria cat) {}
	
	public void agregarCategoriaVideo(String nomV, Categoria cat) {}
	
	public void agregarLista(ListaReproduccion lista) {}
	
	public void agregarLista(String nomL, Boolean publico) {}
	
	public void agregarNombreCanal(String nomC) {}
	
	public void agregarSeguidor(Usuario u) {}
	
	public void agregarSeguidor(Usuario u1) {}
	
	public void agregarValoracion(Valoracion val) {}
	
	public void agregarVideo(String nomV, String desc, Date fPub, int dur, String url) {}
	
	public void agregarVideo(String nomV, Boolean publico, String desc, Date fPub, int dur, String url) {}
	
	public void dejarSeguirUsuario(Usuario u2) {}
	
	public void eliminarVideoDeLista(String nomVid, String nomList) {}
	
	public Boolean existeListaDefecto(String nomL) {}
	
	public Boolean existeListaParticular(String nomL) {}
	
	public ArrayList<String> listarListasDeUsuario() {}         
	
	public ArrayList<String> listarListasParticulares() {}
	
	public ArrayList<String> listarVideosdeLista(String nomList) {}
	
	public void modificarInfoCanal(String nomC, String descC, Boolean publico) {}
	
	public void obtenerCanalU(Usuario u) {}
	
	public DtVideo obtenerInfoVideo(String nomVid) {}
	
	public DtLista obtenerListaDeUsuario(String nomList) {}
	
	public DtListaRep obtenerListaDeUsuario(String nomList) {}
	
	public void quitarSeguidor(Usuario u1) {}
	
	public void seguirUsuario(Usuario u2) {}
	
	public void valorarVideo(String nomVid, Usuario uVal, Boolean val) {}
	
	public ArrayList<String> listarSeguidores(String nick) {}
	
	public ArrayList<String> listarSeguidos(String nick) {}
	
	public void agregarVideoLista(Video v, String nomList) {}
	
	public Video obtenerVideo(String nomVid) {}*/
	
}

