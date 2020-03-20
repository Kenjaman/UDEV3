package udev3.TD2.exo2.controller;

import java.io.IOException;
import java.net.HttpCookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Accueil() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				System.out.println(cookie.getName());
				if(cookie.getName().equals("nom")) {
				request.setAttribute("nom", cookie.getValue());
				}

			}
			this.getServletContext().getRequestDispatcher("/WEB-INF/affichage.jsp").forward(request, response);

		}else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/formulaire.jsp").forward(request, response);
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String[]metiers = request.getParameterValues("metiers");
		String autreMetiers = request.getParameter("liste-metiers");

		Cookie cookies = new Cookie("nom", nom);
		cookies.setMaxAge(60*60*2);
		response.addCookie(cookies);
		
		response.sendRedirect(request.getContextPath() + "/accueuil");
		
//		this.getServletContext().getRequestDispatcher("/WEB-INF/affichage.jsp").forward(request, response);

	}

}
