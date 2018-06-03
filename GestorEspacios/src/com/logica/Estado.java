package com.logica;

public abstract class Estado {

	protected String estado;
	
	public Estado(String estado){
		this.estado = estado;
	}
	
	public abstract void actualizarEstado();
	
}
