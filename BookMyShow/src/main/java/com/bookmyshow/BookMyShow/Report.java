package com.bookmyshow.BookMyShow;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
public class Report {

	static Properties p;
	ExtentReports reports;
	ExtentTest testInfo;
	WebDriver driver;
	public void screenShot(String Imagename) throws IOException {
	TakesScreenshot ts=(TakesScreenshot) driver;
	File srcFile=ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcFile, new File("E:\\Bookmyshow\\BookMyShow\\Report " + Imagename+".jpeg"));
			
	}
	
	@BeforeTest
	public void setUp()  throws Exception{
	
		ExtentHtmlReporter htmlreporter=new ExtentHtmlReporter(new File("E:\\Bookmyshow\\BookMyShow\\Report\\BMSAUTOMATIONREPORT.html"));
		htmlreporter.loadXMLConfig("E:\\Bookmyshow\\BookMyShow\\ExtentConfig.xml");
		
	    reports=new ExtentReports();
		reports.setSystemInfo("Environment", "Test");
		reports.attachReporter(htmlreporter);
		
		FileReader reader=new FileReader("E:\\Bookmyshow\\BookMyShow\\File\\datasheet.properties");  
		p=new Properties(); 
		p.load(reader);
			
			
		
	}
	


	@BeforeMethod
	public void register(Method method) {
		String testName=method.getName();
        testInfo=reports.createTest(testName);
	}
	
	@AfterMethod
	public void status(ITestResult result) throws IOException {
		if (result.getStatus()==ITestResult.SUCCESS)
		{
			testInfo.log(Status.PASS, "Test Case "+result.getName()+" got passed");
			
		}
		else if (result.getStatus()==ITestResult.FAILURE)
		{
			testInfo.log(Status.FAIL, "Test Case "+ result.getName() +" got failed");
			testInfo.log(Status.FAIL, "Test failure :"+ result.getThrowable());
			screenShot(result.getName());
		}
		
		else if (result.getStatus()==ITestResult.SKIP)
		{
			testInfo.log(Status.SKIP, "Test Case "+result.getName()+" got skipped");
			
		}
	}
	
	
	@AfterTest
	public void tearDown() {
		reports.flush();
	}
	
}
