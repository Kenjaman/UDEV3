package udev.java.cours.heritage;

public class Mammifere {

	private String nom;
	
	public Mammifere() {
		super();
	}
	
	public Mammifere(String nom) {
		super();
		this.setNom(nom);
	}
	
	public void seDeplacer() {
		System.out.println("La chose bouge...");
	}
	public void manger() {
		System.out.println("Mon mammiefère mange de tout");
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
