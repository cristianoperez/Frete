package br.com.cristiano.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cristiano.entity.Malha;

@Repository
public class MalhaDAO extends BaseDAO {
	
	public List<Malha> findBy(String origem){
		Query query = entityManager.createQuery("SELECT m from Malha m WHERE m.origem = :origem");
		query.setParameter("origem", origem);
		return query.getResultList();
	}

	public void salvar(Malha malha) {
		entityManager.getTransaction().begin();
		entityManager.persist(malha);
		entityManager.getTransaction().commit();
	}
	
	public List<Malha> findAll(){
		Query query = entityManager.createQuery("SELECT m from Malha m");
		return query.getResultList();
	}
	
	public int delete(){
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("DELETE FROM Malha");
		int result = query.executeUpdate();
		entityManager.getTransaction().commit();
		return result;
	}
}
