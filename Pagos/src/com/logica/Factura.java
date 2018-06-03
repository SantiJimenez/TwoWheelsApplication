package com.logica;

import estructura.modelos.Espacio;
import estructura.modelos.Usuario;

public class Factura {

	private int id;
	private Usuario usuario;
	private Espacio espacio;
	private float valor;
	private String fecha;
	private int tiempo;
	
	//estoy poniendo algunos, despues miro si se necesitan mas o menos atributos
	
	private Pago pago;
	
	public Factura(int id, Usuario usuario, Espacio espacio, int tiempo){
		this.id = id;
		this.usuario = usuario;
		this.espacio = espacio;
		this.valor = 0;
		this.fecha = "fecha actual";
		this.tiempo = tiempo;
	}	
	
	public void setTipoPago(Pago pago){
		this.pago = pago;
	}
	
	public void pagar(Tarjeta tarjeta){
		pago.pagar(tarjeta, this.tiempo);
	}
	
}
