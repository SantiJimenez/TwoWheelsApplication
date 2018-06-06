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
import estructura.modelos.Factura;
import estructura.modelos.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class VentanaListaFacturas extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTable tblFacturas;
	private JLabel lblEspacios;
	private JScrollPane scrollPane;

	protected ConectorComponentes cc;
	protected DefaultTableModel dtm;
	
	protected VentanaElegirEspacio vElegirEspacio;
	
	/**
	 * Create the frame.
	 */
	public VentanaListaFacturas(ConectorComponentes cc) {
		
		this.cc = cc;
		
		this.dtm = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Identificador", "Usuario", "Espacio", "valor"
		});
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblEspacios = new JLabel("FACTURAS");
		lblEspacios.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspacios.setBounds(10, 11, 434, 14);
		contentPane.add(lblEspacios);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 434, 204);
		contentPane.add(scrollPane);
		
		tblFacturas = new JTable(dtm);
		tblFacturas.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(tblFacturas);
		
		listarFacturas();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public void listarFacturas(){
		System.out.println("--------------------");
		System.out.println("Listando Facturas");
		dtm.setRowCount(0);
		System.out.println(cc.getRecaudo().obtenerListaFacturas());
		for(java.util.Map.Entry<Integer, Factura> entry: cc.getRecaudo().obtenerListaFacturas().entrySet()) {
		   dtm.addRow(new Object[] {entry.getKey(), entry.getValue().getIdUsuario(), entry.getValue().getIdEspacio(), entry.getValue().getValor()});
		   System.out.println("Agregando fila: " + entry.getValue().getId());
		   dtm.fireTableDataChanged();
		}
	}
}
