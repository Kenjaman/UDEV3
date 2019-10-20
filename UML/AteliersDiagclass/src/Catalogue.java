import java.util.ArrayList;
import java.util.List;

public class Catalogue {

	List <Article> articles= new ArrayList <Article>();

	public int ajouterArticle(Article a) {
		if(a==null) {
			throw new NullPointerException("Votre article est null !");
		}
		if(this.articles.indexOf(a)<0) 
			articles.add(a);
		return this.articles.indexOf(a);

	}

	public Article getArticle(int numeroArticle){
		return this.articles.get(numeroArticle);

	}
}
