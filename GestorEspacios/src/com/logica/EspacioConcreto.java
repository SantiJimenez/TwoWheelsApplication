package com.logica;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import estructura.modelos.Espacio;

public class EspacioConcreto extends Espacio{
	
	public EspacioConcreto(int id){
		this.id = id; 
		this.estado = new EstadoDisponible();
		this.idUsuario = 0;
		this.horaReservaMilisegundos = 0;
		this.horaReserva = null;
	}
	
	@Override
	public void liberar(){
		this.estado = new EstadoDisponible();
		this.estado.actualizarEstado();
		this.idUsuario = 0;
		this.horaReservaMilisegundos = 0;
		this.horaReserva = null;
	}
	
	@Override
	public void solicitar(int idUsuario){
		this.estado = new EstadoOcupado();
		this.estado.actualizarEstado();
		this.idUsuario = idUsuario;
		
		Date horaReserva = new Date();
		this.horaReserva = horaReserva;
		this.horaReservaMilisegundos = horaReserva.getTime();
		System.out.println("Hora reservacion: " + this.horaReserva);
	}
	
}
