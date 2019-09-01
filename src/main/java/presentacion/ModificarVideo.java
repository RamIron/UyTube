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
import javax.swing.event.ListSelectionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ModificarVideo extends JInternalFrame { //TODO es una copia de alta video, faltan cosas

	private JList listaUsr;
	private String usr = "";
	private JTextField nomVid;
	private JTextField duracion;
	private JTextField url;
	private JButton btnSelecUsr = new JButton("Seleccionar Usuario");
	private JScrollPane scrollPane = new JScrollPane();
	private JTextArea descripcion = new JTextArea();
	private JComboBox<Integer> fDia = new JComboBox<Integer>();
	private JComboBox<Integer> fMes = new JComboBox<Integer>();
	private JComboBox<Integer> fAnio = new JComboBox<Integer>();
	private JCheckBox chckbxVideoPublico = new JCheckBox("Video publico");
	private JComboBox categoria = new JComboBox();
	private JButton btnAgregar = new JButton("Agregar");
	private JLabel lblMsgExiste = new JLabel("Ya existe un video con este nombre.");
	private JLabel lblMsgError = new JLabel("Error: falta completar algun campo.");
	private JLabel lblMsgExito = new JLabel("El video fue agregado con exito.");
	private JLabel lblMsgErrorUsr = new JLabel("Debe seleccionar un usuario");
	private final JLabel lblListaDeUsuarios = new JLabel("Lista de Usuarios");
	private Boolean videoPublico = false;

	/**
	 * Create the frame.
	 */
	public ModificarVideo(IUsuario iU, ICategoria iC, IVideo iV) {
		
//		inicializar(iU, iC);
		
		setTitle("Agregar un video");
		setBounds(0, 0, 800, 542);
		ModificarVideo.this.setVisible(false);
		getContentPane().setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(629, 473, 117, 25);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarVideo.this.setVisible(false);
			}
		});
		getContentPane().add(btnSalir);
		
		btnSelecUsr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reiniciarMsg();
				if(usr.isEmpty()) {
					lblMsgErrorUsr.setVisible(true);
				}else {
					habilitarFormUsr(false);
					habilitarFormVid(true);
					if(iU.esCanalPublico(usr)) {
						chckbxVideoPublico.setEnabled(true);
					}
				}
			}
		});
		
		
		btnSelecUsr.setBounds(36, 438, 198, 25);
		getContentPane().add(btnSelecUsr);
		
		
		scrollPane.setBounds(36, 50, 198, 345);
		getContentPane().add(scrollPane);
		
		listaUsr  = new JList();
		scrollPane.setViewportView(listaUsr);
		listaUsr.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int i = listaUsr.getSelectedIndex();
				usr = listaUsr.getModel().getElementAt(i).toString();
			}
		});
		listaUsr.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(282, 50, 70, 15);
		getContentPane().add(lblNombre);
		
		nomVid = new JTextField();
		nomVid.setBounds(449, 48, 313, 19);
		getContentPane().add(nomVid);
		nomVid.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(282, 97, 107, 15);
		getContentPane().add(lblDescripcion);
		
		
		descripcion.setBounds(449, 97, 313, 63);
		getContentPane().add(descripcion);
		
		JLabel lblDuracion = new JLabel("Duracion (segundos)");
		lblDuracion.setBounds(282, 203, 149, 15);
		getContentPane().add(lblDuracion);
		
		duracion = new JTextField();
		duracion.setBounds(449, 201, 313, 19);
		getContentPane().add(duracion);
		duracion.setColumns(10);
		
		
		fDia.setBounds(449, 302, 49, 24);
		fDia.addItem(null);
		for(Integer i=1; i<=31; i++) {
			fDia.addItem(i);
		}
		getContentPane().add(fDia);
		
		
		fMes.setBounds(510, 302, 52, 24);
		fMes.addItem(null);
		for(Integer i=1; i<=12; i++) {
			fMes.addItem(i);
		}
		getContentPane().add(fMes);
		
		
		fAnio.setBounds(574, 302, 77, 24);
		fAnio.addItem(null);
		for(Integer i=1920; i<=2019; i++) {
			fAnio.addItem(i);
		}
		getContentPane().add(fAnio);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(282, 257, 70, 15);
		getContentPane().add(lblUrl);
		
		url = new JTextField();
		url.setBounds(449, 255, 313, 19);
		getContentPane().add(url);
		url.setColumns(10);
		
		JLabel lblFechaDePublicacion = new JLabel("Fecha de publicacion");
		lblFechaDePublicacion.setBounds(282, 307, 148, 15);
		getContentPane().add(lblFechaDePublicacion);
		chckbxVideoPublico.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				videoPublico = ! videoPublico;
			}
		});
		
		
		chckbxVideoPublico.setBounds(449, 407, 129, 23);
		getContentPane().add(chckbxVideoPublico);
		
		
		categoria.setBounds(449, 354, 313, 24);
		getContentPane().add(categoria);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(282, 359, 70, 15);
		getContentPane().add(lblCategoria);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reiniciarMsg();
				if(nomVid.getText().isEmpty() || duracion.getText().isEmpty() || url.getText().isEmpty() ||
					descripcion.getText().isEmpty() || fDia.equals(null) || fMes.equals(null) || fAnio.equals(null)) {
					lblMsgError.setVisible(true);
				}else if(iV.existeVideo(usr, nomVid.getText())) {
					lblMsgExiste.setVisible(true);
				}else {
					Calendar fPub = Calendar.getInstance();
			        fPub.set((Integer) fAnio.getSelectedItem(), (Integer) fMes.getSelectedItem(), (Integer) fDia.getSelectedItem());
					iV.agregarVideo(usr, nomVid.getText(), descripcion.getText(), fPub, Integer.parseInt(duracion.getText()), url.getText());
					//TODO falta el tema de la privacidad en el constructor
					
					if(categoria.getSelectedIndex() != 0) {
						iV.agregarCategoria(categoria.getSelectedItem().toString());
					}
					inicializar(iU, iC);
					lblMsgExito.setVisible(true);
				}
			}
		});
		
		
		btnAgregar.setBounds(474, 473, 117, 25);
		getContentPane().add(btnAgregar);
		
		
		lblMsgExiste.setForeground(Color.RED);
		lblMsgExiste.setBounds(459, 70, 303, 15);
		getContentPane().add(lblMsgExiste);
		
		
		lblMsgError.setForeground(Color.RED);
		lblMsgError.setBounds(484, 443, 278, 15);
		getContentPane().add(lblMsgError);
		
		
		lblMsgExito.setForeground(new Color(124, 252, 0));
		lblMsgExito.setBounds(492, 443, 254, 15);
		getContentPane().add(lblMsgExito);
		lblMsgErrorUsr.setForeground(Color.RED);
		lblMsgErrorUsr.setBounds(36, 407, 219, 15);
		
		getContentPane().add(lblMsgErrorUsr);
		lblListaDeUsuarios.setBounds(70, 24, 137, 15);
		
		getContentPane().add(lblListaDeUsuarios);

	}
	
	public void cargarUsuarios(IUsuario iU) {
		List<String> usuarios = iU.listarUsuarios();
		DefaultListModel<String> listaU = new DefaultListModel<String>();
		int i = 0;
		for(String u: usuarios) {
			listaU.add(i++, u);
		}
		listaUsr.setModel(listaU);
	}
	
	public void cargarCategorias(ICategoria iC) {
		List<String> categorias = iC.listarCategorias();
		categoria.addItem("<Sin categoria>");
		for(String c: categorias) {
			categoria.addItem(c);
		}
	}
	
	public void limpiarListas() {
		DefaultListModel<String> listaU = new DefaultListModel<String>();
		listaUsr.setModel(listaU);
		categoria.removeAllItems();
	}
	
	public void habilitarFormVid(Boolean flag) {
		
		nomVid.setEnabled(flag);
		duracion.setEnabled(flag);
		url.setEnabled(flag);
		descripcion.setEnabled(flag);
		fDia.setEnabled(flag);
		fMes.setEnabled(flag);
		fAnio.setEnabled(flag);
		chckbxVideoPublico.setEnabled(false);
		categoria.setEnabled(flag);
		btnAgregar.setEnabled(flag);
		
	}
	
	public void habilitarFormUsr(Boolean flag) {
		listaUsr.setEnabled(flag);
		btnSelecUsr.setEnabled(flag);
	}
	
	public void reiniciarMsg() {
		lblMsgExiste.setVisible(false);
		lblMsgError.setVisible(false);
		lblMsgExito.setVisible(false);
		lblMsgErrorUsr.setVisible(false);
	}
	
	public void reiniciarVal() {
		nomVid.setText("");
		duracion.setText("");
		url.setText("");
		descripcion.setText("");
		fDia.setSelectedIndex(-1);
		fMes.setSelectedIndex(-1);
		fAnio.setSelectedIndex(-1);
		chckbxVideoPublico.setSelected(false);
		categoria.setSelectedIndex(-1);
		usr = "";
	}
	
	public void inicializar(IUsuario iU, ICategoria iC) {
		videoPublico = false;
		reiniciarVal();
		reiniciarMsg();
		limpiarListas();
		cargarUsuarios(iU);
		cargarCategorias(iC);
		habilitarFormUsr(true);
		habilitarFormVid(false);
		
	}
}
