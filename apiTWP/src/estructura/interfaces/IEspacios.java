package estructura.interfaces;

import java.util.Hashtable;

import estructura.modelos.Espacio;

public interface IEspacios {

	public void cambiarEstadoEspacio(int idEspacio, int idUsuario, String estado);
	public void crearEspacio(int idEspacio);
	public void eliminarEspacio(int idEspacio);
	public Hashtable<Integer, Espacio> obtenerEspacios();
}
