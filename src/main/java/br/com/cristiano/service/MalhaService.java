package br.com.cristiano.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cristiano.dao.MalhaDAO;
import br.com.cristiano.entity.Malha;

@Component
public class MalhaService {

	@Autowired
	private MalhaDAO malhaDAO;
	
	public void salvar(Malha malha){
		malhaDAO.salvar(malha);
	}
	
	public List<Malha> findBy(String origem){
		return malhaDAO.findBy(origem);
	}
	
	public List<Malha> findAll(){
		return malhaDAO.findAll();
	}
	
	public int delete(){
		return malhaDAO.delete();
	}
}

