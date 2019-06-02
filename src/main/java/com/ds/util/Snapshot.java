package com.ds.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class Snapshot {
	
	//瑙ｅ浘
	 public static void snapshot(TakesScreenshot drivername, String filename)
	  {
	      // this method will take screen shot ,require two parameters ,one is driver name, another is file name
	     
		 
	    File scrFile = (File) drivername.getScreenshotAs(OutputType.FILE);
	        // Now you can do whatever you need to do with it, for example copy somewhere
	        try {
	        	  String projectRoot = getProjectRoot();
	        	  System.out.println("save snapshot path is:"+projectRoot+"\\test-output\\html\\snapshot\\"+filename+new Date().toString());
		            FileUtils.copyFile(scrFile, new File(projectRoot+"\\test-output\\html\\snapshot\\"+filename));

	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            System.out.println("Can't save screenshot");
	            e.printStackTrace();
	        }
	        finally
	        {
	            System.out.println("screen shot finished");
	        }
	  }
	//截图
		 public static String getSnapshot(TakesScreenshot drivername, String path)
		  {
		      // this method will take screen shot ,require two parameters ,one is driver name, another is file name
			    File scrFile = (File) drivername.getScreenshotAs(OutputType.FILE);
			    Date currentTime = new Date();
		     	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		     	String dateString = formatter.format(currentTime);
		     	String filename = path+"screenshot_"+formatter.format(currentTime)+".png";

		        // Now you can do whatever you need to do with it, for example copy somewhere
		        try {
		        	  System.out.println("save snapshot path is:"+filename);
			            FileUtils.copyFile(scrFile, new File(filename)); 
			          
		        } catch (IOException e) {
		            // TODO Auto-generated catch block
		            System.out.println("Can't save screenshot");
		            e.printStackTrace();
		        }
		        finally
		        {
		            System.out.println("screen shot finished");
		        }
		        return filename;
		  }
	 
	 //锟叫讹拷元锟斤拷锟角凤拷锟斤拷锟�
	 public static boolean isElementExsit(WebDriver driver, By locator) {  
	        boolean flag = false;  
	        try {  
	            WebElement element=driver.findElement(locator);  
	            flag=null!=element;  
	        } catch (NoSuchElementException e) {  
	            System.out.println("Element:" + locator.toString()  
	                    + " is not exsit!");  
	        }  
	        return flag;  
	    }
	 
	 
//	 public static boolean isElementExsit(WebDriver driver, WebElement element) {  
//	        boolean flag = false;  
//	        try {  
//	            WebElement element=driver.findElement(locator);  
//	            flag=null!=element;  
//	        } catch (NoSuchElementException e) {  
//	            System.out.println("Element:" + locator.toString()  
//	                    + " is not exsit!");  
//	        }  
//	        return flag;  
//	    }
	 
	// 锟斤拷锟絋itle锟叫伙拷锟铰达拷锟斤拷
	  public static boolean switchToWindow_Title(WebDriver driver, String windowTitle) {
	    boolean flag = false;
	    try {
	      String currentHandle = driver.getWindowHandle();
	      Set<String> handles = driver.getWindowHandles();
	      for (String s : handles) {
	        if (s.equals(currentHandle))
	          continue;
	        else {
	          driver.switchTo().window(s);
	          if (driver.getTitle().contains(windowTitle)) {
	            flag = true;
	            System.out.println("Switch to Window: " + windowTitle
	                + "  successfully~~~!");
	            break;
	          } else
	            continue;
	        }
	      }
	    } catch (NoSuchWindowException e) {
	      System.out.println("Window: " + windowTitle + " cound not find!!!"
	          + e.fillInStackTrace());
	      flag = false;
	    }
	    return flag;
	  }
	  
	// 锟斤拷锟経RL锟叫伙拷锟铰达拷锟斤拷
	  public static boolean switchToWindow_Url(WebDriver driver, String windowUrl) {
	    boolean flag = false;
	    try {
	      String currentHandle = driver.getWindowHandle();
	      Set<String> handles = driver.getWindowHandles();
	      for (String s : handles) {
	        if (s.equals(currentHandle))
	          continue;
	        else {
	          driver.switchTo().window(s);
	          if (driver.getCurrentUrl().contains(windowUrl)) {
	            flag = true;
	            System.out.println("Switch to Window: " + windowUrl
	                + "  successfully~~~!");
	            break;
	          } else
	            continue;
	        }
	      }
	    } catch (NoSuchWindowException e) {
	      System.out.println("Window: " + windowUrl + " cound not find!!!"
	          + e.fillInStackTrace());
	      flag = false;
	    }
	    return flag;
	  }

	//锟斤拷锟斤拷潜锟节碉拷1锟斤拷alert锟斤拷javascript锟斤拷锟斤拷锟斤拷
	  public static boolean dealPotentialAlert(WebDriver driver,boolean option) {
	  //锟角凤拷锟斤拷锟�
	  boolean flag = false;
	  //锟届常锟斤拷锟斤拷
	  try {
	      Alert alert = driver.switchTo().alert();
	      //锟叫讹拷锟角凤拷锟斤拷锟絘lert锟斤拷锟斤拷
	      if (null == alert){
	          throw new NoAlertPresentException();
	      }
	      //锟届常锟斤拷锟斤拷
	      try {
	          //确锟斤拷or取锟斤拷
	          if (option) {
	              //确锟斤拷
	              alert.accept();
	              System.out.println("Accept the alert: " + alert.getText());
	          } else {
	              //取锟斤拷
	              alert.dismiss();
	              System.out.println("Dismiss the alert: " + alert.getText());
	          }
	          flag = true;
	      } catch (WebDriverException e) {
	          if (e.getMessage().startsWith("Could not find")){
	              System.out.println("There is no alert appear!");
	          }else{
	              throw e;
	          }
	      }
	  } catch (NoAlertPresentException e) {
	      System.out.println("There is no alert appear!");
	  }
	  return flag;
	  }
	  
	  public static void setFirefox(){
          //System.setProperty("webdriver.firefox.bin", "D:/Program Files/Mozilla firefox/firefox.exe"); 
	         // System.setProperty("webdriver.firefox.bin", "D:/Program Files (x86)/Mozilla Firefox/firefox.exe"); 
	          System.setProperty("webdriver.firefox.bin", "C:/Program Files (x86)/Mozilla Firefox/firefox.exe"); 

//		  C:\Program Files (x86)\Mozilla Firefox
	  }
	  
	  public static void setChromeBrowser(){
   	 
		  System.setProperty(
                  "webdriver.chrome.driver",
                  "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
		
		  
	          // 璁剧疆 chrome 鐨勮矾寰�
	        
	          // 鍒涘缓涓�釜 ChromeDriver 鐨勬帴鍙ｏ紝鐢ㄤ簬杩炴帴 Chrome
	      //    @SuppressWarnings("deprecation")
//	          ChromeDriverService service = new ChromeDriverService.Builder()
//
//	  .usingDriverExecutable(
//	                          new File(
//	                                  "E:/lib/selenium/dirver/chromedriver_2.9.exe"))
//
//	                  .usingAnyFreePort().build();
//	          service.start();
	          
	          
	  }
	  
	  //鑾峰彇椤圭洰璺緞
	  public static String getProjectRoot(){
		  File directory = new File("");// 
		  String courseFile = null;
		try {
			courseFile = directory.getCanonicalPath();
			  System.out.println(courseFile);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return courseFile;

	  }  
	  //鍒涘缓鏂囦欢澶�
	  public static boolean makeDirs(String folderStr) {
	        File folder = new File(folderStr);
	        return (folder.exists() && folder.isDirectory()) ? true : folder.mkdirs();
	    }
	  
	  //创建时间戳的文件夹
	  public static boolean makeResultFolder(String folderStr) {
	        File folder = new File(folderStr);
	        return (folder.exists() && folder.isDirectory()) ? true : folder.mkdirs();
	    }
	  
	  //copy file
	  public static void copyFile(File sourcefile,File targetFile) throws IOException{
	        
	        //鏂板缓鏂囦欢杈撳叆娴佸苟瀵瑰畠杩涜缂撳啿
	        FileInputStream input=new FileInputStream(sourcefile);
	        BufferedInputStream inbuff=new BufferedInputStream(input);
	        
	        //鏂板缓鏂囦欢杈撳嚭娴佸苟瀵瑰畠杩涜缂撳啿
	        FileOutputStream out=new FileOutputStream(targetFile);
	        BufferedOutputStream outbuff=new BufferedOutputStream(out);
	        
	        //缂撳啿鏁扮粍
	        byte[] b=new byte[1024*5];
	        int len=0;
	        while((len=inbuff.read(b))!=-1){
	            outbuff.write(b, 0, len);
	        }
	        
	        //鍒锋柊姝ょ紦鍐茬殑杈撳嚭娴�
	        outbuff.flush();
	        
	        //鍏抽棴娴�
	        inbuff.close();
	        outbuff.close();
	        out.close();
	        input.close();
	        
	        
	    }
	  
	  public static void copyDirectiory(String sourceDir,String targetDir) throws IOException{ 
		  //	        String targetDir = "D:/TestReports/"+getNowDateShort();  

	        //鏂板缓鐩爣鐩綍
		  makeDirs(targetDir);
	        //(new File(targetDir)).makeDirs();
	        
	        //鑾峰彇婧愭枃浠跺す褰撲笅鐨勬枃浠舵垨鐩綍
	        File[] file=(new File(sourceDir)).listFiles();
	        System.out.println("dd"+file.length);
	        for (int i = 0; i < file.length; i++) {
	            if(file[i].isFile()){
	                //婧愭枃浠�
	                File sourceFile=file[i];
	                        System.out.println(i+sourceFile.getAbsolutePath());

	                    //鐩爣鏂囦欢
	                File targetFile=new File(new File(targetDir).getAbsolutePath()+File.separator+file[i].getName());
	                
	                copyFile(sourceFile, targetFile);
	            
	            }
	            
	            
	            if(file[i].isDirectory()){
	                //鍑嗗澶嶅埗鐨勬簮鏂囦欢澶�
	                String dir1=sourceDir+file[i].getName()+"/";
	                //鍑嗗澶嶅埗鐨勭洰鏍囨枃浠跺す
	                String dir2=targetDir+"/"+file[i].getName()+"/";
			        System.out.println("ddddddd"+dir1); 
			        System.out.println("dddddddddd"+dir2); 

	                copyDirectiory(dir1, dir2);
	            }
	        }
	        
	    }
	  
	  /**
	   * 鑾峰彇鐜板湪鏃堕棿
	   * 
	   * @return杩斿洖鐭椂闂存牸寮�yyyy-MM-dd
	   */
	  public static String getNowDateShort() {
	   Date currentTime = new Date();
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	   String dateString = formatter.format(currentTime);
       System.out.println(dateString+"鏃ユ湡杞崲鎴愬姛"); 


	   return dateString; 

	  }
	  
	  /**
	   * 获取时间到haom
	   * 
	   * @return杩斿洖鐭椂闂存牸寮�yyyy-MM-dd
	   */
	  public static String getNowDateForResult() {
	   Date currentTime = new Date();
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmssSSS");
	   String dateString = formatter.format(currentTime);
       System.out.println(dateString+"鏃ユ湡杞崲鎴愬姛"); 


	   return dateString; 

	  }
	  
	  
	  public  static boolean isTextPresent(WebDriver driver,String what) {
		  try{
		       System.out.println(driver.findElement(By.tagName("body"))+"鏃ユvvvvvvvvvvvvvvvvvvv杞崲鎴愬姛"); 

		  return driver.findElement(By.tagName("body")).getText().contains(what);// 遍历body节点下的所有节点 取其文本值 并判断是否包含 文本 what
		  }
		  catch (Exception e){
		  return false;// 没有该文本 则 返回 false
		  }
		  }
	  
	  public  static boolean isTextPresentForAPP(WebDriver driver,String what) {
		  try{

		  return driver.findElement(By.name("name")).getText().contains(what);// 遍历body节点下的所有节点 取其文本值 并判断是否包含 文本 what
		  }
		  catch (Exception e){
		  return false;// 没有该文本 则 返回 false
		  }
		  }
	  
	  /** <Summary>
	/// Highlight WebElement
	/// </Summary>
	**/
	public static void highlightElement(WebDriver driver, WebElement element) {
	 
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("element = arguments[0];" +
	             "original_style = element.getAttribute('style');" +
	                 "element.setAttribute('style', original_style + \";" +
//	             "background: yellow; border: 1px solid red;\");" +
                 "background: yellow;\");" +

	             "setTimeout(function(){element.setAttribute('style', original_style);}, 500);", element);
	}
	

public static List<String> showAllFiles(File dir, String matcher) throws Exception{
	List<String> list = new ArrayList<String>();
	   File[] fs = dir.listFiles();
	   for(int i=0; i<fs.length; i++){
	   if(fs[i].getName().contains(matcher)){
	     System.out.println(fs[i].getName());
	     list.add(fs[i].getName());
	    }
	    else{}
	   }
	return list;
	}
//	public static void sendMail(){
//		Snapshot.setFirefox();
//		 WebDriver driver = new FirefoxDriver();
//		 String  baseUrl = "http://192.168.21.31:9999/2015-10-26/";
//		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		    
//		    driver.get(baseUrl);
//		      driver.manage().window().maximize();
//
//			  Snapshot.snapshot((TakesScreenshot)driver,"report.png");
//			  driver.quit();
//	        // 閰嶇疆鍙戦�閭欢鐨勭幆澧冨睘鎬�
//	        final Properties props = new Properties();
//	        /*
//	         * 鍙敤鐨勫睘鎬э細 mail.store.protocol / mail.transport.protocol / mail.host /
//	         * mail.user / mail.from
//	         */
//	        // 琛ㄧずSMTP鍙戦�閭欢锛岄渶瑕佽繘琛岃韩浠介獙璇�
//	        props.put("mail.smtp.auth", "true");
//	        props.put("mail.smtp.host", "smtp.163.com");
//	        // 鍙戜欢浜虹殑璐﹀彿
//	        props.put("mail.user", "wojiushio@163.com");
//	        // 璁块棶SMTP鏈嶅姟鏃堕渶瑕佹彁渚涚殑瀵嗙爜
//	        props.put("mail.password", "6281621");
//
//	        // 鏋勫缓鎺堟潈淇℃伅锛岀敤浜庤繘琛孲MTP杩涜韬唤楠岃瘉
//	        Authenticator authenticator = new Authenticator() {
//	            @Override
//	            protected PasswordAuthentication getPasswordAuthentication() {
//	                // 鐢ㄦ埛鍚嶃�瀵嗙爜
//	                String userName = props.getProperty("mail.user");
//	                String password = props.getProperty("mail.password");
//	                return new PasswordAuthentication(userName, password);
//	            }
//	        };
//	        // 浣跨敤鐜灞炴�鍜屾巿鏉冧俊鎭紝鍒涘缓閭欢浼氳瘽
//	        Session mailSession = Session.getInstance(props, authenticator);
//	        // 鍒涘缓閭欢娑堟伅
//	        MimeMessage message = new MimeMessage(mailSession);
//	        // 璁剧疆鍙戜欢浜�
//	        InternetAddress form;
//			try {
//				form = new InternetAddress(
//				        props.getProperty("mail.user"));
//		        message.setFrom(form);
//		        // 璁剧疆鎶勯�
//		        InternetAddress cc = new InternetAddress("527618032@qq.com");
//		        message.setRecipient(RecipientType.CC, cc);
//
//		        // 璁剧疆瀵嗛�锛屽叾浠栫殑鏀朵欢浜轰笉鑳界湅鍒板瘑閫佺殑閭欢鍦板潃
//		        InternetAddress bcc = new InternetAddress("502621427@qq.com");
//		        message.setRecipient(RecipientType.CC, bcc);
//
//		        // 璁剧疆閭欢鏍囬
//		        message.setSubject("娴嬭瘯閭欢");
//
//		        // 璁剧疆閭欢鐨勫唴瀹逛綋
//		        message.setContent("<a href='http://www.fkjava.org'>绾︾偖鍚�</a>", "text/html;charset=UTF-8");
//
//		        // 鍙戦�閭欢
//		        Transport.send(message);
//		        
//		        
//		        
//		        
//		        
//		        
//		        MimeBodyPart text = new MimeBodyPart(); 
//		        // setContent(鈥滈偖浠剁殑姝ｆ枃鍐呭鈥�鈥濊缃偖浠跺唴瀹圭殑缂栫爜鏂瑰紡鈥� 
//		        text.setContent("娴嬭瘯鎶ュ憡锛屾閭欢涓虹郴缁熻嚜鍔ㄥ彂閫�img src='cid:a'><img src='cid:b'>", 
//		                "text/html;charset=gb2312"); 
//		        MimeBodyPart img = new MimeBodyPart(); 
//		        /*
//		         * JavaMail API涓嶉檺鍒朵俊鎭彧涓烘枃鏈�浠讳綍褰㈠紡鐨勪俊鎭兘鍙兘浣滆導鑷細MimeMessage鐨勪竴閮ㄥ垎.
//		         * 闄や簡鏂囨湰淇℃伅,浣滀负鏂囦欢闄勪欢鍖呭惈鍦ㄧ數瀛愰偖浠朵俊鎭殑涓�儴鍒嗘槸寰堟櫘閬嶇殑. JavaMail
//		         * API閫氳繃浣跨敤DataHandler瀵硅薄,鎻愪緵涓�釜鍏佽鎴戜滑鍖呭惈闈炴枃鏈珺odyPart瀵硅薄鐨勭畝渚挎柟娉�
//		         */ 
//		        DataHandler dh = new DataHandler(new FileDataSource("D://report.png"));//鍥剧墖璺緞 
//		        img.setDataHandler(dh); 
//		        // 鍒涘缓鍥剧墖鐨勪竴涓〃绀虹敤浜庢樉绀哄湪閭欢涓樉绀�
//		        img.setContentID("a"); 
//		   
////		        MimeBodyPart img2 = new MimeBodyPart(); 
////		        DataHandler dh2 = new DataHandler(new FileDataSource("d://goToOrder.png"));//绗簩寮犲浘鐗囪矾寰�
////		        img2.setDataHandler(dh2); 
////		        img2.setContentID("b"); 
//		        // 鍒涘缓闄勪欢 
//		        // MimeBodyPart attch = new MimeBodyPart(); 
//		        // DataHandler dh1 = new DataHandler(new FileDataSource("src//b.jpg")); 
//		        // attch.setDataHandler(dh1); 
//		        // String filename1 = dh1.getName(); 
//		        // MimeUtility 鏄竴涓伐鍏风被锛宔ncodeText锛堬級鐢ㄤ簬澶勭悊闄勪欢瀛楋紝闃叉涓枃涔辩爜闂 
//		        // attch.setFileName(MimeUtility.encodeText(filename1)); 
//		        // 鍏崇郴 姝ｆ枃鍜屽浘鐗囩殑 
//		        MimeMultipart mm = new MimeMultipart(); 
//		        mm.addBodyPart(text); 
//		        mm.addBodyPart(img); 
//		        mm.setSubType("related");// 璁剧疆姝ｆ枃涓庡浘鐗囦箣闂寸殑鍏崇郴 
//		        // 鍥剧彮涓庢鏂囩殑 body 
//		        MimeBodyPart all = new MimeBodyPart(); 
//		        all.setContent(mm); 
//		        // 闄勪欢涓庢鏂囷紙text 鍜�img锛夌殑鍏崇郴 
//		        MimeMultipart mm2 = new MimeMultipart(); 
//		        mm2.addBodyPart(all); 
//		       // mm2.addBodyPart(img2); 
//		        mm2.setSubType("mixed");// 璁剧疆姝ｆ枃涓庨檮浠朵箣闂寸殑鍏崇郴 
//		   
//		        message.setContent(mm2); 
//		        message.saveChanges(); // 淇濆瓨淇敼 
//		        
//		        Transport.send(message);// 鍙戦�閭欢 
//		        System.out.println("閭欢鍙戦�鎴愬姛"); 
//
//		        
//		        
//		        
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//	        // 璁剧疆鏀朵欢浜�
//	      //  InternetAddress to = new InternetAddress("yangfangfang@360kad.com");
//	       // message.setRecipient(RecipientType.TO, to);
//
//	     
//	        
//	}


/** 
 * 上滑 
 *  
 * @param driver 
 * @param during 
 * @param num 
 */  
public static void swipeToUp(AppiumDriver<WebElement> driver,int during, int num) {  
   
        try {
        	 int width = driver.manage().window().getSize().width;  
        	    int height = driver.manage().window().getSize().height;  
        	    for (int i = 0; i < num; i++) {  
        	        driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, during);  
			Thread.sleep(3);
        	    } 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
     
}  
  
/** 
 * 下拉 
 *  
 * @param driver 
 * @param during 
 * @param num 
 */  
public static void swipeToDown(AppiumDriver<WebElement> driver,int during, int num) {  
    int width = driver.manage().window().getSize().width;  
    int height = driver.manage().window().getSize().height;  
    System.out.println(width);  
    System.out.println(height);  
    for (int i = 0; i < num; i++) {  
        driver.swipe(width / 2, height / 4, width / 2, height * 3 / 4, during);  
//        goSleep(3);  
    }  
}  
  
/** 
 * 向左滑动 
 *   
 * @param driver 
 * @param during 
 * @param num 
 */  
public static void swipeToLeft(AppiumDriver<WebElement> driver,int during, int num) {  
   
		try {
			 int width = driver.manage().window().getSize().width;  
			    int height = driver.manage().window().getSize().height;  
			    System.out.println("widthwidthwidthwidthwidthwidth"+width);  
			    System.out.println("heightheightheightheightheight"+height);  
			    for (int i = 0; i < num; i++) {  
//			        driver.swipe(width * 3 / 4, height / 2, width / 4, height / 2, during);  
			        driver.swipe(width * 3 / 4, height / 2, width / 4, height / 2, during);  

			Thread.sleep(3000);
			    }  
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
}  


/**
 * 通过传坐标来执行滑动操作
 * start(startX,startY)
 * end(endX,endY)
 *
 * @param startX 起始X坐标
 * @param startY 起始Y坐标
 * @param endX   终点X坐标
 * @param endY   终点Y坐标
 */
public static void fff(AppiumDriver<WebElement> driver) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 int width = driver.manage().window().getSize().width;  
	    int height = driver.manage().window().getSize().height;  
    Map<Object,Object> params = new HashMap<Object, Object>();
    params.put("duration", 2000);
    params.put("fromX", width * 19 / 20);
    params.put("fromY", height / 2);
    params.put("toX", width / 20);
    params.put("toY", height / 2);
//    params.put("element", swipeView.getId());
    js.executeScript("mobile: dragFromToForDuration", params);
}
  

/**
 * description：定位到元素坐标，然后进行滑动操作
 * id: 要操作的元素     *
 * moveX：从起始x位置需要移动的距离（移动到beginX+moveX的位置）
 * moveY：从起始y位置需要移动的距离（移动到beginY+moveY的位置）
 */
public static void swipeToPosition(AppiumDriver<WebElement> driver){

  
    TouchAction ta = new TouchAction(driver);
    int width = driver.manage().window().getSize().width;  
    int height = driver.manage().window().getSize().height;  
  
    ta.press(width * 19 / 20,height / 2).moveTo(width / 20,height / 2).release().perform();
}


/** 
 * 向右滑动 
 *  
 * @param driver 
 * @param during 
 * @param num 
 */  
public static void swipeToRight(AppiumDriver<WebElement> driver,int during, int num) {  
    int width = driver.manage().window().getSize().width;  
    int height = driver.manage().window().getSize().height;  
    for (int i = 0; i < num; i++) {  
        driver.swipe(width / 4, height / 2, width * 3 / 4, height / 2, during);  
//        goSleep(3);  
    }  
}  

public static void clickScreen(int x, int y, int duration,
AppiumDriver drivers) {
JavascriptExecutor js = (JavascriptExecutor) drivers;
HashMap tapObject = new HashMap();
tapObject.put("x", x);
tapObject.put("y", y);
tapObject.put("duration", duration);
js.executeScript("mobile: tap", tapObject);
}


}
