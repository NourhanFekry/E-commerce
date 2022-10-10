package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class D06_homeSlidersStepDefinition {
    P03_homePage homeSlider = new P03_homePage();

    @When("user clicks on first slider")
    public void clickOnFirstSlider()
    {
     homeSlider.slider("1").click();
    }
    @Then("relative product for first slider is displayed")
    public void displayedFirstSlider() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals
                (Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/iphone-6");
    }
    @When("user clicks on second slider")
    public void clickOnSecondSlider()
    {
        homeSlider.slider("2").click();
    }
    @Then("relative product for second slider is displayed")
    public void displayedSecondSlider() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals
                (Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/nokia-lumia-1020");
    }

}
