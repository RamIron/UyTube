package logica;

import datatypes.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Elemento {
	@Id
	@SequenceGenerator(name = "elementoGenerator", sequenceName = "ELEMENTO_SEQUENCE", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "elementoGenerator")
	protected int id; 
	
	private String nombre;
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	protected List<Categoria> categorias = new ArrayList<Categoria>();
	
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
	
	public List<Categoria> getCategoria() {
		return categorias;
	}

	public void setCategoria(Categoria categoria) {
		this.categorias.add(categoria);
	}

	public void quitarCategoria(Categoria c){
		this.categorias.remove(c);
	}
	
	public abstract DtElementoUsuario obtenerElemCategoria();
	
}