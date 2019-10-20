package fr.epsi.udev.ex15;

public class Rectangle extends Figure {

	private int largeur;
	private int longueur;
	
	public Rectangle(int largeur, int longueur) {
		this.largeur= largeur;
		this.longueur=longueur;
	}
	@Override
	public double aire() {
		return this.largeur*this.longueur;
	}
	
	public double perimetre() {
		return this.largeur*2+this.longueur*2;
	}
	
	public boolean isCarre() {
		return (this.longueur==this.largeur);
	}
	
	public String toString() {
		return String.format("Longueur : [%d] - Largeur : [%d] - Périmètre : [%f] - Aire : [%f] - [%s]",
				this.longueur,
				this.largeur,
				this.perimetre(),
				this.aire(),
				this.isCarre()?"Ceci est un carre":"ceci est un rectangle");
				
	}
	
	public static void main(String[] args) {
		Figure figu = new Rectangle(20,10);
		System.out.println(figu.toString());
	}

}