package com.logica;

public class TarjetaOcasional extends Tarjeta{

	public TarjetaOcasional(int id, int idCliente) {
		this.id = id; //generaci�n de id incrementales, por separado los id de Ocasionales y Frecuentes, supongo 
		this.idCliente = idCliente;
		this.codigoBarras = "codigoBarras";
		this.tasa = 2;
	}
	
	
}
