package com.animoz;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.animoz.modele.Espece;

public class SuppressionEspeceApplication {			
		
		public static void main(String[] args) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("animaux");
			EntityManager em = emf.createEntityManager();
			String nomEspece = "Hominidé";
			try {
				em.getTransaction().begin();
				em.createQuery("delete from Espece e where e.nom = :nom")
				.setParameter("nom", nomEspece)
				.executeUpdate();
				em.getTransaction().commit();
				
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
