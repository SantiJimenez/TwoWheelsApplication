package com.logica;

import estructura.modelos.Usuario;

public class ClienteFinal extends Usuario{

	public ClienteFinal(int id, String nombre, String apellido, String telefono){
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.tipo = "Cliente";
	}
	
	@Override
	public Usuario clonar(int id, String nombre, String apellido, String telefono) {
		Usuario usuario = new ClienteFinal(id, nombre, apellido, telefono);
		return usuario;
	}
	
}
