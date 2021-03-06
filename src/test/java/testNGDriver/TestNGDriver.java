package testNGDriver;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.uncommons.reportng.HTMLReporter;



public class TestNGDriver {

	public static void main(String[] args) throws IOException {
		testNGrun();
	}
	
	public static void testNGrun(){
		String projectPath = System.getProperty("user.dir");
		String caseLogPath=projectPath+File.separator+"src/test/java/report"+File.separator+"caseLog.txt";
		TestNG  testng = new TestNG();
		testng.setUseDefaultListeners(false);
		
	    HTMLReporter rp =new HTMLReporter();
	    testng.addListener(rp);
	    System.setProperty("org.uncommons.reportng.title", "cloud test report");
		List<String> suites= new ArrayList<String>();
		//System.out.println(System.getProperty("user.dir"));
		suites.add(projectPath+File.separator+"TestNG.xml");
		testng.setTestSuites(suites);
		File file = new File(caseLogPath);
		if(!file.exists()){
			file.mkdirs();
		}
		testng.setOutputDirectory(file.getAbsolutePath());
		testng.run();
	}

}
