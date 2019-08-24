package logica;

import java.util.*;
import datatypes.DtElementoUsuario;

import javax.persistence.*;

@Entity
public class Categoria {
		
		//ATRIBUTOS
		@Id
		private String nombre;
		
//		@OneToMany(mappedBy="categoria",cascade=CascadeType.ALL,orphanRemoval=true)
//		private List<Elemento> elementos;
		
		
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
			
//		public List<Elemento> getElementos() {
//			return elementos;
//		}

//		public List<DtElementoUsuario> obtenerElemCategoria(){
//			List<DtElementoUsuario> res = new LinkedList<DtElementoUsuario>();
//			DtElementoUsuario elem;
//			for(Elemento e: elementos) {
//				elem = e.obtenerElemCategoria();
//				res.add(elem);
//			}
//			return res;
//		}
//		
//		public void agregarVideo(Video v) {
//			elementos.add(v);		}
//		
//		public void agregarLista(Particular p) {
//			elementos.add(p);
//		}
}