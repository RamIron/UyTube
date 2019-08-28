package logica;

import java.util.*;
import datatypes.DtElementoUsuario;

import javax.persistence.*;

@Entity
public class Categoria {
		
		//ATRIBUTOS
		@Id
		private String nombre;
		
		@OneToMany(mappedBy="categoria",cascade=CascadeType.ALL,orphanRemoval=true)
		private List<Elemento> elementos = new ArrayList <Elemento>();
		
		
		//METODOS
		
		public Categoria() {
		}
		
		public Categoria(String nombre) {
			super();
			this.nombre = nombre;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
			
		public List<Elemento> getElementos() {
			return elementos;
		}

		public List<DtElementoUsuario> obtenerElemCategoria(){
			List<DtElementoUsuario> res = new LinkedList<DtElementoUsuario>();
			DtElementoUsuario elem;
			for(Elemento e: elementos) {
				//elem = e.obtenerElemCategoria();
				//res.add(elem);
			}
			return res;
		}
		
		public void agregarElemento(Elemento e) {
			Conexion conexion = Conexion.getInstancia();
			EntityManager em = conexion.getEntityManager();
			em.getTransaction().begin();
			elementos.add(e);
			e.setCategoria(this);
			em.persist(e);
			em.persist(this);
			em.getTransaction().commit();
		}
		
		public void agregarLista(Particular p) {
			elementos.add(p);
		}
}