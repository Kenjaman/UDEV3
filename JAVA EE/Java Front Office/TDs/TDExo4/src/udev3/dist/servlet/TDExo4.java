package udev3.dist.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import udev3.dist.beans.Etudiant;
import udev3.dist.beans.Professeur;

/**
 * Servlet implementation class TDExo4
 */
@WebServlet("/TDExo4")
public class TDExo4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TDExo4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Etudiant etu1 = new Etudiant();
		Etudiant etu2 = new Etudiant(1,"Roux","Kénan",1927415845,2);
		Professeur p1 = new Professeur();
		Professeur p2 = new Professeur(1,"Damas","Luc",188759989,5);
		
		request.setAttribute("etudiant1", etu1);
		request.setAttribute("etudiant2", etu1);
		request.setAttribute("prof1", p1);
		request.setAttribute("prof2", p2);
		this.getServletContext().getRequestDispatcher("/WEB-INF/TDExo4.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
