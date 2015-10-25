package com.cdp.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestConfiguration {
	

		private final static String FIREFOX = "firefox";
		private final static String CHROME = "chrome";
		private final static String IEXPLORER = "iexplorer";
		private final static String HTMLUNIT = "htmlunit";
		
		private static String userName;
		
		private static String password;
		
		private static String getpaidBaseUrl;
		
		private static String courierBaseUrl;
		
		private static String browserType;

		static {
			
			System.setProperty("atu.reporter.config", "C:/getpaid/getpaid762/workspace_tag_branch/selenium-automation/src/main/resources/atu.properties");
			
			
			Properties props = new Properties();
			InputStream in = TestConfiguration.class.getClassLoader().getResourceAsStream("automation-config.properties");
			if (in != null) {
				try {
					props.load(in);
					userName = props.getProperty("userName");
					password = props.getProperty("password");
					browserType = props.getProperty("browserType");
					getpaidBaseUrl = props.getProperty("getpaidBaseUrl");
					courierBaseUrl = props.getProperty("courierBaseUrl");
				} catch (IOException e) {
					e.printStackTrace();
					System.exit(1);
				}
			}
			
		}
		
	    public static WebDriver getWebDriver() {
	    	
	    	if(FIREFOX.equalsIgnoreCase(browserType)) {
	    		return new FirefoxDriver();
	    	}
	    	
	    	if(CHROME.equalsIgnoreCase(browserType)) {
	    		return new ChromeDriver();
	    	}
	    	
	    	if(IEXPLORER.equalsIgnoreCase(browserType)) {
	    		return new InternetExplorerDriver();
	    	}
	        
	    	if(HTMLUNIT.equalsIgnoreCase(browserType)) {
	    		return new HtmlUnitDriver();
	    	}
	    	
	    	return new FirefoxDriver();
	    }
		
		/**
		 * @return the userName
		 */
		public static String getUserName() {
			return userName;
		}

		/**
		 * @return the password
		 */
		public static String getPassword() {
			return password;
		}

		/**
		 * @return the baseUrl
		 */
		public static String getGetpaidBaseUrl() {
			return getpaidBaseUrl;
		}

		/**
		 * @return the browserType
		 */
		public static String getBrowserType() {
			return browserType;
		}

		/**
		 * @return the courierBaseUrl
		 */
		public static String getCourierBaseUrl() {
			return courierBaseUrl;
		}

	}

