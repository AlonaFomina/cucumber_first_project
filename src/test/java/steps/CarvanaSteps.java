package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.*;
import utils.Driver;
import utils.DropdownHandler;
import utils.Waiter;

public class CarvanaSteps {
    WebDriver driver;
    CarvanaMainPage carvanaMainPage;
    CarvanaHelpMePage carvanaHelpMePage;
    CarvanaWhatCarShoulIGetPage carvanaWhatCarShoulIGetPage;
    CarvanaTradePage carvanaTradePage;
    CarvanaFinancialPage carvanaFinancialPage;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        carvanaHelpMePage = new CarvanaHelpMePage();
        carvanaMainPage = new CarvanaMainPage();
        carvanaWhatCarShoulIGetPage = new CarvanaWhatCarShoulIGetPage();
        carvanaTradePage = new CarvanaTradePage();
        carvanaFinancialPage = new CarvanaFinancialPage();
    }

    @Given("user navigates to {string}")
    public void userNavigatesTo(String url) {
        driver.get(url);
    }

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String barMenuOption) {
        Waiter.waitForVisibilityOfElement(driver,carvanaMainPage.carFinderPage,30);
        switch (barMenuOption) {
            case "CAR FINDER":
                carvanaMainPage.carFinderPage.click();
                break;
            case "SELL/TRADE":
                carvanaMainPage.sellTradeButton.click();
                break;
            case "AUTO LOAN CALCULATOR":
                carvanaMainPage.autoLoanCalculator.click();
                break;
            default:
                throw new NotFoundException("The button text is not defined properly in the feature file!!!");
        }
    }

    @Then("user should be navigated to {string}")
    public void userShouldBeNavigatedTo(String whatCarUrl) {
        switch (whatCarUrl) {
            case "https://www.carvana.com/help-me-search/qa":
                Assert.assertEquals(whatCarUrl, driver.getCurrentUrl());
                break;
            case "https://www.carvana.com/help-me-search/":
                Assert.assertEquals(whatCarUrl, driver.getCurrentUrl());
                break;
            case "https://www.carvana.com/sell-my-car":
                Assert.assertEquals(whatCarUrl, driver.getCurrentUrl());
                break;
            default:
                throw new NotFoundException("The button text is not defined properly in the feature file!!!");
        }
    }

    @And("user should see {string} text")
    public void userShouldSeeText(String text) {
        switch (text) {
            case "WHAT CAR SHOULD I GET?":
                Assert.assertEquals(text, carvanaWhatCarShoulIGetPage.header1.getText());
                break;
            case "Car Finder can help! Answer a few quick questions to find the right car for you.":
                Assert.assertEquals(text, carvanaWhatCarShoulIGetPage.header2.getText());
                break;
            case "WHAT IS MOST IMPORTANT TO YOU IN YOUR NEXT CAR?":
                Assert.assertEquals(text, carvanaHelpMePage.heading1.getText());
                break;
            case "Select up to 4 in order of importance":
                Assert.assertEquals(text, carvanaHelpMePage.heading2.getText());
                break;
            case "GET A REAL OFFER IN 2 MINUTES":
                Assert.assertEquals(text, carvanaTradePage.h1.getText());
                break;
            case "We pick up your car. You get paid on the spot.":
                Assert.assertEquals(text, carvanaTradePage.h2.getText());
                break;
            default:
                throw new NotFoundException("The button text is not defined properly in the feature file!!!");
        }
    }

    @And("user should see {string} link")
    public void userShouldSeeLink(String textLink) {
        Assert.assertEquals(textLink, carvanaWhatCarShoulIGetPage.tryCarFinder.getText());
        Assert.assertTrue(carvanaWhatCarShoulIGetPage.tryCarFinder.isDisplayed());
    }

    @When("user clicks on {string} link")
    public void userClicksOnLink(String data) {
        carvanaWhatCarShoulIGetPage.tryCarFinderButton.click();
//
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String button) {
        switch (button) {
            case "VIN":
                carvanaTradePage.vinButton.click();
                break;
            case "GET MY OFFER":
                carvanaTradePage.offerButton.click();
                break;
            default:
                throw new NotFoundException("The button text is not defined properly in the feature file!!!");
        }
    }

    @And("user enters vin number as {string}")
    public void userEntersVinNumberAs(String vinNum) {
        carvanaTradePage.vinInput.sendKeys(vinNum);
    }

    @When("user hovers over on {string} menu item")
    public void userHoversOverOnMenuItem(String financingHover) {
        Actions action = new Actions(driver);
        Waiter.waitForVisibilityOfElement(driver, carvanaMainPage.carFinderPage, 30);
        action.moveToElement(carvanaMainPage.financialButton).build().perform();
    }

    @When("user enters {string} as {string}")
    public void userEntersAs(String entersInputBox, String enterInput) {
        switch (entersInputBox) {
            case "Cost of Car I want":
                Waiter.waitForVisibilityOfElement(driver, carvanaFinancialPage.costOfCarIWant, 30);
                carvanaFinancialPage.costOfCarIWant.click();
                carvanaFinancialPage.costOfCarIWant.sendKeys(enterInput);
                Waiter.pause(3);
                break;
            case "What is Your Down Payment?":
                Waiter.waitForVisibilityOfElement(driver, carvanaFinancialPage.downPayment, 30);
                carvanaFinancialPage.downPayment.click();
                carvanaFinancialPage.downPayment.sendKeys(enterInput);
                break;
            default:
                throw new NotFoundException("The button text is not defined properly in the feature file!!!");
        }
    }

    @And("user selects {string} as {string}")
    public void userSelectsAs(String scoreText, String optionText) {
        switch (scoreText) {
            case "What’s Your credit Score?":
                DropdownHandler.selectOptionByVisibleText(carvanaFinancialPage.creditScoreBox, optionText);
                break;
            case "Choose Your Loan Terms":
                Waiter.pause(2);
                DropdownHandler.selectOptionByVisibleText(carvanaFinancialPage.loanTerm, optionText);
                break;
            default:
                throw new NotFoundException("The button text is not defined properly in the feature file!!!");
        }
    }

    @Then("user should see the monthly payment as {string}{int}")
    public void userShouldSeeTheMonthlyPaymentAs(String monthlyPayment, int arg1) {
        Waiter.waitForVisibilityOfElement(driver, carvanaFinancialPage.calculate, 30);
        Assert.assertEquals(monthlyPayment, carvanaFinancialPage.calculate.getText());
    }
}
