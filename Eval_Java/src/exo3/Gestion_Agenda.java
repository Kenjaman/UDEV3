package exo3;

import java.util.ArrayList;
import java.util.List;

public class Gestion_Agenda {
	private List <Personne> listPersonne;

	
	public Gestion_Agenda() {
		super();
		this.listPersonne= new ArrayList<Personne>();
	}

	public Gestion_Agenda(List<Personne> listPersonne) {
		super();
		this.listPersonne = listPersonne;
	}


	public void ajouterPersonne(Personne persoAjout) {
		this.listPersonne.add(persoAjout);
	}
	
	public Personne recherchePersonne(String nom) {
		Personne personneRecherche = null;
		for(Personne person : listPersonne) {
			if(person.getNom().equals(nom))
				personneRecherche=person;
		}
		return personneRecherche;
	}
	public List<Personne> getListPersonne() {
		return listPersonne;
	}
	
	public void setListPersonne(List<Personne> listPersonne) {
		this.listPersonne = listPersonne;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Agenda/Repertoire :\n");
		builder.append("==========================\n");
		for(Personne personne : listPersonne)
			builder.append(personne.toString());
		builder.append("\n==========================");
		return builder.toString();
	}
	
	
}
