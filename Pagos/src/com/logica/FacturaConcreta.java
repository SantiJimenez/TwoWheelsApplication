package com.logica;

import java.util.Date;

import estructura.modelos.Espacio;
import estructura.modelos.Factura;
import estructura.modelos.Usuario;

public class FacturaConcreta extends Factura{
	
	//estoy poniendo algunos, despues miro si se necesitan mas o menos atributos
	
	private Pago pago;
	
	public FacturaConcreta(int id, int idUsuario, int idEspacio, int tiempo){
		this.id = id;
		this.idUsuario = idUsuario;
		this.idEspacio = idEspacio;
		this.valor = tiempo*0.25;
		this.fecha = new Date();
		this.tiempo = tiempo;
	}	
	
	public void setTipoPago(Pago pago){
		this.pago = pago;
	}
	
	public float pagar(Tarjeta tarjeta){
		return pago.pagar(tarjeta, this.tiempo);
	}
	
}
