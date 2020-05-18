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

	public boolean existe(String nomAnimal) {
		long nb = em.createQuery("select count(a) from Animal a where lower(a.nom) = lower(:nom)", Long.class)
				    .setParameter("nom", nomAnimal)
				    .getSingleResult();
		return nb > 0;
	}
	
	public void ajouter(Animal animal) {
		em.persist(animal);
	}

//	public void modifier(Animal animal) { -----> Ca marchait mais tant pis, viva springa !! 
//		em.createQuery("Update Animal a SET a.nom = :nom, a.description = :description,"
//				+ " a.origine = :origine, a.regime = :regime, a.espece.id = :espece_id where a.id = :id")
//		.setParameter("nom", animal.getNom())
//		.setParameter("description", animal.getDescription())
//		.setParameter("origine", animal.getOrigine())
//		.setParameter("regime", animal.getRegime())
//		.setParameter("espece_id", animal.getEspece().getId())
//		.setParameter("id", animal.getId())
//		.executeUpdate();
//		
//	}
}
