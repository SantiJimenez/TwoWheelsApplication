package com.logica;

public class Espacio {

	protected int id;
	protected Estado estado;
	protected int idUsuario;
	protected int horaReserva;
	
	public Espacio(){
		this.id = 1; 
		this.estado = new EstadoDisponible();
		this.idUsuario = 0;
		this.horaReserva = 0;
	}
	
	public void liberar(){
		this.estado = new EstadoDisponible();
		this.estado.actualizarEstado();
		this.idUsuario = 0;
		this.horaReserva = 0;
	}
	
	public void solicitar(int idUsuario){
		this.estado = new EstadoOcupado();
		this.estado.actualizarEstado();
		this.idUsuario = idUsuario;
	}
	
}
