package cribleEratosthene;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean [] tabCrible = new boolean[101];
		initialiserTableau(tabCrible);
		rechercherNombresPremiers(tabCrible);
		afficherNombresPremiers(tabCrible);
	}
	
	static void initialiserTableau(boolean [] tabAInitialiser) {
		for(int i=1;i<tabAInitialiser.length;i++){
			tabAInitialiser[i]=true;
			if(i==1)
				tabAInitialiser[i]=false;
		}
	}
	
	static void mettreLesMultiplesAFaux(boolean [] tab, int i) {
		for(int j=i;j<tab.length;j++){
			if(i%j==0 && i*j<tab.length)
				tab[i*j]=false;
		}
		
	}
	
	static void rechercherNombresPremiers(boolean []tab) {
		for(int i=2;i<100;i++) {
			for(int j=100; j>0;j--) {
				if(i%j==0 && (j !=1 && i!=j))
					tab[i]=false;
				else if(i==j && i%j==0)
					mettreLesMultiplesAFaux(tab, i);
			}
		}
	}
	
	static void afficherNombresPremiers(boolean[] tab) {
		System.out.println("Liste des nombre premiers :");
		for (int i=0; i<tab.length;i++) {
			if(tab[i])
				System.out.println(i);
		}
	}
}
