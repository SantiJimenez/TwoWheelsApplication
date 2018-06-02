package com.logica;

import estructura.modelos.Usuario;

public class CreadorTarjetaFrecuente extends CreadorTarjeta{

	@Override
	public Tarjeta crearTarjeta(Usuario cliente) {
		return new TarjetaFrecuente(cliente);
	}
	
	
}
