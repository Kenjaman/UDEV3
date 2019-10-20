package fr.epsi.udev.ex11;

public class Article {
	private int reference;
	private String designation;
	private double prixHT;
	private static double tauxTVA=20;
	
	public Article() {
		super();
		this.reference=00000;
		this.designation="Article";
		this.prixHT=100;
	}
	
	public Article(int reference, String designation, double prixHT) {
		super();
		this.reference = reference;
		this.designation = designation;
		this.prixHT = prixHT;
	}

	public Article(int reference, String designation) {
		super();
		this.reference = reference;
		this.designation = designation;
		this.prixHT = 1;

	}

	public Article (Article article) {
		super();
		this.reference=article.getReference();
		this.designation=article.getDesignation();
		this.prixHT=article.getPrixHT();
	}

	public double calculPrixTTC() {
		return this.prixHT*(1+Article.tauxTVA/100);
	}
	
	public void afficherArticle() {
		System.out.println("Arctile reference : "+this.getReference()+"\n Designation : "+this.getDesignation()+
				"\n Prix HT : "+this.getPrixHT()+"\n Prix TTC : "+this.calculPrixTTC()+"�");
	}
	
	public int getReference() {	
		return reference;
	}

	public void setReference(int reference) {
		this.reference = reference;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(double prixHT) {
		this.prixHT = prixHT;
	}

}
