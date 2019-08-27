package presentacion;

import java.util.Date;
import java.util.Scanner;

import interfaces.IUsuario;
import interfaces.UFactory;

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
