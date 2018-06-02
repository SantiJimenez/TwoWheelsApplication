package com.logica;

import java.awt.Frame;

import javax.swing.JOptionPane;

import estructura.interfaces.IRecaudo;
import estructura.modelos.Espacio;
import estructura.modelos.Usuario;

public class Pagos implements IRecaudo {

	@Override
	public void calcularTarifa(int arg0) {
		JOptionPane.showMessageDialog(new Frame(), "Calcular tarifa", this.getClass().getName(), JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void captarPago(int arg0, Usuario arg1, Espacio arg2) {
		JOptionPane.showMessageDialog(new Frame(), "Captar pago", this.getClass().getName(), JOptionPane.INFORMATION_MESSAGE);
	}

}
