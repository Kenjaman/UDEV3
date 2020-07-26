package com.permApp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.permApp.dao.AssociationDao;
import com.permApp.modele.Association;

@Service
public class AssociationService {
	
	@Autowired
	private AssociationDao associationDao;

	public List<Association> getAssociations() {
		return associationDao.getAssociation();
	}

//	@Transactional
//	public void ajouter(String nom) {
//		if(! associationDao.existe(nom)) {
//			Espece espece = new Espece();
//			espece.setNom(nom);
//			associationDao.ajouter(espece);
//		}
//	}

//	@Transactional(rollbackOn = AnimalExisteEncoreException.class)
//	public void supprimer(String nom) throws AnimalExisteEncoreException {
//		Espece espece = associationDao.get(nom);
//		if (espece == null) {
//			return;
//		}
//		if (! espece.getAnimaux().isEmpty()) {
//			throw new AnimalExisteEncoreException("Cette espèce a encore des animaux.");
//		} 
//		associationDao.supprimer(nom);
//	}
}
