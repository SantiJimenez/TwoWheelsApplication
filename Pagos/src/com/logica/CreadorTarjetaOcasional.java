package com.logica;

import estructura.modelos.Usuario;

public class CreadorTarjetaOcasional extends CreadorTarjeta{

	@Override
	public Tarjeta crearTarjeta(Usuario cliente) {
		return new TarjetaOcasional(cliente);
	}

} 