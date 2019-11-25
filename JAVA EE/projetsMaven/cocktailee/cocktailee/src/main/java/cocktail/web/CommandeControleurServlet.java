package cocktail.web;

import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cocktail.modele.Cocktail;
import cocktail.modele.CocktailService;
import cocktail.modele.Commande;
import cocktail.modele.DonneesInvalidesException;
import cocktail.modele.TableauCommandes;

@WebServlet(urlPatterns = "/commande", loadOnStartup = 0)
public class CommandeControleurServlet extends HttpServlet {

	private static final String VUE_COMMANDE = "/WEB-INF/jsp/commande.jsp";
	private static final String VUE_RECAP_COMMANDE = "/WEB-INF/jsp/recapCommande.jsp";

	@Override
	public void init() throws ServletException {
		CocktailService cocktailService = new CocktailService();
		// on place le service en portée "application" pour qu'il puisse être récupéré plus tard.
		getServletContext().setAttribute("cocktailService", cocktailService);
		// on place la liste des cocktails en portée "application" pour que les vues puissent y accéder.
		getServletContext().setAttribute("listeCocktails", cocktailService.getListeCocktails());
		TableauCommandes listeCommande = new TableauCommandes();
		getServletContext().setAttribute("listeCommandes", listeCommande);
	
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher(VUE_COMMANDE);
		
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CocktailService cocktailService = getCocktailService();
		TableauCommandes listeCommandes = (TableauCommandes) getServletContext().getAttribute("listeCommandes");
		try {
		Integer cockComm = Integer.valueOf(req.getParameter("cocktail"));
		String numTable = req.getParameter("table");
		Commande laCommande = new Commande(cocktailService.getCocktail(cockComm),numTable);
		if(listeCommandes.ajoutCommande(laCommande)) {
			req.setAttribute("laCommande", laCommande);
			System.out.println(laCommande.getNumeroTable()+ " inserer");
			getServletContext().setAttribute("listeCommandes", listeCommandes);
			System.out.println(listeCommandes);
			getServletContext().getRequestDispatcher(VUE_RECAP_COMMANDE).forward(req, resp);		
		}
		else
			throw new DonneesInvalidesException("Quelque chose a mal tourné dans l'ajout de la commande...");
		}catch(DonneesInvalidesException e ) {
			req.setAttribute("erreurs", e.getErreurs());
			req.setAttribute("cocktailService", cocktailService);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(VUE_COMMANDE);
			rd.forward(req, resp);

		}
	}

	private CocktailService getCocktailService() {
		return (CocktailService) getServletContext().getAttribute("cocktailService");
	}
}
