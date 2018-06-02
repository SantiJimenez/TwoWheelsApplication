package estructura.interfaces;

public interface IUsuarios {
	
	void crearUsuario(int idUsuario, String nombreUsuario, String telefonoEstudiantes, String documentoUsuario);
	void eliminarUsuario(int idUsuario);
	void actualizarUsuario(int idUsuario, String nombreUsuario, String telefonoEstudiantes, String documentoUsuario);
	void listarUsuarios();
}
