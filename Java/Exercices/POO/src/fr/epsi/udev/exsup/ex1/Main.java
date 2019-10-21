package fr.epsi.udev.exsup.ex1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Solution 1 :
		Triangle monPremierTriange = new Triangle();
		monPremierTriange.setA(new Point(0,0));
		monPremierTriange.setB(new Point(0,10));
		monPremierTriange.setC(new Point(10,0));
		//Solution 2:
		Point pA= new Point(1,1);
		Point pB= new Point(3,3);
		Point pC= new Point(0,3);
		Triangle monDeuxiemeTriangle = new Triangle(pA,pB,pC);
		System.out.println(monPremierTriange.isIsocele());
		System.out.println(monDeuxiemeTriangle.isIsocele());
		
	}

}
