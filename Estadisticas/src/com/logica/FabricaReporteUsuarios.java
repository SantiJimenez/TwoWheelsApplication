package com.logica;

public class FabricaReporteUsuarios extends FabricaReporte{

	@Override
	public ReporteUsuarios crearReporteUsuarios() {
		System.out.println("Creando reporte ingresos");
		return new ReporteIngresos();
	}

	@Override
	public ReporteEspacios crearReporteEspacios() {
		System.out.println("Creando reporte inventario");
		return new ReporteInventario();
	}

}
