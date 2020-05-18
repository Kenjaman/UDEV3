package com.animoz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animoz.controleur.AnimalDto;
import com.animoz.dao.AnimalDao;
import com.animoz.modele.Animal;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalDao animalDao;

	public List<Animal> getAnimaux() {
		return animalDao.getAnimaux();
	}

	public Animal getAnimal(long animalId) {
		return animalDao.getAnimal(animalId);
	}

	@Transactional
	public void ajouter(AnimalDto adto) {
		if(! animalDao.existe(adto.getNom())) {
			Animal animal = new Animal();
			animal.setNom(adto.getNom());
			animal.setDescription(adto.getDescription());
			animal.setOrigine(adto.getOrigine());
			animal.setEspece(adto.getEspece());
			animal.setRegime(adto.getRegime());
			animalDao.ajouter(animal);
		}
	}
	
	@Transactional
	public void modifier(Animal animal) {
		Animal animalMAJ = animalDao.getAnimal(animal.getId());
		animalMAJ.setNom(animal.getNom());
		animalMAJ.setDescription(animal.getDescription());
		animalMAJ.setOrigine(animal.getOrigine());
		animalMAJ.setEspece(animal.getEspece());
		animalMAJ.setRegime(animal.getRegime());
	}

}
