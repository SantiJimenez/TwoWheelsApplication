package com.logica;

public class PagoCredito extends Pago{

	@Override
	public float pagar(Tarjeta tarjeta, int tiempo) {
		// TODO Auto-generated method stub
		return tarjeta.tasa * tiempo;
	}

}
