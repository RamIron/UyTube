package interfaces;

import java.util.ArrayList;
import java.util.Date;

import datatypes.DtCanal;
import datatypes.DtUsuario;

public interface IUsuario {
	
	public void agregarCanal(String nick, String desc, boolean publico);
	
	public void agregarNombreCanal(String nick, String nomC);
	
	public void agregarUsuario(String nick, String nom, String ape, Date fechaN, String email);
	
	public void dejarDeSeguirUsuario(String seguidor, String seguido);
	
	public boolean existeEmail(String email);
	
	public boolean existeNickname(String nick);
	
	public ArrayList<String> listarSeguidores();
	
	public ArrayList<String> listarSeguidos();
	
	public ArrayList<String> listarUsuarios();
	
	public void modificarImagen(String nick, String img);
	
	public void modificarInfoCanal(String nick, String nomC, String descC, boolean publico);
	
	public void modificarInfoUsuario(String nick, String nomU, String apeU, Date fNacU, String imagen);
	
	public DtCanal obtenerInfoCanal();
	
	public DtUsuario obtenerInfoUsuario(String nick);
	
	public void seguirUsuario(String seguidor, String seguido);
	
}
