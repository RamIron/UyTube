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
	@Override 
	public void agregarCanal(String desc, boolean publico) {
		usr.agregarCanal(desc, publico);
		this.can = this.usr.obtenerCanalU();
	}
	
	@Override 
	public void agregarNombreCanal(String nomC) {
		this.agregarNombreCanal(nomC);
	}
	
	@Override 
	public void agregarUsuario(String nick, String nom, String ape, Date fechaN, String email) {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Usuario usuario = new Usuario(nick, nom, ape, fechaN, email);
		this.usr = usuario;
		mu.agregarUsuario(usuario);
	}
	
	@Override 
	public void dejarDeSeguirUsuario(String seguidor, String seguido) {}
	
	@Override 
	public boolean existeEmail(String email) {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		return false;
	}
	
	@Override 
	public boolean existeNickname(String nick) {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		return mu.existeUsuario(nick);
	}
	
	@Override 
	public ArrayList<String> listarSeguidores() {
		ArrayList<String> dtSeguidores = new ArrayList<String>();
		Collection<Usuario> seguidores = usr.getSeguidores();
		
		for(Usuario u:seguidores) {
			dtSeguidores.add(u.getNickname());
		}
		
		return dtSeguidores;
	}
	
	@Override 
	public ArrayList<String> listarSeguidos() {
		ArrayList<String> dtSeguidos = new ArrayList<String>();
		Collection<Usuario> seguidos = usr.getSeguidos();
		
		for(Usuario u:seguidos) {
			dtSeguidos.add(u.getNickname());
		}
		
		return dtSeguidos;
	}
	
	@Override 
	public List<String> listarUsuarios() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query consulta = em.createQuery("SELECT u.nombre FROM Usuarios u", String.class);
	    List<String> usuarios = consulta.getResultList();
	    em.close();
	    return usuarios;
	}
	
	@Override 
	public void modificarImagen(String img) {
		this.usr.setImagen(img);
	}
	
	@Override 
	public void modificarInfoCanal(String nomC, String descC, boolean publico) {
		this.usr.modificarInfoCanal(nomC, descC, publico);
	}
	
	@Override 
	public void modificarInfoUsuario(String nick, String nomU, String apeU, Date fNacU, String imagen) {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		this.usr = mu.obtenerUsuario(nick);
		this.usr.setNombre(nomU);
		this.usr.setApellido(apeU);
		this.usr.setfNac(fNacU);
		this.usr.setImagen(imagen);
	}
	
	@Override 
	public DtCanal obtenerInfoCanal() {
		DtCanal dtCan = usr.obtenerInfoCanal();
		return dtCan;
	}
	
	@Override 
	public DtUsuario obtenerInfoUsuario(String nick) {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Usuario usr = mu.obtenerUsuario(nick);
		DtUsuario dtUsr = new DtUsuario(usr.getNickname(), usr.getNombre(), usr.getApellido(), usr.getfNac(), usr.getImagen(), usr.getCorreoE());
		
		this.usr = usr;
		return dtUsr;
	}
	
	@Override 
	public void seguirUsuario(String seguidor, String seguido) {}

}
