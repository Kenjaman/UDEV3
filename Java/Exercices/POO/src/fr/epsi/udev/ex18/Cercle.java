package fr.epsi.udev.ex18;


public class Cercle extends Forme {

	private int rayon;

	public Cercle(int rayon) {
		super();
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
