package Rpack;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import resources.Base;

public class FourTest extends Base {
	public WebDriver driver;
	@Test
	public void testFour() throws IOException, InterruptedException {
		System.out.println("testFour is executed");
	 driver=intializeBrowser();
		driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
		Assert.assertTrue(false);
		Thread.sleep(2000);
		driver.close();
	}

}
