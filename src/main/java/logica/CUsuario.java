package logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import datatypes.DtCanal;
import datatypes.DtUsuario;
import interfaces.IUsuario;

public class CUsuario implements IUsuario {
	public Usuario usr;
	public Canal can;
	
	//Operaciones
	public void agregarCanal(String desc, boolean publico) {
		usr.agregarCanal(desc, publico);
		this.can = this.usr.obtenerCanalU();
	}
	
	public void agregarNombreCanal(String nomC) {
		this.agregarNombreCanal(nomC);
	}
	
	public void agregarUsuario(String nick, String nom, String ape, Date fechaN, String email) {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Usuario usuario = new Usuario(nick, nom, ape, fechaN, email);
		this.usr = usuario;
		mu.agregarUsuario(usuario);
	}
	
	public void dejarDeSeguirUsuario(String seguidor, String seguido) {}
	
	public boolean existeEmail(String email) {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		return false;
	}
	
	public boolean existeNickname(String nick) {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		return mu.existeUsuario(nick);
	}
	
	public ArrayList<String> listarSeguidores() {
		ArrayList<String> dtSeguidores = new ArrayList<String>();
		Collection<Usuario> seguidores = usr.getSeguidores();
		
		for(Usuario u:seguidores) {
			dtSeguidores.add(u.getNickname());
		}
		
		return dtSeguidores;
	}
	
	public ArrayList<String> listarSeguidos() {
		ArrayList<String> dtSeguidos = new ArrayList<String>();
		Collection<Usuario> seguidos = usr.getSeguidos();
		
		for(Usuario u:seguidos) {
			dtSeguidos.add(u.getNickname());
		}
		
		return dtSeguidos;
	}
	
	public ArrayList<String> listarUsuarios() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query consulta = em.createQuery("SELECT * FROM Usuarios u", Usuario.class);
	    List<Usuario> usuarios = consulta.getResultList();
	    ArrayList<String> nickUsers = new ArrayList<String>();
	    String nick;
	    for(Usuario u : usuarios) {
			nick = u.getNickname();
			nickUsers.add(nick);
		}
	    return nickUsers;
	}
	
	public void modificarImagen(String img) {
		this.usr.setImagen(img);
	}
	
	public void modificarInfoCanal(String nomC, String descC, boolean publico) {
		this.usr.modificarInfoCanal(nomC, descC, publico);
	}
	
	public void modificarInfoUsuario(String nick, String nomU, String apeU, Date fNacU, String imagen) {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		this.usr = mu.obtenerUsuario(nick);
		this.usr.setNombre(nomU);
		this.usr.setApellido(apeU);
		this.usr.setfNac(fNacU);
		this.usr.setImagen(imagen);
	}
	
	public DtCanal obtenerInfoCanal() {
		DtCanal dtCan = usr.obtenerInfoCanal();
		return dtCan;
	}
	
	public DtUsuario obtenerInfoUsuario(String nick) {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Usuario usr = mu.obtenerUsuario(nick);
		DtUsuario dtUsr = new DtUsuario(usr.getNickname(), usr.getNombre(), usr.getApellido(), usr.getfNac(), usr.getImagen(), usr.getCorreoE());
		
		this.usr = usr;
		return dtUsr;
	}
	
	public void seguirUsuario(String seguidor, String seguido) {}
}
