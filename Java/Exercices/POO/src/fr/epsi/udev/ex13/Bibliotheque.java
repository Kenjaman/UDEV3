package fr.epsi.udev.ex13;

import java.util.ArrayList;
import java.util.List;

import fr.epsi.udev.ex12.Livre;

public class Bibliotheque {
	private int id;
	private String nom;
	private List<Livre> listeLivre = new ArrayList<Livre>();
	private String adresse;
	private String ville;

	public static final int maxDeLivre=10;

	public Bibliotheque() {
		super();

	}

	public Bibliotheque(int id, String nom, List<Livre> listeLivre, String adresse, String ville) {
		super();
		this.id = id;
		this.nom = nom;
		this.listeLivre = listeLivre;
		this.adresse = adresse;
		this.ville = ville;
	}
	@Override
	public String toString() {
		StringBuilder sl=new StringBuilder();

		sl.append(this.id);
		sl.append("\tNom : ");
		sl.append(this.nom);
		sl.append("\nAdresse:  ");
		sl.append(this.adresse);
		sl.append("\t Ville:  ");
		sl.append(this.ville);
		sl.append("\n");
		sl.append("=======================Nos Livres=======================\n");
		for(Livre l:this.getListeLivre()) {
			sl.append(l);
		}
		sl.append("=========================================================");
		sl.append("\n");
		sl.append("Vous avez ");
		sl.append(this.getListeLivre().size());
		sl.append(" livre(s) / ");
		sl.append(maxDeLivre);
		return sl.toString();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Livre> getListeLivre() {
		return listeLivre;
	}
	public void setListeLivre(List<Livre> listeLivre) {
		this.listeLivre = listeLivre;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}


}
