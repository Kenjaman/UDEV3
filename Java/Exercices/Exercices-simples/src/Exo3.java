import java.util.Scanner;

public class Exo3 {

	public static void main(String[] args) {
		int nb1,nb2,nb3,min=0;
		double moyenne;
		Scanner scan = new Scanner(System.in);
		System.out.println("Entrez un nombre :");
		nb1=scan.nextInt();
		System.out.println("Entrez un nombre :");
		nb2=scan.nextInt();
		System.out.println("Entrez un nombre :");
		nb3=scan.nextInt();
		scan.close();
		if(nb1<nb2 && nb1<nb3) {
			min=nb1;
		}else if(nb2<nb1 && nb2<nb3) {
				min=nb2;
		}else
			min=nb3;
		
		moyenne = (nb1+nb2+nb3)/3;
		System.out.println("Le plus petit est :"+min+" et la moyenne des trois est :"+moyenne);
	}

}
