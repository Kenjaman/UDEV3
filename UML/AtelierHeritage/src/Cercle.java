
public class Cercle extends Forme {

	private int rayon;

	public Cercle(int x, int y,int couleur, int rayon) {
		super(x,y,couleur);
		this.rayon = rayon;
	}
	@Override
	public double getSurface() {
		return rayon*rayon*Math.PI;
	}
	@Override
	public String toString() {
		return "Cercle [rayon=" + rayon + ", toString()=" + super.toString() + "]";
	}
	@Override
	public boolean contient(int xx, int yy) {
		int dx = getX()-xx;
		int dy = getY()-yy;
		return dx*dx+dy*dy <=rayon*rayon;
	}


}
