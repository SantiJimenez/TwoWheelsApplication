package com.logica;

import java.awt.Frame;

import javax.swing.JOptionPane;

import estructura.interfaces.IEspacios;
import estructura.modelos.Espacio;
import estructura.modelos.Estado;
import estructura.modelos.Usuario;

public class GestorEspacios implements IEspacios {

	@Override
	public void asignarUsuario(Usuario arg0) {
		JOptionPane.showMessageDialog(new Frame(), "Asignar usuario", this.getClass().getName(), JOptionPane.INFORMATION_MESSAGE);
		
	}

	@Override
	public void cambiarEstadoEspacio(Espacio arg0, Estado arg1) {
		JOptionPane.showMessageDialog(new Frame(), "Cambiar estado espacio", this.getClass().getName(), JOptionPane.INFORMATION_MESSAGE);
		
	}

	@Override
	public void crearEspacio(int arg0) {
		JOptionPane.showMessageDialog(new Frame(), "Crear espacio", this.getClass().getName(), JOptionPane.INFORMATION_MESSAGE);
		
	}

	@Override
	public void eliminarEspacio(int arg0) {
		JOptionPane.showMessageDialog(new Frame(), "Eliminar espacio", this.getClass().getName(), JOptionPane.INFORMATION_MESSAGE);
		
	}

	@Override
	public void listarEspacios() {
		JOptionPane.showMessageDialog(new Frame(), "Listar espacios", this.getClass().getName(), JOptionPane.INFORMATION_MESSAGE);
		
	}

	@Override
	public void registrarTiempo() {
		JOptionPane.showMessageDialog(new Frame(), "Registrar tiempo", this.getClass().getName(), JOptionPane.INFORMATION_MESSAGE);
		
	}

}
