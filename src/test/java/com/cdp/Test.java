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

public class Test {

    public static void main(String[] args) {
        
     //Login.login("ralphlauren", "rl", "Init1234");
     String fileName ="F:\\Jordan\\git reposi\\SeleniumTest-master\\cdp\\src\\test\\java\\resource\\CloudData.xls";
     String sheetName="AssignShift";
    // ExcelDataProvider edp =  new ExcelDataProvider(fileName,sheetName);
     SetExcelValue.setExcelValue(fileName,sheetName);
       

    }

}
