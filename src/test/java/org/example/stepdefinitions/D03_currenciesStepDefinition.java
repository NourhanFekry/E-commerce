package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class D03_currenciesStepDefinition {
    P03_homePage homeCurrency = new P03_homePage(Hooks.driver);

    @When("user Select Euro currency option from the dropdown list on the top left of home page")
    public void selectEuroCurrency() {
        //Static dropdown
        Select select = new Select(homeCurrency.Currency());
        select.selectByVisibleText("Euro");
    }

    @Then("Euro Symbol is displayed on all product")
    public void displayedEuroSymbol() {
        int count = homeCurrency.verifyEuroPrice().size();
        for (int i = 0; i < count; i++) {
            String symbol = homeCurrency.verifyEuroSymbol().getText();
            Assert.assertTrue(symbol.contains("€"));
        }


    }
}
