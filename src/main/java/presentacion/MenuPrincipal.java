package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import interfaces.*;
import java.awt.GridLayout;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	//MENU
	private JMenuBar menuBar = new JMenuBar();	
	private JMenu mnUsuario = new JMenu("Usuario");
	private JMenuItem mntmAgregarUsuario = new JMenuItem("Agregar");
	private JMenuItem mntmModificarUsuario = new JMenuItem("Modificar");
	private JMenuItem mntmListarTodos = new JMenuItem("Listar todos");
	private JMenuItem mntmConsultarUsuario = new JMenuItem("Consultar");
	private JMenuItem mntmSeguir = new JMenuItem("Seguir");
	private JMenuItem mntmDejarDeSeguir = new JMenuItem("Dejar de seguir");
	private JMenu mnVideo = new JMenu("Video");
	private JMenuItem mntmAgregarVideo = new JMenuItem("Agregar");
	private JMenuItem mntmModificarVideo = new JMenuItem("Modificar");
	private JMenuItem mntmConsultarVideo = new JMenuItem("Consultar");
	private JMenuItem mntmComentar = new JMenuItem("Comentar");
	private JMenuItem mntmValorar = new JMenuItem("Valorar");
	private JMenu mnListaDeReproduccion = new JMenu("Lista de Reproduccion");
	private JMenuItem mntmAgregarLista = new JMenuItem("Agregar");
	private JMenuItem mntmModificarLista = new JMenuItem("Modificar");
	private JMenuItem mntmConsultarLista = new JMenuItem("Consultar");
	private JMenuItem mntmAgregarVideoA = new JMenuItem("Agregar video a lista");
	private JMenuItem mntmQuitarVideoDe = new JMenuItem("Quitar video de lista");
	private JMenu mnCategoria = new JMenu("Categoria");	
	private JMenuItem mntmAgregarCategoria = new JMenuItem("Agregar");
	private JMenuItem mntmListarTodas = new JMenuItem("Listar todas");
	private JMenuItem mntmConsultarCategoria = new JMenuItem("Consultar");
	
	//JInternalFrames
	private AltaCategoria altaCategoriaIF;
	private ListarCategoria listarCategoriaIF;
	
	private AltaUsuario altaUsuarioIF;
	private ListarUsuario listarUsuarioIF;
	private ConsultaUsuario consultaUsuarioIF;
	
	private AltaVideo altaVideoIF;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void LimpiarFrame() {
		altaCategoriaIF.setVisible(false);
		listarCategoriaIF.setVisible(false);
		altaUsuarioIF.setVisible(false);
		listarUsuarioIF.setVisible(false);
		altaVideoIF.setVisible(false);
	}
	
	/**
	 * Create the frame.
	 */
	/**
	 * 
	 */
	public MenuPrincipal() {
		setTitle("UyTube");
		//Categoria
		CFactory fC = CFactory.getInstancia();
		ICategoria iC = fC.getICategoria();
		
		altaCategoriaIF = new AltaCategoria(iC);
		altaCategoriaIF.setBounds(0, 0, 800, 542);
		listarCategoriaIF = new ListarCategoria(iC);
		listarCategoriaIF.setBounds(0, 0, 800, 542);
		
		//Usuario
		UFactory fU = UFactory.getInstancia();
		IUsuario iU = fU.getIUsuario();
		
		altaUsuarioIF = new AltaUsuario(iU);
		altaUsuarioIF.setLocation(0, 0);
		
		listarUsuarioIF = new ListarUsuario(iU);
		listarUsuarioIF.setLocation(0, 0);
		
		consultaUsuarioIF = new ConsultaUsuario(iU);
		consultaUsuarioIF.setLocation(0, 0);
		
		//Video
		VFactory fV = VFactory.getInstancia();
		IVideo iV = fV.getIVideo();
		
		altaVideoIF = new AltaVideo(iU, iC, iV);
		listarUsuarioIF.setLocation(0, 0);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		
		setJMenuBar(menuBar);
		
		
		menuBar.add(mnUsuario);
		mntmAgregarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimpiarFrame();
				altaUsuarioIF.setVisible(true);
			}
		});
		
		
		mnUsuario.add(mntmAgregarUsuario);
		
		
		mnUsuario.add(mntmModificarUsuario);
		mntmListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimpiarFrame();
				listarUsuarioIF.cargarElementos(iU);
				listarUsuarioIF.setVisible(true);
			}
		});
		
		
		mnUsuario.add(mntmListarTodos);
		mntmConsultarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaUsuarioIF.cargarElementos(iU);
				consultaUsuarioIF.setVisible(true);
			}
		});
		
		
		mnUsuario.add(mntmConsultarUsuario);
		
		
		mnUsuario.add(mntmSeguir);
		
		
		mnUsuario.add(mntmDejarDeSeguir);
		
		
		menuBar.add(mnVideo);
		mntmAgregarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimpiarFrame();
				altaVideoIF.inicializar(iU, iC);
				altaVideoIF.setVisible(true);
				System.out.print("llego al final del boton");
			}
		});
		
		
		mnVideo.add(mntmAgregarVideo);
		
		
		mnVideo.add(mntmModificarVideo);
		
		
		mnVideo.add(mntmConsultarVideo);
		
		
		mnVideo.add(mntmComentar);
		
		
		mnVideo.add(mntmValorar);
		
		
		menuBar.add(mnListaDeReproduccion);
		
		
		mnListaDeReproduccion.add(mntmAgregarLista);
		
		
		mnListaDeReproduccion.add(mntmModificarLista);
		
		
		mnListaDeReproduccion.add(mntmConsultarLista);
		
		
		mnListaDeReproduccion.add(mntmAgregarVideoA);
		
		
		mnListaDeReproduccion.add(mntmQuitarVideoDe);
		
		
		menuBar.add(mnCategoria);
		
		
		mntmAgregarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimpiarFrame();
				altaCategoriaIF.setVisible(true);
			}
		});
		mnCategoria.add(mntmAgregarCategoria);
		mntmListarTodas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimpiarFrame();
				listarCategoriaIF.cargarElementos(iC);
				listarCategoriaIF.setVisible(true);
			}
		});
		
		
		mnCategoria.add(mntmListarTodas);
		
		
		mnCategoria.add(mntmConsultarCategoria);
		
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		contentPane.add(altaCategoriaIF);
		contentPane.add(listarCategoriaIF);
		
		contentPane.add(altaUsuarioIF);
		contentPane.add(listarUsuarioIF);
		contentPane.add(consultaUsuarioIF);
		
		contentPane.add(altaVideoIF);
		
		LimpiarFrame();
	}
}
