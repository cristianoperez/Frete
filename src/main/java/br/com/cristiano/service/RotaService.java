package br.com.cristiano.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cristiano.dao.MalhaDAO;
import br.com.cristiano.entity.Estrutura;
import br.com.cristiano.entity.Malha;
import br.com.cristiano.entity.Rota;

@Component
public class RotaService {
	
	@Autowired
	private MalhaDAO malhaDAO;
	
	private List<Rota> rotas;
	private Estrutura estrutura;

	public Estrutura buildEstrutura(String origem, String destino){
		estrutura = new Estrutura();
		buildEstrutura(origem, destino, estrutura);
		return estrutura;
	}
	
	private void buildEstrutura(String origem, String destino, Estrutura estrutura){
		List<Malha> find = malhaDAO.findBy(origem);
		if(find != null){
			for (Malha malha : find) {
				estrutura.setOrigem(malha.getOrigem());
				
				Estrutura e = new Estrutura();
				e.setOrigem(malha.getDestino());
				e.setDistancia(malha.getDistancia());
				e.setDistanciaPercorrida(estrutura.getDistanciaPercorrida()+malha.getDistancia());
				
				estrutura.getDestinos().add(e);
				 
				if(!destino.equals(malha.getDestino())){
					for(Estrutura ee : estrutura.getDestinos()){
						if(ee.getOrigem().equalsIgnoreCase(e.getOrigem())){
							buildEstrutura(malha.getDestino(), destino, ee);
						}
					}
				}
			}
		}
	}
	
	public Rota buscarMenorRota(Estrutura estrutura, String destino, BigDecimal valorCombustivel, int autonomia){
		rotas = new ArrayList<Rota>();
		List<Rota> rotas = getRota(estrutura, destino, valorCombustivel, autonomia, new Rota());
		return buscarMenorRota(rotas);
	}
	
	public Rota buscarMenorRota(List<Rota> list){
		Rota menorRota = new Rota();
		for(Rota r : list){
			if(menorRota.getDistancia() == 0){
				menorRota = r;
			} else if(r.getDistancia() < menorRota.getDistancia()){
				menorRota = r;
			}
		}
		return menorRota;
	}

	private List<Rota> getRota(Estrutura estrutura, String destino, BigDecimal valorCombustivel, int autonomia, Rota rota) {
		Rota clone = rota.clone();
		clone.setRota(prepareNullString(clone.getRota()) + prepareNullString(estrutura.getOrigem()));
		clone.setDistancia(estrutura.getDistanciaPercorrida());
		clone.setGasto(estrutura.calcularGasto(valorCombustivel, autonomia));
		for(Estrutura e : estrutura.getDestinos()){
			if(!e.getOrigem().equalsIgnoreCase(destino)){
				getRota(e, destino, valorCombustivel, autonomia, clone);
			} else {
				clone.setRota(clone.getRota()+e.getOrigem());
				clone.setDistancia(e.getDistanciaPercorrida());
				clone.setGasto(e.calcularGasto(valorCombustivel, autonomia));
				rotas.add(clone);
			}
		}
		return rotas;
	}
	
	private String prepareNullString(String str){
		if(str==null){
			return "";
		}
		return str;
	}
	
}
