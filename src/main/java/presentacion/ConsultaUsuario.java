package presentacion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import interfaces.IListaReproduccion;
import interfaces.IUsuario;
import interfaces.IVideo;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.event.ListSelectionListener;

import datatypes.*;

import javax.swing.event.ListSelectionEvent;

public class ConsultaUsuario extends JInternalFrame {

	private JList listaUsr;
	private JTextField nick;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField email;
	private JTextField nomCanal;
	private Boolean agregarFoto = false;
	private Boolean agregarNomCanal = false;
	private Boolean publico = false;
	private JComboBox<Integer> fDia = new JComboBox<Integer>();
	private JComboBox <Integer>fMes = new JComboBox<Integer>();
	private JComboBox<Integer> fAnio = new JComboBox<Integer>();
	private JTextPane desCanal = new JTextPane();
	private JCheckBox chckbxCanalPublico = new JCheckBox("");
	private final JLabel lblImagen = new JLabel("");
	private JButton btnSelecFoto = new JButton("Seleccionar");
	private final JScrollPane scrollDescCanal = new JScrollPane();
	private JList listaSeguidores = new JList();
	private JList listaSeguidos = new JList();
	private JLabel img = new JLabel("");
	private JList listaVid = new JList();
	private JList listaLisRep = new JList();
	
	
	private ConsultaVideo cvIF;

	/**
	 * Create the frame.
	 */
	public ConsultaUsuario(IUsuario iU, IVideo iV, IListaReproduccion iL, ConsultaVideo cvIF) {
		
//		limpiarLista();
//		resetearFormulario();
		
		this.cvIF = cvIF;
		
		setRootPaneCheckingEnabled(false);
		setTitle("Consultar usuario");
		setBounds(100, 100, 800, 542);
		getContentPane().setLayout(null);
		ConsultaUsuario.this.setVisible(false);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarLista();
				ConsultaUsuario.this.setVisible(false);
			}
		});
		btnSalir.setBounds(201, 209, 168, 25);
		getContentPane().add(btnSalir);
		

		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(391, 51, 70, 15);
		getContentPane().add(lblNickname);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(391, 74, 70, 15);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(391, 97, 70, 15);
		getContentPane().add(lblApellido);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(391, 120, 70, 15);
		getContentPane().add(lblEmail);
		
		JLabel lblFechaDeNacimento = new JLabel("Fecha de nacimento");
		lblFechaDeNacimento.setBounds(391, 147, 148, 15);
		getContentPane().add(lblFechaDeNacimento);
		
		nick = new JTextField();
		nick.setEnabled(false);
		nick.setBounds(552, 49, 202, 19);
		getContentPane().add(nick);
		nick.setColumns(10);
		
		nombre = new JTextField();
		nombre.setEnabled(false);
		nombre.setBounds(552, 72, 202, 19);
		getContentPane().add(nombre);
		nombre.setColumns(10);
		
		apellido = new JTextField();
		apellido.setEnabled(false);
		apellido.setBounds(552, 95, 202, 19);
		getContentPane().add(apellido);
		apellido.setColumns(10);
		
		email = new JTextField();
		email.setEnabled(false);
		email.setBounds(552, 118, 202, 19);
		getContentPane().add(email);
		email.setColumns(10);
		fDia.setEnabled(false);

		
		
		
		
		fDia.setBounds(552, 142, 49, 24);
		fDia.addItem(null);
		for(Integer i=1; i<=31; i++) {
			fDia.addItem(i);
		}
		getContentPane().add(fDia);
		fMes.setEnabled(false);
		
		
		fMes.setBounds(613, 142, 52, 24);
		fMes.addItem(null);
		for(Integer i=1; i<=12; i++) {
			fMes.addItem(i);
		}
		getContentPane().add(fMes);
		fAnio.setEnabled(false);
		
		
		fAnio.setBounds(677, 142, 77, 24);
		fAnio.addItem(null);
		for(Integer i=1920; i<=2019; i++) {
			fAnio.addItem(i);
		}
		getContentPane().add(fAnio);
		
		JLabel lblNombreDelCanal = new JLabel("Nombre");
		lblNombreDelCanal.setBounds(391, 373, 148, 15);
		getContentPane().add(lblNombreDelCanal);
		
		nomCanal = new JTextField();
		nomCanal.setEnabled(false);
		nomCanal.setBounds(547, 373, 207, 19);
		getContentPane().add(nomCanal);
		nomCanal.setColumns(10);
		
		JLabel lblDescripcionDelCanal = new JLabel("Descripcion");
		lblDescripcionDelCanal.setBounds(391, 424, 200, 15);
		getContentPane().add(lblDescripcionDelCanal);
		chckbxCanalPublico.setEnabled(false);
		
		chckbxCanalPublico.setBounds(725, 400, 29, 23);
		getContentPane().add(chckbxCanalPublico);
		scrollDescCanal.setBounds(391, 441, 363, 57);
		
		getContentPane().add(scrollDescCanal);
		desCanal.setEnabled(false);
		scrollDescCanal.setViewportView(desCanal);
		
		JLabel lblInfoCanal = new JLabel("Informacion del Canal");
		lblInfoCanal.setFont(new Font("Dialog", Font.BOLD, 14));
		lblInfoCanal.setBounds(391, 337, 202, 27);
		getContentPane().add(lblInfoCanal);
		
		JLabel lblInfoUsuario = new JLabel("Informacion del Usuario");
		lblInfoUsuario.setFont(new Font("Dialog", Font.BOLD, 14));
		lblInfoUsuario.setBounds(391, 12, 202, 27);
		getContentPane().add(lblInfoUsuario);
		
		JLabel lblPublico = new JLabel("Publico");
		lblPublico.setBounds(391, 399, 70, 15);
		getContentPane().add(lblPublico);
		
		JButton btnSeleccionarUsuario = new JButton("Seleccionar");
		btnSeleccionarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iU.limpiarControlador();
				resetearFormulario();
				int i = listaUsr.getSelectedIndex();
				String usr = listaUsr.getModel().getElementAt(i).toString();
				DtUsuario infoU = iU.obtenerInfoUsuario(usr);
				DtCanal infoC =iU.obtenerInfoCanal();
				
				//INFO USUARIO
				nick.setText(infoU.getNickname());
				nombre.setText(infoU.getNombre());
				apellido.setText(infoU.getApellido());
				email.setText(infoU.getCorreoE());
				fDia.setSelectedIndex(infoU.getfNac().get(Calendar.DAY_OF_MONTH));
				fMes.setSelectedIndex(infoU.getfNac().get(Calendar.MONTH));
				fAnio.setSelectedItem(infoU.getfNac().get(Calendar.YEAR));
				try {
					mostrarImg(infoU.getImagen());
				} catch (Exception e1) {
					e1.printStackTrace();
				}					

				
				//INFO CANAL
				nomCanal.setText(infoC.getNombre());
				desCanal.setText(infoC.getDescripcion());
				System.out.println(infoC.getDescripcion());
				chckbxCanalPublico.setSelected(infoC.getPublico());
				
				//SEGUIDORES
				List<String> seguidores = iU.listarSeguidores();
				if(!seguidores.isEmpty()) {
					for(String u: seguidores) {
						((DefaultListModel) listaSeguidores.getModel()).addElement(u);
					}					
				}
				
				//SEGUIDOS
				List<String> seguidos = iU.listarSeguidos();
				if(!seguidos.isEmpty()) {
					for(String u: seguidos) {
						((DefaultListModel) listaSeguidos.getModel()).addElement(u);
					}					
				}
				
				//VIDEOS
				List<String> videos = iV.listarVideosDeUsuario(usr);
				if(!videos.isEmpty()) {
					for(String v: videos) {
						((DefaultListModel) listaVid.getModel()).addElement(v);
					}
				}
				
				//LISTAS DE REPRODUCCION
				List<String> listasRep = iL.listarListasDeUsuario(usr);
				if(!listasRep.isEmpty()) {
					for(String lP: listasRep) {
						((DefaultListModel) listaLisRep.getModel()).addElement(lP);
					}
				}
			}
		});
		btnSeleccionarUsuario.setBounds(23, 209, 168, 25);
		getContentPane().add(btnSeleccionarUsuario);
		
		JScrollPane scrollSeguidores = new JScrollPane();
		scrollSeguidores.setBounds(586, 217, 168, 108);
		getContentPane().add(scrollSeguidores);
		
		DefaultListModel<String> listaS1 = new DefaultListModel<String>();
		listaSeguidores.setModel(listaS1);
		scrollSeguidores.setViewportView(listaSeguidores);
		
		JScrollPane scrollSeguidos = new JScrollPane();
		scrollSeguidos.setBounds(391, 217, 168, 108);
		getContentPane().add(scrollSeguidos);
		
		DefaultListModel<String> listaS2 = new DefaultListModel<String>();
		listaSeguidos.setModel(listaS2);
		scrollSeguidos.setViewportView(listaSeguidos);
		
		JLabel lblSeguidos = new JLabel("Seguidos");
		lblSeguidos.setBounds(443, 190, 70, 15);
		getContentPane().add(lblSeguidos);
		
		JLabel lblSeguidores = new JLabel("Seguidores");
		lblSeguidores.setBounds(629, 190, 98, 15);
		getContentPane().add(lblSeguidores);
		
		
		try {
		mostrarImg("src/main/resources/img/default.png");
		img.setBounds(230, 51, 120, 120);
		} catch (IOException e1) {
			
			e1.printStackTrace();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		getContentPane().add(img);
		
		JScrollPane scrollVid = new JScrollPane();
		scrollVid.setBounds(23, 276, 138, 187);
		getContentPane().add(scrollVid);
		
		DefaultListModel<String> listaV = new DefaultListModel<String>();
		listaVid.setModel(listaV);
		scrollVid.setViewportView(listaVid);
		
		JScrollPane scrollLisRep = new JScrollPane();
		scrollLisRep.setBounds(188, 277, 138, 187);
		getContentPane().add(scrollLisRep);
		
		DefaultListModel<String> listaL = new DefaultListModel<String>();
		listaLisRep.setModel(listaL);
		scrollLisRep.setViewportView(listaLisRep);
		
		JLabel lblVideos = new JLabel("Videos");
		lblVideos.setBounds(70, 261, 49, 15);
		getContentPane().add(lblVideos);
		
		JLabel lblListasDeReproduccion = new JLabel("Listas");
		lblListasDeReproduccion.setBounds(241, 261, 39, 15);
		getContentPane().add(lblListasDeReproduccion);
		
		JScrollPane scrollListaUsr = new JScrollPane();
		scrollListaUsr.setBounds(23, 17, 168, 179);
		getContentPane().add(scrollListaUsr);
		
		listaUsr  = new JList();
		listaUsr.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
			}
		});
		scrollListaUsr.setViewportView(listaUsr);
		
		JButton btnSelecVideo = new JButton("Seleccionar");
		btnSelecVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = listaUsr.getSelectedIndex();
				String usr = listaUsr.getModel().getElementAt(i).toString();
				i = listaVid.getSelectedIndex();
				String vid = listaVid.getModel().getElementAt(i).toString();
				cvIF.inicializar();
				cvIF.cargarVideo(usr, vid);
				ConsultaUsuario.this.setVisible(false);
				cvIF.setVisible(true);
				
			}
		});
		btnSelecVideo.setBounds(23, 475, 138, 23);
		getContentPane().add(btnSelecVideo);
		
		JButton btnSelecLista = new JButton("Seleccionar");
		btnSelecLista.setBounds(188, 475, 138, 23);
		getContentPane().add(btnSelecLista);

	}
	
	public void cargarElementos(IUsuario iU) {
		List<String> usuarios = iU.listarUsuarios();
		DefaultListModel<String> listaU = new DefaultListModel<String>();
		int i = 0;
		for(String u: usuarios) {
			listaU.add(i++, u);
		}
		listaUsr.setModel(listaU);
	}
	
	public void limpiarLista() {
		((DefaultListModel) listaUsr.getModel()).clear();
	}
	
	public void resetearFormulario() {
		nick.setText("");
		nombre.setText("");
		apellido.setText("");
		email.setText("");
		nomCanal.setText("");
		img.setText("");
		fDia.setSelectedIndex(0);
		fMes.setSelectedIndex(0);
		fAnio.setSelectedIndex(0);
		desCanal.setText("");
		agregarFoto = false;
		agregarNomCanal = false;
		publico = false;
		chckbxCanalPublico = new JCheckBox("Canal Publico");
		nomCanal.setEnabled(false);
		lblImagen.setIcon(null);
		((DefaultListModel) listaSeguidores.getModel()).clear();
		((DefaultListModel) listaSeguidos.getModel()).clear();
		((DefaultListModel) listaVid.getModel()).clear();
		((DefaultListModel) listaLisRep.getModel()).clear();
	}
	
	
	
	public void mostrarImg(final String filename) throws Exception
	  {
	    SwingUtilities.invokeLater(new Runnable()
	    {
	      public void run()
	      {
	                
	        BufferedImage image = null;
	        try
	        {
	          image = ImageIO.read(new File(filename));
	        }
	        catch (Exception e)
	        {
	          e.printStackTrace();
	          System.exit(1);
	        }
	        ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(120, 120, Image.SCALE_FAST));
	        img.setIcon(imageIcon);


	      }
	    });
	  }
}