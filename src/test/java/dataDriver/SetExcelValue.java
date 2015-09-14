package dataDriver;

import java.util.Iterator;
import java.util.Map;

import objectManager.UIMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebElement;

public class SetExcelValue {
    static WebDriver drv= new FirefoxDriver();
    public static void setExcelValue(String fileName,String sheetName){
	ExcelDataProvider edp = new ExcelDataProvider(fileName, sheetName);
	while(edp.hasNext()){
		Map<String, String> obj_value = edp.next();
		//obj_value.keySet() 
		String objName ="test"; 
		String value =String.valueOf(obj_value.get(objName));
	
		WebElement ele = drv.findElement(By.xpath(UIMap.getObject(objName)));
		ele.sendKeys(value);
	}
    }
}
