package fr.epsi.udev.ex18;


public class Cercle extends Forme {

	private int rayon;

	public Cercle(int x, int y, int rayon) {
		super(x,y);
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


}
