
public class Exo8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tab1[]= {6,8,12,9,3,5,41,6};
		int tab2[]= {3,8,9,2,2,3,17,4};
		int tab3[]= new int [8];
		
		for (int i=0;i<tab3.length;i++) {
			tab3[i]= tab1[i]+tab2[i];
			System.out.println(tab3[i]);
		}
	}

}
