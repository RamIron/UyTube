package logica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

import Manejadores.ManejadorCategoria;
import Manejadores.ManejadorUsuario;
import Manejadores.ManejadorVideo;
import datatypes.DtComentario;
import datatypes.DtValoracion;
import datatypes.DtVideo;
import interfaces.IVideo;

public class CVideo implements IVideo {
	public Usuario usr;
	public Video vid;
	
	//Operaciones
	@Override 
	public void agregarCategoria(String nomC) {
		ManejadorCategoria mC = ManejadorCategoria.getInstancia();
		if(mC.existeCategoria(nomC)) {
			Categoria cat = mC.obtenerCategoria(nomC);
			cat.agregarElemento(this.vid);
			mC.modificarCategoria(cat);
		}
	}
	
	
	@Override 
	public void agregarVideo(String nick, String nomV, String desc, Calendar fPub, int dur, String url) {
		ManejadorVideo mV = ManejadorVideo.getInstancia();
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		if(mU.existeUsuario(nick)) {
			this.usr = mU.obtenerUsuario(nick);
			this.vid = this.usr.getCanal().agregarVideo(nomV, desc, fPub, dur, url);
			mV.agregarVideo(this.vid);
		}else {
			throw new java.lang.RuntimeException("No existe un usuario con ese nick");
		}
	}
	
	
	@Override
	public void limpiarControlador() { //Operacion para utilizar al final de cada caso de uso
		this.vid = null;
		this.usr = null;
	}
	
	@Override
	public List<String> listarVideosDeUsuario(String nick){
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		if(mU.existeUsuario(nick)) {
			this.usr = mU.obtenerUsuario(nick);
			return this.usr.getCanal().obtenerNombreVideos();
		}else {
			throw new java.lang.RuntimeException("No existe un usuario con ese nick");
		}
	}
	
	
	@Override
	public List<String> listarVideosPublicosDeUsuario(String nick) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		if(mU.existeUsuario(nick)) {
			this.usr = mU.obtenerUsuario(nick);
			return this.usr.getCanal().obtenerNombreVideosPublicos();
		}else {
			throw new java.lang.RuntimeException("No existe un usuario con ese nick");
		}
	}
	
	@Override 
	public void modificarInfoVideo(String nomV, String desc, Calendar fecha, int dur, String url, boolean publico) {
		ManejadorVideo mV = ManejadorVideo.getInstancia();
		this.vid.setNombre(nomV);
		this.vid.setDescripcion(desc);
		this.vid.setfPublicacion(fecha);
		this.vid.setDuracion(dur);
		this.vid.setUrl(url);
		this.vid.setPublico(publico);
		mV.modificarVideo(this.vid);
	}
	
	@Override 
	public void/*List<DtComentario>*/ obtenerComentariosVideo(String nomVid) {
		this.vid = this.usr.getCanal().obtenerVideo(nomVid);
		
		/*List<DtComentario> dtComentarios = this.vid.obtenerComentariosVideo();
		return dtComentarios;*/
	}
	
	@Override 
	public DtVideo obtenerInfoVideo(String nomVid) {
		this.vid = this.usr.getCanal().obtenerVideo(nomVid);
		return this.usr.getCanal().obtenerInfoVideo(nomVid);
	}
	
	@Override 
	public List<DtValoracion> obtenerValoracionVideo() {
		return null;
	}
	
	@Override 
	public void responderComentario(int idCom, String nick, Calendar fcom, String texto) {}
	
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
		ManejadorVideo mV = ManejadorVideo.getInstancia();
		
		if(mU.existeUsuario(nickVal)) {
			Usuario usrVal = mU.obtenerUsuario(nickVal);
			this.vid.valorarVideo(val, usrVal);
			mU.modificaDatosUsuario(usrVal);
			mV.agregarVideo(this.vid);
		}else {
			throw new java.lang.RuntimeException("No existe un usuario con ese nick");
		}
	}

	
	@Override
	public Boolean existeVideo(String nick, String nomV) {
		// TODO Auto-generated method stub
		return false;
	}
}