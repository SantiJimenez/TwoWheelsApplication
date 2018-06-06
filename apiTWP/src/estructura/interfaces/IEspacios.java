package estructura.interfaces;

public interface IEspacios {

	void cambiarEstadoEspacio(int idEspacio, int idUsuario, String estado);
	void crearEspacio(int idEspacio);
	void eliminarEspacio(int idEspacio);
}
