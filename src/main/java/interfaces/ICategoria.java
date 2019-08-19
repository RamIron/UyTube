package interfaces;

import java.util.ArrayList;

import datatypes.DtElementoUsuario;

public interface ICategoria {

	public boolean existeCategoria(String nomC);
	
	public void altaCategoria(String nomC);
	
	public ArrayList<DtElementoUsuario> listarElemCategoria(String nomC);
	
	public ArrayList<String> listarCategorias();
	
}