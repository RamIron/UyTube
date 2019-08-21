package logica;

import java.util.*;
//import datatypes.DtVideo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import datatypes.DtCanal;
import datatypes.DtListaRep;
import datatypes.DtVideo;

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
	
	@Column(name="FECHA_DE_NACIMIENTO")
	private Date fNac;
	
	@Column(name="IMAGEN")
	private String imagen;
	
	@Column(name="CORREO_ELECTRONICO")
	private String correoE;
	
	@OneToOne(mappedBy="usuario", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private Canal canal;
	
	@OneToMany(mappedBy="usuario",cascade=CascadeType.ALL,orphanRemoval=true)
	private ArrayList<Valoracion> valoraciones;
	
	@OneToMany(mappedBy="usuario",cascade=CascadeType.ALL,orphanRemoval=true)
	private ArrayList<Usuario> seguidores;
	
	@OneToMany(mappedBy="usuario",cascade=CascadeType.ALL,orphanRemoval=true)
	private ArrayList<Usuario> seguidos;

	//Constructores
	public Usuario() {
		super();
	}
	
	public Usuario(String nickname, String nombre, String apellido, Date fNac, String correoE) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fNac = fNac;
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
	
	public ArrayList<Usuario> getSeguidos() {
		return seguidos;
	}

	public void setSeguidos(ArrayList<Usuario> seguidos) {
		this.seguidos = seguidos;
	}

	public ArrayList<Usuario> getSeguidores() {
		return seguidores;
	}

	public void setSeguidores(ArrayList<Usuario> seguidores) {
		this.seguidores = seguidores;
	}
	

	
	//Operaciones
	public void agregarCanal(String desc, Boolean publico) {
		Canal can = new Canal(this.getNickname(), desc, publico);
		this.canal = can;
	}
	
	public void agregarCategoriaALista(String nomL, Categoria cat) {}
	
	public void agregarCategoriaVideo(String nomV, Categoria cat) {}
	
	public void agregarLista(ListaReproduccion lista) {}
	
	public void agregarLista(String nomL, Boolean publico) {}
	
	public void agregarNombreCanal(String nomC) {
		this.canal.setNombre(nomC);
	}
	
	public void agregarSeguidor(Usuario u) {
		this.seguidores.add(u);
	}
	
	public void agregarValoracion(Valoracion val) {}
	
	public void agregarVideo(String nomV, String desc, Date fPub, int dur, String url) {}
	
	public void agregarVideo(String nomV, Boolean publico, String desc, Date fPub, int dur, String url) {}
	
	public void agregarVideoLista(Video v, String nomList) {}
	
	public void dejarSeguirUsuario(Usuario u2) {
		this.seguidos.remove(u2);
	}
	
	public void eliminarVideoDeLista(String nomVid, String nomList) {}
	
	public Boolean existeListaDefecto(String nomL) {
		return null;
	}
	
	public Boolean existeListaParticular(String nomL) {
		return null;
	}
	
	public ArrayList<String> listarListasDeUsuario() {
		return null;
	}         
	
	public ArrayList<String> listarListasParticulares() {
		return null;
	}
	
	public ArrayList<String> listarVideosdeLista(String nomList) {
		return null;
	}
	
	public void modificarInfoCanal(String nomC, String descC, Boolean publico) {
		this.canal.setNombre(nomC);
		this.canal.setDescripcion(descC);
		this.canal.setPublico(publico);
	}
	
	public Canal obtenerCanalU() {
		return this.canal;
	}
	
	public DtCanal obtenerInfoCanal() {
		DtCanal dtCan = new DtCanal(canal.getNombre(), canal.getDescripcion(), canal.isPublico());
		
		return dtCan;
	}
	
	public DtVideo obtenerInfoVideo(String nomVid) {
		return null;
	}
	
	public DtListaRep obtenerListaDeUsuario(String nomList) {
		return null;
	}
	
	public ArrayList<String> listarSeguidores() {
		ArrayList<String> dtSeguidores = new ArrayList<String>();
		Collection<Usuario> seguidores = this.getSeguidores();
		
		for(Usuario u:seguidores) {
			dtSeguidores.add(u.getNickname());
		}
		
		return dtSeguidores;
	}
	
	public ArrayList<String> listarSeguidos() {
		ArrayList<String> dtSeguidos = new ArrayList<String>();
		Collection<Usuario> seguidos = this.getSeguidos();
		
		for(Usuario u:seguidos) {
			dtSeguidos.add(u.getNickname());
		}
		
		return dtSeguidos;
	}
	
	public Video obtenerVideo(String nomVid) {
		return null;
	}
	
	public void quitarSeguidor(Usuario u1) {
		this.seguidores.remove(u1);
	}
	
	public void seguirUsuario(Usuario u2) {
		this.seguidos.add(u2);
	}
	
	public void valorarVideo(String nomVid, Usuario uVal, Boolean val) {}
}

