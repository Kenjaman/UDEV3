import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Commande maCommande = new Commande(3.2); 
	    Article[] promos = {
	    		new Article ("Serviette baleine",12.7),
	    		new Article ("Seau Mickey",4.5)
	    };
	    Catalogue monCatalogue = new Catalogue();
	    
	    for(Article a : promos) {
	    	monCatalogue.ajouterArticle(a);
	    }
	    
	    //LigneCommande ligne2;
	    //ArrayList<LigneCommande> commande = new ArrayList<LigneCommande>();
	    
	    Article tongs = new Article("Tong Bahamas",3.5);
	    int noTongs=monCatalogue.ajouterArticle(tongs);
	    //LigneCommande ligne1 = new LigneCommande("Tong Bahamas", 2, 3.5);
	    //commande.add(ligne1);
	    
	    Article ballon = new Article("Ballon",1.05);
	    //ligne2 = new LigneCommande("Ballon", 1.05);
	    //commande.add(ligne2);
	    int noBallon = monCatalogue.ajouterArticle(ballon);
	    maCommande.ajouterLigneCommande(tongs,2);
	    for(Article article : promos)
	    	maCommande.ajouterLigneCommande(article, 1);
		String articlePluslong="";
		for (LigneCommande ligne : maCommande.getLignes()) {
			if(articlePluslong.length()<=ligne.getNomArticle().length())
				articlePluslong=ligne.getNomArticle();
		}

		int longueurArticleMax=articlePluslong.length();
		System.out.println("+-"+dessiner1ereColones(longueurArticleMax,"-")+"------+--------+-----+---------+");
		System.out.println("| Articles"+dessiner1ereColones(longueurArticleMax-2, " ")+"|  P.U   | Qte |  Prix   |");
		System.out.println("+-"+dessiner1ereColones(longueurArticleMax,"-")+"------+--------+-----+---------+");
		for (LigneCommande ligne : maCommande.getLignes()) {
			System.out.printf("| %-"+(5+longueurArticleMax)+"s | %6.2f | %3d | %7.2f |\n", // %7.2f = un r�el sur 7 caract�re avec 2 chiffre apr�s la virgule
					ligne.getNomArticle(),
					ligne.getPrixUnitaire(),
					ligne.getQuantite(),
					ligne.getPrixLigne());
		}// %-17s = decalage vers la gauche et completion si necessaire de la chaine de caract�re avec 17 caract�res d'espacement
		System.out.println("+-"+dessiner1ereColones(longueurArticleMax,"-")+"------+--------+-----+---------+");
		System.out.printf(" Sous-total"+dessiner1ereColones(longueurArticleMax+12, " ")+"| %7.2f |\n", maCommande.getSousTotal());
		System.out.printf(" Livraison"+dessiner1ereColones(longueurArticleMax+13, " ")+"| %7.2f |\n", maCommande.getLivraison());
		System.out.println(dessiner1ereColones(longueurArticleMax+23, " ")+"+---------+");
		System.out.printf(" Total HT"+dessiner1ereColones(longueurArticleMax+14, " ")+"| %7.2f |\n", maCommande.getPrixTotalHT());
		System.out.printf(" Total TTC"+dessiner1ereColones(longueurArticleMax+13, " ")+"| %7.2f |\n", maCommande.getPrixTotalTTC(0.20));
		System.out.println(""+dessiner1ereColones(longueurArticleMax+23, " ")+"+---------+");

	}
	
	private static String dessiner1ereColones(int articlePluslong,String motif) {
		String dessin = "";
		for(int i=0; i<articlePluslong;i++)
			dessin+=motif;
		return dessin;
	}

}
