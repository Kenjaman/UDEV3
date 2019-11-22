package cocktail.modele;

public class DonneesInvalidesException extends Exception {
	
	private ErreurCommande erreurs;

	public DonneesInvalidesException(ErreurCommande erreurs) {
		this.erreurs = erreurs;
	}
	
	public ErreurCommande getErreurs() {
		return erreurs;
	}

}
