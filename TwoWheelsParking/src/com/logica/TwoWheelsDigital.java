package com.logica;

import estructura.interfaces.IAnalitica;
import estructura.interfaces.IEspacios;
import estructura.interfaces.IRecaudo;
import estructura.interfaces.IUsuarios;
import estructura.interfaces.IVisualizacion;

public class TwoWheelsDigital {

	public static void main(String[] args) {
		Cargador cargadorNegocio= new Cargador("negocio", ClassLoader.getSystemClassLoader());
		Cargador cargadorPresentacion= new Cargador("presentacion", ClassLoader.getSystemClassLoader());
		
		System.out.println("Antes del try");
		try {
			System.out.println("En el try");
			Class cls = (Class)cargadorNegocio.cargarUnaClaseDesdeSuDirectorio(IRecaudo.class.getName());
			System.out.println("cls " + cls.getName());
			if(cls!=null) {
				IRecaudo recaudo =(IRecaudo)cls.newInstance();
				if(recaudo!=null) {
					System.out.println("En metodos recaudo");
					recaudo.calcularTarifa(0);
					recaudo.captarPago(0, null, null);
				}
			}
			cls = (Class)cargadorNegocio.cargarUnaClaseDesdeSuDirectorio(IAnalitica.class.getName());
			if(cls!=null) {
				IAnalitica analitica = (IAnalitica)cls.newInstance();					
				if(analitica!=null) {
					analitica.calcularGanancias();
					analitica.calcularIngresosVehiculos();
					analitica.calcularRetirosVehiculos();
				}
			}
			cls = (Class)cargadorNegocio.cargarUnaClaseDesdeSuDirectorio(IEspacios.class.getName());
			if(cls!=null) {
				IEspacios espacios = (IEspacios)cls.newInstance();
				if(espacios!=null) {
					espacios.asignarUsuario(null);
					espacios.cambiarEstadoEspacio(null, null);
					espacios.crearEspacio(0);
					espacios.eliminarEspacio(0);
					espacios.listarEspacios();
					espacios.registrarTiempo();
				}
			}
			
			cls = (Class)cargadorNegocio.cargarUnaClaseDesdeSuDirectorio(IUsuarios.class.getName());
			if(cls!=null) {
				IUsuarios usuarios = (IUsuarios)cls.newInstance();
				if(usuarios!=null) {
					usuarios.actualizarUsuario(0, null, null, null);
					usuarios.crearUsuario(0, null, null, null);
					usuarios.eliminarUsuario(0);
					usuarios.listarUsuarios();
				}
			}
			
			cls = cargadorPresentacion.cargarUnaClaseDesdeSuDirectorio(IVisualizacion.class.getName());
			if(cls!=null) {
				IVisualizacion gui = (IVisualizacion)cls.newInstance();
				if(gui!=null) {
					gui.iniciarAplicacion();
				}
			}

		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("En el catch");
			e.printStackTrace();
		}

	}

}
