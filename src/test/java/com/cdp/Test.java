package com.cdp;
import java.util.Map;

import objectManager.UIMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.*;

import com.cdp.common.Login;

import dataDriver.ExcelDataProvider;
import dataDriver.SetExcelValue;
//import org.testng.annotations.*;
public class Test {

	WebDriver driver =Login.loadDriver();
	
    public static void main(String[] args) {
//     String fileName ="D:\\Javaspace\\SeleniumJordan\\src\\test\\java\\resource\\CloudData.xls";
//     String sheetName="AssignShift";
//     ExcelDataProvider edp =  new ExcelDataProvider(fileName,sheetName);
//     SetExcelValue.setExcelValue(fileName,sheetName);
    
    	String	projectPath =System.getProperty("user.dir");
    	String pP = projectPath.replaceAll("", "\\");
System.out.println(pP);
    }
    @org.testng.annotations.BeforeSuite
   public void login(){
	   Login.login(driver,"url","ralphlauren", "rl", "Init1234");
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
