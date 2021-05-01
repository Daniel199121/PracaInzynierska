package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import pages.MainPage;
import resources.init;


public class CorrectUrl extends init {
	    WebDriver driver;
		MainPage mainpage;

		@Test
		public void testEasy() {
			driver.get(prop.getProperty("url"));
			mainpage=new MainPage(driver);
			Assert.assertTrue(mainpage.getTitle().contains("Wirtualna Polska - Wszystko co"));
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