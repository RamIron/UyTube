package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JList;

import interfaces.ICategoria;
import interfaces.IUsuario;
import interfaces.IVideo;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import datatypes.DtComentario;
import datatypes.DtValoracion;
import datatypes.DtVideo;

import javax.swing.event.ListSelectionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ModificarVideo extends JInternalFrame { //TODO es una copia de alta video, faltan cosas

	private JList listaUsr = new JList();
	private JTextField nomVid = new JTextField();
	private JTextField duracion = new JTextField();
	private JTextField url = new JTextField();
	private JButton btnSeleccionarUsuario = new JButton("Seleccionar");
	private JScrollPane scrollPane = new JScrollPane();
	private JTextArea descripcion = new JTextArea();
	private JComboBox<Integer> fDia = new JComboBox<Integer>();
	private JComboBox<Integer> fMes = new JComboBox<Integer>();
	private JComboBox<Integer> fAnio = new JComboBox<Integer>();
	private JComboBox categoria = new JComboBox();
	private JList listaVid = new JList();
	private JButton btnSelecVid = new JButton("Seleccionar");
	private JCheckBox publico = new JCheckBox("");
	private DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Comentarios");
	private boolean esPublico = false;
	private JLabel lblMsgExiste = new JLabel("Ya existe un video con este nombre en el canal.");
	private JLabel lblMsgError = new JLabel("Error: falta completar algun campo.");
	private JLabel lblMsgExito = new JLabel("El video fue agregado con exito.");
	private JLabel lblMsgErrorUsr = new JLabel("Debe seleccionar un usuario");
	private JLabel lblMsgErrorNum = new JLabel("Deben ser numeros");
	private final JLabel lblMsgErrorVid = new JLabel("Debe seleccionar un video");
	private String vid = "";
	
	private IVideo iV;
	private IUsuario iU;
	private ICategoria iC;


	/**
	 * Create the frame.
	 */
	public ModificarVideo(IUsuario iU, ICategoria iC, IVideo iV) {
		
		this.iV = iV;
		this.iU = iU;
		this.iC = iC;
		setTitle("Modificar video");
		setBounds(100, 100, 800, 542);
		getContentPane().setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicializar();	
				((DefaultListModel) listaVid.getModel()).clear();
				listaVid.setEnabled(false);
				ModificarVideo.this.setVisible(false);
			}
		});
		btnSalir.setBounds(606, 476, 168, 25);
		getContentPane().add(btnSalir);
		
		JScrollPane scrollListaUsr = new JScrollPane();
		scrollListaUsr.setBounds(23, 26, 168, 190);
		getContentPane().add(scrollListaUsr);
		
		listaUsr  = new JList();
		DefaultListModel<String> listaU = new DefaultListModel<String>();
		listaUsr.setModel(listaU);
		scrollListaUsr.setViewportView(listaUsr);
		
		
		btnSeleccionarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reiniciarMsg();
				int i = listaUsr.getSelectedIndex();
				System.out.println(i);
				if(i < 0) {
					lblMsgErrorUsr.setVisible(true);
				}else {
					String usr = listaUsr.getModel().getElementAt(i).toString();
					((DefaultListModel) listaVid.getModel()).clear();
					List<String> videos = iV.listarVideosDeUsuario(usr);
					if(!videos.isEmpty()) {
						for(String v: videos) {
							((DefaultListModel) listaVid.getModel()).addElement(v);
						}
					}
					listaUsr.setEnabled(false);
					btnSeleccionarUsuario.setEnabled(false);
					
					listaVid.setEnabled(true);
					btnSelecVid.setEnabled(true);					
				}
			}
		});
		
		btnSeleccionarUsuario.setBounds(23, 229, 168, 25);
		getContentPane().add(btnSeleccionarUsuario);
		
		JLabel lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setBounds(76, 12, 58, 14);
		getContentPane().add(lblUsuarios);
		
		JScrollPane scrollListaVid = new JScrollPane();
		scrollListaVid.setBounds(201, 26, 168, 190);
		getContentPane().add(scrollListaVid);
		
		
		listaVid.setEnabled(false);
		listaVid.setModel(new DefaultListModel<String>());
		scrollListaVid.setViewportView(listaVid);
		
		JLabel lblVideos = new JLabel("Videos");
		lblVideos.setBounds(263, 12, 46, 14);
		getContentPane().add(lblVideos);
		btnSelecVid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = listaVid.getSelectedIndex();
				reiniciarMsg();
				if(i < 0) {
					lblMsgErrorVid.setVisible(true);
				}else {
					listaVid.setEnabled(false);
					btnSelecVid.setEnabled(false);
					String vid = listaVid.getModel().getElementAt(i).toString();
					DtVideo infoV = iV.obtenerInfoVideo(vid);
					nomVid.setText(infoV.getNombre());
					duracion.setText(infoV.getDuracion().toString());
					url.setText(infoV.getUrl());
					descripcion.setText(infoV.getDescripcion());
					fDia.setSelectedIndex(infoV.getfPublicacion().get(Calendar.DAY_OF_MONTH));
					fMes.setSelectedIndex(infoV.getfPublicacion().get(Calendar.MONTH));
					fAnio.setSelectedItem(infoV.getfPublicacion().get(Calendar.YEAR));
					if(infoV.getCategoria() == null) {
						categoria.setSelectedIndex(0);
					} else {
						categoria.setSelectedItem(infoV.getCategoria());					
					}
					publico.setSelected(infoV.getPublico());
					esPublico = infoV.getPublico();
					i = listaVid.getSelectedIndex();
					vid = listaVid.getModel().getElementAt(i).toString();
				}
				
			}
		});
		
		
		btnSelecVid.setEnabled(false);
		btnSelecVid.setBounds(201, 230, 168, 23);
		getContentPane().add(btnSelecVid);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(420, 14, 70, 15);
		getContentPane().add(lblNombre);
		
		nomVid = new JTextField();
		nomVid.setBounds(555, 11, 219, 19);
		getContentPane().add(nomVid);
		nomVid.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(420, 62, 107, 15);
		getContentPane().add(lblDescripcion);
		
		
		descripcion.setBounds(555, 58, 219, 63);
		getContentPane().add(descripcion);
		
		JLabel lblDuracion = new JLabel("Duracion (segundos)");
		lblDuracion.setBounds(420, 135, 149, 15);
		getContentPane().add(lblDuracion);
		
		duracion = new JTextField();
		duracion.setBounds(555, 132, 219, 19);
		getContentPane().add(duracion);
		duracion.setColumns(10);
		
		
		fDia.setBounds(572, 214, 49, 24);
		fDia.addItem(null);
		for(Integer i=1; i<=31; i++) {
			fDia.addItem(i);
		}
		getContentPane().add(fDia);
		
		
		fMes.setBounds(633, 214, 52, 24);
		fMes.addItem(null);
		for(Integer i=1; i<=12; i++) {
			fMes.addItem(i);
		}
		getContentPane().add(fMes);
		
		
		fAnio.setBounds(697, 214, 77, 24);
		fAnio.addItem(null);
		for(Integer i=1920; i<=2019; i++) {
			fAnio.addItem(i);
		}
		getContentPane().add(fAnio);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(420, 188, 70, 15);
		getContentPane().add(lblUrl);
		
		url = new JTextField();
		url.setBounds(555, 185, 219, 19);
		getContentPane().add(url);
		url.setColumns(10);
		
		JLabel lblFechaDePublicacion = new JLabel("Fecha de publicacion");
		lblFechaDePublicacion.setBounds(420, 218, 148, 15);
		getContentPane().add(lblFechaDePublicacion);
		
		
		categoria.setBounds(555, 249, 219, 24);
		getContentPane().add(categoria);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(420, 258, 70, 15);
		getContentPane().add(lblCategoria);
		
		JLabel lblVideoPublico = new JLabel("Video publico");
		lblVideoPublico.setBounds(420, 296, 98, 14);
		getContentPane().add(lblVideoPublico);
		publico.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				esPublico = ! esPublico;
			}
		});
		
		
		publico.setBounds(556, 291, 27, 23);
		getContentPane().add(publico);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reiniciarMsg();
				if(nomVid.getText().isEmpty() || duracion.getText().isEmpty() || url.getText().isEmpty() ||
					descripcion.getText().isEmpty() || fDia.equals(null) || fMes.equals(null) || fAnio.equals(null)) {
					lblMsgError.setVisible(true);
					lblMsgExiste.setVisible(true);
				}else if(!duracion.getText().chars().allMatch(Character::isDigit)){
					lblMsgErrorNum.setVisible(true);
				}else{
					Calendar fPub = Calendar.getInstance();
			        fPub.set((Integer) fAnio.getSelectedItem(), (Integer) fMes.getSelectedItem(), (Integer) fDia.getSelectedItem());
					iV.modificarInfoVideo(nomVid.getText(), descripcion.getText(), fPub, Integer.parseInt(duracion.getText()), url.getText(), esPublico);
					if(categoria.getSelectedIndex() != 0) {
						iV.agregarCategoria(categoria.getSelectedItem().toString());
					}
					inicializar();
					lblMsgExito.setVisible(true);
				}
			}
		});
		btnModificar.setBounds(428, 476, 168, 25);
		getContentPane().add(btnModificar);
		
		
		lblMsgExiste.setForeground(Color.RED);
		lblMsgExiste.setBounds(528, 32, 303, 15);
		getContentPane().add(lblMsgExiste);
		
		
		lblMsgError.setForeground(Color.RED);
		lblMsgError.setBounds(484, 443, 278, 15);
		getContentPane().add(lblMsgError);
		
		
		lblMsgExito.setForeground(new Color(124, 252, 0));
		lblMsgExito.setBounds(492, 443, 254, 15);
		getContentPane().add(lblMsgExito);
		lblMsgErrorUsr.setForeground(Color.RED);
		lblMsgErrorUsr.setBounds(33, 265, 149, 15);
		
		getContentPane().add(lblMsgErrorUsr);
		
		
		lblMsgErrorNum.setForeground(Color.RED);
		lblMsgErrorNum.setBounds(555, 159, 219, 15);
		getContentPane().add(lblMsgErrorNum);
		lblMsgErrorVid.setForeground(Color.RED);
		lblMsgErrorVid.setBounds(211, 264, 168, 14);
		
		getContentPane().add(lblMsgErrorVid);
		
	}
	public void cargarElementos() {
		List<String> usuarios = iU.listarUsuarios();
		DefaultListModel<String> listaU = new DefaultListModel<String>();
		int i = 0;
		for(String u: usuarios) {
			listaU.add(i++, u);
		}
		listaUsr.setModel(listaU);
	}
		
	
	public void cargarComentarios(String nomVid) {
		List<DtComentario> listaCom = iV.obtenerComentariosVideo(nomVid);
		for(DtComentario c: listaCom) {
			DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(c);
			cargarRespuestas(nodo, c.getRespuestas());
			raiz.add(nodo);
		}
	}
	
	public void cargarLeGusta(IVideo iV, String nomVid) {
		List<DtValoracion> listaVal = iV.obtenerValoracionVideo();
		DefaultListModel<String> listaU = new DefaultListModel<String>();
		int i = 0;
		for(DtValoracion v: listaVal) {
			if(!listaVal.isEmpty()) {
				if(v.getGusta()) {
					listaU.add(i++, v.getNickname());
				}
			}
		}	
	}
	
	public void cargarNoGusta(IVideo iV, String nomVid) {
		List<DtValoracion> listaVal = iV.obtenerValoracionVideo();
		DefaultListModel<String> listaU = new DefaultListModel<String>();
		int i = 0;
		for(DtValoracion v: listaVal) {
			if(!listaVal.isEmpty()) {
				if(!v.getGusta()) {
					listaU.add(i++, v.getNickname());
				}
			}
		}
	}
	
	public void cargarRespuestas(DefaultMutableTreeNode padre, List<DtComentario> com) {
		for(DtComentario c: com) {
			DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(c);
				cargarRespuestas(nodo, c.getRespuestas());	
			padre.add(nodo);
		}

	}
	
	public void limpiarLista() {	
		((DefaultListModel) listaVid.getModel()).clear();
		listaVid.setEnabled(false);
	    
	}
	
	public void limpiarForm() {
		btnSeleccionarUsuario.setEnabled(true);
		((DefaultListModel) listaUsr.getModel()).clear();
		listaUsr.setEnabled(true);
		btnSelecVid.setEnabled(false);
		nomVid.setText("");
		duracion.setText("");
		url.setText("");
		descripcion.setText("");
		fDia.setSelectedIndex(-1);
		fMes.setSelectedIndex(-1);
		fAnio.setSelectedIndex(-1);
		categoria.setSelectedIndex(-1);
	}
	
	public void cargarCategorias() {
		categoria.removeAllItems();
		List<String> categorias = iC.listarCategorias();
		categoria.addItem("<Sin categoria>");
		for(String c: categorias) {
			categoria.addItem(c);
		}
	}
	
	public void inicializar() {
		reiniciarMsg();
		cargarCategorias();
		limpiarLista();
		limpiarForm();
		cargarElementos();
	}
	
	public void cargarVideo(String nick, String vid) {
		this.vid = vid;
		iV.setUsr(nick);
		listaUsr.setEnabled(false);
		btnSeleccionarUsuario.setEnabled(false);
		listaVid.setEnabled(false);
		btnSelecVid.setEnabled(false);
		DtVideo infoV = iV.obtenerInfoVideo(vid);
		nomVid.setText(infoV.getNombre());
		duracion.setText(infoV.getDuracion().toString());
		url.setText(infoV.getUrl());
		descripcion.setText(infoV.getDescripcion());
		fDia.setSelectedIndex(infoV.getfPublicacion().get(Calendar.DAY_OF_MONTH));
		fMes.setSelectedIndex(infoV.getfPublicacion().get(Calendar.MONTH));
		fAnio.setSelectedItem(infoV.getfPublicacion().get(Calendar.YEAR));
		if(infoV.getCategoria() == null) {
			categoria.setSelectedIndex(0);
		}else {
			categoria.setSelectedItem(infoV.getCategoria());			
		}
		publico.setSelected(infoV.getPublico());
		cargarComentarios(vid);
	}
	
	public static boolean esNumero(String str) { 
		for (char c : str.toCharArray()){
	        if (!Character.isDigit(c)) {
	        	System.out.print("false");
	        	return false;
	        }
	    }
		System.out.print("true");
	    return true;

	}
	
	public void reiniciarMsg() {
		lblMsgExiste.setVisible(false);
		lblMsgError.setVisible(false);
		lblMsgExito.setVisible(false);
		lblMsgErrorUsr.setVisible(false);
		lblMsgErrorNum.setVisible(false);
		lblMsgErrorVid.setVisible(false);
	}
}
