package com.cdp.common;

import objectManager.UIMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {
  public static void login(String com,String user,String psw){
	  // System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");  
  	  WebDriver driver = new FirefoxDriver();
      driver.get(UIMap.getObject("url"));
      driver.manage().window().maximize();
      WebElement ele = driver.findElement(By.xpath(UIMap.getObject("company_xpath")));
      ele.sendKeys(com);
      WebElement ele2 = driver.findElement(By.xpath(UIMap.getObject("user_xpath")));
      ele2.sendKeys(user);
      WebElement ele3 = driver.findElement(By.xpath(UIMap.getObject("password_xpath")));
      ele3.sendKeys(psw);
      WebElement ele4 = driver.findElement(By.xpath(UIMap.getObject("login_xpath")));
      ele4.click();
    
  }
}
