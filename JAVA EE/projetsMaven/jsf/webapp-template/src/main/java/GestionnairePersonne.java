import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="gp")
@RequestScoped
public class GestionnairePersonne {
	private Personne personne = new Personne();

	public Personne getPersonne() {
		return personne;
	}
	
	public String acceuillir() {
		System.out.println("coucouuuuuuuuuuuuuuuuuu "+getPersonne().getNom());
		return "affichageParametres";
	}
 
}
