package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionEvent;

import interfaces.*;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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
	private SeguirUsuario seguirUsuarioIF;
	private DejarSeguirUsuario dejarSeguirUsuarioIF;
	
	private AltaVideo altaVideoIF;
	private ConsultaVideo consultaVideoIF;
	private ComentarVideo comentarVideoIF; 
	private ValorarVideo valorarVideoIF;
	private ModificarVideo modificarVideoIF;
	
	private AltaLista altaListaIF;
	private ConsultaListaRep consultarListaIF;
	
	private final JLabel fondo = new JLabel("");
	private final JLabel logo = new JLabel("");
	
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
		consultaUsuarioIF.setVisible(false);
		consultaVideoIF.setVisible(false);
		comentarVideoIF.setVisible(false);
		valorarVideoIF.setVisible(false);
		altaListaIF.setVisible(false);
		modificarVideoIF.setVisible(false);
		seguirUsuarioIF.setVisible(false);
		dejarSeguirUsuarioIF.setVisible(false);
		consultarListaIF.setVisible(false);
	}
	
	/**
	 * Create the frame.
	 */
	/**
	 * 
	 */
	public MenuPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Martin\\Desktop\\UyTube\\src\\main\\resources\\img\\logo.png"));
		setTitle("UyTube");
		CFactory fC = CFactory.getInstancia();
		ICategoria iC = fC.getICategoria();
		
		VFactory fV = VFactory.getInstancia();
		IVideo iV = fV.getIVideo();
		
		UFactory fU = UFactory.getInstancia();
		IUsuario iU = fU.getIUsuario();
		
		LRFactory fL = LRFactory.getInstancia();
		IListaReproduccion iL = fL.getIListaReproduccion(); 

		//Categoria
		altaCategoriaIF = new AltaCategoria(iC);
		altaCategoriaIF.setBounds(0, 0, 800, 542);
		listarCategoriaIF = new ListarCategoria(iC);
		listarCategoriaIF.setBounds(0, 0, 800, 542);
		
		//Video
		altaVideoIF = new AltaVideo(iU, iC, iV);
		altaVideoIF.setLocation(0, 0);
		
		comentarVideoIF = new ComentarVideo(iU, iV);
		comentarVideoIF.setLocation(0, 0);
		
		consultaVideoIF = new ConsultaVideo(iU, iV, iC);
		consultaVideoIF.setLocation(0, 0);
		
		valorarVideoIF = new ValorarVideo(iV, iU);
		valorarVideoIF.setLocation(0, 0);
		
		modificarVideoIF = new ModificarVideo(iU, iC, iV);
		modificarVideoIF.setLocation(0, 0);
		
		//Lista
		altaListaIF = new AltaLista(iU, iC, iL);
		altaVideoIF.setLocation(0, 0);
		
		consultarListaIF = new ConsultaListaRep(iU, iV, iC, iL);
		consultarListaIF.setLocation(0, 0);
		
		//Usuario
		altaUsuarioIF = new AltaUsuario(iU);
		altaUsuarioIF.setLocation(0, 0);
		
		listarUsuarioIF = new ListarUsuario(iU);
		listarUsuarioIF.setLocation(0, 0);
		
		consultaUsuarioIF = new ConsultaUsuario(iU, iV, iL, consultaVideoIF);
		consultaUsuarioIF.setLocation(0, 0);
		
		seguirUsuarioIF = new SeguirUsuario(iU);
		seguirUsuarioIF.setLocation(0, 0);
		
		dejarSeguirUsuarioIF = new DejarSeguirUsuario(iU);
		dejarSeguirUsuarioIF.setLocation(0, 0);
		
		
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
				LimpiarFrame();
				consultaUsuarioIF.cargarElementos(iU);
				consultaUsuarioIF.setVisible(true);
			}
		});
		
		
		mnUsuario.add(mntmConsultarUsuario);
		mntmSeguir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LimpiarFrame();
				seguirUsuarioIF.inicializar(iU);
				seguirUsuarioIF.setVisible(true);
			}
		});
		
		
		mnUsuario.add(mntmSeguir);
		mntmDejarDeSeguir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			LimpiarFrame();
			dejarSeguirUsuarioIF.inicializar(iU);
			dejarSeguirUsuarioIF.setVisible(true);
			}
		});
		
		
		mnUsuario.add(mntmDejarDeSeguir);
		
		
		menuBar.add(mnVideo);
		mntmAgregarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimpiarFrame();
				altaVideoIF.inicializar(iU, iC);
				altaVideoIF.setVisible(true);
			}
		});
		
		
		mnVideo.add(mntmAgregarVideo);
		mntmModificarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LimpiarFrame();
				modificarVideoIF.inicializar();
				modificarVideoIF.setVisible(true);
			}
		});
		
		
		mnVideo.add(mntmModificarVideo);
		mntmConsultarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimpiarFrame();
				consultaVideoIF.inicializar();
				consultaVideoIF.setVisible(true);
			}
		});
		
		
		mnVideo.add(mntmConsultarVideo);
		mntmComentar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimpiarFrame();
				comentarVideoIF.inicializar(iU);
				comentarVideoIF.setVisible(true);
			}
		});
		
		
		mnVideo.add(mntmComentar);
		mntmValorar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimpiarFrame();
				valorarVideoIF.inicializar(iU);
				valorarVideoIF.setVisible(true);
			}
		});
		
		
		mnVideo.add(mntmValorar);
		
		
		menuBar.add(mnListaDeReproduccion);
		mntmAgregarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimpiarFrame();
				altaListaIF.inicializar(iU, iC);
				altaListaIF.setVisible(true);
			}
		});
		
		
		mnListaDeReproduccion.add(mntmAgregarLista);
		
		
		mnListaDeReproduccion.add(mntmModificarLista);
		mntmConsultarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LimpiarFrame();
				consultarListaIF.inicializar();
				consultarListaIF.setVisible(true);
			}
		});
		
		
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
		contentPane.add(seguirUsuarioIF);
		contentPane.add(dejarSeguirUsuarioIF);
		
		contentPane.add(altaVideoIF);
		contentPane.add(consultaVideoIF);
		contentPane.add(comentarVideoIF);
		contentPane.add(valorarVideoIF);
		contentPane.add(modificarVideoIF);
		
		contentPane.add(altaListaIF);
		contentPane.add(consultarListaIF);
		
		logo.setBounds(140, 300, 616, 225);
		contentPane.add(logo);
		logo.setIcon(new ImageIcon("src/main/resources/img/logo.png"));
		fondo.setIcon(new ImageIcon("src/main/resources/img/fondo.jpg"));
		fondo.setBounds(0, 0, 800, 550);
		
		contentPane.add(fondo);
		
		LimpiarFrame();
	}
}