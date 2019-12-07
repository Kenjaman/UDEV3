package cocktail.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cocktail.modele.Commande;
import cocktail.modele.TableauCommandes;

@WebServlet("/execute")
public class ServiceCommande extends HttpServlet {
	private static final String VUE_LISTE = "/WEB-INF/jsp/tableauDesCommandes.jsp";
	private static final String VUE_EXECUTION = "/WEB-INF/jsp/executionCommande.jsp";
	private TableauCommandes lesCommandes;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		lesCommandes = getListCommandes();
		Commande laCommande = lesCommandes.peek();
		if(laCommande!=null) {
			req.getServletContext().setAttribute("laCommande", laCommande);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(VUE_EXECUTION);
			rd.forward(req, resp);
		}else {
			req.setAttribute("errTabEmpty", "Pas de commande en attente");
			RequestDispatcher rd = getServletContext().getRequestDispatcher(VUE_LISTE);
			rd.forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(lesCommandes.traiterCommande()!=null) {
			getServletContext().setAttribute("listeCommandes", lesCommandes);
			resp.sendRedirect("/cocktailee/recapCommande");
		}
//		RequestDispatcher rd = getServletContext().getRequestDispatcher(VUE_LISTE);
//		rd.forward(req, resp);
	}
	
	private TableauCommandes getListCommandes() {
		return (TableauCommandes) getServletContext().getAttribute("listeCommandes");
	}

}
