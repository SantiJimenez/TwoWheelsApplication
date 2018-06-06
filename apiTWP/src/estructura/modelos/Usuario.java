package estructura.modelos;

public abstract class Usuario {

	protected int id;
	protected String nombre;
	protected String apellido;
	protected String telefono;
	protected String tipo;
	protected Usuario sucesor;
	
	public abstract Usuario clonar(int id, String nombre, String apellido, String telefono); 
	
	public Usuario setSucesor(Usuario usuario){
		sucesor = usuario;
		return this;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipo() {
		return tipo;
	}

	public Usuario getSucesor() {
		return sucesor;
	}
	
	
}
