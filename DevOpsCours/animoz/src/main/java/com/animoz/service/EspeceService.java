package com.animoz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animoz.dao.EspeceDao;
import com.animoz.modele.Espece;

@Service
public class EspeceService {
	
	@Autowired
	private EspeceDao especeDao;

	public List<Espece> getEspeces() {
		return especeDao.getEspeces();
	}

	@Transactional
	public void ajouter(String nom) {
		if(! especeDao.existe(nom)) {
			Espece espece = new Espece();
			espece.setNom(nom);
			especeDao.ajouter(espece);
		}
	}

	@Transactional(rollbackOn = AnimalExisteEncoreException.class)
	public void supprimer(String nom) throws AnimalExisteEncoreException {
		Espece espece = especeDao.get(nom);
		if (espece == null) {
			return;
		}
		if (! espece.getAnimaux().isEmpty()) {
			throw new AnimalExisteEncoreException("Cette espèce a encore des animaux.");
		} 
		especeDao.supprimer(nom);
	}
}
