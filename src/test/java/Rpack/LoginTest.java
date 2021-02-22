package Rpack;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	
	public WebDriver driver;
	Logger log;
	@Test
	public void login() throws IOException {

//Logger log = LogManager.getLogger(Demo.class.getName());
	LandingPage lp=new LandingPage(driver);
	lp.myAccountDropDown().click();
	lp.loginOption().click();
	LoginPage loginpage=new LoginPage(driver);
	loginpage.emailField().sendKeys(prop.getProperty("email"));
	log.debug("email id  is eneterd");
	loginpage.passwordField().sendKeys(prop.getProperty("password"));
	log.debug("password is eneterd");
	loginpage.login().click();
	log.debug("clicked on login button");
	
	AccountPage ap=new AccountPage(driver);
	Assert.assertTrue(ap.accounteditAcountInformation().isDisplayed());
		
		
	}
	@BeforeMethod
	public void openApplicatio() throws IOException {
		 log = LogManager.getLogger(LoginTest.class.getName());
		driver=intializeBrowser();
		log.debug("browser is launched");
		driver.get(prop.getProperty("url"));
		log.debug("naviagtion to url");
	}
	@AfterMethod
	public void browserClose() {
		driver.close();
		log.debug("browser is close");
	}
	

}
	
