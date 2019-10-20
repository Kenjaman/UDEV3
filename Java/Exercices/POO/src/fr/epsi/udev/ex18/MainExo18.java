package fr.epsi.udev.ex18;

public class MainExo18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Terrain monTerrain = new Terrain();
		monTerrain.ajouterForme(new Rectangle(0,0,2,2));
		System.out.println(monTerrain.calculerSurfaceTotale());
		monTerrain.ajouterForme(new Rectangle(0,0,2,2));
		System.out.println(monTerrain.calculerSurfaceTotale());
		monTerrain.ajouterForme(new Rectangle(0,0,2,2));
		System.out.println(monTerrain.calculerSurfaceTotale());
		monTerrain.ajouterForme(new Cercle(4,0,2));
		System.out.println(monTerrain.calculerSurfaceTotale());
		monTerrain.ajouterForme(new Triangle(0,6,5,23));
		System.out.println(monTerrain.calculerSurfaceTotale());
		monTerrain.ajouterForme(new Cercle(0,6,5));
		System.out.println(monTerrain.calculerSurfaceTotale());
	}

}
