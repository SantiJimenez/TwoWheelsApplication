package estructura.interfaces;

import java.util.Hashtable;

import estructura.modelos.Factura;

public interface IRecaudo {
	
	void captarPago(int monto, int idUsuario, int idEspacio, int idTarjeta);
	void crearTarjeta(int id, int idCliente, String codigoBarras);
	Hashtable<Integer, Factura> obtenerListaFacturas();
	
}
