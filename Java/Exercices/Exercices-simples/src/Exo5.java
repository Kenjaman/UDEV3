import java.util.Scanner;

public class Exo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nb=0;
		Scanner scn = new Scanner(System.in);
		do {
			System.out.println("Entrez un nombre entre 50 et 100 svp :");
			nb=scn.nextInt();
			if(nb<50)
				System.out.println("Plus grand...");
			else if(nb>100)
				System.out.println("Plus petit...");
		}while(nb<50 || nb>100);
		scn.close();
		System.out.println("MErci bye!");
	}

}
