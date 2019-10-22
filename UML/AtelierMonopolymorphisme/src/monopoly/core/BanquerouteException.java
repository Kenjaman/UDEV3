package monopoly.core;

public class BanquerouteException extends Exception {
	private String erreur;
	private int montant;
	private Joueur joueur;
	public BanquerouteException(String erreur, int montant, Joueur joueur) {
		super(erreur);
		this.montant = montant;
		this.joueur = joueur;
	}
	public int getMontant() {
		return montant;
	}
	public Joueur getJoueur() {
		return joueur;
	}
	
	
}
