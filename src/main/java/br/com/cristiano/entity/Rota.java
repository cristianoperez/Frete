package br.com.cristiano.entity;

import java.math.BigDecimal;

public class Rota implements Cloneable {

	private String rota;
	private int distancia;
	private BigDecimal gasto;

	public String getRota() {
		return rota;
	}

	public void setRota(String rota) {
		this.rota = rota;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
	

	public BigDecimal getGasto() {
		return gasto;
	}

	public void setGasto(BigDecimal gasto) {
		this.gasto = gasto;
	}

	@Override
	public String toString() {
		return "R [rota=" + rota + ", distancia=" + distancia + "]";
	}

	public Rota clone() {
		try {
			return (Rota) super.clone();
		} catch (CloneNotSupportedException e) {
			return this;
		}
	}

}
