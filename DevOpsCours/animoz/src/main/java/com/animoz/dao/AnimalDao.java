package com.animoz.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.animoz.modele.Animal;

@Repository
public class AnimalDao {
	
	@PersistenceContext
	private EntityManager em;

	public Animal getAnimal(long animalId) {
		return em.find(Animal.class, animalId);
	}

	public List<Animal> getAnimaux() {
		return em.createQuery("select a from Animal a order by a.nom", Animal.class).getResultList();
	}

}
