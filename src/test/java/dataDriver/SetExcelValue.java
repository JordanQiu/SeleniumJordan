package dataDriver;

import java.util.Iterator;
import java.util.Map;

import objectManager.UIMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebElement;
//缺点：只支持了Firefox，只考虑了输入的情况，还有一种例外，用来比对的，如set工作日历的值，不能直接输入，而需另外考虑
public class SetExcelValue {
    static WebDriver drv= new FirefoxDriver();
    public static void setExcelValue(String excelName,String sheetName,String objName){
	ExcelDataProvider edp = new ExcelDataProvider(excelName,sheetName);
	while(edp.hasNext()){
		Map<String, String> obj_value = edp.next();
		//obj_value.keySet()  
		String value =String.valueOf(obj_value.get(objName));
	//objName是一个key或是xml中的自定义标签名
		WebElement ele = drv.findElement(By.xpath(UIMap.getObject(objName)));
		ele.sendKeys(value);
	}
    }
}
