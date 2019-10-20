package fr.epsi.udev.ex18;


public class Triangle extends Forme {

	private int hauteur;
	private int longueur;
	
	public Triangle(int x, int y, int hauteur, int longueur) {
		super(x,y);
		this.hauteur= hauteur;
		this.longueur=longueur;
	}
	@Override
	public double getSurface() {
		return (this.hauteur*this.longueur)/2;
	}
	
	public int getLargeur() {
		return hauteur;
	}
	public void setLargeur(int largeur) {
		this.hauteur = largeur;
	}
	public int getLongueur() {
		return longueur;
	}
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}
	@Override
	public String toString() {
		return super.toString()+ ", largeur : "+ hauteur+ ", longueur : "+longueur;
	}

}
