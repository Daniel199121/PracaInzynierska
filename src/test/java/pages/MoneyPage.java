package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoneyPage {		
	    
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"app\"]/div/div[8]/div/div/div[1]/div/div/div[1]/aside/span/div/div/div[2]/div[2]/div[2]/span/div[2]/div/a/div/div[2]")
	WebElement EUR;

	@FindBy(xpath="//*[@id=\"app\"]/div/div[8]/div/div/div[1]/div/div/div[1]/aside/span/div/div/div[2]/div[2]/div[2]/span/div[3]/div/a/div/div[2]")
	WebElement FRANK;	
	
	@FindBy(xpath="//*[@id=\"app\"]/div/div[8]/div/div/div[1]/div/div/div[1]/aside/span/div/div/div[2]/div[2]/div[2]/span/div[4]/div/a/div/div[2]")
	WebElement DOLAR;
	
	@FindBy(xpath="//*[@id=\"app\"]/div/div[8]/div/div/div[1]/div/div/div[1]/aside/span/div/div/div[2]/div[2]/div[2]/span/div[5]/div/a/div/div[2]")
	WebElement FUNT;

	@FindBy(xpath="/html/body/div[3]/div/div[2]/div[3]/div/button[2]")
	WebElement zgoda;
	
	public MoneyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getEURO() {
		return EUR.getText().toString().replaceAll(",",".");
	}
	
	public String getFRANK() {
		return	FRANK.getText().toString().replaceAll(",",".");
	}
		
	public String getDOLAR() {
		return DOLAR.getText().toString().replaceAll(",",".");
	}
	
	public String getFUNT() {
		return FUNT.getText().toString().replaceAll(",",".");
	}

	public void clickZgoda() {
		zgoda.click();
	}
}	