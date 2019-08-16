package datatypes;

import java.util.*;

public class DtVideo {
	private String nombre;
	private String descripcion;
	private Date fPublicacion;
	private Integer duracion;
	private String url;
	private Boolean publico;
	
	//Constructor
	public DtVideo() {
		super();
	}

	public DtVideo(String nombre, String descripcion, Date fPublicacion, Integer duracion, String url,
			Boolean publico) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fPublicacion = fPublicacion;
		this.duracion = duracion;
		this.url = url;
		this.publico = publico;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Date getfPublicacion() {
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
	
	
	
	
}
