package pages;

import cucumber.api.java.bs.A;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CarvanaFinancialPage {
    public CarvanaFinancialPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = "input[name='vehiclePrice']")
    public WebElement costOfCarIWant;

    @FindBy(css = ".loan-calculator-display-value")
    public WebElement calculate;

    @FindBy(id="creditBlock")
    public WebElement creditScoreBox;

    @FindBy(css = "select[name='loanTerm']")
    public WebElement loanTerm;

    @FindBy(css="input[name='downPayment']")
    public WebElement downPayment;

}
