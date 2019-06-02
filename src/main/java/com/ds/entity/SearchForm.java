package com.ds.entity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchForm {
	
	public static void search(WebDriver driver,String keyWords){
		// driver.get(baseUrl);
		    driver.findElement(By.id("J_Keyword")).clear();
		    driver.findElement(By.id("J_Keyword")).sendKeys(keyWords);
		   
		
		    driver.findElement(By.className("searchBtn")).click();
		
	}
	
	
	public static void searchAndSelectProduct(WebDriver driver,String keyWords,String productName){
	
		search(driver,keyWords);
		   
		
	}
	
}
