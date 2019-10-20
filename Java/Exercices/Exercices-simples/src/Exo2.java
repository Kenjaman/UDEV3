import java.util.Scanner;

public class Exo2 {

	public static void main(String[] args) {
		int nb1, nb2;
		Scanner scan= new Scanner(System.in);
		System.out.println("Entrez un nombre : ");
		nb1=scan.nextInt();
		System.out.println("Entrez un autre nombre : ");
		nb2=scan.nextInt();
		scan.close();
		System.out.println(nb1>nb2?"Le plus grand est "+nb1 : "Les plus grand est "+nb2);
	}
}
