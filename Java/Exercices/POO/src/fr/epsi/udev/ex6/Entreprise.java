package fr.epsi.udev.ex6;

public class Entreprise {

	public void augmente(Personne p1) {
		if(p1.getSalaire()<1500)
			p1.setSalaire(p1.getSalaire()*(1+20/100));
	}
}
