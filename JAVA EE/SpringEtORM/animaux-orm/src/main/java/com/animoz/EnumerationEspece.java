package com.animoz;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EnumerationEspece {			
		
		public static void main(String[] args) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("animaux");
			EntityManager em = emf.createEntityManager();
			String nomEspece = "Félidé";
			try {
				Long aniList = em.createQuery("select SUM(p.nombreIndividus) from Population p where p.animal.espece.nom = :nom group by p.animal.espece",Long.class)
						.setParameter("nom", nomEspece)
						.getSingleResult();
				System.out.println("Il y a "+aniList+" individus de l'espece "+nomEspece);
//				for(Animal animauxEspece : aniList)
//				System.out.println("Il y a "+animauxEspece.getPop().getNombreIndividus()+" individus appartenant a l'espece "+animauxEspece.getEspece().getNom());
				
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
