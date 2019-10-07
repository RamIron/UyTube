package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import datatypes.*;
import org.hibernate.SessionFactory;

import Manejadores.ManejadorCategoria;
import Manejadores.ManejadorPorDefecto;
//import Manejadores.ManejadorListaParticular;
import Manejadores.ManejadorUsuario;
import interfaces.IListaReproduccion;

public class CListaReproduccion implements IListaReproduccion {

	private Usuario uVid;
	private Usuario uList;
	private Video video;
	private ListaReproduccion lista;

	@Override 
	public void agregarCategoriaALista(String nomC) {
		ManejadorCategoria mC = ManejadorCategoria.getInstancia();
		if(mC.existeCategoria(nomC)) {
			Categoria cat = mC.obtenerCategoria(nomC);
			cat.agregarElemento(this.lista);
			mC.modificarCategoria(cat);
		}
	}

	@Override
	public List<String> obtenerCatListPart(String nomL){
		List<String> categoriasList = new ArrayList<String>();
		if(this.lista instanceof Particular){
			for(String c : categoriasList){
				String cat = this.lista.getCategoria().getNombre();
				categoriasList.add(cat);
			}
		}
		return categoriasList;
	}
	
	@Override 
	public void agregarListaDefecto(String nomL) {	
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ManejadorPorDefecto mPD = ManejadorPorDefecto.getInstancia();
		List<Usuario> usuarios = mU.obtenerUsuarios();
		
	    for(Usuario u:usuarios) {
			u.getCanal().agregarListaDefecto(nomL);
	    	mU.modificaDatosUsuario(u);
		}
		
	    NombrePorDefecto nomPD = new NombrePorDefecto(nomL);
		mPD.agregarPorDefecto(nomPD);
	}
	
	
	@Override 
	public void agregarListaParticular(String nomL, boolean publico) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		this.uList = mU.obtenerUsuario(this.uList.getNickname());
		this.lista = this.uList.getCanal().agregarListaParticular(nomL, publico);
		mU.modificaDatosUsuario(uList);
	}
	
	@Override 
	public void agregarVideoListaParticular(String nickVideo, String nomVid, String nomList) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		this.uVid = mU.obtenerUsuario(nickVideo);
		this.video = this.uVid.getCanal().obtenerVideo(nomVid);
		this.uList.getCanal().agregarVideoListaParticular(this.video, nomList);
		mU.modificaDatosUsuario(this.uList);
	}
	
	@Override 
	public void agregarVideoListaPorDefecto(String nickVideo, String nomVid, String nomList) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		this.uVid = mU.obtenerUsuario(nickVideo);
		this.video = this.uVid.getCanal().obtenerVideo(nomVid);
		this.uList.getCanal().agregarVideoListaPorDefecto(this.video, nomList);
		mU.modificaDatosUsuario(this.uList);
	}
	
	@Override 
	public void eliminarVideoDeLista(String nickVid, String nomVid, String nomList) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		if(mU.existeUsuario(nickVid)) {
			this.uVid = mU.obtenerUsuario(nickVid);
			this.video = this.uVid.getCanal().obtenerVideo(nomVid);	
			this.uList.getCanal().eliminarVideoDeLista(this.video, nomList);
			mU.modificaDatosUsuario(this.uList);
		}else {
			throw new IllegalArgumentException("No existe un usuario con ese nickname");
		}
	}
	
	@Override 
	public boolean existeLista(String nomL) {
		return this.uList.getCanal().existeLista(nomL);
	}
	
	@Override 
	public boolean existeListaDefecto(String nomL) {
		ManejadorPorDefecto mPD = ManejadorPorDefecto.getInstancia();
		return mPD.existePorDefecto(nomL);
	}
	
	@Override 
	public boolean existeListaParticular(String nick, String nomL) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		this.uList = mU.obtenerUsuario(nick);
		return this.uList.getCanal().existeListaParticular(nomL);
	}
	
	@Override
	public void limpiarControlador() { //Operacion para utilizar al final de cada caso de uso
		this.lista = null;
		this.uList = null;
		this.uVid = null;
		this.video = null;
	}
	
	@Override 
	public List<String> listarListasDeUsuario(String nick) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		this.uList = mU.obtenerUsuario(nick);
		return this.uList.getCanal().listarListasDeUsuario();
	}
	
	@Override 
	public List<String> listarListasParticulares(String nick) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		this.uList = mU.obtenerUsuario(nick);
		return this.uList.getCanal().listarListasParticulares();
	}

	@Override 
	public List<String> listarListasPorDefecto(String nick) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		this.uList = mU.obtenerUsuario(nick);
		return this.uList.getCanal().listarListasPorDefecto();
	}
	
	@Override 
	public List<DtVideoUsuario> listarVideosdeLista(String nomList) {
		return this.uList.getCanal().listarVideosdeLista(nomList);
	}

	@Override
	public List<DtElementoWeb> listarVideosLista(String nomList) {
		return this.uList.getCanal().listarVideosLista(nomList);
	}
	
	@Override 
	public void modificarCategoria(String nomC) {
		System.out.println("sa");
		ManejadorCategoria mC = ManejadorCategoria.getInstancia();
		if(mC.existeCategoria(nomC)) {
			//Debo obtener la categoria de la lista, para esa categoria sacar la lista
			Particular part = (Particular) this.lista;
//			Categoria catPart = part.getCategoria();
//			if(!(catPart == null)) {
//				catPart.quitarElemento(part);
//				mC.modificarCategoria(catPart);
//			}
			Categoria cat = mC.obtenerCategoria(nomC);
			cat.agregarElemento(this.lista);
			mC.modificarCategoria(cat);
		}
	}
	
	@Override 
	public void modificarInfoLista(String nomL, boolean publico) {
		this.lista = this.uList.getCanal().obtenerLista(nomL);
		Particular part = (Particular) this.lista;
		part.setPublico(publico);
	}
	
	@Override 
	public List<DtComentario> obtenerComentariosVideo(String nomVid) {
		return null;
	}
	
	@Override 
	public DtVideo obtenerInfoVideo(String nomVid) {
		return null;
	}
	
	@Override 
	public DtListaRep obtenerListaDeUsuario(String nomList) {
		return this.uList.getCanal().obtenerListaDeUsuario(nomList);
	}
	
	@Override 
	public ArrayList<DtValoracion> obtenerValoracionVideo(String nomVid) {
		return null;
	}

	@Override
	public void setuVid(String nick) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		this.uVid =mU.obtenerUsuario(nick);
	}

	@Override
	public void setuList(String nick) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		this.uList = mU.obtenerUsuario(nick);
	}

	@Override
	public void setVideo(String nomV) {
		this.video = this.uVid.getCanal().obtenerVideo(nomV);
	}

	@Override
	public void setLista(String nomL) {
		this.lista = this.uList.getCanal().obtenerLista(nomL);
	}
	
	@Override 
	public void eliminarCategoria() {
		ManejadorCategoria mC = ManejadorCategoria.getInstancia();
		Particular part = (Particular) this.lista;
//		Categoria catPart = part.getCategoria();
//		catPart.quitarElemento(part);
//		mC.modificarCategoria(catPart);
	}
	
	
}