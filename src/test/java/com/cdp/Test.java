package com.cdp;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import objectManager.UIMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.cdp.common.Login;

import dataDriver.ExcelDataProvider;
import dataDriver.SetExcelValue;
//import org.testng.annotations.*;
public class Test {

	WebDriver driver =Login.loadDriver();
	
    public static void main(String[] args) {
    // String fileName ="D:\\Javaspace\\SeleniumJordan\\src\\test\\java\\resource\\CloudData.xls";
    // String sheetName="AssignShift";
    // ExcelDataProvider edp =  new ExcelDataProvider(fileName,sheetName);
    // SetExcelValue.setExcelValue(fileName,sheetName);
    }
    @org.testng.annotations.BeforeSuite
    public void login(){
 	   Login.login(driver,"url","ralphlauren", "rl", "Init1234");
    }
    
    
    @BeforeTest
    @Parameters({"seleniumHost", "seleniumPort", "bs","nodeUrl"}) 
    public void sitenav(String seleniumHost,String seleniumPort,String bs,String nodeUrl) throws MalformedURLException{
    	if(bs=="*firefox"){	 
    	DesiredCapabilities dc =DesiredCapabilities.firefox();
    	driver = new RemoteWebDriver(new URL(nodeUrl), dc);
		//dc.setCapability(FirefoxDriver.PROFILE, profile);
		//dc.setBrowserName(browser);
//    	try{
//    		synchronized (RemoteWebDriver.class){
//    		driver = new RemoteWebDriver(new URL(nodeUrl), dc);
//    		}
//    			}catch(org.openqa.selenium.remote.UnreachableBrowserException e){
//    			System.out.println(nodeUrl+ "无法连接, 切换到备份节点");
//    			driver = null; this.nodeUrl = SystemConstant.LangCode.EN.getNodeURL();
//    			init();
//    			}catch(org.openqa.selenium.WebDriverException e){
//    			System.out.println(nodeUrl+ "异常, 切换到备份节点");
//    			driver = null;
//    			this.nodeUrl = SystemConstant.LangCode.EN.getNodeURL();
//    			init();
//    			}
    }
    	else if(bs=="*iexplore"){
   		 
        	DesiredCapabilities dc =DesiredCapabilities.internetExplorer();
    		//dc.setCapability(FirefoxDriver.PROFILE, profile);
    		//dc.setBrowserName(browser);
        	driver = new RemoteWebDriver(new URL(nodeUrl), dc);
        }
    	
    	
    }
  
  
    @org.testng.annotations.Test(description="enter time menu")
   public void enterTimeMenu(){
    	  
	      WebElement ele = driver.findElement(By.xpath(UIMap.getObject("Time_xpath")));
	      ele.click();
	      WebElement ele2 = driver.findElement(By.xpath(UIMap.getObject("Schdule_xpath")));
	      ele2.click();
	      WebElement ele3 = driver.findElement(By.xpath(UIMap.getObject("Schedule_Assign_xpath"))); 
	      ele3.click();
   }
   
    @org.testng.annotations.Test(description="enter Salary menu")
   public void enterSalaryMenu(){
	   WebElement ele = driver.findElement(By.xpath(UIMap.getObject("Salary_xpath")));
	   ele.click();
   }
    @org.testng.annotations.AfterSuite(alwaysRun=true)
    public void logOut(){
    	WebElement ele = driver.findElement(By.xpath(UIMap.getObject("logOut_xpath")));
    	ele.click();
    	WebElement ele2 = driver.findElement(By.xpath(UIMap.getObject("OK_xpath")));
    	ele2.click();
    	
    }
   
}
