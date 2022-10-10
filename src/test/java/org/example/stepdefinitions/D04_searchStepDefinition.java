package org.example.stepdefinitions;
import org.example.pages.P03_homePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D04_searchStepDefinition {
    P03_homePage homeSearch = new P03_homePage();
        SoftAssert soft = new SoftAssert();
        @Given("user click on search field")
        public void search()
        {
            homeSearch.searchField.click();
        }

        @And("user search with {string}")
        public void userSearchWith(String text) {
            homeSearch.searchField.sendKeys(text);
            homeSearch.searchField.sendKeys(Keys.ENTER);
        }

        @Then("user could find  {string} relative words")
        public void userCouldFindRelativeWords(String word) {
            String text = null;
            for (int i = 0; i < homeSearch.getData().size(); i++) {
                text = homeSearch.getData().get(i).getText().toLowerCase();
            }
            soft.assertTrue(text.contains(word));
            String url_expected="https://demo.nopcommerce.com/search?q=";
            String url = Hooks.driver.getCurrentUrl();
            soft.assertTrue(url.contains(url_expected));
            soft.assertAll();

        }

        @Then("user could find  {string} inside product detail page")
        public void userCouldFindInsideProductDetailPage(String word1) {
            homeSearch.click_on_product().click();
            String serial_text = homeSearch.get_product_serial_text().getText();
            Assert.assertTrue(word1.contains(serial_text));

        }
    }

