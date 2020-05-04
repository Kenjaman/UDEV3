package com.animoz;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.animoz.modele.Espece;

public class Application {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("animaux");
		EntityManager em = emf.createEntityManager();
		
		try {
			Espece espece = new Espece();
//			espece.setNom("hominidé");
//			
//			em.getTransaction().begin();
//			em.persist(espece);
//			em.getTransaction().commit();
//			
//			System.out.println(espece.getId());
//			System.out.println(espece.getNom());
			
//			espece = em.find(Espece.class, 6L); 
//			em.getTransaction().begin();
//			espece.setNom("Hominidé");
//			em.getTransaction().commit();---> Ca marche aussi
		}catch(Exception ex) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			System.err.println(ex.getMessage());
				
		} finally {
			em.close();
			emf.close();
		}
	}

}
