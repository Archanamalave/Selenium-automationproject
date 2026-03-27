package com.Ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.Ui.pages.HomePage;
import com.Utility.BrowserUtility;
import com.Utility.LambdaTestUtility;
import com.Utility.LoggerUtility;
import com.beust.jcommander.Parameter;
import com.constants.Browser;

public class TestBase {
	
	protected HomePage homepage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	protected boolean  isLambdaTest ;
	
	
	@Parameters({"browser","isLambdaTest","isHeadless"})
	
	@BeforeMethod (description = "Load the homepage ")

	public void setup(
			@Optional("chrome")String browser,
			@Optional("false")boolean isLambdaTest,
			@Optional ("ture")boolean isHeadless,ITestResult result) {
		this.isLambdaTest =isLambdaTest;
		WebDriver lambdaDriver;
		
		if(isLambdaTest) {
			
			lambdaDriver=LambdaTestUtility.intializeLambdaTestSession("chrome", result.getMethod().getMethodName());
			homepage = new HomePage(lambdaDriver); 
			
			
		 
		}else {
			//running the test on local machine
			logger.info("load the homepage od website");
			homepage= new HomePage(Browser.valueOf(browser.toUpperCase()),isHeadless);
		}
	}
	public BrowserUtility getInstance() {
		return homepage;
	}
	
	@AfterMethod (description="Tear Down th browser")
	public void tearDown() {
		if(isLambdaTest) {
			LambdaTestUtility.quiteSession();
	}else {
		homepage.quite();
		}
	}
}
