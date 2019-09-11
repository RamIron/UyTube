package datatypes;

public class DtListaRep {
	private String nombre;
	private Boolean publico;
	private Boolean esParticular;
	private String categoria;
	
	//Constructores
	public DtListaRep() {
		super();
	}

	public DtListaRep(String nombre, Boolean publico, Boolean esParticular) {
		super();
		this.nombre = nombre;
		this.publico = publico;
		this.esParticular = esParticular;
	}
	
	
	
	public DtListaRep(String nombre, Boolean publico, Boolean esParticular, String categoria) {
		super();
		this.nombre = nombre;
		this.publico = publico;
		this.esParticular = esParticular;
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public Boolean getPublico() {
		return publico;
	}

	public Boolean getEsParticular() {
		return esParticular;
	}

	public String getCategoria() {
		return categoria;
	}
	
	
}
