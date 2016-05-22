package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.utils.WebManagar;

/**
 * Servlet implementation class for Servlet: AppConfigServlet
 *
 */
@WebServlet("/AppConfigServlet")
public class AppConfigServlet extends javax.servlet.http.HttpServlet {
	static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String initial = getInitParameter("initial");
		System.out.println("########### AppConfigServlet Servlet initialized  #######################" + initial);
		WebManagar.setApplicationProperties(this.getServletContext());

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext servletContext = this.getServletContext();
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