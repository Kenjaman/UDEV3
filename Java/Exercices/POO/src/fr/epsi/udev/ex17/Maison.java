package fr.epsi.udev.ex17;

public class Maison extends Batiment {
	private int nbPiece;

	public Maison() {
		super();
		this.nbPiece =0;
	}

	public Maison(String adresse, int nbPiece) {
		super(adresse);
		this.nbPiece = nbPiece;
	}

	public int getNbPiece() {
		return nbPiece;
	}

	public void setNbPiece(int nbPiece) {
		this.nbPiece = nbPiece;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(" [nbPiece=");
		builder.append(nbPiece);
		builder.append("]");
		builder.append(" : Maison");

		return builder.toString();
	}
	
}
