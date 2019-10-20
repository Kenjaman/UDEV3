public class LigneCommande { //mod�le

	private Article article;
	private int quantite;
	private double prixUnitaire;


//	public LigneCommande() { // les classes ne dialoguent pas avec l'utilisateur
//		// 
//		this.setNomArticle("Nouveau Produit");;
//		this.setQuantite(1);
//		this.setPrixUnitaire(0.0);
//	}

	public LigneCommande(Article article, int qte) {
		this.setArticle(article);
		this.setQuantite(qte);
		this.setPrixUnitaire(article.getPrix());
	}

	public LigneCommande(Article article) {
		this(article,1);
	}
	
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public double getPrixLigne() {
		return this.prixUnitaire*this.quantite;
	}
	
	/**
	 * A �t� remplacer par le getNom() de la classe Article
	 *
	 * @deprecated utiliser le getNom() d'Article
	 */
	
	@Deprecated
	public String getNomArticle() {
		return this.article.getNom();
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		if(quantite<1) {
			throw new IllegalArgumentException("La quantit� doit etre strictement positive");
		}else
			this.quantite = quantite;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		if(prixUnitaire < 0.0)
			throw new IllegalArgumentException("La prix doit etre strictement positive"); 
		else 
			this.prixUnitaire = prixUnitaire;
	}


}