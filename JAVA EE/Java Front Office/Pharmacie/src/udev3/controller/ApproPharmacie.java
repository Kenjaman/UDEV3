package udev3.controller;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import udev3.bdd.ConnexionBdd;
import udev3.beans.Medicament;

/**
 * Servlet implementation class ApproPharmacie
 */
@WebServlet("/appro")
public class ApproPharmacie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String VUE_ACC = "/WEB-INF/accueil.jsp";
	private static String VUE_FORM = "/WEB-INF/appro.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApproPharmacie() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnexionBdd connexion = new ConnexionBdd();
		Medicament medocInconnue = (Medicament) getServletContext().getAttribute("medocInconnu");
		if(medocInconnue!= null) {
			if(Integer.valueOf(request.getParameter("create"))==1) {
				medocInconnue.setPrix(Double.valueOf(request.getParameter("prix")));
				connexion.creationBDDMed(medocInconnue);
				getServletContext().removeAttribute("medocInconnu");

				this.getServletContext().getRequestDispatcher(request.getContextPath() + "/").forward(request, response);//(request.getContextPath() + "/");
			}else {
				getServletContext().removeAttribute("medocInconnu");
				System.out.println(this.getServletContext().getContextPath());
				//sendRedirect(request.getContextPath() + "/");
			}
		}
		this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnexionBdd connexion = new ConnexionBdd();
		Medicament medicament = new Medicament(request.getParameter("nomMed"),
				Double.valueOf(request.getParameter("qte")),0);
		try {
			connexion.approvisionnement(request.getParameter("nomMed"),Integer.valueOf(request.getParameter("qte")));
			response.sendRedirect(request.getContextPath() + "/");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.getServletContext().setAttribute("medocInconnu", medicament);
			request.setAttribute("error", e.getMessage());
			this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);
		}			
	}

}
