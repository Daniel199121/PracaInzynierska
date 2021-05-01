package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {		
	    
	WebDriver driver;

	@FindBy(xpath="//*[@id=\"site-header\"]/div[2]/div[4]/a[1]")
	WebElement email;

	@FindBy(xpath="/html/body/div[2]/div/div[2]/div[3]/div/button[2]")
	WebElement zgoda;

	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmail(){
		return email;
	}

	public EmailLoginPage getLogin()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", email);
		EmailLoginPage lp=new EmailLoginPage(driver);
		return lp;
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void clickZgoda() {
		zgoda.click();
	}
}