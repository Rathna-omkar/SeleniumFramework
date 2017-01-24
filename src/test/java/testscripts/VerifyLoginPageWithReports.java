package testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;

public class VerifyLoginPageWithReports {
WebDriver driver;
ExtentReports report;
ExtentTest logger;


	
	@BeforeMethod
	public void setUp()
	{
		report = new ExtentReports("./Reports/SanityReport.html", true);
		logger = report.startTest("Verify Login Page");
		
		driver = BrowserFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.log(LogStatus.INFO, "Application is up and running");
	}
	
	@Test
	public void verifyLogin(){
		HomePage home = PageFactory.initElements(driver, HomePage.class); // When we say HomePage.class it will return the object of HomePage class
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.log(LogStatus.PASS, "Home page loaded succesfully");
		
		home.clickOnSignInLink();
		logger.log(LogStatus.INFO, "Clicked on SignIn Link");
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.loginIntoApplication(DataProviderFactory.getExcel().getData("Login", 0, 0), DataProviderFactory.getExcel().getData("Login", 0, 1));
		logger.log(LogStatus.INFO, "Logged in successfully");
		login.verifySignOutLink();
		logger.log(LogStatus.PASS, "Signout link verified");
		
	}
	
	@AfterMethod
	public void tearDown(){
		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}

}
