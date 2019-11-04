package logica;

import java.util.*;

import Manejadores.ManejadorCategoria;
import datatypes.DtElementoUsuario;
import datatypes.DtElementoWeb;
import datatypes.tipoElemento;

import javax.persistence.*;

@Entity
public class Categoria {
		
		//ATRIBUTOS
		@Id
		private String nombre;

		@OneToMany(mappedBy="categoria",cascade=CascadeType.MERGE)
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
				elem = e.obtenerElemCategoria();
				res.add(elem);
			}
			return res;
		}

		public List<DtElementoWeb> obtenerVideosWeb(){
			List<DtElementoWeb> res = new LinkedList<DtElementoWeb>();
			DtElementoWeb infoVid;
			for(Elemento e: elementos) {
				if(e instanceof Video) {
					Video video = (Video) e;
					infoVid = new DtElementoWeb(video.getCanal().getUsuario().getNickname(), video.getNombre(), tipoElemento.VIDEO, video.getUrl());
					res.add(infoVid);
				}
			}
			return res;
		}
		
		public void agregarElemento(Elemento e) {
			e.setCategoria(this);
			elementos.add(e);
		}
		
		public void agregarLista(Particular p) {
			elementos.add(p);
		}
		
		public void quitarElemento(Elemento e) {
			ManejadorCategoria mc = ManejadorCategoria.getInstancia();
			e.setCategoria(null);
            //e.quitarCategoria(this);
			elementos.remove(e);
			//mc.modificarCategoria(this);
		}
}