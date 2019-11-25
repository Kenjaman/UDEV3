package cocktail.modele;

public class DonneesInvalidesException extends Exception {
	
	private ErreurCommande erreurs;

	public DonneesInvalidesException(ErreurCommande erreurs) {
		this.erreurs = erreurs;
	}
	
	public DonneesInvalidesException(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}

	public ErreurCommande getErreurs() {
		return erreurs;
	}

}
