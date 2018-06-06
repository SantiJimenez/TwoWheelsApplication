package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

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

public class VentanaElegirEspacio extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblUsuarios;
	private JLabel lblUsuarios;
	private JScrollPane scrollPane;
	private JButton btnElegirEspacio;

	protected ConectorComponentes cc;
	protected DefaultTableModel dtm;
	protected int idEspacio;
	
	protected VentanaListaFacturas vListaFacturas;
	protected VentanaCrearFactura vCrearFactura;
	
	/**
	 * Create the frame.
	 */
	public VentanaElegirEspacio(ConectorComponentes cc, VentanaListaFacturas vListaFacturas) {
		
		this.cc = cc;
		this.vListaFacturas = vListaFacturas;
		this.vCrearFactura = new VentanaCrearFactura(cc, this);
		
		this.dtm = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Identificador", "Estado", "Usuario Asociado", "Hora Reserva"
		});
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 635, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsuarios = new JLabel("ESPACIOS OCUPADOS");
		lblUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarios.setBounds(10, 11, 428, 14);
		contentPane.add(lblUsuarios);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 599, 204);
		contentPane.add(scrollPane);
		
		tblUsuarios = new JTable(dtm);
		tblUsuarios.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(tblUsuarios);
		
		btnElegirEspacio = new JButton("Seleccionar Espacio");
		btnElegirEspacio.setBounds(448, 7, 161, 23);
		btnElegirEspacio.setActionCommand("SELECCIONAR");
		btnElegirEspacio.addActionListener(this);
		contentPane.add(btnElegirEspacio);
		
		listarEspacios();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String accion = e.getActionCommand();
		
		if(accion == "SELECCIONAR") {
			
			int fila = tblUsuarios.getSelectedRow();
			int columna = tblUsuarios.getSelectedColumn();
			Object obj = dtm.getValueAt(fila, columna);
			
			Espacio espacio = cc.getEspacios().obtenerEspacios().get(obj);
			Usuario usuario = cc.getUsuarios().obtenerUsuario(espacio.getUsuario());
			
			Date date = new Date();
			
			double valor = (date.getTime() - espacio.getHoraReservaMilisegundos())*0.25; 
			
			vCrearFactura.setValor(valor);
			vCrearFactura.llenarFactura(usuario, espacio);
			
			vCrearFactura.setVisible(true);
//			int fila = tblUsuarios.getSelectedRow();
//			int columna = tblUsuarios.getSelectedColumn();
//			Object obj = dtm.getValueAt(fila, columna);
//			
//			cc.getEspacios().cambiarEstadoEspacio((Integer)obj, idEspacio, "Reservado");
//			
////			vListaEspacios.dtm.fireTableDataChanged();
////			vListaEspacios.listarEspacios();
//			
//			this.setVisible(false);
		}
		
	}
	
	public void listarEspacios(){
		System.out.println("--------------------");
		System.out.println("Listando Espacios ocupados");
		dtm.setRowCount(0);
		System.out.println(cc.getEspacios().obtenerEspacios());
		for(java.util.Map.Entry<Integer, Espacio> entry: cc.getEspacios().obtenerEspacios().entrySet()) {
			if (entry.getValue().getEstado().getEstado() == "Ocupado") {
				System.out.println("Si esta ocupado");
				dtm.addRow(new Object[] {entry.getKey(), entry.getValue().getEstado().getEstado(), entry.getValue().getUsuario(), entry.getValue().getHoraReserva()});
			}
//			dtm.addRow(new Object[] {entry.getKey(), entry.getValue().getEstado().getEstado(), entry.getValue().getUsuario(), entry.getValue().getHoraReserva()});
			System.out.println("Agregando fila: " + entry.getValue().getId());
			dtm.fireTableDataChanged();
		}
	}
	
	public void setIdEspacio(int id){
		this.idEspacio = id;
	}
}
