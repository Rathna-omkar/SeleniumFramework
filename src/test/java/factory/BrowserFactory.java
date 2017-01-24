package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	static WebDriver driver;
	
	public static WebDriver getBrowser(String browserName){
		
		if(browserName.equalsIgnoreCase("firefox")){
			//System.setProperty("webdriver.gecko.driver", DataProviderFactory.getConfig().getGeckoDriverPath());
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromeDriverPath());
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", DataProviderFactory.getConfig().getIEDriverPath());
			driver = new InternetExplorerDriver();
		}else if(browserName.equals("edge")){
			System.setProperty("webdriver.edge.driver", DataProviderFactory.getConfig().getEdgeDriverPath());
			driver = new EdgeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	
	public static void closeBrowser(WebDriver driver){
		driver.quit();
	}

}
