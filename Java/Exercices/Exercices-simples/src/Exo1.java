import java.util.Scanner;
public class Exo1 {

	public static void main(String[] args) {
		final double TVA=1.2;
		double prixHT;
		double prixTTC;
		Scanner scan = new Scanner(System.in);
		System.out.println("Entrez le prix HT");
		prixHT= scan.nextFloat();
		scan.close();
		prixTTC=prixHT*TVA;
		System.out.println("Prix HT : "+prixHT+"\nPrix TTC : "+prixTTC+" € (TVA = "+((TVA-1)*100)+"%)");
		

	}

}
