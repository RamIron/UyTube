package logica;

import javax.persistence.*;

import datatypes.DtElementoUsuario;

@Entity
@DiscriminatorValue("LP")
public class Particular extends ListaReproduccion{
	private boolean publico;
	
	@ManyToOne
	private Categoria categoria;

	public Particular() {
		super();
	}

	public Particular(String nombre, Canal canal, boolean publico) {
		super(nombre, canal);
		this.publico = publico;
	}
	
	public Particular(String nombre, Canal canal, boolean publico, Categoria cat) {
		super(nombre, canal);
		this.publico = publico;
		this.categoria = cat;
	}

	//Getters & Setters
	
	@Override
	public boolean esPublico() {
		// TODO Auto-generated method stub
		return publico;
	} 
	
	public void setPublico(boolean publico) {
		this.publico = publico;
	}
	
	
	public Categoria getCatergoria() {
		return categoria;
	}

	public void setCatergoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	//Operaciones

	
	public DtElementoUsuario obtenerElemCategoria() {
		return null;
	}
	
	

	@Override
	public boolean esParticular() {
		return true;
	}
	
	public void modificarCategoria(String nomC) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Categoria c = em.find(Categoria.class, nomC);
		this.categoria = c;
	}
}
