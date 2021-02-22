package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
 WebDriver driver;
 public Properties  prop;
	public WebDriver intializeBrowser() throws IOException{
	 prop=new Properties();
		String propPath=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
		FileInputStream fis=new FileInputStream(propPath);
		prop.load(fis);
		
		String browserName=prop.getProperty("browser");
	
		if(browserName.equalsIgnoreCase("chrome")) {
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32 (4)\\chromedriver.exe");
 driver=new ChromeDriver();
	
		}else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.firefox.driver", "C:\\geckodriver-v0.27.0-win64\\geckodriver.exe");
		 driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("internetExplorer")) {
			System.setProperty("webdriver.internetexplorer.driver", "C:\\IEDriverServer_x64_3.141.59\\IEDriverServer.exe");
		 driver=new InternetExplorerDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
public void takeScreenshot(String testName,WebDriver driver) throws IOException {
		
		File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFilePath = System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
		FileUtils.copyFile(SourceFile,new File(destinationFilePath));
	
	}
 
 
}
