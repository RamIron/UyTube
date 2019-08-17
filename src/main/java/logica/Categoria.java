package logica;

import java.util.*;

public class Categoria {
		
		//ATRIBUTOS
		private String nombre;
		private List <Elemento> elementos;
		
		
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
