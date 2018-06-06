package estructura.modelos;

public abstract class Estado {

	protected String estado;
	
	public Estado(String estado){
		this.estado = estado;
	}
	
	public String getEstado(){
		return estado;
	}
	
	public abstract void actualizarEstado();
	
}
