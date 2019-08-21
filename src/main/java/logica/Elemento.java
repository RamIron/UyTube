package logica;

import datatypes.*;

import javax.persistence.*;

@Entity
@MappedSuperclass
public abstract class Elemento {
	@Id
	@GeneratedValue
	private Integer id; 
	
	private String nombre;
	
	@ManyToOne
	private Categoria categoria;
	
	@ManyToOne
	private Canal canal;
	
	//Constructor por defecto
	public Elemento() {
		super();
	}

	public Elemento(String nombre, Canal canal) {
		super();
		this.nombre = nombre;
		this.canal = canal;
	}

	public Elemento(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}
	
	public abstract DtElementoUsuario obtenerElemCategoria();
	
}
