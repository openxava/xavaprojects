package org.openxava.xavaprojects.site;

import java.io.IOException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.commons.logging.*;
import org.openxava.util.*;


/**
 * @author Javier Paniza
 */


@WebServlet({"/ate/*", "/adw/*", "/dad/*"})
public class LandingServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] uri = request.getRequestURI().split("/", 5);
		if (uri.length >= 3) {
			String url = uri[uri.length - 1]; 
			String keyPrefix = url.replace("-", "_") + "_";
			
			Properties properties = Landing.getAll(request);
			String title = properties.getProperty(keyPrefix + "title");
			request.setAttribute("pageTitle", title);
			
			String description1 = properties.getProperty(keyPrefix + "description1");
			request.setAttribute("description1", description1);
			
			String description2 = properties.getProperty(keyPrefix + "description2");
			request.setAttribute("description2", description2);			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/naviox/welcome.jsp"); 
		dispatcher.forward(request, response);		
	}
	

}