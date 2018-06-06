package com.logica;

import java.util.Hashtable;
import estructura.modelos.Usuario;
import presentacion.VentanaInicial;

public class TwoWheelsDigital {
	
	protected static ConectorComponentes cc;
	
	public static void main(String[] args) {
		
		cc = new ConectorComponentes();
		
		cc.getUsuarios().crearUsuario(1, "Daniela", "Cordoba", "12345678", "Cliente");
		cc.getUsuarios().crearUsuario(2, "Santiago", "Jimenez", "23456789", "Cliente");
		cc.getUsuarios().crearUsuario(3, "Johan", "Quiroga", "123", "Cliente");
		cc.getUsuarios().crearUsuario(4, "Pedro", "Cardona", "5678", "Operario");
		cc.getUsuarios().crearUsuario(5, "Laura", "Garcia", "234569", "Operario");
		cc.getUsuarios().crearUsuario(6, "Alejandro", "Gonzalez", "23123", "Administrador");
		
		
		cc.getEspacios().crearEspacio(1);
		cc.getEspacios().crearEspacio(2);
		cc.getEspacios().crearEspacio(3);
		
		VentanaInicial vInicial = new VentanaInicial(cc);
		vInicial.setVisible(true);
		
		
		//listaUsuarios = cc.getUsuarios().obtenerListaUsuarios();
		
		//System.out.println(listaUsuarios);
		//System.out.println(cc.getUsuarios().obtenerUsuario(1).getNombre());
		//System.out.println(cc.getUsuarios().obtenerUsuario(2).getNombre());
		
		// cc.getAnalitica().calcularGanancias();
		
		/*Cargador cargadorNegocio= new Cargador("negocio", ClassLoader.getSystemClassLoader());
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
		}*/

	}

}
