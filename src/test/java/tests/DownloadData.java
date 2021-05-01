package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.EmailLoginPage;
import pages.MainPage;
import pages.MoneyPage;
import resources.init;

public class DownloadData extends init{
	    private WebDriver driver;		
	    private String URL = "http://www.wp.pl";
	    int before;
	    int after;
	    MainPage mainpage;
	    EmailLoginPage emailpage;
	    MoneyPage moneypage;

		@Test				
		public void testEasy() throws FileNotFoundException {
			driver.get(prop.getProperty("moneyUrl"));
			moneypage = new MoneyPage(driver);
			moneypage.clickZgoda();
			String frank = moneypage.getFRANK();
			String funt = moneypage.getFUNT();
			String dolar = moneypage.getDOLAR();
			String euro = moneypage.getEURO();
			frank = frank.format("%.6s\n", moneypage.getFRANK());
			funt = funt.format("%.6s\n", moneypage.getFUNT());
			dolar = dolar.format("%.6s\n", moneypage.getDOLAR());
			euro = euro.format("%.6s\n", moneypage.getEURO());
			Assert.assertTrue(Float.parseFloat(frank) > 1.0);
			Assert.assertTrue(Float.parseFloat(funt) > 1.0);
			Assert.assertTrue(Float.parseFloat(dolar) > 1.0);
			Assert.assertTrue(Float.parseFloat(euro) > 1.0);
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