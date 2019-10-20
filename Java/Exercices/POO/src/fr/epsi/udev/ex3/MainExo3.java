package fr.epsi.udev.ex3;

public class MainExo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TableauNombre tbNb = new TableauNombre();
		System.out.println(tbNb.calculMoyenne());
		System.out.println(tbNb.getMax());
		System.out.println(tbNb.getMin());
		System.out.println(tbNb.ecartMax());
		tbNb.triAbulle();
		System.out.println(tbNb.ecartMax());
	}
}
