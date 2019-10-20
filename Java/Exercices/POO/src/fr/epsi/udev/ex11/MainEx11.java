package fr.epsi.udev.ex11;

public class MainEx11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Article [] articles =new Article[4];
		articles[0] =new Article();
		articles[1] =new Article(002,"Article 2",20);
		articles[2] =new Article(003,"Article 3");
		articles[3] =new Article(articles[0]);
		
		for(int i=0;i<4;i++)
			System.out.println("Prx article "+i+" :"+articles[i].calculPrixTTC());
	}

}
