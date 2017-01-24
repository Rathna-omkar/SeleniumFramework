package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver driver;

	//create constructor
	public HomePage(WebDriver ldriver){
		this.driver = ldriver;
	}
	
	@FindBy(xpath="//a[text()='Sign In']") WebElement signInLink;
	@FindBy(xpath="//a[text()='My Account']") WebElement myAccountLink;
	@FindBy(xpath="//a[text()='Rewards']") WebElement rewardsLink;
	@FindBy(xpath="//a[text()='Stores']") WebElement storesLink;
	@FindBy(xpath="//a[text()='Track Order']") WebElement trackOrderLink;
	@FindBy(xpath="//a[text()='Wishlist']") WebElement wishlistLink;
	
	public void clickOnSignInLink(){
		signInLink.click();
	}
	
	public void clickOnMyAccountLink(){
		myAccountLink.click();
	}
	
	public void clickOnRewardsLink(){
		rewardsLink.click();
	}
	
	public void clickOnStoresLink(){
		storesLink.click();
	}
	
	public void clickOnTrackOrderLink(){
		trackOrderLink.click();
	}
	
	public void clickOnWishlistLink(){
		wishlistLink.click();
	}
	
	public String getHomePageTitle(){
		return driver.getTitle();
	}

}
