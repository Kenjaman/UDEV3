package exo2;

public class Ticket {

	private double prix;
	private String film;
	
	public Ticket(double prix, String film) {
		super();
		this.prix = prix;
		this.film = film;
	}
	
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getFilm() {
		return film;
	}
	public void setFilm(String film) {
		this.film = film;
	}

	@Override
	public String toString() {
		return "Ticket [prix=" + prix + ", film=" + film + "]";
	}
	
	
}
