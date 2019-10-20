import java.util.Scanner;

public class Exo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double prixHT,tauxTVA,prixTTC;
		int nbArticle=0;
		double remise=0;

		Scanner scn= new Scanner(System.in);
		System.out.println("Entrer le prix du produit :");
		prixHT=scn.nextDouble();

		System.out.println("Entrer la TVA :");
		tauxTVA=scn.nextDouble();

		do{
			System.out.println("Entrer le nombre d'article :");
			nbArticle=scn.nextInt();
			if(nbArticle<0)
				System.out.println("Entrez un nombre d'articles positif");
			else if(nbArticle>10)
				remise=10;
			else if(nbArticle>5 && nbArticle<=10)
				remise=7.5;
			else
				remise=5;
		}while(nbArticle<0);

		prixHT=prixHT*nbArticle;
		prixTTC=prixHT*(1+tauxTVA/100);

		System.out.println("Le Prix TTC est de "+prixTTC+" €");
		prixTTC=prixTTC*(1-remise/100);
		System.out.println(prixTTC +"€ après remise");
		scn.close();
	}
}
