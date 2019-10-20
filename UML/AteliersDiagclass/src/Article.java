
public class Article {
	private String nom;
	private double prix;
	
	
	
	public Article(String nom, double prix) {
		super();
		this.setNom(nom);
		this.setPrix (prix);
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nomArticle) {
		if (nomArticle.length() < 2) {
			throw new IllegalArgumentException("Le nom doit faire au moins 2 caractères");
		}else
			this.nom = nomArticle;
	}
	
	public double getPrix() {
		return prix;
	}
	
	public void setPrix(double prix) {
		if(prix < 0.0)
			throw new IllegalArgumentException("La prix doit etre strictement positive"); 
		else
			this.prix= prix;
	}
	
	
}
