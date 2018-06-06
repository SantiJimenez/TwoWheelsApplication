package estructura.interfaces;

import java.util.Hashtable;
import estructura.modelos.Usuario;

public interface IUsuarios {
	
	void crearUsuario(int id, String nombreUsuario, String apellidoApellido, String telefono, String tipo);
	void eliminarUsuario(int idUsuario);
	void actualizarUsuario(int idUsuario, String nombreUsuario, String apellidoUsuario, String telefono);
	Usuario obtenerUsuario(int id);
	Hashtable<Integer, Usuario> obtenerListaUsuarios();

}
