package com.animoz.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.animoz.modele.IPopulation;
import com.animoz.modele.Population;

@Repository
public class PopulationDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void ajouter(IPopulation population) {
		em.persist(population);
	}

	public List<Population> getPopulations() {
		return em.createQuery("Select p from Population p",Population.class).getResultList();
	}
}
