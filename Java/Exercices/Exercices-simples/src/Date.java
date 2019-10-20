import java.util.GregorianCalendar;
import java.util.Scanner;

public class Date {

	private int _jour,_mois,_annee;

	public Date() {
		GregorianCalendar dateActuelle = new GregorianCalendar();
		this.set_jour(dateActuelle.get(GregorianCalendar.DATE));
		this.set_mois(dateActuelle.get((GregorianCalendar.MONTH))+1);
		this.set_annee(dateActuelle.get(GregorianCalendar.YEAR));
	}


	public Date(int j, int m, int a) {
		this.set_jour(j);
		this.set_mois(m);
		this.set_annee(a);
	}

	private boolean estValide(int j,int m,int a) { //Il s'agit d'une fonction privée interne a la classe utilisable uniquement à l'interieur de celle ci
		boolean valide;

		if(m>=1 && m<=12) {
			if(j>=1 && j<=nbJourDansLeMois(m,a))
				valide=true;
			else
				valide=false;
		}else
			valide=false;
		return valide;
	}


	private int nbJourDansLeMois(int m,int a) {
		int dernierJourDuMois=0;
		switch(m) {
		case 1: case 3: case 5:
		case 7: case 8: case 10:
		case 12:
			dernierJourDuMois= 31;
			break;
		case 4: case 6:
		case 9: case 11:
			dernierJourDuMois= 30;
			break;
		case 2:
			dernierJourDuMois = nbJourFevrier(a);
			break;
		}
		return dernierJourDuMois;
	}
	

	private int nbJourFevrier(int a) {
		if((a% 4 == 0 && a % 100 != 0) || a % 400 == 0)  
			return 29;//Annee bissextile
		else
			return 28;//Annee non bissextile
	}

	public void saisir() {
		int j,m,a;
		boolean estValide=false;
		Scanner scn  = new Scanner (System.in);
		while(!estValide){// On fait recommencer tant que la date saisie n'est pas valide	
			System.out.println("Veuillez entrer le jour :");
			j=scn.nextInt();
			System.out.println("Veuillez entrer le mois :");
			m=scn.nextInt();
			System.out.println("Veuillez entrer l'année :");
			a=scn.nextInt();
			if(estValide(j,m,a)) {
				this.set_annee(a);
				this.set_mois(m);
				this.set_jour(j);
				estValide=true;
			}
			else{
				estValide=false;
				System.out.println("Erreur la date n'est pas valide ! Recommencez");
			}
		}	
		scn.close();
	}

	public String enChaine() {
		String dateS="";
		if(this.get_jour()<10)
			dateS+="0"+this.get_jour()+"/";
		else
			dateS+=this.get_jour()+"/";
		if(this.get_mois()<10)
			dateS+="0"+this.get_mois()+"/";
		else
			dateS+=this.get_mois()+"/";
		dateS+=this.get_annee();
		return dateS;
	}

	public int quantieme() {
		int quantieme=0;
		for (int c_mois = 1; c_mois<this.get_mois(); c_mois++) {
			quantieme+=nbJourDansLeMois(c_mois, this.get_annee());
		}
		quantieme+=this.get_jour();
		return quantieme;
	}


	public int get_jour() {
		return _jour;
	}

	public void set_jour(int _jour) {
		if(_jour<=31 && _jour>0)
			this._jour = _jour;
		else
			System.out.println("Erreur : le jour n'est pas valide !");

	}

	public int get_mois() {
		return _mois;

	}

	public void set_mois(int _mois) {
		if(_mois>=1 && _mois<=12)
			this._mois = _mois;
		else
			System.out.println("Erreur : le mois n'est pas valide !");
	}

	public int get_annee() {
		return _annee;
	}

	public void set_annee(int _annee) {
		if(_annee>=0)
			this._annee = _annee;
		else
			System.out.println("Erreur : Veuillez entrer un année positive");
	}	


	public static void main(String[] args) {
		Date debut = new Date();
		Date fin = new Date(1,1,1);
		fin.saisir();
		System.out.println("Il y a une difference de "+Math.abs((fin.quantieme()-debut.quantieme()))+" entre les quantiemes du "+debut.enChaine()+" et du "+fin.enChaine());

	}

}
