package udev3.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import udev3.bdd.ConnexionBdd;
import udev3.beans.Client;
import udev3.beans.Medicament;

/**
 * Servlet implementation class ApproPharmacie
 */
@WebServlet("/achat")
public class AchatMedoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String VUE_ACC = "/WEB-INF/accueil.jsp";
	private static String VUE_FORM = "/WEB-INF/achat.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AchatMedoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnexionBdd connexion = new ConnexionBdd();
		List<Medicament> medocs = connexion.getMedicaments();	

		this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnexionBdd connexion = new ConnexionBdd();
		try {
			Medicament medoc = connexion.lireMedicament(request.getParameter("nomMed"));
			Client client= connexion.lireClient(request.getParameter("nomCli"));
			connexion.achat(client.getNom(),
					medoc.getNom(),
					Integer.valueOf(request.getParameter("qte")),
					Integer.valueOf(request.getParameter("paiement")));
			response.sendRedirect(request.getContextPath() + "/");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);
		}			
	}

}
