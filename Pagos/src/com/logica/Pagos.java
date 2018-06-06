package com.logica;

import java.util.Hashtable;

import estructura.interfaces.IRecaudo;
import estructura.modelos.Factura;

public class Pagos implements IRecaudo {

	private Hashtable<Integer, Factura> listaFacturas;
	
	public Pagos() {
		this.listaFacturas = new Hashtable<Integer, Factura>();
	}
	
	@Override
	public void captarPago(int id, int idUsuario, int idEspacio, int tiempo) {
		FacturaConcreta factura = new FacturaConcreta(id, idUsuario, idEspacio, tiempo);
		listaFacturas.put(id, factura);
	}

	@Override
	public void crearTarjeta(int arg0, int arg1, String arg2) {
		// TODO Auto-generated method stub
	}

	@Override
	public Hashtable<Integer, Factura> obtenerListaFacturas() {
		return this.listaFacturas;
	}

}
