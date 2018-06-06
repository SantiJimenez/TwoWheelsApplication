package com.logica;

import estructura.modelos.Usuario;

public class Operario extends Usuario{

	public Operario(int id, String nombre, String apellido, String telefono){
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.tipo = "Operario";
	}
	
	@Override
	public Usuario clonar(int id, String nombre, String apellido, String telefono) {
		Usuario usuario = new Operario(id, nombre, apellido, telefono);
		return usuario;
	}
	
}
