//package com.permApp.dao;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import org.springframework.stereotype.Repository;
//
//import com.permApp.modele.Espece;
//
//@Repository
//public class EspeceDao {
//	
//	@PersistenceContext
//	private EntityManager em;
//	
//	public List<Espece> getEspeces() {
//		return em.createQuery("select e from Espece e order by e.nom", Espece.class).getResultList();
//	}
//
//	public boolean existe(String nomEspece) {
//		long nb = em.createQuery("select count(e) from Espece e where lower(e.nom) = lower(:nom)", Long.class)
//				    .setParameter("nom", nomEspece)
//				    .getSingleResult();
//		return nb > 0;
//	}
//
//	public void ajouter(Espece espece) {
//		em.persist(espece);
//	}
//
//	public void supprimer(String nom) {
//		em.createQuery("delete from Espece e where e.nom = :nom")
//		  .setParameter("nom", nom)
//		  .executeUpdate();
//	}
//
//	public Espece get(String nom) {
//		List<Espece> especes = em.createQuery("select e from Espece e where e.nom = :nom", Espece.class)
//				                 .setParameter("nom", nom)
//				                 .getResultList();
//		if (especes.size() == 1) {
//			return especes.get(0);
//		} else {
//			return null;
//		}
//	}
//
//}
