package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.config.web.WebConstants;
import com.web.utils.ContextData;
import com.web.utils.PropertyManager;
import com.web.utils.WebUtil;

/**
 * Servlet implementation class for Servlet: AppConfigServlet
 *
 */
public class AppConfigServlet extends javax.servlet.http.HttpServlet {
	static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String initial = getInitParameter("initial");
		System.out.println("initialdddd " + initial);
		// setApplicationProperties(getServletContext());

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
		setApplicationProperties(servletContext);

	}

	private void setApplicationProperties(ServletContext servletContext) {
		System.out.println("set appliation properties called");
		WebUtil util = new WebUtil(servletContext);
		Map<String, String> propertiesMap = PropertyManager.readPropertiefiles(WebConstants.RESOURCE_PROP_FILE);
		String contextPath = servletContext.getContextPath();
		ContextData contextData = new ContextData();
		contextData.setExtJSPath(contextPath + propertiesMap.get(WebConstants.EXT_JS_PATH).trim());
		contextData.setOpenLayerJsPath(contextPath + propertiesMap.get(WebConstants.OPENLAYER_JS_PATH).trim());
		contextData.setContextPath(contextPath);
		contextData.setCustomJsPath(contextPath + propertiesMap.get(WebConstants.CUSTOM_JS_PATH).trim());
		contextData.setImagesPath(contextPath + propertiesMap.get(WebConstants.IMAGES_PATH).trim());
		contextData.setCssPath(contextPath + propertiesMap.get(WebConstants.CSS_PATH).trim());
		contextData.setJqueryJsPath(contextPath + propertiesMap.get(WebConstants.JQUERY_PATH).trim());
		servletContext.setAttribute(WebConstants.APP_CONTEXT_BEAN, contextData);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	public void destroy() {

	}

}