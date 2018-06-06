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

public class VentanaEspacios extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnCrearEspacio, btnBuscarEspacio;
	private JLabel lblAdministracionDeEspacios;
	
	protected VentanaCrearEspacio vCrearEspacio;
	protected VentanaListaEspacios vListaEspacios;
	
	/**
	 * Create the frame.
	 */
	public VentanaEspacios(ConectorComponentes cc) {
		
		vCrearEspacio = new VentanaCrearEspacio(cc);
		vListaEspacios = new VentanaListaEspacios(cc);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 387, 116);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCrearEspacio = new JButton("Crear Espacio");
		btnCrearEspacio.setBounds(10, 45, 170, 23);
		btnCrearEspacio.setActionCommand("CREAR");
		btnCrearEspacio.addActionListener(this);
		contentPane.add(btnCrearEspacio);
		
		btnBuscarEspacio = new JButton("Listar Espacios");
		btnBuscarEspacio.setBounds(190, 45, 170, 23);
		btnBuscarEspacio.setActionCommand("LISTAR");
		btnBuscarEspacio.addActionListener(this);
		contentPane.add(btnBuscarEspacio);
		
		lblAdministracionDeEspacios = new JLabel("ADMINISTRACION DE ESPACIOS");
		lblAdministracionDeEspacios.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdministracionDeEspacios.setBounds(10, 11, 350, 14);
		contentPane.add(lblAdministracionDeEspacios);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String accion = e.getActionCommand();
		
		if(accion == "CREAR") {
			System.out.println("Boton crear usuario presionado");
			vCrearEspacio.setVisible(true);
		}
		
		if(accion == "LISTAR") {
			System.out.println("Boton listar usuarios presionado");
			vListaEspacios.listarEspacios();
			vListaEspacios.setVisible(true);
		}
	}

}
