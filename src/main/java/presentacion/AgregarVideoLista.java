package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import datatypes.DtComentario;
import datatypes.DtValoracion;
import datatypes.DtVideo;
import interfaces.IListaReproduccion;
import interfaces.IUsuario;
import interfaces.IVideo;

public class AgregarVideoLista extends JInternalFrame {
	private JList listaUsrV;
	private JButton btnSelecUsrV = new JButton("Seleccionar");
	private JScrollPane scrollPane = new JScrollPane();
	private JList listaVid = new JList();
	private JButton btnSelecVid = new JButton("Seleccionar");
	private DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Comentarios");
	private IVideo iV;
	private IUsuario iU;
	private IListaReproduccion iL;
	
	public AgregarVideoLista(IVideo iV, IUsuario iU, IListaReproduccion iL) {
		this.iV = iV;
		this.iU = iU;
		this.iL = iL;
		setTitle("Agregar video a Lista de Reproduccion");
		setBounds(100, 100, 800, 542);
		getContentPane().setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarVideoLista.this.setVisible(false);
			}
		});
		btnSalir.setBounds(606, 476, 168, 25);
		getContentPane().add(btnSalir);
		
		JScrollPane scrollListaUsr = new JScrollPane();
		scrollListaUsr.setBounds(23, 26, 168, 190);
		getContentPane().add(scrollListaUsr);
		
		listaUsrV  = new JList();
		DefaultListModel<String> listaU = new DefaultListModel<String>();
		listaUsrV.setModel(listaU);
		scrollListaUsr.setViewportView(listaUsrV);
		
		
		btnSelecUsrV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = listaUsrV.getSelectedIndex();
				String usr = listaUsrV.getModel().getElementAt(i).toString();
				((DefaultListModel) listaVid.getModel()).clear();
				List<String> videos = iV.listarVideosDeUsuario(usr);
				if(!videos.isEmpty()) {
					for(String v: videos) {
						((DefaultListModel) listaVid.getModel()).addElement(v);
					}
				}
				listaUsrV.setEnabled(false);
				btnSelecUsrV.setEnabled(false);
				
				listaVid.setEnabled(true);
				btnSelecVid.setEnabled(true);
			}
		});
		
		btnSelecUsrV.setBounds(23, 229, 168, 25);
		getContentPane().add(btnSelecUsrV);
		
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
				listaVid.setEnabled(false);
				btnSelecVid.setEnabled(false);
				int i = listaVid.getSelectedIndex();
				String vid = listaVid.getModel().getElementAt(i).toString();
				
				//TODO
			}
		});
		
		
		btnSelecVid.setEnabled(false);
		btnSelecVid.setBounds(201, 230, 168, 23);
		getContentPane().add(btnSelecVid);
		
		JLabel label = new JLabel("Usuarios");
		label.setBounds(76, 266, 58, 14);
		getContentPane().add(label);
		
		JScrollPane scrollListaUsrL = new JScrollPane();
		scrollListaUsrL.setBounds(23, 280, 168, 190);
		getContentPane().add(scrollListaUsrL);
		
		JList listUsrL = new JList();
		scrollListaUsrL.setViewportView(listUsrL);
		
		JScrollPane scrollListaLis = new JScrollPane();
		scrollListaLis.setBounds(201, 280, 168, 190);
		getContentPane().add(scrollListaLis);
		
		JList list = new JList();
		list.setEnabled(false);
		scrollListaLis.setViewportView(list);
		
		JLabel lblListasDeReproduccion = new JLabel("Listas de Reproduccion");
		lblListasDeReproduccion.setBounds(231, 265, 127, 14);
		getContentPane().add(lblListasDeReproduccion);
		
		JButton btnSelecUsrL = new JButton("Seleccionar");
		btnSelecUsrL.setBounds(23, 477, 168, 23);
		getContentPane().add(btnSelecUsrL);
		
		JButton btnSelecLista = new JButton("Seleccionar");
		btnSelecLista.setEnabled(false);
		btnSelecLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSelecLista.setBounds(201, 477, 168, 23);
		getContentPane().add(btnSelecLista);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setEnabled(false);
		btnAgregar.setBounds(606, 439, 168, 25);
		getContentPane().add(btnAgregar);
		
	}
	public void cargarElementos() {
		List<String> usuarios = iU.listarUsuarios();
		DefaultListModel<String> listaU = new DefaultListModel<String>();
		int i = 0;
		for(String u: usuarios) {
			listaU.add(i++, u);
		}
		listaUsrV.setModel(listaU);
	}
		
	
	public void cargarComentarios(String nomVid) {
		List<DtComentario> listaCom = iV.obtenerComentariosVideo(nomVid);
		for(DtComentario c: listaCom) {
			DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(c);
			cargarRespuestas(nodo, c.getRespuestas());
			raiz.add(nodo);
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
		((DefaultListModel) listaUsrV.getModel()).clear();
	}
	
	public void LimpiarForm() {
		//TODO
	}
	
	
	public void inicializar() {
		limpiarLista();
		LimpiarForm();
		cargarElementos();
	}
}
