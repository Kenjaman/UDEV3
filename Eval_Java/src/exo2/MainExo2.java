package exo2;

public class MainExo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Guichet g = new Guichet();
		Personne pp = new Personne("Roux");
		System.out.println("Ticket guichet :"+g.getTick()); // null
		System.out.println("Ticket personne :"+pp.getTick()); //  Les deux n'ont pas de ticket -> null
		System.out.println("Personne commande un ticket au guichet");
		pp.demmandeUnTicket(g, 10.5, "Rambo"); // Personne commande un ticket au guichet
		
		System.out.println("Ticket personne :"+pp.getTick()); // On verifie que la personne n'a toujours pas son ticket -> null
		
		System.out.println("Ticket guichet :"+g.getTick()); // Le guichet a un ticket en revanche -> toString du ticket de guichet
		System.out.println("Le guichet donne son ticket a la personne");
		g.donnerTicket(pp); // Le guichet donne son ticket a la personne
		
		System.out.println("Ticket personne :"+pp.getTick()); // On verifie que la personne a son ticket
		
		System.out.println("Ticket guichet :"+g.getTick()); // Et que guichet n'en a plus -> null
		
		
		
	}

}
