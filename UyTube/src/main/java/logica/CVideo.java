package logica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

import Manejadores.ManejadorCategoria;
import Manejadores.ManejadorComentario;
import Manejadores.ManejadorUsuario;
//import Manejadores.ManejadorVideo;
import datatypes.*;
import interfaces.IVideo;

public class CVideo implements IVideo {
	public Usuario usr;
	public Video vid;
	
	//Operaciones
	@Override 
	public void agregarCategoria(String nomC) {
		ManejadorCategoria mC = ManejadorCategoria.getInstancia();
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		if(mC.existeCategoria(nomC)) {
			Categoria cat = mC.obtenerCategoria(nomC);
			cat.agregarElemento(this.vid);
			mC.modificarCategoria(cat);
			//mU.modificaDatosUsuario(this.vid.getCanal().getUsuario());
		}
	}
	
	@Override 
	public void agregarVideo(String nick, String nomV, String desc, Calendar fPub, int dur, String url){
		//ManejadorVideo mV = ManejadorVideo.getInstancia();
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		this.usr = mU.obtenerUsuario(nick);
		this.vid = this.usr.getCanal().agregarVideo(nomV, desc, fPub, dur, url);
		mU.modificaDatosUsuario(this.usr);
		/*if(!existeVideo(usr.getNickname(), nomV)) {
			mV.agregarVideo(this.vid);
		} else {
			throw new java.lang.RuntimeException("Ya existe un video con ese nombre");
		}*/
	}
	
	@Override
	public void limpiarControlador() { //Operacion para utilizar al final de cada caso de uso
		this.vid = null;
		this.usr = null;
	}
	
	@Override
	public List<String> listarVideosDeUsuario(String nick){
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		this.usr = mU.obtenerUsuario(nick);
		return this.usr.getCanal().obtenerNombreVideos();
	}
	
	
	@Override
	public List<String> listarVideosPublicosDeUsuario(String nick) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		this.usr = mU.obtenerUsuario(nick);
		return this.usr.getCanal().obtenerNombreVideosPublicos();
	}

	@Override
	public List<DtElementoUsuario> listarVideosPublicos() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		List<String> usuarios = mU.listarUsuarios();
		List<DtElementoUsuario> res  = new ArrayList<DtElementoUsuario>();
		for(String nick: usuarios){
			List<String> videos = listarVideosPublicosDeUsuario(nick);
			for (String vid : videos){
				DtElementoUsuario v = new DtElementoUsuario(nick, vid, tipoElemento.VIDEO);
				res.add(v);
			}
		}
		return res;
	}

	@Override 
	public void modificarInfoVideo(String nomV, String desc, Calendar fecha, int dur, String url, boolean publico) {
		//ManejadorVideo mV = ManejadorVideo.getInstancia();
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		this.vid.setNombre(nomV);
		this.vid.setDescripcion(desc);
		this.vid.setfPublicacion(fecha);
		this.vid.setDuracion(dur);
		this.vid.setUrl(url);
		this.vid.setPublico(publico);
		mU.modificaDatosUsuario(this.usr);
		//mV.modificarVideo(this.vid);
	}
	
	@Override 
	public List<DtComentario> obtenerComentariosVideo(String nomVid) {
		this.vid = this.usr.getCanal().obtenerVideo(nomVid);
		return this.vid.obtenerComentariosVideo();
	}
	
	@Override 
	public DtVideo obtenerInfoVideo(String nomVid) {
		this.vid = this.usr.getCanal().obtenerVideo(nomVid);
		return this.usr.getCanal().obtenerInfoVideo(nomVid);
	}
	
	@Override 
	public List<DtValoracion> obtenerValoracionVideo() {
		return this.vid.listarValoraciones();
	}
	
	@Override 
	public void responderComentario(int idCom, String nick, Calendar fcom, String texto) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ManejadorComentario mC = ManejadorComentario.getInstancia();
		if(mU.existeUsuario(nick)) {
			Usuario usrRes = mU.obtenerUsuario(nick);
			if(mC.existeComentario(idCom)) {
				Comentario c = mC.obtenerComentario(idCom);
				c.crearRespuesta(usrRes, fcom, texto);
			} else {
				throw new java.lang.RuntimeException("No existe el comentario ingresado");
			}
		} else {
			throw new java.lang.RuntimeException("No existe un usuario con ese nick");
		}
	}
	
	@Override 
	public void realizarComentario(String nick, Calendar fCom, String texto) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		if(mU.existeUsuario(nick)) {
			Usuario usrCom = mU.obtenerUsuario(nick);
			this.vid.crearComentario(usrCom, fCom, texto);
			mU.modificaDatosUsuario(this.usr);
			mU.modificaDatosUsuario(usrCom);
		}
	}
	
	@Override 
	public void valorarVideo(String nickVal, boolean val) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		//ManejadorVideo mV = ManejadorVideo.getInstancia();
		
		if(mU.existeUsuario(nickVal)) {
			Usuario usrVal = mU.obtenerUsuario(nickVal);
			this.vid.valorarVideo(val, usrVal);
			
			mU.modificaDatosUsuario(this.usr);
			//mU.modificaDatosUsuario(usrVal);
			//mV.agregarVideo(this.vid);
		}else {
			throw new java.lang.RuntimeException("No existe un usuario con ese nick");
		}
	}

	
	@Override
	public Boolean existeVideo(String nick, String nomV) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario u = mU.obtenerUsuario(nick);
		return u.getCanal().existeVideo(nomV);
	}

	@Override
	public void setUsr(String usr) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		this.usr = mU.obtenerUsuario(usr);
	}

	@Override
	public void setVid(String vid) {
		this.vid = usr.getCanal().obtenerVideo(vid);
	}

	
	
}