package com.web.utils;

import java.io.Serializable;

public class ContextData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7108684215446338603L;
	private String extJSPath;
	private String openLayerJsPath;
	private String customJsPath;
	private String contextPath;
	private String cssPath;
	private String configFilesPath;
	private String imagesPath;
	private String jqueryJsPath;
	
	public String getExtJSPath() {
		return extJSPath;
	}
	public void setExtJSPath(String extJSPath) {
		this.extJSPath = extJSPath;
	}
	public String getOpenLayerJsPath() {
		return openLayerJsPath;
	}
	public void setOpenLayerJsPath(String openLayerJsPath) {
		this.openLayerJsPath = openLayerJsPath;
	}
	public String getCustomJsPath() {
		return customJsPath;
	}
	public void setCustomJsPath(String customJsPath) {
		this.customJsPath = customJsPath;
	}
	public String getContextPath() {
		return contextPath;
	}
	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
	public String getCssPath() {
		return cssPath;
	}
	public void setCssPath(String cssPath) {
		this.cssPath = cssPath;
	}
	public String getConfigFilesPath() {
		return configFilesPath;
	}
	public void setConfigFilesPath(String configFilesPath) {
		this.configFilesPath = configFilesPath;
	}
	public String getImagesPath() {
		return imagesPath;
	}
	public void setImagesPath(String imagesPath) {
		this.imagesPath = imagesPath;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getJqueryJsPath() {
		return jqueryJsPath;
	}
	public void setJqueryJsPath(String jqueryJsPath) {
		this.jqueryJsPath = jqueryJsPath;
	}
	
	
}