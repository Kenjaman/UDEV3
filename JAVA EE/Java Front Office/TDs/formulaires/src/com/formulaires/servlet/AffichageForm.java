package com.formulaires.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AffichageForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_AFF = "/WEB-INF/jsp/affichage.jsp";
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		request.getSession().getAttribute("nom");
		request.getSession().getAttribute("prenom");
		request.getSession().getAttribute("metiers");
		request.getSession().getAttribute("autresMetiers");
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(VUE_AFF);
		
		
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
