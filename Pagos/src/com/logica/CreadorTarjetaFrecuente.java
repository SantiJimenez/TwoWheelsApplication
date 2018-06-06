package com.logica;

import estructura.modelos.Usuario;

public class CreadorTarjetaFrecuente extends CreadorTarjeta{

	@Override
	public Tarjeta crearTarjeta(int id, int idCliente) {
		return new TarjetaFrecuente(id, idCliente);
	}
	
	
}
