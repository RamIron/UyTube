package interfaces;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import datatypes.DtCanal;
import datatypes.DtUsuario;

public interface IUsuario {
	
	public void agregarCanal();
	
	public void agregarUsuario(String nick, String nom, String ape, Calendar fechaN, String email);
	
	public void dejarDeSeguirUsuario(String seguidor, String seguido);
	
	public boolean existeEmail(String email);
	
	public boolean existeNickname(String nick);
	
	public void limpiarControlador();
	
	public List<String> listarSeguidores();
	
	public List<String> listarSeguidos();
	
	public List<String> listarUsuarios();
	
	public void modificarImagen(String img);
	
	public void modificarInfoCanal(String nomC, String descC, boolean publico);
	
	public void modificarInfoUsuario(String nick, String nomU, String apeU, Calendar fNacU, String imagen);
	
	public DtCanal obtenerInfoCanal();
	
	public Boolean esCanalPublico(String nick);
	
	public DtUsuario obtenerInfoUsuario(String nick);
	
	public void seguirUsuario(String seguidor, String seguido);
	
}
