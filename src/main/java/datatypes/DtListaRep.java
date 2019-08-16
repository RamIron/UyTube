package datatypes;

public class DtListaRep {
	private String nombre;
	private Boolean publico;
	private Boolean esParticular;
	
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

	public String getNombre() {
		return nombre;
	}

	public Boolean getPublico() {
		return publico;
	}

	public Boolean getEsParticular() {
		return esParticular;
	}
	
}
