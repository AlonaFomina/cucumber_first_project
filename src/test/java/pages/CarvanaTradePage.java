package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CarvanaTradePage {
    public CarvanaTradePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@class='sc-7ed29b82-1 jwFVns']/div[2]")
    public WebElement h1;

    @FindBy(xpath = "//div[@class='sc-7ed29b82-1 jwFVns']/div[3]")
    public WebElement h2;

    @FindBy(xpath = "//button[@data-cv-test='VINToggle']")
    public  WebElement vinButton;

    @FindBy(xpath = "//input[@aria-labelledby='VIN']")
    public WebElement vinInput;

    @FindBy(xpath = "//button[@data-cv-test='heroGetMyOfferButton']")
    public WebElement offerButton;
}
