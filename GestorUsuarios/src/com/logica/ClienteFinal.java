package com.logica;

public class ClienteFinal extends Usuario{

	public ClienteFinal(String nombre, String apellido, String telefono){
		this.id = 1;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}
	
	@Override
	public Usuario clonar(String nombre, String apellido, String telefono) {
		Usuario usuario = new ClienteFinal(nombre, apellido, telefono);
		return usuario;
	}
	
}
