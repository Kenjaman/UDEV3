package com.permApp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.permApp.modele.Association;

@Repository
public class AssociationDao {
	@PersistenceContext
	private EntityManager em;

	public List<Association> getAssociation() {
		return em.createQuery("select a from Association a",Association.class).getResultList();
	}
	
}
