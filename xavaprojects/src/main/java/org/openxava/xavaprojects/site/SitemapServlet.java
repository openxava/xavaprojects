package org.openxava.xavaprojects.site;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Redirect sitemap.xml to sitemap.jsp.
 * 
 * @author Javier Paniza
 */

@WebServlet("/sitemap.xml")
public class SitemapServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/sitemap.jsp"); 
		dispatcher.forward(request, response);		
	}

}