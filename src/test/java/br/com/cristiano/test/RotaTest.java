package br.com.cristiano.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.collections.map.MultiValueMap;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import br.com.cristiano.app.Application;
import br.com.cristiano.entity.Estrutura;
import br.com.cristiano.entity.Rota;
import br.com.cristiano.service.RotaService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes={Application.class})
@IntegrationTest("server.port=8080")
@WebAppConfiguration
public class RotaTest {

	private String HOST = "http://localhost:8080/";
	private final BigDecimal VALOR_COMBUSTIVEL = new BigDecimal(2);
	private final int AUTONOMIA = 10;
	private RestTemplate restTemplate = new TestRestTemplate();
	
	@Autowired
	private RotaService rotaService;

	@Test
	public void healthCheck(){
		ResponseEntity<String> entity = this.restTemplate.getForEntity(HOST+"/healthCheck", String.class);
		HttpStatus statusCode = entity.getStatusCode();
		Assert.assertEquals(HttpStatus.OK, statusCode);
	}
	
	@Test
	public void calculoCorreto(){
		Estrutura e = new Estrutura();
		e.setDistanciaPercorrida(20);
		
		BigDecimal custo = e.calcularGasto(VALOR_COMBUSTIVEL, AUTONOMIA);
		Assert.assertEquals(new BigDecimal(4), custo);
	}
	
	@Test
	public void salvarMalha(){
		LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("origem", "A");
		params.add("destino", "B");
		params.add("distancia", "10");
		
		ResponseEntity<String> entity = this.restTemplate.postForEntity(HOST+"/malha", params, String.class);
		Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
	}
	
	@Test
	public void buscarMenorRota(){
		List<Rota> list = new ArrayList<Rota>();
		Rota rota = new Rota();
		rota.setDistancia(10);
		rota.setRota("ABCD");
		list.add(rota);
		
		rota = new Rota();
		rota.setDistancia(100);
		rota.setRota("AGCD");
		list.add(rota);
		
		rota = new Rota();
		rota.setDistancia(9);
		rota.setRota("AD");
		list.add(rota);
		
		Rota r = rotaService.buscarMenorRota(list);
		
		Assert.assertEquals(9, r.getDistancia());
	}
	
}
 