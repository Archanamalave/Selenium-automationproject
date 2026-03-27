package com.Ui.tests;
import static  com.constants.Browser.*;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Ui.pages.HomePage;
import com.Ui.pages.LoginPage;
import com.Ui.pojo.User;
import com.Utility.BrowserUtility;
import com.Utility.LoggerUtility;



@Listeners({com.Ui.listener.TestListner.class})
public class LoginTest3 extends TestBase {
	
	@Test(description = "Verifys login test with valid credentials ",groups= {"e2e","sanity"},dataProviderClass = com.Ui.dataproviders.LoginDataprovider.class,dataProvider="LoginTestDataProvider")
		public void  loginTest(User user) {
		
		assertEquals(homepage.goToLoginpage().doLoginWith(user.getName(),user.getEmailAdress()).getUserName(),"ENTER ACCOUNT INFORMATION");
		
	}
	/*@Test(description = "Verifys login test with valid credentials ",groups= {"e2e","sanity"},dataProviderClass = com.Ui.dataproviders.LoginDataprovider.class,dataProvider="LoginTestCSVDataProvider")
	public void  loginCSVTest(User user) {
		assertEquals(homepage.goToLoginpage().doLoginWith(user.getName(),user.getEmailAdress()).getUserName(),"ENTER ACCOUNT INFORMATION");
	
}
	@Test(description = "Verifys login test with valid credentials ",groups= {"e2e","sanity"},dataProviderClass = com.Ui.dataproviders.LoginDataprovider.class,dataProvider="LoginTestExcelDataProvider")
	public void  loginExcelTest(User user) {
		
		assertEquals(homepage.goToLoginpage().doLoginWith(user.getName(),user.getEmailAdress()).getUserName(),"ENTER ACCOUNT INFORMATION");
		
	}
	@Test(description = "Verifys login test with valid credentials ",groups= {"e2e","sanity"},dataProviderClass = com.Ui.dataproviders.LoginDataprovider.class,dataProvider="LoginTestDataProvider",
			retryAnalyzer=com.Ui.listener.MyRetryAnalyzer.class)
	public void  loginExcelTest1(User user) {
		
	
	assertEquals(homepage.goToLoginpage().doLoginWith(user.getName(),user.getEmailAdress()).getUserName(),"ENTER ACCOUNT INFORMATION");
	
	}*/

}
