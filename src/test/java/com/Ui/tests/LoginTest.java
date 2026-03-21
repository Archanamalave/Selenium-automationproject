package com.Ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Utility.BrowserUtility;

import org.openqa.selenium.WebElement;


public class LoginTest {

	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();//launch browser
		BrowserUtility browserutility = new BrowserUtility (driver);// create object
		browserutility.goToWebsite("https://automationexercise.com/");
		browserutility.maximizeWindow();
		
		
		By SingInxpathLocator= By.xpath("//a[contains(text(),' Signup / Login')]");
		browserutility.clickOn(SingInxpathLocator);
		
		By GetTextxpathLocator= By.xpath("//h2[contains(text(),'New User Signup!')]");
		
		//System.out.println("Text"+GetTextxpathLocator);
		
		By NamexpathLocator= By.xpath("//input[@data-qa=\"signup-name\"]");
		browserutility.enterData(NamexpathLocator, "aaa");
		
		
		By EmailxpathLocator= By.xpath("//input[@data-qa=\"signup-email\"]");
		browserutility.enterData(EmailxpathLocator, "");
		 
		By SingUPxpathLocator= By.xpath("//button[@data-qa=\"signup-button\"]");
		browserutility.clickOn(SingUPxpathLocator);
		
		


	}

}
