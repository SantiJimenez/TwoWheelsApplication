package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.logica.ConectorComponentes;

import estructura.modelos.Espacio;
import estructura.modelos.Usuario;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;

public class VentanaCrearEspacio extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JButton btnCrearEspacio;
	private JLabel lblNuevoEspacio, lblId;
	
	protected Hashtable<Integer, Espacio> listaEspacios;
	protected ConectorComponentes cc;

	/**
	 * Create the frame.
	 */
	public VentanaCrearEspacio(ConectorComponentes cc) {
		this.cc = cc;		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 293, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNuevoEspacio = new JLabel("NUEVO ESPACIO");
		lblNuevoEspacio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNuevoEspacio.setForeground(Color.BLACK);
		lblNuevoEspacio.setBackground(Color.BLACK);
		lblNuevoEspacio.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoEspacio.setBounds(10, 11, 257, 25);
		contentPane.add(lblNuevoEspacio);
		
		lblId = new JLabel("IDENTIDICADOR:  ");
		lblId.setBounds(10, 50, 107, 14);
		contentPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(127, 47, 139, 20);
		contentPane.add(txtId);
		
		btnCrearEspacio = new JButton("Crear Espacio");
		btnCrearEspacio.setBounds(10, 78, 257, 23);
		btnCrearEspacio.setActionCommand("CREAR");
		btnCrearEspacio.addActionListener(this);
		contentPane.add(btnCrearEspacio);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String accion = e.getActionCommand();
		
		if(accion == "CREAR") {
			
			cc.getEspacios().crearEspacio(Integer.parseInt(txtId.getText()));
			listaEspacios = cc.getEspacios().obtenerEspacios();
			System.out.println(listaEspacios);
			
//			cc.getUsuarios().crearUsuario(Integer.parseInt(txtDocumento.getText()), txtNombre.getText(), txtApellido.getText(), txtId.getText(), comboBox.getSelectedItem().toString());
//			listaUsuarios = cc.getUsuarios().obtenerListaUsuarios();
//			txtDocumento.setText("");
//			txtNombre.setText("");
//			txtApellido.setText("");
//			txtId.setText("");
//			comboBox.setSelectedIndex(0);
//			System.out.println(listaUsuarios);
		}
		
	}
}
