package com.logica;

import java.util.Hashtable;

import estructura.interfaces.IEspacios;
import estructura.modelos.Espacio;

public class GestorEspacios implements IEspacios {

	private Hashtable<Integer, Espacio> listaEspacios;
	
	public GestorEspacios() {
		listaEspacios = new Hashtable<Integer, Espacio>();
	}
	
	@Override
	public void cambiarEstadoEspacio(int idEspacio, int idUsuario, String estado) {
		
		if (estado == "Disponible") {
			Espacio espacio = listaEspacios.get(idEspacio);
			espacio.liberar();
		}
		
		if (estado == "Reservado") {
			Espacio espacio = listaEspacios.get(idEspacio);
			espacio.solicitar(idUsuario);
		}
	}

	@Override
	public void crearEspacio(int id) {
		EspacioConcreto espacio = new EspacioConcreto(id); 
		listaEspacios.put(espacio.getId(), espacio);
	}

	@Override
	public void eliminarEspacio(int idEspacio) {
		listaEspacios.remove(idEspacio);		
	}

	@Override
	public Hashtable<Integer, Espacio> obtenerEspacios() {
		return listaEspacios;
	}

}
