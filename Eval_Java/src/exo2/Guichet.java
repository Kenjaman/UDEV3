package exo2;

public class Guichet {

	private Ticket tick;
	
	public Guichet() {
		super();
	}
	
	public void nouveauTicket(double prix, String titre) {
		this.setTick(new Ticket(10.5, "Rambo"));
	}
	
	public void donnerTicket(Personne perso) {
		perso.setTick(this.getTick());
		this.setTick(null);
	}
	

	public Ticket getTick() {
		return tick;
	}

	public void setTick(Ticket tick) {
		this.tick = tick;
	}
}