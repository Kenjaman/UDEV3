package fr.epsi.udev.ex17;

public class Batiment {
	private String adresse;

	public Batiment(String adresse) {
		this.adresse = adresse;
	}

	public Batiment() {
		this.adresse="";
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Batiment [adresse=");
		builder.append(adresse);
		builder.append("]");
		return builder.toString();
	}
	
	
}
