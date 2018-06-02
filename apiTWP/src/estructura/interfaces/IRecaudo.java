package estructura.interfaces;

import estructura.modelos.Espacio;
import estructura.modelos.Usuario;

public interface IRecaudo {
	
	/**
	 * @param monto
	 * @param usuario
	 * @param espacio
	 */
	void captarPago(int monto, Usuario usuario, Espacio espacio);
	void calcularTarifa(int tiempo);
	
}
