package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.web.utils.WebManagar;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: AppConfigServlet
 *
 */

//http://www.codejava.net/java-ee/servlet/webservlet-annotation-examples
/*
 * commented because 
 * 	1. Servlet Registered Twice:
	The servlet is registered both via @WebServlet annotation and programmatically in your SpringWebAppInitializer (or similar Java config). This causes the servlet container to create two instances.
 * @WebServlet(urlPatterns = "/AppConfigServlet",
		loadOnStartup = 1,
        asyncSupported = false)*/

public class AppConfigServlet extends HttpServlet {
	static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String initial = getInitParameter("initial");
		System.out.println("########### AppConfigServlet Servlet initialized  #######################" + initial);
		WebManagar.setApplicationProperties(this.getServletContext());

	}
	

	/*@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
		System.out.println("########### AppConfigServlet Servlet service #######################" );
	}*/


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext servletContext = this.getServletContext();
		System.out.println(request.getContextPath()+"/logon.htm"+"########### AppConfigServlet Servlet doGet #######################" );
		//response.sendRedirect(request.getContextPath()+"/logon.htm");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title> AppConfig Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Setting properties </h1>");
		out.println("<a href=" + servletContext + ">" + "Click here to go back to input page " + "</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		WebManagar.setApplicationProperties(servletContext);
		

	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	public void destroy() {

	}

}