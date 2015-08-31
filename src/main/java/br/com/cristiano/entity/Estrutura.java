package br.com.cristiano.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Estrutura {

	private String origem;
	private int distancia;
	private int distanciaPercorrida;
	private List<Estrutura> destinos = new ArrayList<>();
	
	public Estrutura() {
	
	}
	
	public Estrutura(Malha malha) {
		origem = malha.getOrigem();
	}
	
	public BigDecimal calcularGasto(BigDecimal valorCombustivel, int autonomia){
		return valorCombustivel.multiply(new BigDecimal(distanciaPercorrida)).divide(new BigDecimal(autonomia));
	}
	
	public int getDistanciaPercorrida() {
		return distanciaPercorrida;
	}

	public void setDistanciaPercorrida(int distanciaPercorrida) {
		this.distanciaPercorrida = distanciaPercorrida;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public List<Estrutura> getDestinos() {
		return destinos;
	}

	public void setDestinos(List<Estrutura> destinos) {
		this.destinos = destinos;
	}

	@Override
	public String toString() {
		return "Estrutura [origem=" + origem + ", distancia=" + distancia + ", distanciaPercorrida="
				+ distanciaPercorrida + ", destinos=" + destinos + "]";
	}
	
}
