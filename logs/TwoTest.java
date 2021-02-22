package Rpack;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class TwoTest extends Base {
	public WebDriver driver;
	@Test
	public void testTwo() throws IOException, InterruptedException  {
		System.out.println("testTwo is executed");
		
 driver=intializeBrowser();
		driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
	Thread.sleep(2000);
	driver.close();
	}

}
