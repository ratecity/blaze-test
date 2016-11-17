package com.ratecity.homeloan.automationFramework.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseClass {
	public static WebDriver driver;
	public static RespositoryParser parser;
	public  static ExtentReports report;
	public  static ExtentTest logger;
	private String timeStamp=null;
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static RespositoryParser getParser() {
		return parser;
	}

	public static ExtentReports getReport() {
		return report;
	}

	public static void setReport(ExtentReports report) {
		BaseClass.report = report;
	}

	public static void setLogger(ExtentTest logger) {
		BaseClass.logger = logger;
	}

	public static ExtentTest getLogger() {
		return logger;
	}

	public static void setParser(RespositoryParser parser) {
		BaseClass.parser = parser;
	}

	public static void setDriver(WebDriver driver) {
		BaseClass.driver = driver;
	}
	
	@BeforeSuite
	public void testReport(){  
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		File file = new File(System.getProperty("user.dir")+File.separator+"Reports");
		if (!file.exists()) {
            if (file.mkdir()) {
            	report=new ExtentReports(System.getProperty("user.dir")+File.separator+"Reports"+File.separator+"AutomationReport : "+timeStamp+".html");
            } else {
               BaseClass.logger.log(LogStatus.ERROR, "INTO Method Test Report ==> Failed to create directory in specified position");
            }
		}else
		report=new ExtentReports(System.getProperty("user.dir")+File.separator+"Reports"+File.separator+"AutomationReport : "+timeStamp+".html");
		
	}
	
	
	@AfterSuite	
	public void testtearDown()
	{
		report.endTest(logger);
		report.flush();
	
		
	   
	   // getDriver().get(System.getProperty("user.dir")+File.separator+"Reports"+File.separator+"AutomationReport : "+timeStamp+".html");
		
	}

	@BeforeMethod
	  public void fn_Launchbrowser() throws IOException{
		 System.setProperty(Utility.fn_ReaddataFronPropFile("chromeDriver"), Utility.fn_ReaddataFronPropFile("chromeDriverpath"));
		  driver  = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Integer.parseInt(Utility.fn_ReaddataFronPropFile("implicit_wait")), TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.get(Utility.fn_ReaddataFronPropFile("staging_url"));
		  

	  }

	@AfterMethod
	  public void fn_closebrowser(ITestResult result){
		  if(result.getStatus()==ITestResult.FAILURE)
		  {
			String screenshot_path = Utility.CaptureScreen(BaseClass.getDriver(), result.getName());
			String image  = logger.addScreenCapture(screenshot_path);
			logger.log(LogStatus.FAIL,"Snapshot below: " ,image);
		    driver.quit();
		  }
		  else{
			  driver.quit();
		  }
	  
	}
	
}
