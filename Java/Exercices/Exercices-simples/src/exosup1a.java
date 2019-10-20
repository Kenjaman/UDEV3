import java.util.Scanner;

public class exosup1a {
	static void minuteSuivante(int h, int m) {
		m++;
		if(m==60) {
			m=0;
			h=h+1;
		}
		if(h==24)
			h=0;
		System.out.println("Dans une minute il sera : "+transformerEnString(h)+":"+transformerEnString(m));
	}

	static void secondeSuivante(int h, int m, int s) {
		s++;
		if(s==60)
			m++;
		if(m==60) {
			m=0;
			h=h+1;
		}
		if(h==24)
			h=0;
		System.out.println("Dans une minute il sera : "+transformerEnString(h)+":"+transformerEnString(m)+":"+transformerEnString(s));
	}

	public static String transformerEnString(int nombre) {
		if(nombre<10)
			return "0"+nombre;
		else
			return ""+nombre;

	}

	public static int saisirNombre(String message) {
		int nb=0;
		Scanner scn = new Scanner(System.in);
		System.out.println(message);
		nb=scn.nextInt();
		return nb;
	}


	public static void main(String[] args) {
		int h,m,s;
		System.out.println("Quelle heure est il ?");
		h = saisirNombre("Heures :");
		m = saisirNombre("Minutes :");
		s = saisirNombre("Secondes");
		minuteSuivante(h, m);
		secondeSuivante(h, m, s);
		

	}

}
