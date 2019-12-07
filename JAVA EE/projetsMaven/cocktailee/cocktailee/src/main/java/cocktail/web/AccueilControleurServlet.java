package cocktail.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cocktail.modele.TableauCommandes;

@WebServlet("/accueil")
public class AccueilControleurServlet extends HttpServlet {

	private static final String VUE_ACCUEIL = "/index.jsp";
	private TableauCommandes lesCommandes;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		lesCommandes = getListCommandes();
		getServletContext().setAttribute("listeCommandes", lesCommandes);
		getServletContext().getRequestDispatcher(VUE_ACCUEIL).forward(req, resp);
	}
	
	private TableauCommandes getListCommandes() {
		return (TableauCommandes) getServletContext().getAttribute("listeCommandes");
	}
}
