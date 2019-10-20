package fr.epsi.udev.ex18;

public abstract class Forme {
	private int x;
	private int y;
	
	public Forme(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void deplace(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() {
		return String.format("x: %d, y: %d, couleur: %d", x, y);
	}
	
	public abstract double getSurface();
}
