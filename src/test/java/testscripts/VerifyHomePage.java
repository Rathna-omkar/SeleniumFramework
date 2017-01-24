package testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;

public class VerifyHomePage {
	
	WebDriver driver;
	
	@BeforeMethod()
	public void setUp(){
		driver = BrowserFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	}
	
	@Test
	public void verifyPage()
	{
		HomePage home = PageFactory.initElements(driver, HomePage.class); // When we say HomePage.class it will return the object of HomePage class
		String title = home.getHomePageTitle();
		System.out.println("Home Page title is : " + title);
		Assert.assertTrue(title.contains("Stage, Bealls, Peebles, Palais Royal & Goody's Department Stores"));
		
	}
	
	@AfterMethod()
	public void tearDown(){
		BrowserFactory.closeBrowser(driver);	
	}

}
