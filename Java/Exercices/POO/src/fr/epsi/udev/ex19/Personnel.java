package fr.epsi.udev.ex19;

import java.util.ArrayList;
import java.util.List;

public class Personnel {
	private List <Employe> personL;

	public Personnel() {
		this.personL = new ArrayList<Employe>();
	}
	
	public void ajouterEmploye(Employe emp) {
		this.personL.add(emp);
	}
	
	public void afficherSalaires() {
		for(Employe employe : personL) {
			System.out.println(employe);
		}
	}
	
	public double salaireMoyen() {
		double salaireMoyen = 0;
		for(Employe employe : personL) {
			salaireMoyen+=employe.calculerSalaire();
		}
		salaireMoyen/=personL.size();
		return salaireMoyen;
	}
	
	
}
