package com.logica;

public class TarjetaFrecuente extends Tarjeta{

	public TarjetaFrecuente(int id, int idCliente) {
		this.id = id; //generación de id incrementales, por separado los id de Ocasionales y Frecuentes, supongo 
		this.idCliente = idCliente;
		this.codigoBarras = "codigoBarras";
		this.tasa = 1; 
	}
	
}