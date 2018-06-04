package com.logica;

public abstract class Registro {
	
	protected Evento evento;
	protected int idRegistro;
	
	public void registrar(){
		evento.registro();
	}
	
	public void setEvento(Evento evento){
		this.evento = evento;
	}
	
}
