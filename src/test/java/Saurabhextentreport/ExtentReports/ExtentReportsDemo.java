package Saurabhextentreport.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {
	
	ExtentReports extent;

	
	@BeforeTest
	public void extentReportConfig() {
		
		String path = System.getProperty("user.dir") + "//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Saurabh Automation Report");
		reporter.config().setDocumentTitle("Extent Reports");
		
		 extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Saurabh Choudhary");
		
		
	}
	

	
	@Test
	public void initialDemo() {
		
		ExtentTest test = extent.createTest("Initial Demo Test");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		
		driver.close();
		//test.fail("Result Do Not Match");  // Here intentionally we are failing this case which will not be the case in real 
		extent.flush();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

