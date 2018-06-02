package estructura.modelos;

public abstract class Espacio {

	private int id;
	private Usuario usuario;
	private Estado estado;
	private int tiempoUso;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public int getTiempoUso() {
		return tiempoUso;
	}
	public void setTiempoUso(int tiempoUso) {
		this.tiempoUso = tiempoUso;
	}
		
}
