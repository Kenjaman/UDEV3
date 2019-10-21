package udev.java.cours.heritage;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Mammifere m = new Mammifere("dupont");
	        Humain h = new Humain("Dylan", "bob");
	        Femme f = new Femme("FiceBouché","Laurie",false);
	        Homme o = new Homme("DeBic","Marcel","pas de barbe");


	        System.out.println(m);
	        System.out.println(h);
	        System.out.println(f);
	        System.out.println(o);

	        m.seDeplacer();
	        h.seDeplacer();
	        f.seDeplacer();
	        o.seDeplacer();

	        m.manger();
	        h.manger();
	        f.manger();
	        o.manger();
	}

}
