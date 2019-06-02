package com.ds.testcases;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import com.ds.test.entity.LoginForm;
import com.ds.entity.SearchForm;
import com.ds.util.Snapshot;



public class testCreateOrder_PC {
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	String folder = "大圣车服PC站/testCreateOrder/";

	@BeforeClass
	@Parameters({ "website", "username", "password" })

	public void setUp(String website, String username, String password) throws Exception {
//		com.ds.util.Snapshot.setFirefox();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(website);
		driver.manage().window().maximize();
		  if(Snapshot.isElementExsit(driver,By.partialLinkText("登录")))
			  driver.findElement(By.partialLinkText("登录")).click();
//		  LoginForm.login(driver, username, password);
		  
		  
		Snapshot.snapshot((TakesScreenshot) driver, folder + "login_suc.png");

	}

	/*
	 * 查询指定商品
	 */
	@Test(priority = 1, description = "testSearchTheProduct")
	public void test_1_SearchTheProduct() throws Exception {
		SearchForm.search(driver, "广汽");
//		driver.findElement(By.className("choose_diamonds")).click();
		driver.findElement(By.xpath("//*[@id='j-search']/div[2]/div[1]/div[2]/div[4]/input")).click();
		
		Snapshot.snapshot((TakesScreenshot) driver, folder + "search_theProduct_suc.png");
	//	assertEquals(true, Snapshot.isElementExsit(driver, By.id("Img63593")));
		// System.out.println(driver.getWindowHandles());

	}

	/*
	 * 查询到指定商品后点击该商品进入详情页
	 */
	@Test(priority = 2, description = "testClickTheSearchedProduct")
	public void test_2_ClickTheSearchedProduct() throws Exception {
//		driver.findElement(By.linkText("雅阁")).click();
		driver.findElement(By.xpath("//*[@id='j-search']/div[2]/div[2]/div[1]/div[2]/div/div[1]/a[1]/p")).click();

		
		Snapshot.switchToWindow_Title(driver, "一口价详情");

		Snapshot.snapshot((TakesScreenshot) driver, folder + "theProduct.png");
		// System.out.println(driver.getWindowHandles());

	}

	/*
	 * 进入详情页,点击立即订车
	 */
	@Test(priority = 3, description = "testAddTheSearchedProductToCart")
	public void test_3_AddTheSearchedProductToCart() throws Exception {
		// add to cart
		driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div/div[5]/div[1]/a/span")).click();
		Thread.sleep(3000);
		Snapshot.snapshot((TakesScreenshot) driver, folder + "addToCart.png");
	}

	/*
	 * 点击查看购物车
	 */
	//@Test(priority = 4, description = "testGoToCart")
	public void test_4_GoToCart() throws Exception {

		driver.findElement(By.cssSelector("#cart_lists_show > div.go_order_box > p:nth-child(2) > a")).click();
		Thread.sleep(3000);

		Snapshot.snapshot((TakesScreenshot) driver, folder + "goToCart.png");
		System.out.println("ffffff" + driver.getWindowHandles());
		Snapshot.switchToWindow_Title(driver, "查看购物车");
	}
	/*
	 * 点击提交订单
	 */
	@Test(priority = 5, description = "testGoToOrder")
	public void test_5_GoToOrder() throws Exception {
		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/oni:validation/ul/li[1]/input")).clear();
//		driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/oni:validation/ul/li[1]/input")).sendKeys("测试");
//		driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/oni:validation/ul/li[2]/input")).clear();
//		driver.findElement(By.("/html/body/div[3]/div[3]/div/oni:validation/ul/li[2]/input")).sendKeys("13111111111");
		
		driver.findElement(By.cssSelector("body > div.checkout_main > div:nth-child(4) > div > oni:validation > ul > li:nth-child(1) > input")).clear();
		driver.findElement(By.cssSelector("body > div.checkout_main > div:nth-child(4) > div > oni:validation > ul > li:nth-child(1) > input")).sendKeys("测试");
		driver.findElement(By.cssSelector("body > div.checkout_main > div:nth-child(4) > div > oni:validation > ul > li:nth-child(2) > input")).clear();
		driver.findElement(By.cssSelector("body > div.checkout_main > div:nth-child(4) > div > oni:validation > ul > li:nth-child(2) > input")).sendKeys("13111111111");
		
		
		
		
		driver.findElement(By.xpath("/html/body/div[3]/div[7]/div[2]/div[2]/input[1]")).click();
		
		
		Snapshot.snapshot((TakesScreenshot) driver, folder + "goToOrder.png");
			assertEquals(true, driver.findElement(By.className("info-left-remind")).getText().contains("提交订单成功，请您尽快付款！"));

		
	}
	/*
	 * 点击查看订单
	 */
	@Test(priority = 6, description = "testSubmitOrder")
	public void test_6_SubmitOrder() throws Exception {

		
		driver.findElement(By.linkText("查看订单")).click();
		Thread.sleep(2000);

		Snapshot.snapshot((TakesScreenshot) driver, folder + "submitOrder.png");

		Thread.sleep(2000);

	}
	/*
	 * 废除订单
	 */
	@Test(priority = 7, description = "testCancelOrder")
	public void test_7_CancelOrder() throws Exception {

		driver.findElement(By.linkText("用户中心")).click();
		Snapshot.snapshot((TakesScreenshot) driver, folder + "goToMyOrder.png");
		driver.findElement(By.linkText("新车订单")).click();

		Thread.sleep(3000);
		driver.findElement(By.linkText("取消订单")).click();
		
		//通过下拉列表中选项的索引选中第二项，即2011年
				Select selectAge = new Select(driver.findElement(By.className("fl")));
				selectAge.selectByIndex(5);
		driver.findElement(By.id("dialog-confirm")).click();

		Snapshot.snapshot((TakesScreenshot) driver, folder + "cancelOrder.png");

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

	public void cancelOrder(){
		
		
		driver.findElement(By.linkText("我的订单")).click();
		driver.findElement(By.linkText("取消订单")).click();
		driver.findElement(By.id("Confirm")).click();

	}
}
