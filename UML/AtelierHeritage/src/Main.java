
public class Main {

	public static void main(String[] args) {
		// Le code suivant �volue "les yeux ferm�s"
		Forme f = new Cercle(20,10,0,10); // f ne pourra pas utiliser les methodes sp�cifiques de Cercle
		System.out.println(f);
		System.out.println(f.getSurface());

		// le code suivant �volue est d�di� au Cercle
		Cercle c = new Cercle(20,8,0,6);
		System.out.println(c);
		System.out.println(c.getSurface());

		Boulon e =	new Boulon (2,2,0,15);
		Rectangle r = new Rectangle(e.getLargeur()/2+e.getX(), e.getLongueur()/2+e.getY(), 0, 10, 10);
		

		Forme[] formesDuDessin = {
				f,
				r,e,
				c
		};
		for( Forme forme : formesDuDessin ) {
			System.out.print(forme);
			System.out.print(": ");
			System.out.println(forme.getSurface());	
		}


			for(int y = 0; y<25;y++) {
				for(int x=0; x<50;x++) {
					boolean contenu=false;
					for(Forme formADess : formesDuDessin) {
						if(formADess.contient(x, y)) 
							contenu=true;
				}
					System.out.print(contenu?"* ":"  ");
			}
			System.out.print("\n ");
		}
	}


}
