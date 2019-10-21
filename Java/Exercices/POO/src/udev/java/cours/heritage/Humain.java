package udev.java.cours.heritage;

public class Humain extends Mammifere {

	private String prenom;

	public Humain() {
		super();
	}

	public Humain(String nom, String prenom) {
		super(nom);
		this.prenom=prenom;
	}
	
	public void seDeplacer() {
		System.out.println("Mon être humain marche");
	}
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Humain [prenom=");
		builder.append(prenom);
		builder.append("]");
		return builder.toString();
	}
	@Override
	public void manger() {
		System.out.println("Mon être humain mange de tout");
	}
	

}
