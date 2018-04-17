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
	private String angularJsPath;
	private boolean isProductionEnv=false;
	private String jstlJspPath; 
	private String springLibJspPath;
	private String scriptJspPath;
	private String loginPageURL;
	private String loginReqURL;/*first req afte entring user pass to create session*/
	private String homePageURL;
	private String jsPath;
	private String bootstrapJsPath;
	private String popperJsPath;
	
	
	
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
	public boolean isProductionEnv() {
		return isProductionEnv;
	}
	public void setProductionEnv(boolean isProductionEnv) {
		this.isProductionEnv = isProductionEnv;
	}
	public String getJstlJspPath() {
		return jstlJspPath;
	}
	public void setJstlJspPath(String jstlJspPath) {
		this.jstlJspPath = jstlJspPath;
	}
	public String getSpringLibJspPath() {
		return springLibJspPath;
	}
	public void setSpringLibJspPath(String springLibJspPath) {
		this.springLibJspPath = springLibJspPath;
	}
	public String getScriptJspPath() {
		return scriptJspPath;
	}
	public void setScriptJspPath(String scriptJspPath) {
		this.scriptJspPath = scriptJspPath;
	}
	public String getLoginPageURL() {
		return loginPageURL;
	}
	public void setLoginPageURL(String loginPageURL) {
		this.loginPageURL = loginPageURL;
	}
	
	public String getLoginReqURL() {
		return loginReqURL;
	}
	public void setLoginReqURL(String loginReqURL) {
		this.loginReqURL = loginReqURL;
	}
	public String getHomePageURL() {
		return homePageURL;
	}
	public void setHomePageURL(String homePageURL) {
		this.homePageURL = homePageURL;
	}
	public String getAngularJsPath() {
		return angularJsPath;
	}
	public void setAngularJsPath(String angularJsPath) {
		this.angularJsPath = angularJsPath;
	}
	public String getJsPath() {
		return jsPath;
	}
	public void setJsPath(String jsPath) {
		this.jsPath = jsPath;
	}
	public String getBootstrapJsPath() {
		return bootstrapJsPath;
	}
	public void setBootstrapJsPath(String bootstrapJsPath) {
		this.bootstrapJsPath = bootstrapJsPath;
	}
	public String getPopperJsPath() {
		return popperJsPath;
	}
	public void setPopperJsPath(String popperJsPath) {
		this.popperJsPath = popperJsPath;
	}
		
}