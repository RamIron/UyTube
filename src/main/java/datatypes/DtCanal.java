package datatypes;

public class DtCanal {
	private String nombre;
	private String descripcion;
	private Boolean publico;
	
	//Constructores
	public DtCanal() {
		super();
	}

	public DtCanal(String nombre, String descripcion, Boolean publico) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.publico = publico;
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
	
	
	
}
