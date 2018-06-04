package com.logica;

public class FabricaReporteEspacios extends FabricaReporte{

	@Override
	public ReporteUsuarios crearReporteUsuarios() {
		System.out.println("Creando reporte de tiempo de aparcamiento");
		return new ReporteTiempoAparcamiento();
	}

	@Override
	public ReporteEspacios crearReporteEspacios() {
		System.out.println("Creando reporte de disponibilidad de espacios");
		return new ReporteDisponibilidad();
	}

}
