package presentacion;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.CFactory;
import interfaces.ICategoria;
import interfaces.IListaReproduccion;
import interfaces.IUsuario;
import interfaces.IVideo;
import interfaces.LRFactory;
import interfaces.UFactory;
import interfaces.VFactory;



public class Principal {
	static void menu() {
		System.out.print("UyTube\n"
							+ "1) Alta Usuario\n"
							+ "2) Modificar Usuario\n"
							+ "3) Listar Usuarios Existentes\n"
							+ "4) Seguir a usuario\n"
							+ "5) Dejar de seguir a usuario\n"
							+ "6) Alta Categoria\n"
							+ "7) Listar Categorias Existentes\n"
							+ "8) Alta Video\n"
							+ "9) Alta Lista de Reproduccion\n"
							+ "0) Salir\n"
							+ "Opcion: ");
	}

	static void altaUsuario() {
		Scanner entrada = new Scanner (System.in);
		UFactory uf = UFactory.getInstancia();
		IUsuario controlador = uf.getIUsuario();
		
		System.out.print("Nickname: ");
		String nick = entrada.nextLine();
		
		if(!controlador.existeNickname(nick)) {//Si no existe el nickname
		
			System.out.print("Nombre: ");
			String nombre = entrada.nextLine();
			
			System.out.print("Apellido: ");
			String apellido = entrada.nextLine();
			
			System.out.print("Correo Electronico: ");
			String correoE = entrada.nextLine();
			
			if(!controlador.existeEmail(correoE)) {
				System.out.println("Fecha de Nacimiento:");
				System.out.print("Anio:");
				int anio = Integer.parseInt(entrada.nextLine());
				System.out.print("Mes:");
				int mes = Integer.parseInt(entrada.nextLine());
				System.out.print("Dia:");
				int dia = Integer.parseInt(entrada.nextLine());
				
				Calendar fNac = Calendar.getInstance();
		        fNac.set(anio, mes, dia);
				
				controlador.agregarUsuario(nick, nombre, apellido, fNac, correoE);
				
				System.out.print("Desea asociar una imagen de perfil? s/n: ");
				char s_n = entrada.next().charAt(0);
				entrada.nextLine();
				if(s_n == 's') {
					System.out.print("Ingrese la imagen: ");
					String imagen = entrada.nextLine();
					controlador.modificarImagen(imagen);
				}
				
				controlador.agregarCanal();
				
				System.out.print("Desea cambiar el nombre de su canal? (Por defecto se llama: " + nick + ") s/n : ");
				s_n = entrada.next().charAt(0);
				entrada.nextLine();
				String nombreCanal = null;
				if(s_n == 's') {
					System.out.print("Ingrese el nuevo nombre de su canal:");
					nombreCanal = entrada.nextLine();
				}else {
					nombreCanal = nick;
				}
				
				System.out.print("Ingrese la descripcion de su canal: ");
				String descCanal = entrada.nextLine();
				
				System.out.print("Su canal sera publico? s/n: ");
				boolean publico = false;
				s_n = entrada.next().charAt(0);
				entrada.nextLine();
				if(s_n == 's') {
					publico = true;
				}
				
				controlador.modificarInfoCanal(nombreCanal, descCanal, publico);
				
				controlador.limpiarControlador();
			} else {
				System.out.println("Ya eiste un usuario con ese Email");
			}
		} else {
			System.out.println("Ya existe un usuario con ese nickname");
		}
	}
	
	static void listarUsuarios() {
		UFactory uf = UFactory.getInstancia();
		IUsuario controlador = uf.getIUsuario();
		
		List<String> usuarios = controlador.listarUsuarios();
		
		for(int i=0; i<usuarios.size(); i++){
		    System.out.println(usuarios.get(i));
		} 
	}
	
	static void modificarUsuario() { //Sin terminar
		listarUsuarios();
		Scanner entrada = new Scanner (System.in);
		UFactory uf = UFactory.getInstancia();
		IUsuario controlador = uf.getIUsuario();
		
		System.out.print("Nickname del usuario a modificar: ");
		String nick = entrada.nextLine();
		
	}
	
	static void seguirUsuario() {
		listarUsuarios();
		Scanner entrada = new Scanner (System.in);
		UFactory uf = UFactory.getInstancia();
		IUsuario controlador = uf.getIUsuario();
		
		System.out.print("Nickname del usuario que seguira a otro: ");
		String uSeguidor = entrada.nextLine();
		
		System.out.print("Nickname del usuario seguido: ");
		String uSeguido = entrada.nextLine();
		
		controlador.seguirUsuario(uSeguidor, uSeguido);
	}
	
	static void dejarDeSeguirUsuario() {
		listarUsuarios();
		Scanner entrada = new Scanner (System.in);
		UFactory uf = UFactory.getInstancia();
		IUsuario controlador = uf.getIUsuario();
		
		System.out.print("Nickname del usuario que dejara de seguir a otro: ");
		String uSeguidor = entrada.nextLine();
		
		System.out.print("Nickname del usuario seguido: ");
		String uSeguido = entrada.nextLine();
		
		controlador.dejarDeSeguirUsuario(uSeguidor, uSeguido);
	}
	
	static void altaCategoria() {
		Scanner entrada = new Scanner (System.in);
		CFactory cf = CFactory.getInstancia();
		ICategoria controlador = cf.getICategoria();
		
		System.out.print("Categoria a ingresar: ");
		String categoria = entrada.nextLine();
		
		controlador.altaCategoria(categoria);
	}
	
	static void listarCategorias() {
		CFactory cf = CFactory.getInstancia();
		ICategoria controlador = cf.getICategoria();
		
		List<String> categorias = controlador.listarCategorias();
		
		for(int i=0; i<categorias.size(); i++){
		    System.out.println(categorias.get(i));
		} 
	}
	
	static void altaVideo() {
		Scanner entrada = new Scanner (System.in);
		VFactory vf = VFactory.getInstancia();
		IVideo controlador = vf.getIVideo();
		
		System.out.print("Nickname del usuario a propietario del video: ");
		String nick = entrada.nextLine();
		
		System.out.print("Nombre del video: ");
		String nomV = entrada.nextLine();
		
		System.out.print("Descripcion del video: ");
		String desc = entrada.nextLine();
		
		System.out.println("Fecha:");
		System.out.print("Anio:");
		int anio = Integer.parseInt(entrada.nextLine());
		System.out.print("Mes:");
		int mes = Integer.parseInt(entrada.nextLine());
		System.out.print("Dia:");
		int dia = Integer.parseInt(entrada.nextLine());
		
		Calendar fPub = Calendar.getInstance();
		fPub.set(anio, mes, dia);
		
		System.out.print("Duracion del video: ");
		int dur = Integer.parseInt(entrada.nextLine());
		
		System.out.print("URL del video: ");
		String url = entrada.nextLine();
		
		controlador.agregarVideo(nick, nomV, desc, fPub, dur, url);
		
		System.out.print("Desea asociar una Categoria? s/n: ");
		char s_n = entrada.next().charAt(0);
		String categoria = null;
		entrada.nextLine();
		if(s_n == 's') {
			System.out.print("Nombre de Categoria: ");
			categoria = entrada.nextLine();
			controlador.agregarCategoria(categoria);
		}
		
		controlador.limpiarControlador();
	}
	
	static void altaListaReproduccion() {//Falta implementar
		Scanner entrada = new Scanner (System.in);
		LRFactory lf = LRFactory.getInstancia();
		IListaReproduccion controlador = lf.getIListaReproduccion();
		
		System.out.print("Desea agregar una lista Por Defecto o Particular? d/p: ");
		char d_p = entrada.next().charAt(0);
		entrada.nextLine();
		if(d_p == 'd') {
			System.out.print("Ingrese el nombre de la Por Defecto: ");
			String defecto = entrada.nextLine();
			//controlador.agregarListaDefecto(defecto);
		}else if(d_p == 'p'){
			System.out.print("Nickname del usuario: ");
			String nick = entrada.nextLine();
			
			System.out.print("Ingrese el nombre de la Particular: ");
			String particular = entrada.nextLine();
			
			System.out.print("Sera una lista publica? s/n: ");
			char s_n = entrada.next().charAt(0);
			boolean publico = false;
			entrada.nextLine();
			if(s_n == 's') {
				publico = true;
			}
			
			controlador.agregarListaParticular(nick, particular, publico);
			
//			System.out.print("Desea asociar una Categoria? s/n: ");
//			s_n = entrada.next().charAt(0);
//			String categoria = null;
//			entrada.nextLine();
//			if(s_n == 's') {
//				System.out.print("Nombre de Categoria: ");
//				categoria = entrada.nextLine();
//				controlador.agregarCategoriaALista(categoria);
//			}
		}
		
		controlador.limpiarControlador();
	}
	
	public static void main (String args[]) {
		Scanner entrada = new Scanner(System.in);
		int opcion;
		
		do {
			menu();
			opcion = Integer.parseInt(entrada.nextLine());
			switch(opcion) {
				case 1:
					altaUsuario();
					break;
				case 2:
					modificarUsuario();
					break;
				case 3:
					listarUsuarios();
					break;
				case 4:
					seguirUsuario();
					break;
				case 5:
					dejarDeSeguirUsuario();
					break;
				case 6:
					altaCategoria();
					break;
				case 7:
					listarCategorias();
					break;
				case 8:
					altaVideo();
					break;
				case 9:
					altaListaReproduccion();
					break;
				case 0:
					System.out.println("adios");
					break;
				default:
					System.out.println("Opcion invalida, intente nuevamente");
			}
		}while(opcion != 0);
		
		
		/*
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
		
		
		em.close();*/
	}
}
