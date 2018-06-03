package estructura.interfaces;

public interface IEspacios {

	void cambiarEstadoEspacio(int idEspacio, String estado);
	void asignarUsuario(int idUsuario);
	void crearEspacio(int idEspacio);
	void eliminarEspacio(int idEspacio);
	void registrarTiempo();
	void listarEspacios();
}
