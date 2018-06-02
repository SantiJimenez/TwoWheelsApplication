package com.logica;

import estructura.modelos.Usuario;

public abstract class Tarjeta {
	
	protected int id;
	protected Usuario cliente;
	protected String codigoBarras;
	protected float tasa;
	
	public int getId() {
		return id;
	}
	
	public Usuario getCliente() {
		return cliente;
	}
	
	public String getCodigoBarras() {
		return codigoBarras;
	}
	
	public float getTasa() {
		return tasa;
	}
	
}
