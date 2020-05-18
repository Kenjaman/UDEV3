package com.animoz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animoz.dao.EnclosDao;
import com.animoz.modele.Enclos;
import com.animoz.modele.Population;

@Service
public class EnclosService {
	@Autowired
	private EnclosDao enclosDao;


	public List<Enclos> getEnclos() {
		return enclosDao.getEnclos();
	}
	
	public int getNbIndEnclos(Enclos enclos) {
		int nbInd = 0;
		for(Population pop : enclos.getPopulations()) {
			nbInd+=pop.getNombreIndividus();
		}
		return nbInd;
	}
	
	public int getNbIndEnclos(Long idEnclos) {
		return enclosDao.getNbIndEnclos(idEnclos);
	}
}
