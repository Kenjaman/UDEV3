package com.animoz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
