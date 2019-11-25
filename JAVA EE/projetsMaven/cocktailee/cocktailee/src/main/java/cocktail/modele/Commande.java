package cocktail.modele;

import java.util.Date;

import cocktail.modele.Cocktail;

public class Commande {

	private Cocktail cocktail;
	private int numeroTable;
	private Date heureCommande;
	private int id;
	private static int idRef=1;
	
	public Commande(Cocktail cockComm, String numTable) throws DonneesInvalidesException{
		super();
		ErreurCommande erreurs = new ErreurCommande();
		this.id=idRef;
		if(cockComm == null)
			erreurs.setErreurCocktail("Veuillez choisir un cocktail");
		this.numeroTable =convertirTable(numTable,erreurs);
		this.cocktail = cockComm;
		this.heureCommande= new Date();
		if(erreurs.isPresent())
			throw new DonneesInvalidesException(erreurs);
		idRef++;
	}

	private int convertirTable(String table, ErreurCommande erreurs) {
		try {
			if (table.equals("")) {
				erreurs.setErreurTable("Veuillez entrer une table");
				return 0;
			}
			int tableConverti = Integer.valueOf(table);
			if (tableConverti <= 0) {
				erreurs.setErreurTable("Le numéro de table doit être supérieur à 0 !");
			}
			return tableConverti;
		} catch(NumberFormatException e) {
			erreurs.setErreurTable("La table n'est pas un nombre !");
			return 0;
		}
	}


	public int getId() {
		return id;
	}


	public int getNumeroTable() {
		return numeroTable;
	}

	public Cocktail getCocktail() {
		return cocktail;
	}

	public void setCocktail(Cocktail cocktail) {
		this.cocktail = cocktail;
	}

	public Date getHeureCommande() {
		return heureCommande;
	}

	public void setHeureCommande(Date heureCommande) {
		this.heureCommande = heureCommande;
	}
	
	
}
