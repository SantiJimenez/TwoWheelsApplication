package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.logica.ConectorComponentes;
import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

import estructura.modelos.Espacio;
import estructura.modelos.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class VentanaListaEspacios extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTable tblEspacios;
	private JLabel lblEspacios;
	private JScrollPane scrollPane;
	private JButton btnReservarEspacio, btnEliminarEspacio;

	protected ConectorComponentes cc;
	protected DefaultTableModel dtm;
	
	protected VentanaElegirUsuario vElegirUsuario;
	
	/**
	 * Create the frame.
	 */
	public VentanaListaEspacios(ConectorComponentes cc) {
		
		this.cc = cc;
		this.vElegirUsuario = new VentanaElegirUsuario(cc, this);
		
		this.dtm = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Identificador", "Estado", "Usuario Asociado", "Hora Reserva"
		});
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 677, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblEspacios = new JLabel("ESPACIOS");
		lblEspacios.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspacios.setBounds(10, 11, 641, 14);
		contentPane.add(lblEspacios);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 493, 204);
		contentPane.add(scrollPane);
		
		tblEspacios = new JTable(dtm);
		tblEspacios.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(tblEspacios);
		
		btnReservarEspacio = new JButton("Reservar Espacio");
		btnReservarEspacio.setBounds(513, 43, 138, 23);
		btnReservarEspacio.setActionCommand("RESERVAR");
		btnReservarEspacio.addActionListener(this);
		contentPane.add(btnReservarEspacio);
		
		btnEliminarEspacio = new JButton("Eliminar Espacio");
		btnEliminarEspacio.setBounds(513, 77, 138, 23);
		btnEliminarEspacio.setActionCommand("ELIMINAR");
		btnEliminarEspacio.addActionListener(this);
		contentPane.add(btnEliminarEspacio);
		
		listarEspacios();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String accion = e.getActionCommand();
		
		if(accion == "RESERVAR") {
			int fila = tblEspacios.getSelectedRow();
			int columna = tblEspacios.getSelectedColumn();
			Object obj = dtm.getValueAt(fila, columna);

			vElegirUsuario.setIdEspacio((Integer)obj);
			vElegirUsuario.setVisible(true);
		}
		
		if(accion == "ELIMINAR") {
			System.out.println("Eliminando usuario");
			int fila = tblEspacios.getSelectedRow();
			int columna = tblEspacios.getSelectedColumn();
			Object obj = dtm.getValueAt(fila, columna);
		
			cc.getEspacios().obtenerEspacios().remove(obj);
			dtm.fireTableDataChanged();
			listarEspacios();
		}
		
	}
	
	public void listarEspacios(){
		System.out.println("--------------------");
		System.out.println("Listando Espacios");
		dtm.setRowCount(0);
		for(java.util.Map.Entry<Integer, Espacio> entry: cc.getEspacios().obtenerEspacios().entrySet()) {
		   dtm.addRow(new Object[] {entry.getKey(), entry.getValue().getEstado().getEstado(), entry.getValue().getUsuario(), entry.getValue().getHoraReserva()});
		   System.out.println("Agregando fila: " + entry.getValue().getId());
		   dtm.fireTableDataChanged();
		}
	}
}
