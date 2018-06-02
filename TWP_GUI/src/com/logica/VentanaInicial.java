package com.logica;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class VentanaInicial extends JFrame implements ActionListener{

	private JLabel lblLogo;
	private JButton btnGestorDeUsuarios, btnGestorDeEspacios, btnPagos, btnEstadisticas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicial window = new VentanaInicial();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaInicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 635, 382);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		
		lblLogo = new JLabel("New label");
		lblLogo.setIcon(new ImageIcon("C:\\Users\\santi_000\\Google Drive\\ArquitecturaPatrones\\Proyectos Eclipse\\TWP_GUI\\img\\logotwp.png"));
		lblLogo.setBounds(10, 11, 597, 291);
		getContentPane().add(lblLogo);
		
		btnGestorDeUsuarios = new JButton("Gestor de Usuarios");
		btnGestorDeUsuarios.setBounds(10, 313, 144, 23);
		btnGestorDeUsuarios.setActionCommand("USUARIOS");
		btnGestorDeUsuarios.addActionListener(this);
		getContentPane().add(btnGestorDeUsuarios);
		
		btnGestorDeEspacios = new JButton("Gestor de Espacios");
		btnGestorDeEspacios.setBounds(164, 313, 144, 23);
		btnGestorDeEspacios.setActionCommand("ESPACIOS");
		btnGestorDeEspacios.addActionListener(this);
		getContentPane().add(btnGestorDeEspacios);
		
		btnPagos = new JButton("Pagos");
		btnPagos.setBounds(318, 313, 144, 23);
		btnPagos.setActionCommand("PAGOS");
		btnPagos.addActionListener(this);
		getContentPane().add(btnPagos);
		
		btnEstadisticas = new JButton("Estadisticas");
		btnEstadisticas.setBounds(472, 313, 137, 23);
		btnEstadisticas.setActionCommand("ESTADISTICAS");
		btnEstadisticas.addActionListener(this);
		getContentPane().add(btnEstadisticas);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String accion = e.getActionCommand();
		
		if(accion == "USUARIOS") {
			System.out.println("Boton usuarios presionado");
			VentanaUsuarios ventanaUsuarios = new VentanaUsuarios();
			ventanaUsuarios.setVisible(true);
		}
		
		if(accion == "ESPACIOS") {
			System.out.println("Boton espacios presionado");
		}
		
		if(accion == "PAGOS") {
			System.out.println("Boton pagos presionado");
		}
		
		if(accion == "ESTADISTICAS") {
			System.out.println("Boton estadisticas presionado");
		}
		
	}
}
