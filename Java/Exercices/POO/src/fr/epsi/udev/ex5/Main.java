package fr.epsi.udev.ex5;


public class Main {

	public static void main(String[] args) {

		De[] des =new De[3];
		for(int i=0;i<des.length;i++) {
			des[i]= new De();
			System.out.println(des[i].getValue());
		}
		boolean win =(des[0].getValue()==des[1].getValue() ||
				des[1].getValue()==des[2].getValue() ||
				des[0].getValue()==des[2].getValue());
		if(win)
			System.out.println("GAGNE ");
		else
			System.out.println("PERDU");
	}
}
