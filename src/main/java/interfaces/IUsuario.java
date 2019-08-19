package interfaces;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import datatypes.DtCanal;
import datatypes.DtUsuario;

public interface IUsuario {
	
	public void agregarCanal(String desc, boolean publico);
	
	public void agregarNombreCanal(String nomC);
	
	public void agregarUsuario(String nick, String nom, String ape, Date fechaN, String email);
	
	public void dejarDeSeguirUsuario(String seguidor, String seguido);
	
	public boolean existeEmail(String email);
	
	public boolean existeNickname(String nick);
	
	public ArrayList<String> listarSeguidores();
	
	public ArrayList<String> listarSeguidos();
	
	public List<String> listarUsuarios();
	
	public void modificarImagen(String img);
	
	public void modificarInfoCanal(String nomC, String descC, boolean publico);
	
	public void modificarInfoUsuario(String nick, String nomU, String apeU, Date fNacU, String imagen);
	
	public DtCanal obtenerInfoCanal();
	
	public DtUsuario obtenerInfoUsuario(String nick);
	
	public void seguirUsuario(String seguidor, String seguido);
	
}
