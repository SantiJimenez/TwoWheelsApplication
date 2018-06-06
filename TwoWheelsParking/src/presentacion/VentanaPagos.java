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

public class VentanaPagos extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnRealizarPago, btnListarPagos;
	private JLabel lblAdministracionDeEspacios;
	
	protected VentanaElegirEspacio vElegirEspacio;
	protected VentanaListaFacturas vListaFacturas;
	
	/**
	 * Create the frame.
	 */
	public VentanaPagos(ConectorComponentes cc) {
		
		vListaFacturas = new VentanaListaFacturas(cc);
		vElegirEspacio = new VentanaElegirEspacio(cc, vListaFacturas);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 387, 116);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnRealizarPago = new JButton("Realizar Pago");
		btnRealizarPago.setBounds(10, 45, 170, 23);
		btnRealizarPago.setActionCommand("REALIZAR");
		btnRealizarPago.addActionListener(this);
		contentPane.add(btnRealizarPago);
		
		btnListarPagos = new JButton("Listar Pagos");
		btnListarPagos.setBounds(190, 45, 170, 23);
		btnListarPagos.setActionCommand("LISTAR");
		btnListarPagos.addActionListener(this);
		contentPane.add(btnListarPagos);
		
		lblAdministracionDeEspacios = new JLabel("PAGOS");
		lblAdministracionDeEspacios.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdministracionDeEspacios.setBounds(10, 11, 350, 14);
		contentPane.add(lblAdministracionDeEspacios);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String accion = e.getActionCommand();
		
		if(accion == "REALIZAR") {
			vElegirEspacio.listarEspacios();
			vElegirEspacio.setVisible(true);
		}
		
		if(accion == "LISTAR") {
			vListaFacturas.setVisible(true);
		}
	}

}
