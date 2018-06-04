package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
	private JButton btnEditarUsuario, btnBuscarUsuario;

	/**
	 * Create the frame.
	 */
	public VentanaListaUsuarios() {
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
		
		tblUsuarios = new JTable();
		tblUsuarios.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(tblUsuarios);
		
		btnEditarUsuario = new JButton("Editar Usuario");
		btnEditarUsuario.setBounds(513, 43, 138, 23);
		btnEditarUsuario.setActionCommand("EDITAR");
		btnEditarUsuario.addActionListener(this);
		contentPane.add(btnEditarUsuario);
		
		btnBuscarUsuario = new JButton("Buscar Usuario");
		btnBuscarUsuario.setBounds(513, 77, 138, 23);
		btnBuscarUsuario.setActionCommand("BUSCAR");
		btnBuscarUsuario.addActionListener(this);
		contentPane.add(btnBuscarUsuario);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String accion = e.getActionCommand();
		
		if(accion == "EDITAR") {
			System.out.println("Editando usuario");
			JOptionPane.showMessageDialog(this, "Editando Usuario");
		}
		
		if(accion == "BUSCAR") {
			System.out.println("Buscando usuario");
			JOptionPane.showMessageDialog(this, "Buscando Usuario");
		}
	}
}
