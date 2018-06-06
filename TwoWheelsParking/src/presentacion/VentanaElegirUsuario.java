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

public class VentanaElegirUsuario extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblUsuarios;
	private JLabel lblUsuarios;
	private JScrollPane scrollPane;
	private JButton btnElegirUsuario;

	protected ConectorComponentes cc;
	protected DefaultTableModel dtm;
	protected int idEspacio;
	
	protected VentanaListaEspacios vListaEspacios;
	
	/**
	 * Create the frame.
	 */
	public VentanaElegirUsuario(ConectorComponentes cc, VentanaListaEspacios vListaEspacios) {
		
		this.cc = cc;
		this.vListaEspacios = vListaEspacios;
		
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
		
		btnElegirUsuario = new JButton("Seleccionar Usuario");
		btnElegirUsuario.setBounds(513, 43, 138, 23);
		btnElegirUsuario.setActionCommand("SELECCIONAR");
		btnElegirUsuario.addActionListener(this);
		contentPane.add(btnElegirUsuario);
		
		listarUsuarios();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String accion = e.getActionCommand();
		
		if(accion == "SELECCIONAR") {
			int fila = tblUsuarios.getSelectedRow();
			int columna = tblUsuarios.getSelectedColumn();
			Object obj = dtm.getValueAt(fila, columna);
			
			cc.getEspacios().cambiarEstadoEspacio((Integer)obj, idEspacio, "Reservado");
			
			vListaEspacios.dtm.fireTableDataChanged();
			vListaEspacios.listarEspacios();
			
			this.setVisible(false);
		}
		
	}
	
	public void listarUsuarios(){
		System.out.println("--------------------");
		System.out.println("Listando Usuarios");
		dtm.setRowCount(0);
		for(java.util.Map.Entry<Integer, Usuario> entry: cc.getUsuarios().obtenerListaUsuarios().entrySet()) {
			if (entry.getValue().getTipo() == "Cliente") {
				dtm.addRow(new Object[] {entry.getKey(), entry.getValue().getNombre(), entry.getValue().getApellido(), entry.getValue().getTelefono(), entry.getValue().getTipo()});
			}
			System.out.println("Agregando fila: " + entry.getValue().getNombre());
			dtm.fireTableDataChanged();
		}
	}
	
	public void setIdEspacio(int id){
		this.idEspacio = id;
	}
}
