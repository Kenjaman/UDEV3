package com.permApp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.permApp.modele.Plante;

@Repository
public class PlanteDao {
	
	@PersistenceContext
	private EntityManager em;

	public Plante getPlante(long planteId) {
		return em.find(Plante.class, planteId);
	}

	public List<Plante> getPlantes() {
		return em.createQuery("select p from Plante p order by p.nom", Plante.class).getResultList();
	}

}
