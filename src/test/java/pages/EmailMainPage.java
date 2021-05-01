package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailMainPage {
    WebDriver driver;

    @FindBy(xpath="//*[@id=\"folder-1\"]/div[2]")
    WebElement income;

    public EmailMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayed(){
        boolean isDisplayed = income.isDisplayed();
        return isDisplayed;
    }

}
