package br.com.cristiano.dao;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class BaseDAO {

	protected EntityManager entityManager;
	
	@PostConstruct
	public void init(){
		entityManager = getEntityManager();
	}
	
	private EntityManager getEntityManager(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		EntityManager em = emf.createEntityManager();
		return em;
	}
}
