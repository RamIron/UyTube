package interfaces;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtElementoUsuario;

public interface ICategoria {

	public void altaCategoria(String nomC);
	
	public List<DtElementoUsuario> listarElemCategoria(String nomC);
	
	public List<String> listarCategorias();
	
	public boolean existeCategoria(String nombre);
	
	public void limpiarControlador();
	
}