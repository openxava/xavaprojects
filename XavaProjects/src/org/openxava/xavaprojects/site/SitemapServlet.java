package org.openxava.xavaprojects.site;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * tmp
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