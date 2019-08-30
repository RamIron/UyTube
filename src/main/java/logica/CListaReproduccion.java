package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;

import Manejadores.ManejadorCategoria;
import Manejadores.ManejadorListaParticular;
import Manejadores.ManejadorUsuario;
import datatypes.DtComentario;
import datatypes.DtListaRep;
import datatypes.DtValoracion;
import datatypes.DtVideo;
import datatypes.DtVideoUsuario;
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
	public void agregarListaDefecto(String nomL) {	
//		Conexion conexion = Conexion.getInstancia();
//		EntityManager em = conexion.getEntityManager();
//		TypedQuery<Canal> consulta = em.createQuery("SELECT * FROM Canal c", Canal.class);
//	    List<Canal> canales = consulta.getResultList();
//	    for(Canal c:canales) {
//			c.agregarListaDefecto(nomL);
//	    	System.out.println("Entro");
//			System.out.println(c.getNombre());
//		}
		
//		if(em.find(PorDefecto.class, nomL) == null) { //Si la lista no existe
//			TypedQuery<Canal> consulta = em.createQuery("SELECT * FROM Canal c", Canal.class);
//		    List<Canal> canales = consulta.getResultList();
//		    System.out.println("Llega aca");
//			try {
//				for(Canal c:canales) {
//					//c.agregarListaDefecto(nomL);
//					System.out.println(c.getNombre());
//				}
//			} catch (Exception e){
//				if(e instanceof RollbackException)
//					if(em.getTransaction().isActive())
//						em.getTransaction().rollback();
//				throw new IllegalArgumentException("Hubo un error inesperado");
//			}
//		} else {
//			throw new IllegalArgumentException("Ya existe una lista con el nombre ingresado");
//		}
	}
	
	
	@Override 
	public void agregarListaParticular(String nomL, boolean publico) {
		ManejadorListaParticular mLP = ManejadorListaParticular.getInstancia();
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		this.uList = mU.obtenerUsuario(this.uList.getNickname());
		this.lista = this.uList.getCanal().agregarListaParticular(nomL, publico);
		mLP.agregarListaParticular((Particular)this.lista);
	}
	
	@Override 
	public void agregarVideoListaParticular(String nickVideo, String nomVid, String nomList) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ManejadorListaParticular mLP = ManejadorListaParticular.getInstancia();
		this.uVid = mU.obtenerUsuario(nickVideo);
		this.video = this.uVid.getCanal().obtenerVideo(nomVid);
		Particular particular = (Particular) this.uList.getCanal().agregarVideoListaParticular(this.video, nomList);
		mLP.modificarListaParticular(particular);
		
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
		return false;
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
		if(mU.existeUsuario(nick)) {
			this.uList = mU.obtenerUsuario(nick);
			return this.uList.getCanal().listarListasParticulares();
		}else {
			throw new java.lang.RuntimeException("No existe un usuario con ese nick");
		}
	}

	@Override 
	public List<DtVideoUsuario> listarVideosdeLista(String nomList) {
		return this.uList.getCanal().listarVideosdeLista(nomList);
	}
	
	@Override 
	public void modificarCategoria(String nick, String nomL, String nomC) {}
	
	@Override 
	public void modificarInfoLista(String nick, String nomL, boolean publico) {}
	
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
		return null;
	}
	
	@Override 
	public ArrayList<DtValoracion> obtenerValoracionVideo(String nomVid) {
		return null;
	}
	
}