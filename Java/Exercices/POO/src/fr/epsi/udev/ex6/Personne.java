package fr.epsi.udev.ex6;

public class Personne {
	private int age;
	private String nom;
	private int salaire;

	public Personne() {
		super();
		age=0;
		nom="Kénan";
		salaire=0;
	}
	public boolean equalsAge(Personne p1) {
		if(this.age==p1.age)
			return true;
		else
			return false;
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getSalaire() {
		return salaire;
	}
	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}
}
