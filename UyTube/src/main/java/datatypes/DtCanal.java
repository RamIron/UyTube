package datatypes;

import logica.Categoria;

public class DtCanal {
	private String nombre;
	private String descripcion;
	private Boolean publico;
	private String categoria;
	
	//Constructores
	public DtCanal() {
		super();
	}

	public DtCanal(String nombre, String descripcion, Boolean publico, String categoria) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.publico = publico;
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Boolean getPublico() {
		return publico;
	}

	public String getCategoria() { return categoria;}
}
