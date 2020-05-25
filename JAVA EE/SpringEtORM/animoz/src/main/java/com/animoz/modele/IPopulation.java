package com.animoz.modele;

import java.util.List;

public interface IPopulation {

	Long getId();

	void setId(Long id);

	int getNombreIndividus();

	void setNombreIndividus(int nombreIndividus);

	public static int getTotalIndividus(List<IPopulation> populations) {
		int nb = 0;
		if(populations != null) {
			for(IPopulation pop : populations)
				nb += pop.getNombreIndividus();
		}
		return nb;
	}

	Animal getAnimal();

	void setAnimal(Animal animal);

	Enclos getEnclos();

	void setEnclos(Enclos enclos);

}