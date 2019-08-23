package presentacion;

import java.util.Date;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.IUsuario;
import interfaces.UFactory;
import logica.Socio;

public class Principal {
	static void menu() {
		System.out.println("UyTube\n"
							+ "1) Alta Usuario\n"
							+ "2) Salir\n"
							+ "Opcion: ");
	}
	
	static void altaUsuario() {
		Scanner entrada = new Scanner (System.in);
		UFactory uf = UFactory.getInstancia();
		IUsuario controlador = uf.getIUsuario();
		
		System.out.print("Nickname: ");
		String nick = entrada.nextLine();
	}

	public static void main (String args[]) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Con");
		EntityManager em = emf.createEntityManager();
		Socio s = new Socio("45453", "fdgfdhg");
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
		emf.close();
		Scanner entrada = new Scanner (System.in);
		int opcion;
		
		do {
			menu();
			opcion = Integer.parseInt(entrada.nextLine());
			switch (opcion) {
				case 1:
					altaUsuario();
					break;
				case 2:
					System.out.println("Adios");
			}
		}while (opcion != 2);
	
	}
}
