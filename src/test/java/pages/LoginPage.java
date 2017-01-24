package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver){
		this.driver = ldriver;		
	}
	
	@FindBy(id="email") WebElement username;
	@FindBy(name="sign-in-pass") WebElement password;
	@FindBy(xpath="//input[@value='sign in']") WebElement signUpButton;
	By signOutLink = By.xpath("//a[@id='signoutLink']");
	
	public void loginIntoApplication(String UN, String pwd){
		username.sendKeys(UN);
		password.sendKeys(pwd);
		signUpButton.click();
	}
	
	public void verifySignOutLink(){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(signOutLink));
		String text = ele.getText();
		Assert.assertEquals(text, "Sign Out", "sign out link is not present");
	}

}
