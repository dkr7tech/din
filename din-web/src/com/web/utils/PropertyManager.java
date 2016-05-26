package com.web.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class PropertyManager {
	public static void main(String args[]){
		Map map=writePropertiefiles("JM_inancial_imited","b",true);
		System.out.println("map"+map);
		
	}

    public static Map<String, String> readPropertiefiles(String fileName) {
        Properties properties = new Properties();
        Map<String, String> proMap = null;
        try {
            InputStream inputStream =WebUtil.getServletContext().getResourceAsStream(WebUtil.getConfigPath()+fileName);
            //InputStream inputStream = utility.getClass().getResourceAsStream(fileName);
            if (inputStream == null) {
                System.out.println("file not found");
            } else {
                properties.load(inputStream);
            }
            proMap = (Map) properties;
        } catch (IOException e) {
            System.out.println("Exception " + e);
        }
        return proMap;
    }
	
	public static Map<String, String> readPropertiefiles2(String fileName) {
		Properties properties = new Properties();
		Map<String, String> proMap = null;
		try {
			FileInputStream fileInputStream = new FileInputStream("c:/a/a.properties");
			System.out.println("readddd");
			properties.load(fileInputStream);
			proMap = (Map) properties;
		} catch (IOException e) {
			System.out.println("Exception " + e);
		}
		return proMap;
	}
	public static Map<String, String> writePropertiefiles(String propKey,String propValue,boolean add) {
		Properties properties = new Properties();
		Map<String, String> proMap = null;
		try {
	
			FileOutputStream fileOutputStream=new FileOutputStream("c:/a/b.properties");
			proMap= readPropertiefiles("dd");
			if(add){
				proMap.put(propKey,propValue);	
		}else{
		
			proMap.remove(propKey);
		}
			String a="";
			
	//Collections.checkedSortedMap(proMap,a.getClass(),a.getClass());
		properties.setProperty("dkd", "ssss");
		System.out.println("readddd"+properties);
		/**
		 * if you pass null then it comments the file with #Sat Sep 04 22:24:15 IST 2010
		 */
		properties.store(fileOutputStream, null);
		
			
		} catch (IOException e) {
			System.out.println("Exception " + e);
		}
		return proMap;
	}
	
}
