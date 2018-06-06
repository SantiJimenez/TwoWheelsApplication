package com.logica;

public abstract class Tarjeta {
	
	protected int id;
	protected int idCliente;
	protected String codigoBarras;
	protected float tasa;
	
	public int getId() {
		return id;
	}
	
	public int getCliente() {
		return idCliente;
	}
	
	public String getCodigoBarras() {
		return codigoBarras;
	}
	
	public float getTasa() {
		return tasa;
	}
	
}
