package com.cdp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseWebDriver {

protected WebDriver driver = null;

private StringBuffer verificationErrors = new StringBuffer();
@Parameters({ "platform", "browser", "version", "url" })
@BeforeTest(alwaysRun = true)
public void setup(String platform, String browser, String version,
String url) throws MalformedURLException, IOException {
DesiredCapabilities caps = null;
// Browsers

if (browser.equalsIgnoreCase("Internet Explorer")) {
System.setProperty("webdriver.ie.driver",
"c:\\test\\IEDriverServer.exe");
caps = DesiredCapabilities.internetExplorer();

// IE安全设置
caps.setCapability(
InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
true);

// browser zoom level must be set to 100%
} else if (browser.equalsIgnoreCase("Firefox")) {
System.setProperty("webdriver.firefox.bin",
"C:\\test\\Firefox4\\firefox.exe");
caps = DesiredCapabilities.firefox();
} else if (browser.equalsIgnoreCase("chrome")) {
System.setProperty("webdriver.chrome.driver",
"c:\\test\\chromedriver.exe");
caps = DesiredCapabilities.chrome();
caps.setCapability(
"chrome.binary",
"C:\\test\\Chrome31\\chrome.exe");

} else if (browser.equalsIgnoreCase("iPad"))
caps = DesiredCapabilities.ipad();
else if (browser.equalsIgnoreCase("Android"))
caps = DesiredCapabilities.android();
 
// Platforms
if (platform.equalsIgnoreCase("Windows"))
caps.setPlatform(org.openqa.selenium.Platform.WINDOWS);
else if (platform.equalsIgnoreCase("MAC"))
caps.setPlatform(org.openqa.selenium.Platform.MAC);
else if (platform.equalsIgnoreCase("Andorid"))
caps.setPlatform(org.openqa.selenium.Platform.ANDROID);

// Version
caps.setVersion(version);
driver = new RemoteWebDriver(new URL(
"http://localhost:4444/node/hub"), caps);
driver.get(url);
//

WebDriverWait wait = new WebDriverWait(driver, 10);
wait.until(new ExpectedCondition<WebElement>() {

public WebElement apply(WebDriver d) {
return d.findElement(By.id("login"));
}
}); 
}
}
