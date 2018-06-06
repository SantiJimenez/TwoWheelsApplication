package com.logica;

import java.util.Hashtable;

import estructura.interfaces.IUsuarios;
import estructura.modelos.Usuario;

public class GestorUsuarios implements IUsuarios{

	private Hashtable<Integer, Usuario> listaUsuarios;
	private Usuario prototipo;
	
	public GestorUsuarios(){
		this.listaUsuarios = new Hashtable<Integer, Usuario>();
	}
	
	@Override
	public void actualizarUsuario(int id, String nombre, String apellido, String telefono) {
		Usuario usuario = listaUsuarios.get(id);
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setTelefono(telefono);
		
		listaUsuarios.replace(id, usuario);
	}

	@Override
	public void crearUsuario(int id, String nombre, String apellido, String telefono, String tipo) {
		
		Usuario usuario = null;
		
		if(tipo == "Cliente"){
			prototipo = new ClienteFinal(id, nombre, apellido, telefono);
			usuario = prototipo.clonar(id, nombre, apellido, telefono);
		}
		
		if(tipo == "Operario"){
			prototipo = new Operario(id, nombre, apellido, telefono);
			usuario = prototipo.clonar(id, nombre, apellido, telefono);
		}
		
		if(tipo == "Administrador"){
			prototipo = new Administrador(id, nombre, apellido, telefono);
			usuario = prototipo.clonar(id, nombre, apellido, telefono);
		}
		
		listaUsuarios.put(id, usuario);
		
	}

	@Override
	public void eliminarUsuario(int id) {
		listaUsuarios.remove(id);
	}

//	@Override
	public Usuario obtenerUsuario(int id) {
		return listaUsuarios.get(id);
	}
	
//	@Override
	public Hashtable<Integer, Usuario> obtenerListaUsuarios(){
		return this.listaUsuarios;
	}



}
