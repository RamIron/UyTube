package logica;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import datatypes.DtElementoUsuario;

@Entity
@DiscriminatorValue("LD")
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
		
	public boolean esParticular() {
		return false;
	}

	@Override
	public boolean esPublico() {
		return false;
	}
	
}
