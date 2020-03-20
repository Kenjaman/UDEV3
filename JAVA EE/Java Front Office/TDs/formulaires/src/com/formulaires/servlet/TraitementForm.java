package com.formulaires.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/information.jsp")
public class TraitementForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_AFF = "/WEB-INF/jsp/affichage.jsp";


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(VUE_AFF);
		
		
		
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(VUE_AFF);
		
//		HttpSession session = request.getSession();
//		String nom = request.getParameter("nom");
//		String prenom = request.getParameter("prenom");
//		String[] metiers = request.getParameterValues("metiers");
//		String autresMetiers = request.getParameter("liste-metiers");
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("prenom")) {
			request.setAttribute("prenom", cookie.getValue());
		}}}

		
		session.setAttribute("nom", nom);
		session.setAttribute("prenom", prenom);
		session.setAttribute("metiers", metiers);
		session.setAttribute("autresMetiers", autresMetiers);
		
		
		response.sendRedirect(request.getContextPath() + "/affichage");
	}

}
