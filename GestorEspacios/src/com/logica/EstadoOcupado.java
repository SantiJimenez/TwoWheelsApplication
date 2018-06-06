package com.logica;

import estructura.modelos.Estado;

public class EstadoOcupado extends Estado{

	public EstadoOcupado() {
		super("Ocupado");
	}

	@Override
	public void actualizarEstado() {
		System.out.println("Actualizando estado a Ocupado");		
	}

}
