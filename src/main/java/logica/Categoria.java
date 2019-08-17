package logica;

import java.util.*;

<<<<<<< HEAD
import datatypes.DtElementoUsuario;


=======
>>>>>>> e83dc7792ec45390cb40810447b68773e28364fe
public class Categoria {
		
		//ATRIBUTOS
		private String nombre;
		private List<Elemento> elementos;
		
		
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
		
		public List<DtElementoUsuario> obtenerElemCategoria(){
			// TODO
		}
		
		public void agregarVideo(Video v) {
			// TODO
		}
		
		public void agregarLista(Particular p) {
			// TODO
		}
}
