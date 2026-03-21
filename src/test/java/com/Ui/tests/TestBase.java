package com.Ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;

import com.Ui.pages.HomePage;
import com.Utility.BrowserUtility;
import com.Utility.LoggerUtility;

public class TestBase {
	
	protected HomePage homepage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	@BeforeMethod (description = "Load the homepage ")

	public void setup() {
		 homepage= new HomePage(CHROME,true);

	}
	public BrowserUtility getInstance() {
		return homepage;
	}
}
