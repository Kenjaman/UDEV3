package fr.epsi.udev.ex18;


public class Terrain {
	private Forme[] formes;

	public Terrain() {
		formes = new Forme[5];
	}

	public Terrain(Forme[] formes) {
		super();
		this.formes = formes;
	}

	public double calculerSurfaceTotale() {
		double surface=0;
		for (Forme forme : formes) {
			if(forme != null)
				surface += forme.getSurface();
		}
		return surface;
	}

	public void ajouterForme(Forme formAj) {
		for (int i=0;i<this.formes.length;i++) {
			if(this.formes[i]== null) {
				this.formes[i]=formAj;
				break;
			}
		}
	}

	public Forme[] getFormes() {
		return formes;
	}


}
