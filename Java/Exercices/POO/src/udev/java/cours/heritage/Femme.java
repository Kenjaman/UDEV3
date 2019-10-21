package udev.java.cours.heritage;

public class Femme extends Humain {
	
	private boolean enceinte;

	public boolean isEnceinte() {
		return enceinte;
	}

	public void setEnceinte(boolean enceinte) {
		this.enceinte = enceinte;
	}

	public Femme() {
		super();
	}

	public Femme(String nom, String prenom, boolean enceinte) {
		super(nom, prenom);
		this.enceinte = enceinte;
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Femme [enceinte=");
		builder.append(enceinte);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public void seDeplacer() {
		System.out.println("La femme se déplace en marchant");
		super.seDeplacer();
	}

	@Override
	public void manger() {
		System.out.println("La femme mange avec des couverts");
	}
	
	

}
