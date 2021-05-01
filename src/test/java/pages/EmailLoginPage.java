package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailLoginPage {		
	    
	WebDriver driver;
	
	@FindBy(name="login_username")
	WebElement user_name;

	@FindBy(name="password")
	WebElement user_password;	
	
	@FindBy(xpath="//*[@id=\"loginForm\"]/div[3]/button")
	WebElement login;

	@FindBy(xpath="//*[@id=\"formError\" and not(contains(@style,\"display:none\"))]")
	WebElement formError;
	
	public EmailLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	public boolean isError() {
		return formError.isEnabled();
	}
	public WebElement getUserName(){
		return user_name;
	}

	public void clickLogin() {
		login.click();
	}
	
	public void setPassword(String strPassword){
		user_password.clear();
	    user_password.sendKeys(strPassword);
	}
	
	public void setUserName(String strName){
		user_name.clear();
	    user_name.sendKeys(strName);
	}
	
	public EmailMainPage loginToMail(String strUserName,String strPassword){
        this.setUserName(strUserName);
        this.setPassword(strPassword);
        this.clickLogin();
		EmailMainPage emp=new EmailMainPage(driver);
		return emp;
    }	
}	