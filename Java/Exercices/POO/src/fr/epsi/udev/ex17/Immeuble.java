package fr.epsi.udev.ex17;

public class Immeuble extends Batiment {
private int nbAppartement;

public Immeuble(String adresse, int nbAppartement) {
	super(adresse);
	this.nbAppartement = nbAppartement;
}

public Immeuble() {
	super();
	this.nbAppartement = 0;
}

public int getNbAppartement() {
	return nbAppartement;
}

public void setNbAppartement(int nbAppartement) {
	this.nbAppartement = nbAppartement;
}

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append(super.toString());
	builder.append("[nb Appartement=");
	builder.append(nbAppartement);
	builder.append("]");
	builder.append(" : Immeuble");
	return builder.toString();
}

}
