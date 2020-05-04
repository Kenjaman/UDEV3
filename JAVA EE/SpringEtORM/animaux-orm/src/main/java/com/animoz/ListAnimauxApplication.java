package com.animoz;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.animoz.modele.Animal;
import com.animoz.modele.Espece;
import com.animoz.modele.Regime;

public class ListAnimauxApplication {			
		
		public static void main(String[] args) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("animaux");
			EntityManager em = emf.createEntityManager();
			try {
				List<Animal> listAn = em.createQuery("select a from Animal a order by a.nom", Animal.class)
										.getResultList();
				
				for(Animal a : listAn) {
					System.out.println(a.getNom()+" : "+a.getEspece().getNom() );
				}
				System.out.println("-----------------------------------------------------------");
				List<Animal> listAn2 = em.createQuery("select a from Animal a where a.regime = :regime", Animal.class)
						.setParameter("regime", Regime.carnivore)
						.getResultList();

				for(Animal a : listAn2) {
					System.out.println(a.getNom()+" : "+a.getDescription() );
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
