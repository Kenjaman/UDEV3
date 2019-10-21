package fr.epsi.udev.exsup.ex2;

public class Appartement {
	private double prix;

	public Appartement(double prix) {
		super();
		this.prix = prix;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public void augmentePrixApp(double augmentation) {
		this.setPrix(prix*(1+augmentation));
	}

}
