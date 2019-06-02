package com.ds.util;
import java.io.File;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Capabilities {	   
	    public static DesiredCapabilities getCapabilities()  {  
	        // set up appium 
			String APPpath = "d:\\apptest\\run\\PRO\\apps\\com.dscf.a_2.7.3_1048619.apk";

	        DesiredCapabilities capabilities = new DesiredCapabilities();  
	        capabilities.setCapability("platformName", "Android");  
	        capabilities.setCapability("deviceName","Android Emulator");  
	        capabilities.setCapability("platformVersion", "4.4");  
//	        capabilities.setCapability("app", "/temp/ContactManager.apk"); 
//	        capabilities.setCapability("app", "/temp/com.dscf.a_1.3.0_16.apk");  
//	        capabilities.setCapability("app", "D:\AntomationTesting\workspace\AppDemo\apps\ContactManager.apk"); 


	        File classpathRoot = new File(System.getProperty("user.dir"));
//	         File appDir = new File(classpathRoot, "apps");
//	         File app = new File(appDir, "ContactManager.apk");
//	         capabilities.setCapability("appPackage", "com.example.android.contactmanager");
	         
//	         File app = new File(appDir, "com.dscf.a.1804191004.apk");
	         
	        capabilities.setCapability("appPackage", "com.dscf.a");  
	        capabilities.setCapability("automationName", "Appium");	       
	        
//	        capabilities.setCapability("app", app.getAbsolutePath()); 
	        capabilities.setCapability("app", APPpath); 
	        capabilities.setCapability("noReset", true);
	        capabilities.setCapability("newCommandTimeout", 120);
	     
	        
	        return capabilities;
	    }
	    
	    
	    
	    
	    
	    public static String getUrl(){
	    	return "http://127.0.0.1:4723/wd/hub";
	    }
	    
	    public String getUserName(){
	    	return "%username%";
	    }
	    
	    public String getPassWord(){
	    	return "%password%";
	    }





		public static DesiredCapabilities getCapabilities(String appDir,
				String name) {
	        // set up appium 
//				String APPpath = "d:\\apptest\\run\\PRO\\apps\\com.dscf.a.1804191004.apk";

		        DesiredCapabilities capabilities = new DesiredCapabilities();  
		        capabilities.setCapability("platformName", "Android");  
		        capabilities.setCapability("deviceName","Android Emulator");  
		        capabilities.setCapability("platformVersion", "4.4");  
//		        capabilities.setCapability("app", "/temp/ContactManager.apk"); 
//		        capabilities.setCapability("app", "/temp/com.dscf.a_1.3.0_16.apk");  
//		        capabilities.setCapability("app", "D:\AntomationTesting\workspace\AppDemo\apps\ContactManager.apk"); 


		        File classpathRoot = new File(System.getProperty("user.dir"));
//		         File appDir = new File(classpathRoot, "apps");
//		         File app = new File(appDir, "ContactManager.apk");
//		         capabilities.setCapability("appPackage", "com.example.android.contactmanager");
		         
//		         File app = new File(appDir, "com.dscf.a.1804191004.apk");
		         
//		        capabilities.setCapability("appPackage", "com.dscf.a");  
		        capabilities.setCapability("appPackage", name);  

		        capabilities.setCapability("automationName", "Appium");	       
		        
//		        capabilities.setCapability("app", app.getAbsolutePath()); 
		        capabilities.setCapability("app", appDir); 

		     
		        
		        return capabilities;
		}    
}
