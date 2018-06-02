package com.logica;

public class PagoEfectivo extends Pago{

	@Override
	public float pagar(Tarjeta tarjeta, int tiempo) {
		// TODO Auto-generated method stub
		if(tarjeta.getClass().getName() == "TarjetaFrecuente"){
			
		}// creo que esto no se necesita
		
		return tarjeta.getTasa() * tiempo;
	}

}
