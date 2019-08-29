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
	public void agregarVideoLista(String nomVid, String nomList) {}
	
	@Override 
	public void eliminarVideoDeLista(String nickVid, String nomVid, String nomList) {}
	
	@Override 
	public boolean esCanalPublico() {
		return this.uList.getCanal().getPublico();
	}
	
	@Override 
	public boolean existeListaDefecto(String nomL) {return false;}
	
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
	public List<String> listarListasDeUsuario(String nick) {return null;}
	
	@Override 
	public List<String> listarListasParticulares(String nick) {return null;}

	@Override 
	public List<String> listarVideosdeLista(String nomList) {return null;}
	
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