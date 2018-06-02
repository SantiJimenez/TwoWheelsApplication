package com.logica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;

public class VentanaCrearUsuario extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtNombre, txtDocumento, txtTelefono;
	private JButton btnCrearUsuario;
	private JLabel lblNuevoUsuario, lblNombre, lblDocumento, lblTelefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCrearUsuario frame = new VentanaCrearUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaCrearUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 293, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNuevoUsuario = new JLabel("NUEVO USUARIO");
		lblNuevoUsuario.setForeground(Color.BLACK);
		lblNuevoUsuario.setBackground(Color.BLACK);
		lblNuevoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoUsuario.setBounds(10, 11, 257, 14);
		contentPane.add(lblNuevoUsuario);
		
		lblNombre = new JLabel("NOMBRE: ");
		lblNombre.setBounds(10, 47, 86, 14);
		contentPane.add(lblNombre);
		
		lblDocumento = new JLabel("DOCUMENTO: ");
		lblDocumento.setBounds(10, 72, 86, 14);
		contentPane.add(lblDocumento);
		
		lblTelefono = new JLabel("TELEFONO: ");
		lblTelefono.setBounds(10, 97, 86, 14);
		contentPane.add(lblTelefono);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(106, 44, 160, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDocumento = new JTextField();
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(106, 69, 160, 20);
		contentPane.add(txtDocumento);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(106, 94, 160, 20);
		contentPane.add(txtTelefono);
		
		btnCrearUsuario = new JButton("Crear Usuario");
		btnCrearUsuario.setBounds(10, 129, 257, 23);
		btnCrearUsuario.setActionCommand("CREAR");
		btnCrearUsuario.addActionListener(this);
		contentPane.add(btnCrearUsuario);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String accion = e.getActionCommand();
		
		if(accion == "CREAR") {
			JOptionPane.showMessageDialog(this, "Usuario Creado");
		}
		
	}
}
