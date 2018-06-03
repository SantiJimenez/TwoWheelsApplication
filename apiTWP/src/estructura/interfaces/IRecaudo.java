package estructura.interfaces;

public interface IRecaudo {
	
	/**
	 * @param monto
	 * @param usuario
	 * @param espacio
	 */
	void captarPago(int monto, int idUsuario, int idEspacio);
	void calcularTarifa(int tiempo);
	
}
