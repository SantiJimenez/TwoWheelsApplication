package estructura.modelos;

import java.util.Date;

public abstract class Espacio {

	protected int id;
	protected Estado estado;
	protected int idUsuario;
	protected long horaReservaMilisegundos;
	protected Date horaReserva;
		
	public abstract void liberar();
	public abstract void solicitar(int idUsuario);
	
	public int getId(){
		return id;
	}
	
	
	public Estado getEstado(){
		return estado;
	}
	
	public int getUsuario(){
		return idUsuario;
	}
	
	public Date getHoraReserva(){
		return horaReserva;
	}
	
	public long getHoraReservaMilisegundos(){
		return horaReservaMilisegundos;
	}
	
}
