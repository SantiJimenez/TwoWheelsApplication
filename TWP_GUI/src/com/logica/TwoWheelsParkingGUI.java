package com.logica;

import java.awt.Frame;

import javax.swing.JOptionPane;

import estructura.interfaces.IVisualizacion;

public class TwoWheelsParkingGUI implements IVisualizacion{

	@Override
	public void iniciarAplicacion() {
		JOptionPane.showMessageDialog(new Frame(), "Iniciando aplicación", this.getClass().getName(), JOptionPane.INFORMATION_MESSAGE);		
	}

}
