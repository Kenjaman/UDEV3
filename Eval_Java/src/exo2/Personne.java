package exo2;

public class Personne {

	private String nom;
	private Ticket tick;
	public Personne(String nom) {
		super();
		this.nom = nom;
	}
	
	public void demmandeUnTicket(Guichet g, double prix, String titre) {
		g.nouveauTicket(prix, titre);
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Ticket getTick() {
		return tick;
	}
	public void setTick(Ticket tick) {
		this.tick = tick;
	}
	
	
}
