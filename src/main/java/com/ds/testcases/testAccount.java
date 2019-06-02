package com.ds.testcases;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ds.entity.SearchForm;
import com.ds.pages.Elements;
//import com.ds.test.entity.LoginForm;
import com.ds.util.Capabilities;
import com.ds.util.Snapshot;

public class testAccount {
	private StringBuffer verificationErrors = new StringBuffer();
	String folder = "大圣车服APP站/testCreateOrder/";
	AndroidDriver<WebElement> driver = null;

	@BeforeClass
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = Capabilities.getCapabilities();

		driver = new AndroidDriver<WebElement>(new URL(Capabilities.getUrl()),
				capabilities);
		boolean isInstalled = driver.isAppInstalled("com.dscf.a");

		System.out.println("dddseeeeeeeeeeeeeeeeeee"+isInstalled);
		
		Thread.sleep(15000);
		
		if(!isInstalled){
			Snapshot.swipeToLeft(driver, 1000, 1);
			Thread.sleep(1000);

			Snapshot.swipeToLeft(driver, 1000, 1);
			Thread.sleep(1000);

			Snapshot.swipeToLeft(driver, 1000, 1);
			Thread.sleep(1000);

			Snapshot.clickScreen(540, 1760, 500, driver);
		}
		
		Snapshot.snapshot((TakesScreenshot) driver, folder + "INIT.png");

	}

	/*
	 * 测试登录
	 */
	@Test(priority = 1, description = "testAccountLogin")
	@Parameters({ "username", "password" })
	public void test_AccountLogin(String username, String password)
			 {

		try {
			Thread.sleep(2000);
			 int width = driver.manage().window().getSize().width;  
			    int height = driver.manage().window().getSize().height;  
//			    driver.tap(1, width-1, 1, 500);			Thread.sleep(2000);
				Snapshot.clickScreen(width-50, height-50, 500, driver);
				Thread.sleep(2000);
				
//				System.out.println("dddseeeeeeeeeeeeeeeeeee"+Snapshot.isElementExsit(driver, By.xpath(Elements.login)));

			// driver.findElementByXPath(Elements.close).click();
//			driver.t.findElementByXPath(Elements.my).click();
			driver.findElementByXPath(Elements.login).click();
			Thread.sleep(2000);

			driver.findElementByName(Elements.loginByAcc).click();
			driver.findElementByName(Elements.phone).sendKeys(username);
			driver.findElementByXPath(Elements.pwd).sendKeys(password);
			driver.findElementByName(Elements.loginBtn).click();


			Snapshot.snapshot((TakesScreenshot) driver, folder + "login.png");
			
			driver.findElementByXPath(Elements.seting).click();
			Thread.sleep(1000);


			assertEquals(true, Snapshot.isElementExsit(driver, By.name("退出登录")));
			driver.findElementByName("退出登录").click();
			driver.findElementByName("退出").click();

			Snapshot.snapshot((TakesScreenshot) driver, folder + "loginOut.png");
			Thread.sleep(1000);

			assertEquals(true, Snapshot.isElementExsit(driver, By.name("登录/注册")));

//			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
			Snapshot.snapshot((TakesScreenshot) driver, folder + "error.png");

			driver.quit();
		}

	}

	/*
	 * 测试登录
	 */
	@Test(priority = 1, description = "testAccountLogin")
	@Parameters({ "username", "Wpassword" })
	public void test_AccountLoginWithWrongPassword(String username, String Wpassword)
			 {

		try {
		
			driver.findElementByXPath(Elements.login).click();
			Thread.sleep(2000);

			driver.findElementByName(Elements.loginByAcc).click();
			driver.findElementByName(Elements.phone).sendKeys(username);
			driver.findElementByXPath(Elements.pwd).sendKeys(Wpassword);
			driver.findElementByName(Elements.loginBtn).click();


			Snapshot.snapshot((TakesScreenshot) driver, folder + "loginW.png");
			Thread.sleep(1000);

			assertEquals(true, Snapshot.isElementExsit(driver, By.name("账号或密码错误")));

		

			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
			Snapshot.snapshot((TakesScreenshot) driver, folder + "error.png");

			driver.quit();
		}

	}
	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
