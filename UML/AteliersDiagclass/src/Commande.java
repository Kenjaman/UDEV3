import java.util.ArrayList;

public class Commande {
	private double livraison;
	private ArrayList<LigneCommande> lignes;

	public Commande(double livraison) {
		this.livraison = livraison;
		this.lignes = new ArrayList<LigneCommande>();
	}
	
	public void setLignes(ArrayList<LigneCommande> lignes) {
		this.lignes = lignes;
	}

	public double getLivraison() {
		return livraison;
	}
	
	public void setLivraison(double livraison) {
		this.livraison = livraison;
	}
	
	public Iterable<LigneCommande> getLignes() {
		return lignes;
	}
	
	public void ajouterLigneCommande(Article article, int qte) {
		LigneCommande ligne = new LigneCommande(article,qte);
		if(!this.lignes.contains(ligne)) 
			lignes.add(ligne);
		else
			this.lignes.set(lignes.indexOf(ligne), ligne);
	}
	
	public double getSousTotal() {
		double sousTotal=0;
		for(LigneCommande ligne:this.getLignes()) 
			sousTotal+=ligne.getPrixLigne();
		return sousTotal;
	}
	
	public double getPrixTotalHT() {
		return this.getSousTotal()+getLivraison();
	}
	
	public double getPrixTotalTTC(double tva) {
		if(tva<0 || tva>=1)
			throw new IllegalArgumentException("Saisir une tva entre 0 et 1");
		else
			return this.getPrixTotalHT()*(1 + tva);
	} 
}