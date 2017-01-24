package testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;

public class VerifyLoginPage {
	//Logs will help us in identifying what the test script does
	WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		driver = BrowserFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void verifyLogin(){
		HomePage home = PageFactory.initElements(driver, HomePage.class); // When we say HomePage.class it will return the object of HomePage class
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		home.clickOnSignInLink();
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.loginIntoApplication(DataProviderFactory.getExcel().getData("Login", 0, 0), DataProviderFactory.getExcel().getData("Login", 0, 1));
		login.verifySignOutLink();
		
	}
	
	@AfterMethod()
	public void tearDown(){
		BrowserFactory.closeBrowser(driver);
	}

}
