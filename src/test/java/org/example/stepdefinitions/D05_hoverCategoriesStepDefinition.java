package org.example.stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class D05_hoverCategoriesStepDefinition
{
    P03_homePage homeHover = new P03_homePage();
    String subCategoryName;

    @When("user hover category and select subcategory")
    public void userHoversCategory() throws InterruptedException {


        Actions action = new Actions(Hooks.driver);
        action.moveToElement(homeHover.computers()).perform();
        action.moveToElement(homeHover.computers()).perform();

        subCategoryName = homeHover.desktops().getText().toLowerCase();

        Thread.sleep(2000);
    }

    @And("user click on subcategory")
    public void userClicksSubcategory(){
        homeHover.desktops().click();
    }

    @Then("user go to relative product page")
    public void relativeSubcategory(){
        Assert.assertEquals(homeHover.categoryList().getText().toLowerCase(),subCategoryName,"subcategory");
    }

}
