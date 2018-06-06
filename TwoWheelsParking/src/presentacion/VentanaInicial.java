package presentacion;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.logica.ConectorComponentes;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import estructura.modelos.Usuario; 									

public class VentanaInicial extends JFrame implements ActionListener{

	/**
	 * Parameters
	 */
	private static final long serialVersionUID = -6900234492144691609L;
	private JLabel lblLogo;
	private JButton btnGestorDeUsuarios, btnGestorDeEspacios, btnPagos, btnEstadisticas;
	
	protected VentanaUsuarios ventanaUsuarios;
	protected VentanaEspacios ventanaEspacios;
	protected VentanaPagos ventanaPagos;
	
	/**
	 * Create the application.
	 */
	public VentanaInicial(ConectorComponentes cc) {
		ventanaUsuarios = new VentanaUsuarios(cc);
		ventanaEspacios = new VentanaEspacios(cc);
		ventanaPagos = new VentanaPagos(cc);
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
			ventanaUsuarios.setVisible(true);
		}
		
		if(accion == "ESPACIOS") {
			System.out.println("Boton espacios presionado");
			ventanaEspacios.setVisible(true);
		}
		
		if(accion == "PAGOS") {
			System.out.println("Boton pagos presionado");
			ventanaPagos.setVisible(true);
		}
		
		if(accion == "ESTADISTICAS") {
			System.out.println("Boton estadisticas presionado");
		}
		
	}
	
}
