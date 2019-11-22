package com.cgi.udev3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.krysalis.barcode4j.servlet.BarcodeServlet;

@WebServlet(urlPatterns = "/codifi")
public class MonCodify extends HttpServlet	 {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String nom = request.getParameter("nomProd");
		String code = request.getParameter("msg");
		System.out.println("nom :"+nom);
		System.out.println("code :"+code);
		response.setContentType("text/html"); // text/plain -> type MIME 
		response.setCharacterEncoding("UTF-8");
		
		response.getWriter().write("<!DOCTYPE html>" + 
				"<html>" + 
				"<head>" + 
				"<meta charset=\"UTF-8\">" + 
				"<title>Insert title here</title>" + 
				"</head>" + 
				"<body><H1>"+nom+"</h1><p>Le code barre :</p>"
				+ "<img width='200px'height='300px' src='./codify?type=datamatrix&nomProd="+nom+"&msg="+code+"'/></body></html>");
//		response.sendRedirect(response.encodeRedirectURL("./codify?type='datamatrix'&nomProd="+nom+"&msg="+code));
	}

}
