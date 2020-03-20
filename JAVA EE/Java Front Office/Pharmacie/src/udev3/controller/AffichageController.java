package udev3.controller;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class AffichageController
 */
@WebServlet("/")
public class AffichageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private static String VUE_ACC = "/WEB-INF/accueil.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffichageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ConnexionBdd connexion = new ConnexionBdd();
		List<Client> clients = new ArrayList<Client> (connexion.getClients());
		List<Medicament> medocs = new ArrayList<Medicament> (connexion.getMedicaments());
		request.setAttribute("clients", clients);
		request.setAttribute("medicaments", medocs);
		this.getServletContext().getRequestDispatcher(VUE_ACC).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
