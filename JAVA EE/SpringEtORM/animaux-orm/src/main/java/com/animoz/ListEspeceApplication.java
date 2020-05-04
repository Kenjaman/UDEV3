package com.animoz;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.animoz.modele.Espece;

public class ListEspeceApplication {			
		
		public static void main(String[] args) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("animaux");
			EntityManager em = emf.createEntityManager();
			String nomEspece = "Félidé";
			try {
				List<Espece> listEspece = em.createQuery("select e from Espece e where e.nom = :nom", Espece.class)
						.setParameter("nom", nomEspece)
						.getResultList();
				
				for(Espece e : listEspece) {
					System.out.println(e.getNom());
				}
				
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
