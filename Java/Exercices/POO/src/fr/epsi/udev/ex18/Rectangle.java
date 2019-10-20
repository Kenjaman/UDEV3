package fr.epsi.udev.ex18;


public class Rectangle extends Forme {

	private int largeur;
	private int longueur;
	
	public Rectangle(int largeur, int longueur) {
		super();
		this.largeur= largeur;
		this.longueur=longueur;
	}
	@Override
	public double getSurface() {
		return this.largeur*this.longueur;
	}
	
	public int getLargeur() {
		return largeur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	public int getLongueur() {
		return longueur;
	}
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}
	@Override
	public String toString() {
		return super.toString()+ ", largeur : "+ largeur+ ", longueur : "+longueur;
	}

}
