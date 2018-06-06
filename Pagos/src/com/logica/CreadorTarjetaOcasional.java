package com.logica;

import estructura.modelos.Usuario;

public class CreadorTarjetaOcasional extends CreadorTarjeta{

	@Override
	public Tarjeta crearTarjeta(int id, int idCliente) {
		return new TarjetaOcasional(id, idCliente);
	}

} 