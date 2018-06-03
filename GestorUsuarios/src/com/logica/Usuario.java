package com.logica;

public abstract class Usuario {

	protected int id;
	protected String nombre;
	protected String apellido;
	protected String telefono;
	protected Usuario sucesor;
	
	public abstract Usuario clonar(String nombre, String apellido, String telefono); 
	public Usuario setSucesor(Usuario usuario){
		sucesor = usuario;
		return this;
	}
}
