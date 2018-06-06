package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.logica.ConectorComponentes;
import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

import estructura.modelos.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class VentanaListaUsuarios extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTable tblUsuarios;
	private JLabel lblUsuarios;
	private JScrollPane scrollPane;
	private JButton btnEditarUsuario, btnEliminarUsuario;

	protected ConectorComponentes cc;
	protected DefaultTableModel dtm;
	protected VentanaEditarUsuario vEditarUsuario;
	
	/**
	 * Create the frame.
	 */
	public VentanaListaUsuarios(ConectorComponentes cc) {
		
		this.cc = cc;
		this.vEditarUsuario = new VentanaEditarUsuario(cc, this);
		
		this.dtm = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Documento", "Nombre", "Apellido", "Teléfono", "Tipo"
		});
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 677, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsuarios = new JLabel("USUARIOS");
		lblUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarios.setBounds(10, 11, 641, 14);
		contentPane.add(lblUsuarios);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 493, 204);
		contentPane.add(scrollPane);
		
		tblUsuarios = new JTable(dtm);
		tblUsuarios.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(tblUsuarios);
		
		btnEditarUsuario = new JButton("Editar Usuario");
		btnEditarUsuario.setBounds(513, 43, 138, 23);
		btnEditarUsuario.setActionCommand("EDITAR");
		btnEditarUsuario.addActionListener(this);
		contentPane.add(btnEditarUsuario);
		
		btnEliminarUsuario = new JButton("Eliminar Usuario");
		btnEliminarUsuario.setBounds(513, 77, 138, 23);
		btnEliminarUsuario.setActionCommand("ELIMINAR");
		btnEliminarUsuario.addActionListener(this);
		contentPane.add(btnEliminarUsuario);
		
		listarUsuarios();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String accion = e.getActionCommand();
		
		if(accion == "EDITAR") {
			int fila = tblUsuarios.getSelectedRow();
			int columna = tblUsuarios.getSelectedColumn();
			Object obj = dtm.getValueAt(fila, columna);
			vEditarUsuario.setIdUsuario((Integer) obj);
			vEditarUsuario.llenarCampos();
			vEditarUsuario.setVisible(true);
		}
		
		if(accion == "ELIMINAR") {
			System.out.println("Eliminando usuario");
			int fila = tblUsuarios.getSelectedRow();
			int columna = tblUsuarios.getSelectedColumn();
			Object obj = dtm.getValueAt(fila, columna);
			
			cc.getUsuarios().eliminarUsuario((Integer) obj);
			listarUsuarios();
			
		}
		
		if(accion == "ACTUALIZAR") {
			listarUsuarios();
		}
	}
	
	public void listarUsuarios(){
		System.out.println("--------------------");
		System.out.println("Listando Usuarios");
		dtm.setRowCount(0);
		for(java.util.Map.Entry<Integer, Usuario> entry: cc.getUsuarios().obtenerListaUsuarios().entrySet()) {
		   dtm.addRow(new Object[] {entry.getKey(), entry.getValue().getNombre(), entry.getValue().getApellido(), entry.getValue().getTelefono(), entry.getValue().getTipo()});
		   System.out.println("Agregando fila: " + entry.getValue().getNombre());
		   dtm.fireTableDataChanged();
		}
	}
}
