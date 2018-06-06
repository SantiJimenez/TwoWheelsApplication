package estructura.interfaces;

public interface IRecaudo {
	
	void captarPago(int monto, int idUsuario, int idEspacio, int idTarjeta);
	void crearTarjeta(int id, int idCliente, String codigoBarras);
	
}
