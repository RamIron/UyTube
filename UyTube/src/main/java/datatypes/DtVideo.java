package datatypes;

import java.util.*;

public class DtVideo {
	private String nombre;
	private String descripcion;
	private Calendar fPublicacion;
	private Integer duracion;
	private String url;
	private Boolean publico;
	private String categoria;
	
	//Constructor
	public DtVideo() {
		super();
	}

	public DtVideo(String nombre, String descripcion, Calendar fPublicacion, Integer duracion, String url,
			Boolean publico, String categoria) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fPublicacion = fPublicacion;
		this.duracion = duracion;
		this.url = url;
		this.publico = publico;
		this.categoria = categoria;
	}


	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Calendar getfPublicacion() {
		return fPublicacion;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public String getUrl() {
		return url;
	}

	public Boolean getPublico() {
		return publico;
	}

	public String getCategoria() {
		return categoria;
	} 
	
	
	
	
	
}
