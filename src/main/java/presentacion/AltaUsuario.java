package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import interfaces.IUsuario;

import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class AltaUsuario extends JInternalFrame {
	private JTextField nick;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField email;
	private JTextField nomCanal;
	private JTextField img;
	private Boolean agregarFoto = false;
	private Boolean agregarNomCanal = false;
	private Boolean publico = false;
	private JComboBox<Integer> fDia = new JComboBox<Integer>();
	private JComboBox <Integer>fMes = new JComboBox<Integer>();
	private JComboBox<Integer> fAnio = new JComboBox<Integer>();
	private JLabel lblMsgErrorNick = new JLabel("Ya existe el nickname");
	private JLabel lblMsgErrorEmail = new JLabel("Ya existe el email.");
	private JTextPane desCanal = new JTextPane();
	private JLabel lblMsgError = new JLabel("Error: Falta completar algun campo.");
	private JLabel lblMsgExito = new JLabel("El usuario ha sido ingresado con exito.");
	private JCheckBox chckbxCanalPublico = new JCheckBox("Canal Publico");
	private JCheckBox chckbxPersonalizarNombreDel = new JCheckBox("Personalizar nombre del canal");
	private JCheckBox lblInsertarImagenDe = new JCheckBox("Insertar imagen de perfil");

	/**
	 * Create the frame.
	 */
	public AltaUsuario(IUsuario iU) {
		setTitle("Agregar usuario");
		setBounds(100, 100, 800, 542);
		getContentPane().setLayout(null);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(23, 27, 70, 15);
		getContentPane().add(lblNickname);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(23, 74, 70, 15);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(23, 124, 70, 15);
		getContentPane().add(lblApellido);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(23, 175, 70, 15);
		getContentPane().add(lblEmail);
		
		JLabel lblFechaDeNacimento = new JLabel("Fecha de nacimento");
		lblFechaDeNacimento.setBounds(23, 225, 148, 15);
		getContentPane().add(lblFechaDeNacimento);
		
		nick = new JTextField();
		nick.setBounds(184, 25, 190, 19);
		getContentPane().add(nick);
		nick.setColumns(10);
		
		nombre = new JTextField();
		nombre.setBounds(184, 72, 190, 19);
		getContentPane().add(nombre);
		nombre.setColumns(10);
		
		apellido = new JTextField();
		apellido.setBounds(184, 122, 190, 19);
		getContentPane().add(apellido);
		apellido.setColumns(10);
		
		email = new JTextField();
		email.setBounds(184, 173, 190, 19);
		getContentPane().add(email);
		email.setColumns(10);

		
		
		
		
		fDia.setBounds(184, 220, 49, 24);
		fDia.addItem(null);
		for(Integer i=1; i<=31; i++) {
			fDia.addItem(i);
		}
		getContentPane().add(fDia);
		
		
		fMes.setBounds(245, 220, 52, 24);
		fMes.addItem(null);
		for(Integer i=1; i<=12; i++) {
			fMes.addItem(i);
		}
		getContentPane().add(fMes);
		
		
		fAnio.setBounds(309, 220, 77, 24);
		fAnio.addItem(null);
		for(Integer i=1920; i<=2019; i++) {
			fAnio.addItem(i);
		}
		getContentPane().add(fAnio);
		
		
		
		
		lblMsgErrorNick.setForeground(Color.RED);
		lblMsgErrorNick.setBounds(184, 45, 190, 15);
		lblMsgErrorNick.setVisible(false);
		getContentPane().add(lblMsgErrorNick);
		
		
		lblMsgErrorEmail.setForeground(Color.RED);
		lblMsgErrorEmail.setBounds(184, 193, 190, 15);
		lblMsgErrorEmail.setVisible(false);
		getContentPane().add(lblMsgErrorEmail);
		
		
		chckbxPersonalizarNombreDel.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				agregarNomCanal = ! agregarNomCanal;
				nomCanal.setEnabled(agregarNomCanal);
			}
		});
		chckbxPersonalizarNombreDel.setBounds(461, 23, 284, 23);
		getContentPane().add(chckbxPersonalizarNombreDel);
		
		JLabel lblNombreDelCanal = new JLabel("Nombre del canal");
		lblNombreDelCanal.setBounds(432, 72, 148, 15);
		getContentPane().add(lblNombreDelCanal);
		
		nomCanal = new JTextField();
		nomCanal.setEnabled(false);
		nomCanal.setBounds(588, 72, 190, 19);
		getContentPane().add(nomCanal);
		nomCanal.setColumns(10);
		
		JLabel lblDescripcionDelCanal = new JLabel("Descripcion del canal");
		lblDescripcionDelCanal.setBounds(432, 124, 200, 15);
		getContentPane().add(lblDescripcionDelCanal);
		
		
		desCanal.setBounds(432, 151, 346, 89);
		getContentPane().add(desCanal);
		
		
		lblInsertarImagenDe.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				agregarFoto = ! agregarFoto;
				img.setEnabled(agregarFoto);
			}
		});
		lblInsertarImagenDe.setBounds(67, 289, 284, 15);
		getContentPane().add(lblInsertarImagenDe);
		
		img = new JTextField();
		img.setEnabled(false);
		img.setBounds(184, 342, 190, 19);
		getContentPane().add(img);
		img.setColumns(10);
		
		JLabel lblImagenDePerfil = new JLabel("Imagen de perfil");
		lblImagenDePerfil.setBounds(23, 344, 148, 15);
		getContentPane().add(lblImagenDePerfil);
		
		
		lblMsgError.setForeground(Color.RED);
		lblMsgError.setBounds(309, 402, 284, 15);
		lblMsgError.setVisible(false);
		getContentPane().add(lblMsgError);
		
		
		lblMsgExito.setForeground(new Color(127, 255, 0));
		lblMsgExito.setBounds(309, 402, 323, 15);
		lblMsgExito.setVisible(false);
		getContentPane().add(lblMsgExito);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nick.getText().isEmpty() || nombre.getText().isEmpty() || apellido.getText().isEmpty() ||
					email.getText().isEmpty() || fDia.equals(null) || fMes.equals(null) || fAnio.equals(null) 
					|| (img.getText().isEmpty() && agregarFoto) || (nomCanal.getText().isEmpty() && agregarNomCanal) 
					|| desCanal.getText().isEmpty()) {
					borrarMsg();
					lblMsgError.setVisible(true);
				}else if(iU.existeEmail(email.getText())){
					borrarMsg();
					lblMsgErrorEmail.setVisible(true);
				}else if(iU.existeNickname(nick.getText())) {
					borrarMsg();
					lblMsgErrorNick.setVisible(true);
				}else {
					Calendar fNac = Calendar.getInstance();
			        fNac.set((Integer) fAnio.getSelectedItem(), (Integer) fMes.getSelectedItem(), (Integer) fDia.getSelectedItem());
			        iU.agregarUsuario(nick.getText(), nombre.getText(), apellido.getText(), fNac, email.getText());
			        if(agregarFoto) {
			        	iU.modificarImagen(img.getText());
			        }
			        iU.agregarCanal();
			        if(agregarNomCanal) {
			        	iU.modificarInfoCanal(nomCanal.getText(), desCanal.getText(), publico);
			        }else {
			        	iU.modificarInfoCanal(nick.getText(), desCanal.getText(), publico);
			        }
			        resetearFormulario();
			        lblMsgExito.setVisible(true);
				}
			}
		});
		btnAgregar.setBounds(309, 446, 117, 25);
		getContentPane().add(btnAgregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetearFormulario();
				AltaUsuario.this.setVisible(false);
			}
		});
		btnCancelar.setBounds(461, 446, 117, 25);
		getContentPane().add(btnCancelar);
		
		
		chckbxCanalPublico.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				publico = ! publico;
			}
		});
		chckbxCanalPublico.setBounds(488, 270, 156, 23);
		getContentPane().add(chckbxCanalPublico);
		
		
		

	}
	
	public void resetearFormulario() {
		nick.setText("");
		nombre.setText("");
		apellido.setText("");
		email.setText("");
		nomCanal.setText("");
		img.setText("");
		fDia = new JComboBox<Integer>();
		fMes = new JComboBox<Integer>();
		fAnio = new JComboBox<Integer>();
		desCanal.setText("");
		agregarFoto = false;
		agregarNomCanal = false;
		publico = false;
		chckbxCanalPublico = new JCheckBox("Canal Publico");
		chckbxPersonalizarNombreDel = new JCheckBox("Personalizar nombre del canal");
		lblInsertarImagenDe = new JCheckBox("Insertar imagen de perfil");
		borrarMsg();
	}
	public void borrarMsg() {
		lblMsgError.setVisible(false);
		lblMsgExito.setVisible(false);
		lblMsgErrorNick.setVisible(false);
		lblMsgErrorEmail.setVisible(false);
	}
}
