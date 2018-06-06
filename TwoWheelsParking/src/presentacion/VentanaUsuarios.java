package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.logica.ConectorComponentes;

import estructura.modelos.Usuario;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VentanaUsuarios extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnCrearUsuario, btnBuscarUsuario;
	private JLabel lblAdministracionDeUsuarios;
	
	protected VentanaCrearUsuario vCrearUsuario;
	protected VentanaListaUsuarios vListaUsuarios;
	
	/**
	 * Create the frame.
	 */
	public VentanaUsuarios(ConectorComponentes cc) {
		
		vCrearUsuario = new VentanaCrearUsuario(cc);
		vListaUsuarios = new VentanaListaUsuarios(cc);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 387, 116);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCrearUsuario = new JButton("Crear Usuario");
		btnCrearUsuario.setBounds(10, 45, 170, 23);
		btnCrearUsuario.setActionCommand("CREAR");
		btnCrearUsuario.addActionListener(this);
		contentPane.add(btnCrearUsuario);
		
		btnBuscarUsuario = new JButton("Listar Usuarios");
		btnBuscarUsuario.setBounds(190, 45, 170, 23);
		btnBuscarUsuario.setActionCommand("LISTAR");
		btnBuscarUsuario.addActionListener(this);
		contentPane.add(btnBuscarUsuario);
		
		lblAdministracionDeUsuarios = new JLabel("ADMINISTRACION DE USUARIOS");
		lblAdministracionDeUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdministracionDeUsuarios.setBounds(10, 11, 350, 14);
		contentPane.add(lblAdministracionDeUsuarios);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String accion = e.getActionCommand();
		
		if(accion == "CREAR") {
			System.out.println("Boton crear usuario presionado");
			vCrearUsuario.setVisible(true);
		}
		
		if(accion == "LISTAR") {
			System.out.println("Boton listar usuarios presionado");
			vListaUsuarios.listarUsuarios();
			vListaUsuarios.setVisible(true);
		}
	}

}
