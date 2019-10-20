package fr.epsi.udev.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TableauNombre {

	Scanner scn = new Scanner(System.in);
	private int[] nombre;

	public TableauNombre() {
		nombre = new int[10];
		for (int i = 0; i < nombre.length; i++) {
			System.out.println("Entrer le " + i + "eme élément :");
			nombre[i] = scn.nextInt();
		}
	}

	public double calculMoyenne() {
		double total = 0;
		for (int i = 0; i < this.nombre.length; i++) {
			total += this.nombre[i];
		}
		return total / this.nombre.length;
	}

	public int getMax() {
		int max = 0;
		for (int i = 0; i < this.nombre.length; i++) {
			if (max < this.nombre[i])
				max = this.nombre[i];
		}
		return max;
	}

	public int getMin() {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < this.nombre.length; i++) {
			if (min > this.nombre[i])
				min = this.nombre[i];
		}
		return min;
	}

	public void afficheSupMoy() {
		for (int nb : this.nombre)
			if (nb > this.calculMoyenne())
				System.out.println(nb);

	}
	
	public List<Integer> rechercherNbSupMoyenne(){
		List listNbSupMoyenne = new ArrayList<Integer>();
		double moyenne = this.calculMoyenne();
		for(int nb: nombre) {
			if(nb>moyenne)
				listNbSupMoyenne.add(nb);
		}
		return listNbSupMoyenne;
	}
	
	public int ecartMax() {
		int ecart = 0, ecartMax = 0;
		for (int i = 1; i < this.nombre.length; i++) {
			ecart = Math.abs(this.nombre[i] - this.nombre[i - 1]);
			if (ecart > ecartMax) {
				ecartMax = ecart;
			}
		}
		return ecartMax;
	}

	public void triAbulle() {
		int n = this.nombre.length - 1;
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				if (this.nombre[j - 1] > this.nombre[j]) {
					int temp = this.nombre[j - 1];
					this.nombre[j - 1] = this.nombre[j];
					this.nombre[j] = temp;
				}
			}
		}
	}

	public int[] getNombre() {
		return nombre;
	}

	public void setNombre(int[] nombre) {
		this.nombre = nombre;
	}

}
