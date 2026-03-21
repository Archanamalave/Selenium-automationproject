package com.Ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import com.Utility.BrowserUtility;
import com.Utility.JSONUtility;
import com.Utility.LoggerUtility;
import com.Utility.propertiesUtil;

import static com.Utility.propertiesUtil.*;
import com.constants.Browser;
import com.constants.ENV;

import static com.constants.ENV.*;

public class HomePage extends BrowserUtility {
	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final By Sing_In_xpath_Locator= By.xpath("//a[contains(text(),' Signup / Login')]");
	
	public HomePage(Browser browsername,boolean isHeadless) {
		super(browsername,isHeadless);// to call parent class to child class constructor
		goToWebsite(readproperty(QA, "URL"));
		//goToWebsite(JSONUtility.readJson(QA).getUrl());
		
	}

	
public LoginPage goToLoginpage() {//-----pagefunctions(in page fn we cannot return void )
	logger.info("Trying to perform signin");
	clickOn(Sing_In_xpath_Locator);
	LoginPage Loginpage = new LoginPage(getDriver());
	return Loginpage;
}


}
