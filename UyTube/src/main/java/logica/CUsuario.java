package logica;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import Manejadores.ManejadorCategoria;
import Manejadores.ManejadorPorDefecto;
import Manejadores.ManejadorUsuario;
import datatypes.*;
import interfaces.IUsuario;

public class CUsuario implements IUsuario {
	public Usuario usr;
	public Canal can;
	
	//Operaciones
	@Override 
	public void agregarCanal() {
		try {
			ManejadorUsuario mU = ManejadorUsuario.getInstancia();
			ManejadorPorDefecto mPD = ManejadorPorDefecto.getInstancia();
			usr.agregarCanal();
			this.can = this.usr.getCanal();
			List<String> listasPorDefecto = mPD.getNombresPorDefecto();
			for(String nomPD:listasPorDefecto) {
				this.can.agregarListaDefecto(nomPD);
			}
			mU.modificaDatosUsuario(this.usr);
		} catch (Exception e){
			throw e;
		}	
	}

	//si la categoria esta vacia en canal se le agrega, si ya tiene una categoria se pisa.
	//si recibe null en nomCat deja al canal sin categoria
	@Override
	public void modificarCatCanal(String nick, String nomCat) {
		try{
			ManejadorUsuario mU = ManejadorUsuario.getInstancia();
			ManejadorCategoria mC = ManejadorCategoria.getInstancia();
			Usuario user = mU.obtenerUsuario(nick);
			Categoria cat = null;
			if(nomCat != null){
				cat = mC.obtenerCategoria(nomCat);
			}
			user.getCanal().setCategoria(cat);
			mU.modificaDatosUsuario(user);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override 
	public void agregarUsuario(String nick, String nom, String ape, Calendar fechaN, String email) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		try {
			Usuario usuario = new Usuario(nick, nom, ape, fechaN, email);
			mU.agregarUsuario(usuario);
			this.usr = usuario;
		} catch (Exception e){
			throw e;
		}	
	}
	
	
	@Override
	public void dejarDeSeguirUsuario(String seguidor, String seguido) {		
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		
		if(mU.existeUsuario(seguidor)) { //Si el usuario existe
			if(mU.existeUsuario(seguido)) { //Si el segundo usuario existe
				try {
					Usuario USeguidor = mU.obtenerUsuario(seguidor);
					Usuario USeguido = mU.obtenerUsuario(seguido);
					USeguidor.dejarSeguirUsuario(USeguido);
					USeguido.quitarSeguidor(USeguidor);
					mU.modificaDatosUsuario(USeguidor);
					mU.modificaDatosUsuario(USeguido);
				} catch (Exception e){
					throw e;
				}
			}else {
				throw new java.lang.RuntimeException("No existe un usuario con nick: " + seguido);
			}
		}else {
			throw new java.lang.RuntimeException("No existe un usuario con nick: " + seguidor);
		}
	}
	
	@Override 
	public boolean existeEmail(String email) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		TypedQuery<String> consulta = em.createNamedQuery("existeMail", String.class);
		consulta.setParameter("correoE", email);
		List<String> mails = consulta.getResultList();	
		if(mails.contains(email))
			return true;
		else
			return false;
	}
	
	@Override 
	public boolean existeNickname(String nick) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		if(mU.existeUsuario(nick)) {
			this.usr = mU.obtenerUsuario(nick);
			return true;
		}else
			return false;
	}
	
	@Override
	public void limpiarControlador() { //Operacion para utilizar al final de cada caso de uso
		this.can = null;
		this.usr = null;
	}
	
	@Override 
	public List<String> listarSeguidores() {
		List<String> dtSeguidores = this.usr.listarSeguidores();
		return dtSeguidores;
	}
	
	@Override 
	public List<String> listarSeguidos() {
		List<String> dtSeguidos = this.usr.listarSeguidos();
		return dtSeguidos;
	}
	
	@Override 
	public List<String> listarUsuarios() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
	    return mU.listarUsuarios();
	}
	
	@Override 
	public void modificarImagen(String img) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		this.usr.setImagen(img);
		mU.modificaDatosUsuario(this.usr);
	}

	@Override
	public void modificarContrasena(String pass) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		this.usr.setContrasena(pass);
		mU.modificaDatosUsuario(this.usr);
	}

	
	@Override 
	public void modificarInfoCanal(String nomC, String descC, boolean publico) {
		try {
			ManejadorUsuario mU = ManejadorUsuario.getInstancia();
			this.can.setNombre(nomC);
			this.can.setDescripcion(descC);
			this.can.setPublico(publico);
			mU.modificaDatosUsuario(this.usr);
		} catch (Exception e){
			throw e;
		}	
	}
	
	@Override 
	public void modificarInfoUsuario(String nomU, String apeU, Calendar fNacU, String imagen) {
		try {
			ManejadorUsuario mU = ManejadorUsuario.getInstancia();
			this.usr.setNombre(nomU);
			this.usr.setApellido(apeU);
			this.usr.setfNac(fNacU);
			this.usr.setImagen(imagen);
			mU.modificaDatosUsuario(this.usr);
			this.can = usr.getCanal();
		} catch (Exception e){
			throw e;
		}
	}
	
	@Override 
	public DtCanal obtenerInfoCanal() {
		DtCanal dtCan = usr.obtenerInfoCanal();
		return dtCan;
	}
	
	@Override 
	public DtUsuario obtenerInfoUsuario(String nick) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		usr = mU.obtenerUsuario(nick);
		DtUsuario res = new DtUsuario(nick, usr.getNombre(), usr.getApellido(), usr.getfNac(), usr.getImagen(), usr.getCorreoE());
		return res;
	}
	
	public Boolean esCanalPublico(String nick) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		this.usr = mU.obtenerUsuario(nick);
		return this.usr.getCanal().getPublico();
	}
	
	@Override 
	public void seguirUsuario(String seguidor, String seguido) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		if(mU.existeUsuario(seguidor)) { //Si el usuario existe
			if(mU.existeUsuario(seguido)) { //Si el segundo usuario existe
				try {
					Usuario USeguidor = mU.obtenerUsuario(seguidor);
					Usuario USeguido = mU.obtenerUsuario(seguido);
					USeguidor.seguirUsuario(USeguido);
					USeguido.agregarSeguidor(USeguidor);
					mU.modificaDatosUsuario(USeguidor);
					mU.modificaDatosUsuario(USeguido);
				} catch (Exception e){
					throw e;
				}
			}else {
				throw new java.lang.RuntimeException("No existe un usuario con nick: " + seguido);
			}
		}else {
			throw new java.lang.RuntimeException("No existe un usuario con nick: " + seguidor);
		}
	}

	@Override

	//Retorna: 0-> si no coincide los datos
	//		   1-> si coincide con nickname
	//		   2-> si coincide con email
	public Integer iniciarSesion(String nick, String pass){
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		if(existeNickname(nick) && mU.obtenerUsuario(nick).getContrasena().equals(pass)) {
			return 1;
		}else if(existeEmail(nick) && mU.obtenerUsuarioMail(nick).getContrasena().equals(pass)){
			return 2;
		}else{
			return 0;
		}
	}

	@Override
	public DtUsuarioWeb obtenerUsuarioWebNick(String nickname){
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u = mU.obtenerUsuario(nickname);
		List<String> lis = u.getCanal().listarListasDeUsuario();
		DtUsuarioWeb res = new DtUsuarioWeb(u.getNickname(), u.getImagen(),lis);
		return res;
	}

	@Override
	public DtUsuarioWeb obtenerUsuarioWebEmail(String email){
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u = mU.obtenerUsuarioMail(email);
		List<String> lis = u.getCanal().listarListasDeUsuario();
		DtUsuarioWeb res = new DtUsuarioWeb(u.getNickname(), u.getImagen(),lis);
		return res;
	}

	@Override
	public List<DtUsuarioWeb> listarUsuariosWeb() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		List<String> usuarios = mU.listarUsuarios();
		List<DtUsuarioWeb> res = new ArrayList<DtUsuarioWeb>();
		for (String nick: usuarios){
			DtUsuarioWeb usr = obtenerUsuarioWebNick(nick);
			res.add(usr);
		}
		return res;
	}

	public List<DtUsuarioWeb> listarNickFotoWeb(List <String> seguidores){
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		List<Usuario> usrs = new LinkedList<Usuario>();
		List<DtUsuarioWeb> dtUsrs = new ArrayList<DtUsuarioWeb>();
		for(String s: seguidores) {
			usrs.add(mU.obtenerUsuario(s));
		}

		for(Usuario u:usrs){
			dtUsrs.add(new DtUsuarioWeb(u.getNickname(), u.getImagen()));
		}
		return dtUsrs;
	}

	@Override
	public List<DtCanalWeb> busqueda(String query, Boolean ordFecha){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		List<DtCanalWeb> res = new ArrayList<DtCanalWeb>();
		List<Object[]> resQuery;
		if(ordFecha){
			Query consulta = em.createNamedQuery("buscarCanalFecha");
			consulta.setParameter(1, "%" + query + "%");
			resQuery = consulta.getResultList();
		} else {
			Query consulta = em.createNamedQuery("buscarCanalNombre");
			consulta.setParameter(1, "%" + query + "%");
			resQuery = consulta.getResultList();
		}
		for(Object[] o : resQuery){
			DtCanalWeb canal = new DtCanalWeb(o[0].toString(), o[1].toString(), o[2].toString());
			res.add(canal);
		}
		return res;
	}

	@Override
	public void eliminarUsuario(String nick){
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		this.usr = mU.obtenerUsuario(nick);
		//TODO Respaldar el usuario
		borrarTodosSeguidores();
		borrarTodosSeguidos();
		this.usr.getCanal().borrarContenidoCanal();
		//TODO borrar tus videos de las listas de otros
		//hecho: borrar valoraciones y comentarios de tus videos
		//hecho: borrar tus listas y videos
		//TODO borrar todos tus comentarios y valoraciones en videos de otros
		//hecho: borrar el usuario
		this.usr.setNickname(null);
		this.usr.setNombre(null);
		this.usr.setApellido(null);
		this.usr.setfNac(null);
		this.usr.setCorreoE(null);
		this.usr.setContrasena(null);
		this.usr.setImagen(null);
		//hecho: PERSISTIR LOS CAMBIOS
		mU.eliminarUsuario(this.usr);
		this.usr = null;
	}

	private void borrarTodosSeguidores(){
		List<String> seguidores = listarSeguidores();
		for (String u: seguidores){
			dejarDeSeguirUsuario(u, usr.getNickname());
		}
	}

	private void borrarTodosSeguidos(){
		List<String> seguidos = listarSeguidos();
		for (String u: seguidos){
			dejarDeSeguirUsuario(usr.getNickname(), u);
		}
	}

}
