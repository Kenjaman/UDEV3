package fr.epsi.udev.exsup.ex1;

public class Triangle {

	private Point a;
	private Point b;
	private Point c;
	
	public Triangle() {
		super();
		a= new Point();
		b=new Point();
		c=new Point();
	}
	
	public Triangle(Point a, Point b, Point c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Point getA() {
		return a;
	}

	public void setA(Point a) {
		this.a = a;
	}

	public Point getB() {
		return b;
	}

	public void setB(Point b) {
		this.b = b;
	}

	public Point getC() {
		return c;
	}

	public void setC(Point c) {
		this.c = c;
	}
	
	public boolean isIsocele() {
		if(this.calculLongeur(a, b)== this.calculLongeur(a, c) ||
				this.calculLongeur(b,c) == this.calculLongeur(b, a) ||
				this.calculLongeur(c, b)== this.calculLongeur(c, a))
			return true;
		else
			return false;
	}
	
	private double calculLongeur(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p2.getX()-p1.getX(),2)+Math.pow(p2.getY()-p1.getY(), 2));
		
	}
	
	
	
	
}
