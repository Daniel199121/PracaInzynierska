package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.EmailLoginPage;
import pages.EmailMainPage;
import pages.MainPage;
import resources.init;

public class Login extends init{
	    public WebDriver driver;
	    MainPage mainpage;
	    EmailLoginPage emailpage;
	    
		@Test				
		public void testEasy() throws FileNotFoundException {

			WebDriverWait wait = new WebDriverWait(driver, 10);

			driver.get(prop.getProperty("url"));
			mainpage=new MainPage(driver);
			WebElement email = mainpage.getEmail();
			mainpage.clickZgoda();
			wait.until(ExpectedConditions.elementToBeClickable(email));
			emailpage = mainpage.getLogin();
			WebElement username = emailpage.getUserName();

			wait.until(ExpectedConditions.elementToBeClickable(username));
			EmailMainPage emailmainpage = emailpage.loginToMail("tester_it", "Testowanie4u!");
			Assert.assertTrue(emailmainpage.isDisplayed());
		}
		@BeforeTest
		public void initialize() throws IOException {
			driver = initializeDriver();
		}
		@AfterTest
		public void afterTest() {
			driver.quit();
		}		
}	