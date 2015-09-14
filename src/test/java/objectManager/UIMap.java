package objectManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UIMap {
     public static String getObject(String obj){
    	 Properties prop = new Properties();
    	 try {
    		 InputStream fis = new FileInputStream("F:\\Jordan\\git reposi\\SeleniumTest-master\\cdp\\src\\test\\java\\META-INF\\prop.properties");
			prop.load(fis);
			fis.close();
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}
    	 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return prop.getProperty(obj);
     }
}
