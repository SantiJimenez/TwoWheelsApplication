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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;

public class VentanaCrearFactura extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnCrearUsuario;
	private JLabel lblNuevoUsuario, lblNombre, lblDocumento, lblTelefono, lblApellido, lblTipo;
	
	protected Hashtable<Integer, Usuario> listaUsuarios;
	
	protected ConectorComponentes cc;
	private JLabel label;
	private JLabel lblNombreUsuario;
	private JLabel lblApellidoUsuario;
	private JLabel lblDocumentoUsuario;
	private JLabel lblTelefonoUsuario;
	private JLabel lblEspacio;
	private JLabel lblMonto;
	
	private int id;
	private double valor;

	protected VentanaElegirEspacio vElegirEspacio;
	
	/**
	 * Create the frame.
	 */
	public VentanaCrearFactura(ConectorComponentes cc, VentanaElegirEspacio vElegirEspacio) {
		this.cc = cc;		
		this.vElegirEspacio = vElegirEspacio;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 263, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNuevoUsuario = new JLabel("FACTURA");
		lblNuevoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNuevoUsuario.setForeground(Color.BLACK);
		lblNuevoUsuario.setBackground(Color.BLACK);
		lblNuevoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoUsuario.setBounds(10, 11, 225, 25);
		contentPane.add(lblNuevoUsuario);
		
		lblNombre = new JLabel("NOMBRE: ");
		lblNombre.setBounds(10, 47, 86, 14);
		contentPane.add(lblNombre);
		
		lblDocumento = new JLabel("DOCUMENTO: ");
		lblDocumento.setBounds(10, 98, 86, 14);
		contentPane.add(lblDocumento);
		
		lblTelefono = new JLabel("ESPACIO: ");
		lblTelefono.setBounds(10, 148, 86, 14);
		contentPane.add(lblTelefono);
		
		btnCrearUsuario = new JButton("Realizar Pago");
		btnCrearUsuario.setBounds(10, 225, 225, 23);
		btnCrearUsuario.setActionCommand("CREAR");
		btnCrearUsuario.addActionListener(this);
		contentPane.add(btnCrearUsuario);
		
		lblApellido = new JLabel("APELLIDO: ");
		lblApellido.setBounds(10, 72, 86, 14);
		contentPane.add(lblApellido);
		
		lblTipo = new JLabel("MONTO:");
		lblTipo.setBounds(10, 194, 46, 14);
		contentPane.add(lblTipo);
		
		label = new JLabel("TELEFONO: ");
		label.setBounds(10, 123, 86, 14);
		contentPane.add(label);
		
		lblNombreUsuario = new JLabel("");
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreUsuario.setBounds(121, 47, 114, 14);
		contentPane.add(lblNombreUsuario);
		
		lblApellidoUsuario = new JLabel("");
		lblApellidoUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellidoUsuario.setBounds(121, 72, 114, 14);
		contentPane.add(lblApellidoUsuario);
		
		lblDocumentoUsuario = new JLabel("");
		lblDocumentoUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDocumentoUsuario.setBounds(121, 98, 114, 14);
		contentPane.add(lblDocumentoUsuario);
		
		lblTelefonoUsuario = new JLabel("");
		lblTelefonoUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefonoUsuario.setBounds(121, 123, 114, 14);
		contentPane.add(lblTelefonoUsuario);
		
		lblEspacio = new JLabel("");
		lblEspacio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEspacio.setBounds(121, 148, 114, 14);
		contentPane.add(lblEspacio);
		
		lblMonto = new JLabel("");
		lblMonto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMonto.setBounds(121, 194, 114, 14);
		contentPane.add(lblMonto);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String accion = e.getActionCommand();
		
		if(accion == "CREAR") {
			id++;
			System.out.println(id);
			System.out.println("id: " + id + "- idUsuario: " + Integer.parseInt(lblDocumentoUsuario.getText()) + " - idEspacio: "+ Integer.parseInt(lblEspacio.getText()) + " - valor: " + valor);
			cc.getRecaudo().captarPago(id, Integer.parseInt(lblDocumentoUsuario.getText()), Integer.parseInt(lblEspacio.getText()), (int)valor);
			System.out.println(cc.getRecaudo().obtenerListaFacturas());
			System.out.println("Usuario Factura: " + cc.getRecaudo().obtenerListaFacturas().get(id).getIdUsuario());
			cc.getEspacios().cambiarEstadoEspacio(Integer.parseInt(lblEspacio.getText()), 0, "Disponible");
			vElegirEspacio.listarEspacios();
			JOptionPane.showMessageDialog(this, "Pago realizado");
			this.setVisible(false);
		}
		
	}
	
	public void setValor(double valor){
		this.valor = valor;
	}
	
	public void llenarFactura(Usuario usuario, Espacio espacio){
		lblNombreUsuario.setText(usuario.getNombre());
		lblApellidoUsuario.setText(usuario.getApellido());
		lblDocumentoUsuario.setText(""+usuario.getId());
		lblTelefonoUsuario.setText(usuario.getTelefono());
		lblEspacio.setText(""+espacio.getId());
		lblMonto.setText(""+valor);
	}
}
