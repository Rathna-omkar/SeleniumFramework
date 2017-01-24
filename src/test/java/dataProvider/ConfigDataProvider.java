package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider()
	{
		File src=  new File("F:\\Testing\\AllEclipseProjects\\December\\com.learnAutomation.hybrid\\Configuration\\config.properties");
	try 
	{
		FileInputStream fis = new FileInputStream(src);  //We use Properties class from java.util package which is used to work with Properties file
		pro = new Properties();
		pro.load(fis);
	} catch (IOException e) {
		System.out.println("Exception is " + e.getMessage());	
	}
	}
	
	public String getApplicationUrl(){
		String url = pro.getProperty("url");
		return url;
	}
	
	public String getChromeDriverPath(){
		return pro.getProperty("chromePath");
	}
	
	public String getGeckoDriverPath(){
		return pro.getProperty("geckoPath");
	}
	
	public String getIEDriverPath(){
		return pro.getProperty("IEPath");
	}
	
	public String getEdgeDriverPath(){
		return pro.getProperty("edgePath");
	}
	
	
	

}
