package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CarvanaMainPage {
    public CarvanaMainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "a[data-cv-test ='headerCarFinderLink']")
    public WebElement carFinderPage;

    @FindBy(xpath = "//a[@data-cv-test='headerTradesLink']")
    public WebElement sellTradeButton;

    @FindBy(css = "div[data-cv-test='headerFinanceDropdown']")
    public WebElement financialButton;

    @FindBy(css = "a[data-cv-test='headerFinanceLoanCalc']")
    public WebElement autoLoanCalculator;

}
