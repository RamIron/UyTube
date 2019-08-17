package logica;

import datatypes.DtElementoUsuario;

public class Particular extends ListaReproduccion{
	private boolean publico;

	public Particular() {
		super();
	}

	public Particular(String nombre, Canal canal) {
		super(nombre, canal);
	}

	public Particular(String nombre) {
		super(nombre);
	}

	public Particular(boolean publico) {
		this.publico = publico;
	}

	//Getters & Setters
	public boolean isPublico() {
		return publico;
	}

	public void setPublico(boolean publico) {
		this.publico = publico;
	}
	
	//Operaciones
	/*public void modificarCategoria(String nomC) {}
	
	public DtElementoUsuario obtenerElemCategoria() {}*/
}
