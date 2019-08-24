package interfaces;

import java.util.List;

import datatypes.DtElementoUsuario;

public interface ICategoria {

	public boolean existeCategoria(String nomC);
	
	public void altaCategoria(String nomC);
	
	public List<DtElementoUsuario> listarElemCategoria(String nomC);
	
	public List<String> listarCategorias();
	
}