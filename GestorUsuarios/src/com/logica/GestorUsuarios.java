package com.logica;

import java.awt.Frame;

import javax.swing.JOptionPane;

import estructura.interfaces.IUsuarios;

public class GestorUsuarios implements IUsuarios{

	@Override
	public void actualizarUsuario(int arg0, String arg1, String arg2, String arg3) {
		JOptionPane.showMessageDialog(new Frame(), "Actualizar usuario", this.getClass().getName(), JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void crearUsuario(int arg0, String arg1, String arg2, String arg3) {
		JOptionPane.showMessageDialog(new Frame(), "Crear usuario", this.getClass().getName(), JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void eliminarUsuario(int arg0) {
		JOptionPane.showMessageDialog(new Frame(), "Eliminar usuario", this.getClass().getName(), JOptionPane.INFORMATION_MESSAGE);	
	}

	@Override
	public void listarUsuarios() {
		JOptionPane.showMessageDialog(new Frame(), "Listar Usuarios", this.getClass().getName(), JOptionPane.INFORMATION_MESSAGE);		
	}

}
