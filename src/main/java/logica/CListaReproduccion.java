//package logica;
//
//import java.util.ArrayList;
//import java.util.Map;
//
//import javax.persistence.EntityManager;
//import javax.persistence.RollbackException;
//
//import datatypes.DtComentario;
//import datatypes.DtListaRep;
//import datatypes.DtValoracion;
//import datatypes.DtVideo;
//import interfaces.ILIstaReproduccion;
//
//public class CListaReproduccion implements ILIstaReproduccion {
//
//	private Usuario uVid;
//	private Usuario uList;
//	private Video video;
//	private ListaReproduccion lista;
//
//	@Override 
//	public void agregarCategoriaALista(String nick, String nomL, String nomC) {
//		Conexion conexion = Conexion.getInstancia();
//		EntityManager em = conexion.getEntityManager();
//		if((em.find(Categoria.class, nomC) != null)) { //Si la categoria existe
//			if((em.find(Usuario.class, nick) != null)) { //Verificando que el nick exista
//				if((em.find(Particular.class, nomL) != null)) { //Verificando que la lista exista
//					this.uList = em.find(Usuario.class, nick);
//					Categoria cat = em.find(Categoria.class, nomC);
//					this.uList.agregarCategoriaALista(nomL, cat);
//				} else { 
//					throw new IllegalArgumentException("No existe una lista con el nombre ingresado");
//				}
//				em.close();
//			} else { 
//				throw new IllegalArgumentException("No existe un usuario con el nickname ingresado");
//			}
//			em.close();
//		} else { 
//			throw new IllegalArgumentException("No existe la categoria con el nombre ingresado");
//		}
//		em.close();
//	}
//	
//	@Override 
//	public void agregarListaDefecto(String nomL) {	
//		Conexion conexion = Conexion.getInstancia();
//		EntityManager em = conexion.getEntityManager();
//		Canal canalU = this.uList.obtenerCanalU();
//		if(em.find(PorDefecto.class, nomL) == null) { //Si la lista no existe
//			PorDefecto lisDef = new PorDefecto(nomL, canalU); //La creo asociada al canal del usuario que recuerda el controlador
//			try {
//			em.getTransaction().begin();
//			em.persist(lisDef);
//			em.getTransaction().commit();
//			} catch (Exception e){
//				if(e instanceof RollbackException)
//					if(em.getTransaction().isActive())
//						em.getTransaction().rollback();
//				throw new IllegalArgumentException("Hubo un error inesperado");
//			}
//			finally { 
//				em.close();
//			}
//		} else {
//			throw new IllegalArgumentException("Ya existe una lista con el nombre ingresado");
//		}
//	}
//	
//	@Override 
//	public void agregarListaParticular(String nick, String nomL, boolean publico) {
//		Conexion conexion = Conexion.getInstancia();
//		EntityManager em = conexion.getEntityManager();
//		Usuario user = em.find(Usuario.class, nick);
//		Canal userC = user.obtenerCanalU();
//		if(em.find(Particular.class, nomL) == null) { //Si la lista no existe
//			Particular lisPar = new Particular(nomL, userC, publico); //La creo, asociada al canal del usuario que tiene nick que me pasan por parametro 
//			try {
//				em.getTransaction().begin();
//				em.persist(lisPar);
//				em.getTransaction().commit();
//			} catch (Exception e){
//				if(e instanceof RollbackException)
//					if(em.getTransaction().isActive())
//						em.getTransaction().rollback();
//				throw new IllegalArgumentException("Hubo un error inesperado");
//			}
//			finally { 
//				em.close();
//			}
//		} else {
//			throw new IllegalArgumentException("Ya existe una lista con el nombre ingresado");
//		}
//	}
//	
//	@Override 
//	public void agregarVideoLista(String nomVid, String nomList) {}
//	
//	@Override 
//	public void eliminarVideoDeLista(String nickVid, String nomVid, String nomList) {}
//	
//	//@Override 
//	//public boolean existeListaDefecto(String nomL) {}
//	
//	@Override 
//	public boolean existeListaParticular(String nick, String nomL) {}
//	
//	@Override 
//	public ArrayList<String> listarListasDeUsuario(String nick) {}
//	
//	@Override 
//	public ArrayList<String> listarListasParticulares(String nick) {}
//
//	@Override 
//	public ArrayList<String> listarVideosdeLista(String nomList) {}
//	
//	@Override 
//	public void modificarCategoria(String nick, String nomL, String nomC) {}
//	
//	@Override 
//	public void modificarInfoLista(String nick, String nomL, boolean publico) {}
//	
//	@Override 
//	public ArrayList<DtComentario> obtenerComentariosVideo(String nomVid) {}
//	
//	@Override 
//	public DtVideo obtenerInfoVideo(String nomVid) {}
//	
//	@Override 
//	public DtListaRep obtenerListaDeUsuario(String nomList) {}
//	
//	@Override 
//	public ArrayList<DtValoracion> obtenerValoracionVideo(String nomVid) {}
//	
//}