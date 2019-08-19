package logica;

import datatypes.DtElementoUsuario;

public class PorDefecto extends ListaReproduccion{

	public PorDefecto() {
		super();
	}

	public PorDefecto(String nombre, Canal canal) {
		super(nombre, canal);
	}

	public PorDefecto(String nombre) {
		super(nombre);
	}

	@Override
	public DtElementoUsuario obtenerElemCategoria() {
		return null;
	}
	
}
