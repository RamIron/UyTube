package logica;

import java.util.*;
//import datatypes.DtVideo;

import javax.persistence.*;

import datatypes.DtCanal;
import datatypes.DtComentario;
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
	
//	@OneToMany(mappedBy="usuario",cascade=CascadeType.ALL,orphanRemoval=true)
	private ArrayList<Valoracion> valoraciones;
	
	@ManyToMany(mappedBy="seguidos")
	private List<Usuario> seguidores;
	
	@ManyToMany
	private List<Usuario> seguidos;

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
	
	public List<Usuario> getSeguidos() {
		return seguidos;
	}

	public void setSeguidos(ArrayList<Usuario> seguidos) {
		this.seguidos = seguidos;
	}

	public List<Usuario> getSeguidores() {
		return seguidores;
	}

	public void setSeguidores(ArrayList<Usuario> seguidores) {
		this.seguidores = seguidores;
	}
	
	public Canal getCanal() {
		return this.canal;
	}
	
	public void setCanal(Canal c) {
		this.canal = c;
	}

	
	//Operaciones
	public void agregarCanal(String desc, Boolean publico) {
		Canal can = new Canal(this.getNickname(), desc, publico);
		this.canal = can;
	}
	
	public void agregarCategoriaALista(String nomL, Categoria cat) {
		this.canal.agregarCategoriaALista(nomL, cat);
	}
	
	public void agregarCategoriaVideo(String nomV, Categoria cat) {
		this.canal.agregarCategoriaVideo(nomV, cat);
	}
	
	public void agregarLista(ListaReproduccion lista) {
		this.canal.agregarLista(lista);
	}
	
	public void agregarLista(String nomL, Boolean publico) {}
	
	public void agregarNombreCanal(String nomC) {
		this.canal.setNombre(nomC);
	}
	
	public void agregarSeguidor(Usuario u) {
		this.seguidores.add(u);
	}
	
	public void agregarValoracion(Valoracion val) {
		this.valoraciones.add(val);
	}
	
	public void agregarVideo(String nomV, Boolean publico, String desc, Date fPub, int dur, String url) {
		this.canal.agregarVideo(nomV, desc, publico, fPub, dur, url);
	}
	
	public void agregarVideoPrivado(String nomV, String desc, Date fPub, int dur, String url) {
		Boolean publico = false;
		this.canal.agregarVideo(nomV, desc, publico, fPub, dur, url);
	}
	
	public void agregarVideoLista(Video v, String nomList) {
		this.canal.agregarVideoLista(v, nomList);
	}
	
	public void dejarSeguirUsuario(Usuario u2) {
		this.seguidos.remove(u2);
	}
	
//	public void eliminarVideoDeLista(String nomVid, String nomList) {
//		this.canal.eliminarVideoDeLista(nomVid, nomList);
//	}
	
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
	
	public ArrayList<String> listarVideosDeUsuario (){
		Map<String, Video> videosUsr = this.canal.getVideos();
		ArrayList<String> videos = new ArrayList<String>();
		
		for (Map.Entry<String, Video> vs: videosUsr.entrySet()) {
			String nomVideo = vs.getKey();
			videos.add(nomVideo);
		}
		return videos;
	}
	
	public void modificarInfoCanal(String nomC, String descC, Boolean publico) {
		this.canal.setNombre(nomC);
		this.canal.setDescripcion(descC);
		this.canal.setPublico(publico);
	}
	
	public DtCanal obtenerInfoCanal() {
		DtCanal dtCan = new DtCanal(canal.getNombre(), canal.getDescripcion(), canal.isPublico());
		
		return dtCan;
	}
	
	public DtVideo obtenerInfoVideo(String nomVid) {
		DtVideo dtVid = this.canal.obtenerInfoVideo(nomVid);
		return dtVid;
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
	
	public ArrayList<DtComentario> obtenerComentariosVideo(String nomVid) {
		ArrayList<DtComentario> dtComentarios = this.canal.obtenerComentariosVideo(nomVid);
		return dtComentarios;
	}
	
	public Video obtenerVideo(String nomVid) {
		Video v= this.canal.obtenerVideo(nomVid);
		return v;
	}
	
	public void quitarSeguidor(Usuario u1) {
		this.seguidores.remove(u1);
	}
	
	public void seguirUsuario(Usuario u2) {
		this.seguidos.add(u2);
	}
	
	public void valorarVideo(String nomVid, Usuario uVal, Boolean val) {
		this.canal.valorarVideo(nomVid, uVal, val);
	}
	
}