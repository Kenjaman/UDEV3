import java.util.Scanner;
public class Exo6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int nb=0;
		boolean premier=true;
		System.out.println("Entrez un nombre ");
		nb=scn.nextInt();
		
		for(int i =1; i<=nb && premier==true;i++) {
				if(nb%i==0 && (i !=1 && i!=nb))
					premier=false;
				else if(i==nb && nb%i==0)
					premier=true;
		}
		
		

		if(premier)
			System.out.println(nb +" est premier ");
		else
			System.out.println(nb +" n'est pas premier");
		scn.close();
	}

}
