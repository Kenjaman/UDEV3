package fr.epsi.udev.ex20;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainEx20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Le nombre entier est : "+saisieCorrect());

	}

	public static int saisieCorrect(){
		boolean ok = false;
		int saisie =0;
		do {
			try {
				System.out.println("Entrez la saisie d'un nombre entier");
				Scanner scn= new Scanner(System.in);
				saisie = scn.nextInt();
				if(saisie<10) {
					//throw new TropBassException("Saisie < 0");
					throw new IllegalArgumentException("Saisie < 0");
				}
				ok=true;

			}catch(InputMismatchException e) {
				ok=false;
				System.out.println("Erreure de saisie");
//			} catch (TropBassException e) {
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				ok=false;
				System.out.println(e.getMessage());
				//				e.printStackTrace();
			}
		}while(!ok);
		return saisie;
	}

}
