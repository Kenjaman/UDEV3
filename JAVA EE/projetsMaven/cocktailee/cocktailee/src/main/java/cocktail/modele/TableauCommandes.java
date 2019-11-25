package cocktail.modele;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TableauCommandes extends ConcurrentLinkedQueue<Commande>{

	public TableauCommandes() {
		super();
	}
	
	public TableauCommandes(ConcurrentLinkedQueue<Commande> attribute) {
		// TODO Auto-generated constructor stub
		super(attribute);
	}

	@Override
	public String toString() {
		String laString="";
		laString += "Tableaux de Commandes :";
		for(Commande st : this) {
			laString+=st.getCocktail().getNom();
			laString+="\n ";
		}
		return laString;
	}

	public boolean ajoutCommande(Commande commande) {
		return this.offer(commande);
	}
	
	public Commande traiterCommande() {
		return this.poll();
	}

}
