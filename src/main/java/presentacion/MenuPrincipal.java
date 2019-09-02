package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

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
import javax.swing.JTabbedPane;

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
	private ConsultaCategoria consultaCategoriaIF;
	
	private AltaUsuario altaUsuarioIF;
	private ListarUsuario listarUsuarioIF;
	private ConsultaUsuario consultaUsuarioIF;
	private SeguirUsuario seguirUsuarioIF;
	private DejarSeguirUsuario dejarSeguirUsuarioIF;
	private ModificarUsuario modificarUsuarioIF;
	
	private AltaVideo altaVideoIF;
	private ConsultaVideo consultaVideoIF;
	private ComentarVideo comentarVideoIF; 
	private ValorarVideo valorarVideoIF;
	
	private AltaLista altaListaIF;
	private ModificarVideo modificarVideoIF;
	private AgregarVideoLista agregarVideoListaIF;
	private ModificarLista modificarListaIF;
	private QuitarVideoLista quitarVideoListaIF;
	
	private ConsultaListaRep consultarListaIF;
	
	private final JLabel fondo = new JLabel("");

	private final JLabel logo = new JLabel();

	/**
	 * @wbp.nonvisual location=87,-31
	 */
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	
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
		modificarListaIF.setVisible(false);
		consultarListaIF.setVisible(false);
		modificarUsuarioIF.setVisible(false);

	}
	
	/**
	 * Create the frame.
	 */
	/**
	 * 
	 */
	public MenuPrincipal() {
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
		consultaCategoriaIF = new ConsultaCategoria(iC);
		consultaCategoriaIF.setBounds(0, 0, 800, 542);
		
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
		

		consultarListaIF = new ConsultaListaRep(iU, iL, consultaVideoIF);
		consultarListaIF.setLocation(0, 0);

		agregarVideoListaIF = new AgregarVideoLista(iV, iU, iL);
		agregarVideoListaIF.setLocation(0, 0);

		
		quitarVideoListaIF = new QuitarVideoLista(iV, iU, iL);
		quitarVideoListaIF.setLocation(0, 0);
		
		modificarListaIF = new ModificarLista(iU, iL, iC);
		modificarListaIF.setLocation(0, 0);
		
		//Usuario
		altaUsuarioIF = new AltaUsuario(iU);
		altaUsuarioIF.setLocation(0, 0);
		
		listarUsuarioIF = new ListarUsuario(iU);
		listarUsuarioIF.setLocation(0, 0);
		
		consultaUsuarioIF = new ConsultaUsuario(iU, iV, iL, consultaVideoIF, consultarListaIF);
		consultaUsuarioIF.setLocation(0, 0);
		
		seguirUsuarioIF = new SeguirUsuario(iU);
		seguirUsuarioIF.setLocation(0, 0);
		
		dejarSeguirUsuarioIF = new DejarSeguirUsuario(iU);
		dejarSeguirUsuarioIF.setLocation(0, 0);
		
		modificarUsuarioIF = new ModificarUsuario(iU, iV, iL, modificarVideoIF, modificarListaIF);
		modificarUsuarioIF.setLocation(0, 0);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 620);
		
		
		setJMenuBar(menuBar);
		
		
		menuBar.add(mnUsuario);
		mntmAgregarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimpiarFrame();
				altaUsuarioIF.setVisible(true);
			}
		});
		
		
		mnUsuario.add(mntmAgregarUsuario);
		mntmModificarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LimpiarFrame();
				modificarUsuarioIF.inicializar(iU);
				modificarUsuarioIF.setVisible(true);
			}
		});
		
		
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
		mntmModificarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimpiarFrame();
				modificarListaIF.inicializar();
				modificarListaIF.setVisible(true);
			}
		});
		
		mnListaDeReproduccion.add(mntmModificarLista);
		mntmConsultarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LimpiarFrame();
				consultarListaIF.inicializar();
				consultarListaIF.setVisible(true);
			}
		});
		

		//Agregar Video de Lista de Reproduccion//////////
		mnListaDeReproduccion.add(mntmConsultarLista);
		mntmAgregarVideoA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimpiarFrame();
				agregarVideoListaIF.inicializar();
				agregarVideoListaIF.setVisible(true);
			}
		});
		mnListaDeReproduccion.add(mntmAgregarVideoA);
		///////////////////////////////////////////////////
		
		//Quitar Video de Lista de Reproduccion////////////
		mntmQuitarVideoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimpiarFrame();
				quitarVideoListaIF.inicializar();
				quitarVideoListaIF.setVisible(true);
			}
		});
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
		
		mntmConsultarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimpiarFrame();
				consultaCategoriaIF.setVisible(true);
				consultaCategoriaIF.inicializar(iC);
			}
		});
		
		mnCategoria.add(mntmConsultarCategoria);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		contentPane.add(altaCategoriaIF);
		contentPane.add(listarCategoriaIF);
		contentPane.add(consultaCategoriaIF);
		
		contentPane.add(altaUsuarioIF);
		contentPane.add(listarUsuarioIF);
		contentPane.add(consultaUsuarioIF);
		contentPane.add(seguirUsuarioIF);
		contentPane.add(dejarSeguirUsuarioIF);
		contentPane.add(modificarUsuarioIF);
		
		contentPane.add(altaVideoIF);
		contentPane.add(consultaVideoIF);
		contentPane.add(comentarVideoIF);
		contentPane.add(valorarVideoIF);
		contentPane.add(modificarVideoIF);
		
		contentPane.add(altaListaIF);
		contentPane.add(consultarListaIF);
		contentPane.add(agregarVideoListaIF);
		contentPane.add(modificarListaIF);
		contentPane.add(quitarVideoListaIF);

		
//		logo.setBounds(140, 300, 616, 225);
//		contentPane.add(logo);
//		logo.setIcon(new ImageIcon("src/main/resources/img/logo.png"));
//		fondo.setIcon(new ImageIcon("src/main/resources/img/fondo.jpg"));
//		fondo.setBounds(0, 0, 800, 550);

		ImageIcon imgLogo = new ImageIcon("src/main/resources/img/logo.png");
		logo.setBounds(250, 80, 493, 180);
		logo.setIcon(new ImageIcon(imgLogo.getImage().getScaledInstance(493, 180, Image.SCALE_SMOOTH)));
		
		fondo.setIcon(new ImageIcon("src/main/resources/img/fondo.jpg"));
		fondo.setBounds(0, 0, 1024, 576);

		contentPane.add(logo);
		contentPane.add(fondo);

		
		LimpiarFrame();
	}
}