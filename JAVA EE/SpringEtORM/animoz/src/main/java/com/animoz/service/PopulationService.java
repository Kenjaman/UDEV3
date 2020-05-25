package com.animoz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animoz.dao.AnimalDao;
import com.animoz.dao.EnclosDao;
import com.animoz.dao.PopulationDao;
import com.animoz.modele.Enclos;
import com.animoz.modele.IPopulation;
import com.animoz.modele.Population;
import com.animoz.modele.Regime;

@Service
public class PopulationService {
	@Autowired
	private PopulationDao populationDao;
	@Autowired
	private AnimalDao animalDao;
	@Autowired
	private EnclosDao enclosDao;
	
	@Transactional
	public void ajouter(IPopulation population) throws IllegalEnclosException {
		IPopulation populationCreer = new Population();
		populationCreer.setAnimal(animalDao.getAnimal(population.getAnimal().getId()));
		populationCreer.setNombreIndividus(population.getNombreIndividus());
		Enclos enclos = enclosDao.getEnclos(population.getEnclos().getId()); 
		
		for (IPopulation p : enclos.getPopulations()) {
			if(population.getEnclos().getId()== p.getEnclos().getId()) {
				System.out.println("on est dans le if numero enclos");
				if(populationCreer.getAnimal().getRegime()==Regime.carnivore) {
					System.out.println("on est dans le if Carnivore");
					if(!populationCreer.getAnimal().getEspece().equals(p.getAnimal().getEspece())) {
						throw new IllegalEnclosException("Les carnivores doivent etre rangés entre même espèce et surtout pas avec des herbivores");
					}
				}else if (populationCreer.getAnimal().getRegime()==Regime.herbivore) {
					if(p.getAnimal().getRegime()==Regime.carnivore)
						throw new IllegalEnclosException("On ne met pas les herbivores dans un enclos de carnivores voyons !");
				}
			}
		}
		populationCreer.setEnclos(population.getEnclos());
		populationDao.ajouter(populationCreer);
	}

	public List<Population> getPopulations() {
		return populationDao.getPopulations();
	}
}
