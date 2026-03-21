package com.Ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Utility.BrowserUtility;

public class LoginPage extends BrowserUtility {
private static final  By NAME_XPATH_LOCATOR  = By.xpath("//input[@data-qa=\"signup-name\"]");
	private static final By EMAIL_XPATH_LOCATOR = By.xpath("//input[@data-qa=\"signup-email\"]");
	private static final By SIGNUP_XPATH_LOCATOR= By.xpath("//button[@data-qa=\"signup-button\"]");
	 public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	public MyAccountPage  doLoginWith(String name,String emailadress) {
		enterText(NAME_XPATH_LOCATOR,name);
		enterText(EMAIL_XPATH_LOCATOR,emailadress);
		clickOn(SIGNUP_XPATH_LOCATOR);
		MyAccountPage myAccountPage =new MyAccountPage(getDriver()) ;
		
		
		return myAccountPage;
		
	}
	
	
	
	}
	

	
		
	


