package com.ds.test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.ds.util.Capabilities;
import com.ds.util.Snapshot;
   
public class Main {  
    private AppiumDriver<WebElement> driver;  
   
    @Before  
    public void setUp() throws Exception {  
        // set up appium 
        DesiredCapabilities capabilities =  Capabilities.getCapabilities();
        driver = new AndroidDriver<WebElement>(new URL(Capabilities.getUrl()), capabilities);
    }  
   
    @After  
    public void tearDown() throws Exception {  
        driver.quit();  
    }  
   
//    @Test  
//    public void addContact(){  
//        WebElement el = driver.findElement(By.name("Add Contact"));  
//        el.click();  
//        List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");  
//        textFieldsList.get(0).sendKeys("Some Name");  
//        textFieldsList.get(2).sendKeys("Some@example.com");  
//        //driver.swipe(100, 500, 100, 100, 2);  
//        driver.findElementByName("Save").click(); 
//        
//    }  
    
    
    @Test  
    public void addContact() throws InterruptedException{  
        Thread.sleep(15000);

    	Snapshot.swipeToLeft(driver, 500, 1);
    	Snapshot.swipeToLeft(driver, 500, 1);
    	Snapshot.swipeToLeft(driver, 500, 1);

        WebElement el = driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.widget.ScrollView[1]/android.view.View[1]/android.view.View[5]/android.widget.HorizontalScrollView[1]/android.view.View[1]/android.view.View[2]/android.widget.TextView[1]"));  
        el.click();  
        
        String close = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.ImageView[1]";
      
        String my = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View[5]/android.widget.ImageView[1]";
        
        String myphoto = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.ScrollView[1]/android.view.View[1]/android.view.View[3]/android.widget.ImageView[1]";
        
        
        driver.findElement(By.xpath(close)).click();
        driver.findElement(By.xpath(my)).click();
        driver.findElement(By.xpath(myphoto)).click();

        
    }  
}  
