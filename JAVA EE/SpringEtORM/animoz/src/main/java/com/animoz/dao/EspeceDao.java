package com.animoz.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.animoz.modele.Espece;

@Repository
public class EspeceDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Espece> getEspeces() {
		return em.createQuery("select e from Espece e order by e.nom", Espece.class).getResultList();
	}
	
	public Espece getEspece(String nom) {
		List<Espece> list= em.createQuery("Select e from Espece e where e.nom = :nom",Espece.class).setParameter("nom", nom).getResultList();
		if(list.size()==1)
			return list.get(0);
		else 
			return null;
	}

	public boolean existe(String nomEspece) {
		long nb = em.createQuery("select count(e) from Espece e where lower(e.nom) = lower(:nom)", Long.class)
				    .setParameter("nom", nomEspece)
				    .getSingleResult();
		return nb > 0;
	}

	public void ajouter(Espece espece) {
		em.persist(espece);
	}

	public void supprimer(Espece espece) { // est ce ici qu'il faut lancer la constrainteException ? ou
		em.remove(espece);

//		return em.createQuery("delete from Espece e where e.nom = :nom")
//		.setParameter("nom", espece.getNom())
//		.executeUpdate();
	}

}
