package com.permApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.permApp.dao.PlanteDao;
import com.permApp.modele.Plante;

@Service
public class PlanteService {
	
	@Autowired
	private PlanteDao planteDao;

	public List<Plante> getPlantes() {
		return planteDao.getPlantes();
	}

	public Plante getPlante(int planteId) {
		return planteDao.getPlante(planteId);
	}


}
