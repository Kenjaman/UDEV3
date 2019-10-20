package fr.epsi.udev.ex14;

import java.util.Random;

public class mainExo14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Etudiant[] etus = new Etudiant[] {new Etudiant(),new Etudiant()};
		
		Employe[] emps = new Employe[] {new Employe(),new Employe()};

		Professeur[] profs = new Professeur[] {new Professeur(),new Professeur()};
		
		for(int i =0; i<2;i++) {
			System.out.println(etus[i]);
			System.out.println(emps[i]);
			System.out.println(profs[i]);
			etus[i].suivreCours(profs[i]);
			profs[i].attribuerNote(etus[i],
					new Random().nextInt(20)+1);
			profs[i].attribuerNote(etus[i],
					new Random().nextInt(20)+1);
			etus[i].passeExamen();
		}
		
		
	}

}
