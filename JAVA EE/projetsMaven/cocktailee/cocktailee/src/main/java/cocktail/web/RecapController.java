package cocktail.web;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cocktail.modele.Commande;
import cocktail.modele.TableauCommandes;

@WebServlet(urlPatterns = "/recapCommande", name = "recapCommande")
public class RecapController extends HttpServlet {
	private static final String VUE_LISTE = "/WEB-INF/jsp/tableauDesCommandes.jsp";
	private static final String VUE_EXECUTION = "/WEB-INF/jsp/executionCommande.jsp";
	private TableauCommandes lesCommandes;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub;
		lesCommandes = new TableauCommandes(getListCommandes());
		getServletContext().setAttribute("listeCommandes", lesCommandes);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(VUE_LISTE);
		rd.forward(req, resp);
	}
	
	//Appui sur le bouton "Cocktail Suivant"
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub.
		System.out.println("doPost");
		lesCommandes = getListCommandes();
		Commande laCommande = lesCommandes.peek();
		if(laCommande!=null) {
			getServletContext().setAttribute("laCommande", laCommande);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(VUE_EXECUTION);
			rd.forward(req, resp);
		}
//		else {
//			RequestDispatcher rd = getServletContext().getRequestDispatcher(VUE_LISTE);
//			rd.forward(req, resp);
//		}
	}

	private TableauCommandes getListCommandes() {
		return (TableauCommandes) getServletContext().getAttribute("listeCommandes");
	}
}