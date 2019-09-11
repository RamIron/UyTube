package logica;

import javax.persistence.*;

import datatypes.*;

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
		DtElementoUsuario defecto = new DtElementoUsuario(this.getCanal().getUsuario().getNickname(), this.getNombre(), tipoElemento.LISTA);
		return defecto;
	}

	@Override
	public boolean isPublico() {
		return false;
	}


//		
//	public boolean esParticular() {
//		return false;
//	}
//
//	@Override
//	public boolean esPublico() {
//		return false;
//	}
//	
}