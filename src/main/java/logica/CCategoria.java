package logica;

import java.util.ArrayList;
import datatypes.DtElementoUsuario;
import interfaces.ICategoria;

public class CCategoria implements ICategoria {
	public Categoria cat;
	
	//Operaciones
	public boolean existeCategoria(String nomC) {
		return false;
	}
	
	public void altaCategoria(String nomC) {}
	
	public ArrayList<DtElementoUsuario> listarElemCategoria(String nomC) {
		return null;
	}
	
	public ArrayList<String> listarCategorias() {
		return null;
	}
	
}
