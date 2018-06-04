package com.logica;

import estructura.interfaces.IAnalitica;
import estructura.interfaces.IEspacios;
import estructura.interfaces.IRecaudo;
import estructura.interfaces.IUsuarios;
import estructura.interfaces.IVisualizacion;

public class ConectorComponentes {

	private Cargador cargadorNegocio;
	private IAnalitica analitica;
	private IRecaudo recaudo;
	private IUsuarios usuarios;
	private IEspacios espacios;
	
	public ConectorComponentes(){
		
		this.cargadorNegocio = new Cargador("negocio", ClassLoader.getSystemClassLoader());
		this.analitica = cargarInterfaceAnalitica();
		this.recaudo = cargarInterfaceRecaudo();
		this.usuarios = cargarInterfaceUsuarios();
		this.espacios= cargarInterfaceEspacios();
	}
	
	public IAnalitica cargarInterfaceAnalitica(){
		try {
			Class cls = (Class)cargadorNegocio.cargarUnaClaseDesdeSuDirectorio(IAnalitica.class.getName());
			if(cls!=null) {
				IAnalitica analitica =(IAnalitica)cls.newInstance();
				if(analitica!=null) {
					return analitica;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null; 
		}
		
		return null;
	}
	
	public IRecaudo cargarInterfaceRecaudo(){
		try {
			Class cls = (Class)cargadorNegocio.cargarUnaClaseDesdeSuDirectorio(IRecaudo.class.getName());
			if(cls!=null) {
				IRecaudo recaudo =(IRecaudo)cls.newInstance();
				if(recaudo!=null) {
					return recaudo;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null; 
		}
		
		return null;
	}
	
	public IEspacios cargarInterfaceEspacios(){
		try {
			Class cls = (Class)cargadorNegocio.cargarUnaClaseDesdeSuDirectorio(IEspacios.class.getName());
			if(cls!=null) {
				IEspacios espacios =(IEspacios)cls.newInstance();
				if(espacios!=null) {
					return espacios;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null; 
		}
		
		return null;
	}
	
	public IUsuarios cargarInterfaceUsuarios(){
		try {
			Class cls = (Class)cargadorNegocio.cargarUnaClaseDesdeSuDirectorio(IUsuarios.class.getName());
			if(cls!=null) {
				IUsuarios usuarios =(IUsuarios)cls.newInstance();
				if(usuarios!=null) {
					return usuarios;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null; 
		}
		
		return null;
	}
	
	

	public IAnalitica getAnalitica() {
		return analitica;
	}

	public IRecaudo getRecaudo() {
		return recaudo;
	}

	public IUsuarios getUsuarios() {
		return usuarios;
	}

	public IEspacios getEspacios() {
		return espacios;
	}
	
	
}
