package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	public static String captureScreenshot(WebDriver driver, String screenshotname){
		TakesScreenshot t = (TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		String path = "F:\\Testing\\AllEclipseProjects\\December\\com.learnAutomation.hybrid\\Screenshots\\"+screenshotname+ ".jpg";
		try {
			FileUtils.copyFile(src, new File(path));
		} catch (IOException e) {
			System.out.println("Unable to take screenshot" + e.getMessage());
			e.printStackTrace();
		}
		
		return path;
	}
	

		
	
}
