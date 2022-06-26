package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CarvanaWhatCarShoulIGetPage {
    public CarvanaWhatCarShoulIGetPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = ".leftSide h1")
    public WebElement header1;

    @FindBy(css = "h3[role='presentation']")
    public WebElement header2;

    @FindBy(linkText = "TRY CAR FINDER")
    public WebElement tryCarFinder;

    @FindBy(css = ".eGplQk.styles__AppContainer-fxl8i5-0 a")
    public WebElement tryCarFinderButton;
}
