package com.logica;

import estructura.modelos.Usuario;

public class Administrador extends Usuario{

	public Administrador(int id, String nombre, String apellido, String telefono){
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.tipo = "Administrador";
	}
	
	@Override
	public Usuario clonar(int id, String nombre, String apellido, String telefono) {
		Usuario usuario = new Administrador(id, nombre, apellido, telefono);
		return usuario;
	}

	
}
