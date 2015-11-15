package com.cdp;
import java.net.MalformedURLException;

import java.net.URL;
import objectManager.UIMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;

import com.cdp.common.Login;
//import org.testng.annotations.*;
public class Test {

	//WebDriver driver =Login.loadDriver();
	public static WebDriver driver;

	
    public static void main(String[] args) {

    }
      
    @org.testng.annotations.BeforeTest
    @Parameters({"seleniumHost","bs"})
    public WebDriver setUp(String seleniumHost,String bs) throws MalformedURLException{
    if(bs.equalsIgnoreCase("chrome")){
        	DesiredCapabilities dc = DesiredCapabilities.chrome();
       WebDriver driver = new RemoteWebDriver(new URL(seleniumHost), dc);
       return driver;
    }
    
    if(bs.equalsIgnoreCase("firefox")){
    	DesiredCapabilities dc = DesiredCapabilities.firefox();
   WebDriver driver = new RemoteWebDriver(new URL(seleniumHost), dc);
       return driver;
}
	return new FirefoxDriver();
        }
    
	@org.testng.annotations.Test(description="login")	
	@Parameters({"seleniumHost","bs"})
    public void login(String seleniumHost,String bs) throws MalformedURLException{
		WebDriver driver = setUp(seleniumHost,bs);
		//driver= new FirefoxDriver();
		  Login.login(driver,"url","ralphlauren", "rl", "Init1234");
    	 
    }
        
	   @org.testng.annotations.AfterTest
	    @Parameters({"seleniumHost","bs"})
	    public void logOut(String seleniumHost,String bs) throws MalformedURLException, InterruptedException{
		   WebDriver driver = setUp(seleniumHost,bs);
		  
		   
	    	WebElement ele = driver.findElement(By.xpath(UIMap.getObject("logOut_xpath")));
	    
	       
	    	ele.click();
	    	WebElement ele2 = driver.findElement(By.xpath(UIMap.getObject("OK_xpath")));
	    	ele2.click();
	    	
	    }
	   

    
    
    
//    @BeforeTest
//    @Parameters({"seleniumHost", "seleniumPort", "bs"}) 
//    public void sitenav(String seleniumHost,String seleniumPort,String bs) throws MalformedURLException{
//    	if(bs=="*firefox"){	 
//    	DesiredCapabilities dc =DesiredCapabilities.firefox();
//    	WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
//    	
//    	
//		//dc.setCapability(FirefoxDriver.PROFILE, profile);
//		//dc.setBrowserName(browser);
////    	try{
////    		synchronized (RemoteWebDriver.class){
////    		driver = new RemoteWebDriver(new URL(nodeUrl), dc);
////    		}
////    			}catch(org.openqa.selenium.remote.UnreachableBrowserException e){
////    			System.out.println(nodeUrl+ "无法连接, 切换到备份节点");
////    			driver = null; this.nodeUrl = SystemConstant.LangCode.EN.getNodeURL();
////    			init();
////    			}catch(org.openqa.selenium.WebDriverException e){
////    			System.out.println(nodeUrl+ "异常, 切换到备份节点");
////    			driver = null;
////    			this.nodeUrl = SystemConstant.LangCode.EN.getNodeURL();
////    			init();
////    			}
//    }
//    	else if(bs=="*iexplore"){
//   		 
//        	DesiredCapabilities dc =DesiredCapabilities.internetExplorer();
//    		//dc.setCapability(FirefoxDriver.PROFILE, profile);
//    		//dc.setBrowserName(browser);
//        	WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
//        }
//    	
//    	
//    }
  
  
//    @org.testng.annotations.Test(description="enter time menu")
//   public void enterTimeMenu() throws MalformedURLException{
//    	
//    	
//    	WebDriver driver = new FirefoxDriver();
//    	
//    	WebElement ele4 = driver.findElement(By.xpath(UIMap.getObject("Expand_xpath")));
//	      ele4.click();
//	      WebElement ele = driver.findElement(By.xpath(UIMap.getObject("Time_xpath")));
//	      ele.click();
//	      WebElement ele2 = driver.findElement(By.xpath(UIMap.getObject("Schdule_xpath")));
//	      ele2.click();
//	      WebElement ele3 = driver.findElement(By.xpath(UIMap.getObject("Schedule_Assign_xpath"))); 
//	      ele3.click();
//   }
//   
//    @org.testng.annotations.Test(description="enter Salary menu")
//   public void enterSalaryMenu(WebDriver driver){
//    	 driver = new InternetExplorerDriver();
//	    WebElement ele = driver.findElement(By.xpath(UIMap.getObject("Salary_xpath")));
//	   ele.click();
//   }
 
}
