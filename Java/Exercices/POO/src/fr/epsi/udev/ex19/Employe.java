package fr.epsi.udev.ex19;

public abstract class Employe {
	private int age;
	private String nom;
	private String prenom;
	private String  dateEntree;

	public Employe() {
		super();
//		age=0;
//		nom="Kénan";
//		salaire=0;
	}
	public Employe(String prenom, String nom,int age , String dateEntree) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.dateEntree = dateEntree;
	}
	
	public abstract double calculerSalaire();
	
	public String toString() {
		return "L'employe "+this.getPrenom()+" "+this.getNom();
	}
	public String getDateEntree() {
		return dateEntree;
	}
	public void setDateEntree(String dateEntree) {
		this.dateEntree = dateEntree;
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}



