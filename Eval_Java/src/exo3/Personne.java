package exo3;

public class Personne {
	private String nom;
	private String adresse;
	private String numeroTel;
	
	
	public Personne() {
		super();
	}
	public Personne(String nom, String adresse, String numeroTel) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.numeroTel = numeroTel;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNumeroTel() {
		return numeroTel;
	}
	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("# ");
		builder.append("Nom  : ");
		builder.append(nom);
		builder.append(" | Adresse : ");
		builder.append(adresse);
		builder.append(" | Tel : ");
		builder.append(numeroTel);
		builder.append("\n ----------------- \n");
		return builder.toString();
	}
	
	
}
