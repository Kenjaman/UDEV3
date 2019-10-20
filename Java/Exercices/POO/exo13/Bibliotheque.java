package exo13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Bibliotheque {
	private List<Livre> liste_livre=new ArrayList<Livre>();
	private final int nb_max_livres=200;
	
	private static int total_livres=0;	
	private int id;
	private String nom;
	private String adresse;
	private String ville;
	
	
	
	
	
	public Bibliotheque(int id, String nom, String adresse, String ville) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
		this.saisie_livre();
		
		
		
	}
	public Bibliotheque() {
		super();
		// TODO Auto-generated constructor stub
	}
	public  List<Livre> getListe_livre() {
		return this.liste_livre;
	}
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setListe_livre(List<Livre> liste_livre) {
		this.liste_livre = liste_livre;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String toString() {
		StringBuilder sl=new StringBuilder();
		
			sl.append(this.id);
			sl.append("\t\t");
			sl.append(this.nom);
			sl.append("\t\t");
			sl.append(this.adresse);
			sl.append("\t\t");
			sl.append(this.ville);
			sl.append("\n");
			sl.append("=========================================================");
			return sl.toString();
		}
	public void saisie_livre() {
		Scanner saisie=new Scanner(System.in);
		String s;
		String [] s1=new String[3];
		do {
			System.out.println("PROGRAMME DE SAISIE DE LIVRE "+this.nom);
			System.out.println("-----------------------------");
			System.out.println("Saisissez le titre,l'auteur,le prix séparé par des virgules :");
			s=saisie.nextLine();
			if(!s.isBlank()) {
				s=s.trim();
				s1=s.split(",");
				this.liste_livre.add(new Livre(s1[0],s1[1],Double.parseDouble(s1[2])));
			}
		
		}while(!s.isBlank());
		//saisie.close();
		
	}
	public  String Affiche() {
		StringBuilder sl=new StringBuilder();
		int nb_livre=0;
		for(Livre l:liste_livre) {
			nb_livre++;
			sl.append(l.getId());
			sl.append("\t\t");
			sl.append(l.getTitre());
			sl.append("\t\t");
			sl.append(l.getNom_auteur());
			sl.append("\t\t");
			sl.append(l.getPrix());
			sl.append("\n");
		}
		sl.append("=========================================================");
		sl.append("\n");
		sl.append("Vous avez ");
		sl.append(nb_livre);
		sl.append(" livre(s) dans la ");
		sl.append(this.nom);
		Bibliotheque.total_livres+=nb_livre;
		return sl.toString();
		}
	
	
	
	
	}
	
	


