package interfaces;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import datatypes.DtCanal;
import datatypes.DtUsuario;
import datatypes.DtUsuarioWeb;

public interface IUsuario {
	
	public void agregarCanal();

    //si la categoria esta vacia en canal se le agrega, si ya tiene una categoria se pisa
    void modificarCatCanal(String nick, String nomCat);

    public void agregarUsuario(String nick, String nom, String ape, Calendar fechaN, String email);
	
	public void dejarDeSeguirUsuario(String seguidor, String seguido);
	
	public Boolean esCanalPublico(String nick);
	
	public boolean existeEmail(String email);
	
	public boolean existeNickname(String nick);
	
	public void limpiarControlador();
	
	public List<String> listarSeguidores();
	
	public List<String> listarSeguidos();
	
	public List<String> listarUsuarios();
	
	public void modificarImagen(String img);

    void modificarContrasena(String pass);

    public void modificarInfoCanal(String nomC, String descC, boolean publico);
	
	public void modificarInfoUsuario(String nomU, String apeU, Calendar fNacU, String imagen);
	
	public DtCanal obtenerInfoCanal();
	
	public DtUsuario obtenerInfoUsuario(String nick);
	
	public void seguirUsuario(String seguidor, String seguido);

	public Integer iniciarSesion(String nick, String pass);

    DtUsuarioWeb obtenerUsuarioWebNick(String nickname);

	DtUsuarioWeb obtenerUsuarioWebEmail(String email);

    List<DtUsuarioWeb> listarUsuariosWeb();
}
