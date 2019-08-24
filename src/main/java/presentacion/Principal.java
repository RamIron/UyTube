package presentacion;

import java.util.Date;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import logica.*;



public class Principal {
	static void menu() {
		System.out.println("UyTube\n"
							+ "1) Alta Usuario\n"
							+ "2) Salir\n"
							+ "Opcion: ");
	}

	public static void main (String args[]) {
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		Socio s = new Socio("dfw", "ww");
		em.persist(s);
		em.getTransaction().commit();
		
		
		
		//Creacion Usuario
		em.getTransaction().begin();
		Date fecha = new Date(2010, 2, 10);
		Usuario u = new Usuario("tincho", "martin", "navarrete", fecha , "asd@fsdfsd.com");
		Usuario u2 = new Usuario("mateo", "mateo", "sayas", fecha , "asd@fsdfsd.com");
		Canal c = new Canal("Mi Canal", "asdsd ds", true);
		u.agregarCanal(c);
		u.seguirUsuario(u2);
		em.persist(c);
		em.persist(u);
		em.persist(u2);
		em.getTransaction().commit();
		
		
		
		em.getTransaction().begin();
		Categoria cat = new Categoria("Deportes");
		em.persist(cat);
		em.getTransaction().commit();
		
		

		Elemento vid = new Video("Video de gatitos", "asds", fecha, 120, "youtube.com", true, c);
		Elemento vid2 = new Video("Videos de putitas", "asds", fecha, 120, "youtube.com", true, c);
		

		Elemento lisP= new Particular("Lista de Videos de gatos", c, false);


		Elemento lisD= new PorDefecto("Favoritos", c);

		
		ListaReproduccion lis = (ListaReproduccion) lisP;
		
		
		lis.agregarVideo((Video) vid);
		lis.agregarVideo((Video) vid2);

		cat.agregarElemento(vid2);
		cat.agregarElemento(lisP);
		
		Video v =(Video) vid;
		v.crearComentario(u, fecha, "Soy un comentario");
		
		
		//com1.crearRespuesta(u, fecha, "te respondo");
		
		
		
		em.close();
		
		
		
	}
}
