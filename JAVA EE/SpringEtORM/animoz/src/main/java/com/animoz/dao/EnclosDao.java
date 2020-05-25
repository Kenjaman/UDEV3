package com.animoz.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.animoz.modele.Enclos;

@Repository
public class EnclosDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Enclos> getEnclos() {
		return em.createQuery("select e from Enclos e order by e.numero", Enclos.class).getResultList();
	}
	
	public Enclos getEnclos(long idEnclos) {
		return em.find(Enclos.class, idEnclos);
	}
	
	public int getNbIndEnclos(long idEnclos) {
		return (int) em.createQuery("select sum(p.nombreIndividus) from Enclos e join Population p on e.id=p.enclos_id group by e.id").getSingleResult();
	}


}
