package estructura.modelos;

import java.util.Date;

import estructura.modelos.Espacio;
import estructura.modelos.Usuario;

public abstract class Factura {

	protected int id;
	protected int idUsuario;
	protected int idEspacio;
	protected double valor;
	protected Date fecha;
	protected int tiempo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdEspacio() {
		return idEspacio;
	}
	public void setIdEspacio(int idEspacio) {
		this.idEspacio = idEspacio;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getTiempo() {
		return tiempo;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	
}
