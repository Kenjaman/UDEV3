package fr.epsi.udev.ex14;

public class Employe extends Personne {

	private String lieuDeTravail;

	public Employe() {
		super();
		this.lieuDeTravail="Maison";
	}


	public Employe(String nom, String prenom, String adresse, String lieuDeTravail) {
		super(nom, prenom, adresse);
		this.lieuDeTravail = lieuDeTravail;
	}




	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Type = Employe \n");
		builder.append(super.toString());
		builder.append("Travail : ");
		builder.append(this.getLieuDeTravail());
		return builder.toString();
	}


	public String getLieuDeTravail() {
		return lieuDeTravail;
	}

	public void setLieuDeTravail(String lieuDeTravail) {
		this.lieuDeTravail = lieuDeTravail;
	}
	
	
}
