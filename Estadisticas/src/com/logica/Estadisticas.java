package com.logica;

import java.awt.Frame;

import javax.swing.JOptionPane;

import estructura.interfaces.IAnalitica;

public class Estadisticas implements IAnalitica{

	@Override
	public void calcularGanancias() {
		JOptionPane.showMessageDialog(new Frame(), "Calcular ganancias", this.getClass().getName(), JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void calcularIngresosVehiculos() {
		JOptionPane.showMessageDialog(new Frame(), "Vehiculos ingresados", this.getClass().getName(), JOptionPane.INFORMATION_MESSAGE);		
	}

	@Override
	public void calcularRetirosVehiculos() {
		JOptionPane.showMessageDialog(new Frame(), "Vehiculos retirados", this.getClass().getName(), JOptionPane.INFORMATION_MESSAGE);		
	}

}
