package com.logica;

public class EstadoDisponible extends Estado{

	public EstadoDisponible(){
		super("Disponible");
	}

	@Override
	public void actualizarEstado() {
		System.out.println("Actualizando estado a Disponible");		
	}
	
	
}
