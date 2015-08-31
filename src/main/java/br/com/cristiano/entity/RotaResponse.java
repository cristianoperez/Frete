package br.com.cristiano.entity;

import java.math.BigDecimal;

public class RotaResponse {

	private String mapa;
	private String origem;
	private String destino;
	private String trajeto;
	private int distanciaPercorrida;
	private BigDecimal valorTotal = new BigDecimal(0);

	public int getDistanciaPercorrida() {
		return distanciaPercorrida;
	}

	public void setDistanciaPercorrida(int distanciaPercorrida) {
		this.distanciaPercorrida = distanciaPercorrida;
	}

	public String getMapa() {
		return mapa;
	}

	public void setMapa(String mapa) {
		this.mapa = mapa;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getTrajeto() {
		return trajeto;
	}

	public void setTrajeto(String trajeto) {
		this.trajeto = trajeto;
	}

}
