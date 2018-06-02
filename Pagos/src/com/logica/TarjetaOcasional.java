package com.logica;

import estructura.modelos.Usuario;

public class TarjetaOcasional extends Tarjeta{

	public TarjetaOcasional(Usuario cliente) {
		this.id = 0; //generación de id incrementales, por separado los id de Ocasionales y Frecuentes, supongo 
		this.cliente = cliente;
		this.codigoBarras = "codigoBarras";
		this.tasa = 2;
	}
	
	
}
