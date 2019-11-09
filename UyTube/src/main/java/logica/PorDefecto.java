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

	@Override
	public DtElementoUsuario obtenerElemCategoria() {
		DtElementoUsuario defecto = new DtElementoUsuario(this.getCanal().getUsuario().getNickname(), this.getNombre(), tipoElemento.LISTA);
		return defecto;
	}

	@Override
	public boolean isPublico() {
		return false;
	}
}