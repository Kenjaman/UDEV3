
public class Boulon extends Carre {
	private Cercle cercle;
	public Boulon(int x, int y, int couleur, int cote) {
		super(x,y,couleur,cote);
		this.cercle= new Cercle (x+cote/2,y+cote/2,couleur,cote/3);
	}

	@Override
	public boolean contient(int xx, int yy) {
		if(super.contient(xx, yy)) {
			if(!cercle.contient(xx, yy)) 
					return true;
		}
		return false;
	}

	@Override
	public double getSurface() {
		return super.getSurface()-cercle.getSurface();
	}

}
