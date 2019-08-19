package logica;

import java.util.ArrayList;

import datatypes.DtComentario;
import datatypes.DtListaRep;
import datatypes.DtValoracion;
import datatypes.DtVideo;
import interfaces.ILIstaReproduccion;

public class CListaReproduccion implements ILIstaReproduccion {

	private Usuario uVid;
	private Usuario uList;
	private Video video;
	private ListaReproduccion lista;

	@Override 
	public void agregarCategoriaALista(String nick, String nomL, String nomC) {}
	@Override 
	public void agregarListaDefecto(String nomL) {}
	public void agregarListaParticular(String nick, String nomL, boolean publico) {}
	public void agregarVideoLista(String nomVid, String nomList) {}
	public void eliminarVideoDeLista(String nickVid, String nomVid, String nomList) {}
	public boolean existeListaDefecto(String nomL) {}
	public boolean existeListaParticular(String nick, String nomL) {}
	public ArrayList<String> listarListasDeUsuario(String nick) {}
	public ArrayList<String> listarListasParticulares(String nick) {}
	public ArrayList<String> listarVideosdeLista(String nomList) {}
	public void modificarCategoria(String nick, String nomL, String nomC) {}
	public void modificarInfoLista(String nick, String nomL, boolean publico) {}
	public ArrayList<DtComentario> obtenerComentariosVideo(String nomVid) {}
	public DtVideo obtenerInfoVideo(String nomVid) {}
	public DtListaRep obtenerListaDeUsuario(String nomList) {}
	public ArrayList<DtValoracion> obtenerValoracionVideo(String nomVid) {}
		
}
