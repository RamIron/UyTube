package presentacion;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import datatypes.DtElementoUsuario;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

import interfaces.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class ConsultaCategoria extends JInternalFrame{

	JList listCategoria;
	JList listElementos;
	
	JLabel lblMsgErrorCat = new JLabel("Debe seleccionar una categoria");
	String nomCat = "";

	/**
	 * Create the frame.
	 */
	public ConsultaCategoria(ICategoria iC) {
		setTitle("Consulta de categoria");
		setBounds(100, 100, 800, 542);
		getContentPane().setLayout(null);
		
		listCategoria = new JList();
		listCategoria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCategoria.setBounds(105, 11, 278, 422);
		getContentPane().add(listCategoria);
		
		listElementos = new JList();
		listElementos.setBounds(410, 10, 278, 422);
		getContentPane().add(listElementos);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaCategoria.this.setVisible(false);
				limpiarListaCategorias();
				limpiarListaElementos();
			}
		});
		
		btnSalir.setBounds(115, 447, 117, 25);
		getContentPane().add(btnSalir);
		JButton btnSeleccionar = new JButton("Seleccionar");
		
		
//		btnSeleccionar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				reiniciarMsg();
//				int i = listCategoria.getSelectedIndex();
//				if(i < 0) {
//					//lblMsgErrorUsr.setVisible(true);
//				}else {
//					System.out.println("Entra aca");
//					String cat = listCategoria.getModel().getElementAt(i).toString();
//					//((DefaultListModel) listElementos.getModel()).clear();
//					List<DtElementoUsuario> elementos = iC.listarElemCategoria(cat);
//					if(!elementos.isEmpty()) {
//						for(DtElementoUsuario e: elementos) {
////							String elemUsr = e.getNombreE() + " " + e.getNickname();
//							((DefaultListModel) listElementos.getModel()).addElement(e.getNickname());
//						}
//					}
//				
//					listElementos.setEnabled(true);					
//				}
//			}
//		});
		
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iC.limpiarControlador();
				listElementos.setEnabled(true);
				listElementos.removeAll();
				int c = listCategoria.getSelectedIndex();
				if(c < 0) {
					lblMsgErrorCat.setVisible(true);
				}else {
					nomCat = listCategoria.getModel().getElementAt(c).toString();
					List<DtElementoUsuario> elementos = iC.listarElemCategoria(nomCat);
					
					if(!elementos.isEmpty()) {						
						ArrayList<String> elems = new ArrayList<String>();
						for(DtElementoUsuario e : elementos) {
							elems.add(e.getNombreE() + " - " + e.getNickname());
						}
						DefaultListModel listModel = new DefaultListModel();
						for (int i = 0; i < elems.size(); i++)
						{
						    listModel.addElement(elems.get(i));
						}
						listElementos.setModel(listModel);
					}
				}
				
			}
			
		});
		btnSeleccionar.setBounds(262, 447, 117, 25);
		getContentPane().add(btnSeleccionar);
		
		lblMsgErrorCat.setEnabled(true);
		
		lblMsgErrorCat.setForeground(Color.RED);
		lblMsgErrorCat.setBounds(262, 483, 158, 14);
		lblMsgErrorCat.setVisible(false);
		getContentPane().add(lblMsgErrorCat);
		this.setVisible(false);

	}
	
	public void cargarCategorias(ICategoria iC) {
		List<String> categorias = iC.listarCategorias();
		DefaultListModel<String> listaCat = new DefaultListModel<String>();
		int i = 0;
		for(String c: categorias) {
			listaCat.add(i++, c);
		}
		listCategoria.setModel(listaCat);
	}
	
//	public void cargarElementos(ICategoria iC) {
//		List<DtElementoUsuario> elementos = iC.listarElemCategoria(nomCat);
//		DefaultListModel<String> listaElem = new DefaultListModel<String>();
//		int i = 0;
//		for(DtElementoUsuario e:elementos) {
//			String elemUsr = e.getNombreE() + " " + e.getNickname();
//			System.out.println(e.getNombreE() + " " + e.getNickname());
//			listaElem.add(i++, elemUsr);
//		}
//		listElementos.setModel(listaElem);
//	}
	
	public void limpiarListaCategorias() {
		DefaultListModel<String> listaCat = new DefaultListModel<String>();
		listCategoria.setModel(listaCat);
	}
	
	public void limpiarListaElementos() {
		DefaultListModel<String> listaEle = new DefaultListModel<String>();
		listElementos.setModel(listaEle);
	}

	public void inicializar(ICategoria iC) {
		limpiarListaCategorias();
		limpiarListaElementos();
		cargarCategorias(iC);
	}
	
	public void reiniciarMsg() {
		lblMsgErrorCat.setVisible(false);
	}
}
