package presentacion;

import java.util.Date;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import logica.Canal;
import logica.Categoria;
import logica.Socio;
import logica.Usuario;

public class Principal {
	static void menu() {
		System.out.println("UyTube\n"
							+ "1) Alta Usuario\n"
							+ "2) Salir\n"
							+ "Opcion: ");
	}

	public static void main (String args[]) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Conexion");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Socio s = new Socio("dfw", "ww");
		em.persist(s);
		em.getTransaction().commit();
		em.close();
		emf.close();	
		
		
		//Creacion Usuario
		emf = Persistence.createEntityManagerFactory("Conexion");
		em = emf.createEntityManager();
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
		em.close();
		emf.close();
		
		emf = Persistence.createEntityManagerFactory("Conexion");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Categoria cat = new Categoria("Deportes");
		em.persist(cat);
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	}
}
