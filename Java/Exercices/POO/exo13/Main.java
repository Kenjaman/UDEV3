package exo13;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bibliotheque b1,b2;
		b1=new Bibliotheque(200,"bibliotheque1","12 rue des pinsons","BORDEAUX");
		b2=new Bibliotheque(400,"bibliothèque2","14 rue des oies","ROUEN");
		System.out.println(b1);
		System.out.println(b1.Affiche());
		System.out.println(b2);
		System.out.println(b2.Affiche());
	}
	

}
