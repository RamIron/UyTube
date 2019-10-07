package logica;

import javax.persistence.*;

import datatypes.DtElementoUsuario;
import datatypes.DtElementoWeb;
import datatypes.tipoElemento;

@Entity
@DiscriminatorValue("LP")
@NamedQueries({
@NamedQuery(name="existeListaParticular", query="select p.nombre from Particular p where p.nombre=:nombreLista")
})
public class Particular extends ListaReproduccion{
	private boolean publico;
	
	@ManyToOne
	private Categoria categoria;

	public Particular() {
		super();
	}
	
	public Particular(String nombre, boolean publico) {
		super(nombre);
		this.publico = publico;
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
	public boolean isPublico() {
		return publico;
	} 
	
	public void setPublico(boolean publico) {
		this.publico = publico;
	}
	
//	public Categoria getCatergoria() {
//		return categoria;
//	}
//
//	public void setCatergoria(Categoria categoria) {
//		this.categoria = categoria;
//	}
	
//	//Operaciones
//
//	
	public DtElementoUsuario obtenerElemCategoria() {
		DtElementoUsuario particular = new DtElementoUsuario(this.getCanal().getUsuario().getNickname(), this.getNombre(), tipoElemento.LISTA);
		return particular;
	}

	//Esta funcion se llama asi porque la necesito para traer los videos de una categoria, no deberia ser usada para traer las listas de una categoria
//	public DtElementoWeb obtenerVideosCategoria() {
//		DtElementoWeb particular = new DtElementoWeb(this.getCanal().getUsuario().getNickname(), this.getNombre(), tipoElemento.LISTA, null);
//		return particular;
//	}
//	
//	
//
//	@Override
//	public boolean esParticular() {
//		return true;
//	}
//	
//	public void modificarCategoria(String nomC) {
//		Conexion conexion = Conexion.getInstancia();
//		EntityManager em = conexion.getEntityManager();
//		Categoria c = em.find(Categoria.class, nomC);
//		this.categoria = c;
//	}
}