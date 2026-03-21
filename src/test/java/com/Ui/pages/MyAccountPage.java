package com.Ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Utility.BrowserUtility;

public class MyAccountPage extends BrowserUtility {
	private static final By ACCOUNT_INFO_XPATH_LOCATOR=By.xpath("//b[text()='Enter Account Information']") ;
	

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public String getUserName() {
		return getvisibleText(ACCOUNT_INFO_XPATH_LOCATOR);
	}
	

	

}
