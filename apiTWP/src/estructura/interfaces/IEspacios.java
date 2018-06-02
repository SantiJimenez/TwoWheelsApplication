package estructura.interfaces;

import estructura.modelos.Espacio;
import estructura.modelos.Estado;
import estructura.modelos.Usuario;

public interface IEspacios {

	void cambiarEstadoEspacio(Espacio espacio, Estado estado);
	void asignarUsuario(Usuario usuario);
	void crearEspacio(int idEspacio);
	void eliminarEspacio(int idEspacio);
	void registrarTiempo();
	void listarEspacios();
}
