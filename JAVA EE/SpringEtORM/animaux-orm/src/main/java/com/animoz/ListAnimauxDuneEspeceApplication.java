package com.animoz;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.animoz.modele.Animal;
import com.animoz.modele.Espece;
import com.animoz.modele.Regime;

public class ListAnimauxDuneEspeceApplication {			
		
		public static void main(String[] args) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("animaux");
			EntityManager em = emf.createEntityManager();
			try {
			Espece espece = em.find(Espece.class, 1L);
			for(Animal a : espece.getAnimaux()) { // --> Instanciation paresseuse (lazy fetch) il attend qu'on lui demande les info pour aller les chercher lorsqu'on a un "Many" dans la relation
				System.out.println(a.getNom());
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
