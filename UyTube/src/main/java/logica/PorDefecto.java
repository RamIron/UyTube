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

	//Esta funcion se llama asi porque la necesito para traer los videos de una categoria, no deberia ser usada para traer las listas de una categoria
//	public DtElementoWeb obtenerVideosCategoria() {
//		DtElementoWeb defecto = new DtElementoWeb(this.getCanal().getUsuario().getNickname(), this.getNombre(), tipoElemento.LISTA, null);
//		return defecto;
//	}

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