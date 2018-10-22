package com.amazon.test;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.amazon.dataprovider.ConfigFileReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ScriptFactory {
	
public static WebDriver driver;
 
public static ConfigFileReader configFileReader= new ConfigFileReader();
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	@BeforeSuite
	public void beforesuite(){
		
		extent = new ExtentReports("D:/MyExtentReport.html",true);
		extent.loadConfig(new File("C:/Users/AMOL/Desktop/Downloades/AmazonKindle/AmazonKindle/resources/extent-config.xml") );
	
	}
	
	@AfterSuite
	public void aftersuite(){
		
		extent.flush();
		extent.close();
	}
	
	@BeforeMethod
		public void beforeMethod(Method method){
		test = extent.startTest(this.getClass().getSimpleName()+"::"+ method.getName(), method.getName());
		test.assignAuthor("Amol Bhos");
		test.assignCategory("Amazon Kindle Order Testing");
		//driver = new ChromeDriver();
		test.log(LogStatus.PASS, "Browser Launched Successfully");	
		}
	
		
	public static WebDriver getDriver() {
		return driver;
	}
	
	@Parameters("browser")
	@BeforeClass
	public static void setupDriver(String browser)  {
		
		// If the browser is Chrome, then do this
				 
		  if(browser.equalsIgnoreCase("chrome")) {
			  
			System.setProperty("webdriver.chrome.driver",configFileReader.getChromeDriverPath());			

			driver = new ChromeDriver();		 
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();		
		    driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		 
		  // If browser is IE, then do this	  
		 
		  }else if (browser.equalsIgnoreCase("ie")) { 
		 
			  // Here I am setting up the path for my IEDriver
		 
			  System.setProperty("webdriver.ie.driver",configFileReader.getIEDriverPath());	
			  
			 /* Setting capability for IE*/
			  DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
			  capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			  capability.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);			  
			  capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);		 
			  driver = new InternetExplorerDriver();					 			  
			  driver.manage().deleteAllCookies();
			  driver.manage().window().maximize();		
			  driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		 
		  } 		 

		 driver.get(configFileReader.getApplicationUrl());		 
	
	}
	@AfterClass
	public void closeDriver() {
		// logger.debug("closeDriver - Attempting to close the driver");
		if (driver != null) {
			try {
				driver.close();
				driver.quit();
				} catch (Exception e) {
				// logger.error("closeDriver - Could not close the driver");
			}
		}
	}
	
}

