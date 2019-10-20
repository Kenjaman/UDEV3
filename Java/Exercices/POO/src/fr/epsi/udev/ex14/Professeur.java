package fr.epsi.udev.ex14;

public class Professeur extends Employe {
	private String matiere;

	public Professeur() {
		super();
		this.matiere="Défense contre les forces du mal";
	}

	public Professeur(String nom, String prenom, String adresse, String lieuDeTravail, String matiere) {
		super(nom, prenom, adresse, lieuDeTravail);
		this.matiere = matiere;
	}

	public void attribuerNote(Etudiant etu,double note) {
		etu.setNotes(note);
		System.out.println(this.nom+" donne la note de "+note+" à l'élève "+etu.getNom());
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Professeur \n");
		builder.append(super.toString());
		builder.append("\nEnseignement : "+matiere);
		return builder.toString();
	}

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	
	
}
