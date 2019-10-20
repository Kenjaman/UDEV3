package exo13;



public class Livre {
	
	
	
	private static int nb_id=200;
	
	private int id;
	private String titre;
	private String nom_auteur;
	private double prix;
	
	
	
	public Livre(String titre, String nom_auteur, double prix) {
		super();
		nb_id++;
		nb_livres++;
		this.titre = titre;
		this.nom_auteur = nom_auteur;
		this.prix = prix;
		this.id=Livre.nb_id;
	}
	public int getId() {
		return id;
	}
	public String getTitre() {
		return titre;
	}
	public String getNom_auteur() {
		return nom_auteur;
	}
	public double getPrix() {
		return prix;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public void setNom_auteur(String nom_auteur) {
		this.nom_auteur = nom_auteur;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
	
	
}
