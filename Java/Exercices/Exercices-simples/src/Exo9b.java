import java.util.Scanner;

public class Exo9b {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tabNote[]= new int [10];
		int tabMin=0,tabMinb=0;
		Scanner scn = new Scanner(System.in);
		for (int i=0;i<tabNote.length;i++) {
			System.out.println("Entrez note n°"+i);
			tabNote[i]=scn.nextInt();
		}
		for (int i=1;i<tabNote.length;i++) {
			if(tabNote[i]>tabNote[i-1]) {
				tabMin = tabNote[i-1];
			}
			else {
				tabMin=tabNote[i];
				tabMinb=tabMin;
			}
			if(tabMinb<tabMin) 
				tabMin=tabMinb;
		}
		System.out.println("Min : "+tabMin);
				
	}
}
