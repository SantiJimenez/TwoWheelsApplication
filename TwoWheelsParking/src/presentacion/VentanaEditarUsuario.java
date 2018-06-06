package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.logica.ConectorComponentes;

import estructura.modelos.Usuario;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;

public class VentanaEditarUsuario extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre, txtDocumento, txtTelefono, txtApellido;
	private JButton btnCrearUsuario;
	private JLabel lblNuevoUsuario, lblNombre, lblDocumento, lblTelefono, lblApellido, lblTipo;
	private JComboBox<String> comboBox;
	
	protected Hashtable<Integer, Usuario> listaUsuarios;
	protected ConectorComponentes cc;
	protected int idUsuario;
	protected VentanaListaUsuarios vListaUsuarios;
	
	/**
	 * Create the frame.
	 */
	public VentanaEditarUsuario(ConectorComponentes cc, VentanaListaUsuarios vListaUsuarios) {
		this.cc = cc;
		this.vListaUsuarios = vListaUsuarios;
		this.idUsuario = 0;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 293, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNuevoUsuario = new JLabel("EDITAR USUARIO");
		lblNuevoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNuevoUsuario.setForeground(Color.BLACK);
		lblNuevoUsuario.setBackground(Color.BLACK);
		lblNuevoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoUsuario.setBounds(10, 11, 257, 25);
		contentPane.add(lblNuevoUsuario);
		
		lblNombre = new JLabel("NOMBRE: ");
		lblNombre.setBounds(10, 47, 86, 14);
		contentPane.add(lblNombre);
		
		lblDocumento = new JLabel("DOCUMENTO: ");
		lblDocumento.setBounds(10, 98, 86, 14);
		contentPane.add(lblDocumento);
		
		lblTelefono = new JLabel("TELEFONO: ");
		lblTelefono.setBounds(10, 124, 86, 14);
		contentPane.add(lblTelefono);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(106, 69, 160, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDocumento = new JTextField();
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(106, 95, 160, 20);
		contentPane.add(txtDocumento);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(106, 121, 160, 20);
		contentPane.add(txtTelefono);
		
		btnCrearUsuario = new JButton("Editar Usuario");
		btnCrearUsuario.setBounds(10, 186, 257, 23);
		btnCrearUsuario.setActionCommand("EDITAR");
		btnCrearUsuario.addActionListener(this);
		contentPane.add(btnCrearUsuario);
		
		lblApellido = new JLabel("APELLIDO: ");
		lblApellido.setBounds(10, 72, 86, 14);
		contentPane.add(lblApellido);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(106, 44, 160, 20);
		contentPane.add(txtNombre);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(106, 152, 161, 20);
		comboBox.addItem("Cliente");
		comboBox.addItem("Operario");
		comboBox.addItem("Administrador");
		contentPane.add(comboBox);
		
		lblTipo = new JLabel("TIPO:");
		lblTipo.setBounds(10, 155, 46, 14);
		contentPane.add(lblTipo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String accion = e.getActionCommand();
		
		if(accion == "EDITAR") {
			
			cc.getUsuarios().actualizarUsuario(idUsuario, txtNombre.getText(), txtApellido.getText(), txtTelefono.getText());
			listaUsuarios = cc.getUsuarios().obtenerListaUsuarios();
			txtDocumento.setText("");
			txtNombre.setText("");
			txtApellido.setText("");
			txtTelefono.setText("");
			comboBox.setSelectedIndex(0);
			System.out.println(listaUsuarios);
			vListaUsuarios.dtm.fireTableDataChanged();
			vListaUsuarios.listarUsuarios();
			this.setVisible(false);
		}
		
	}
	
	public void llenarCampos(){
		Usuario usuario = cc.getUsuarios().obtenerUsuario(idUsuario);
		txtDocumento.setText(""+usuario.getId());
		txtNombre.setText(usuario.getNombre());
		txtApellido.setText(usuario.getApellido());
		txtTelefono.setText(usuario.getTelefono());
		
	}
	
	public void setIdUsuario(int id){
		this.idUsuario = id;
	}
	
}
