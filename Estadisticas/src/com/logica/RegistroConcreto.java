package com.logica;

public class RegistroConcreto extends Registro{

	public RegistroConcreto(){
	}
	
	public int getId(){
		return this.idRegistro;
	}
	
	public Evento getEvento(){
		return this.evento;
	}
}
