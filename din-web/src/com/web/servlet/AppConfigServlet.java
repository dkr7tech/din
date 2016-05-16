package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: AppConfigServlet
 *
 */
public class AppConfigServlet extends javax.servlet.http.HttpServlet {
	// private ServletContext servletContext;
	private String contextPath;
	static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String initial = getInitParameter("initial");
		System.out.println("initialdddd " + initial);
		setApplicationProperties(getServletContext());

	}

	/*
	 * public void init(ServletConfig config) throws ServletException {
	 * super.init(config); System.out.println(
	 * "Context Path:>+++++++++++++++++++++++++++++++");
	 * config.getServletContext();
	 * setServletContext(config.getServletContext());
	 * setContextPath(getServletContext().getContextPath()); System.out.println(
	 * "Context Path:>"+getContextPath()); setApplicationProperties(); }
	 */
	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
	 * HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext servletContext = this.getServletContext();
		// System.out.println("Context Path:>"+getContextPath());

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title> A very simple servlet example</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>dddddaaaaa" + servletContext + "</h1>");
		out.println("<a href=" + servletContext + ">" + "Click here to go back to input page " + "</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		setApplicationProperties(servletContext);

	}

	private void setApplicationProperties(ServletContext servletContext) {
		System.out.println("set appliation properties called" + servletContext.getContextPath());
		String contextPath = servletContext.getContextPath();
		HashMap<String, String> cofigMap = new HashMap<String, String>();
		cofigMap.put("EXT_JS_PATH", contextPath + "/js/extjs-4.1.0");
		cofigMap.put("OPENLAYER_JS_PATH", contextPath + "/js/Map/OpenLayers-2.11");
		cofigMap.put("CUSTOM_JS_PATH", contextPath + "/js/custom");
		cofigMap.put("CONTEXT_PATH", contextPath);
		servletContext.setAttribute("configMap", cofigMap);

	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 * HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	public void destroy() {

	}

}