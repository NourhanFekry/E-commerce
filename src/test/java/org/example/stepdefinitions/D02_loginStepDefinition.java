package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDefinition {
    P02_login login = new P02_login(Hooks.driver);


    @Given("user go to login page")
    public void goToLoginPage()
    {
        login.loginLink().click();
    }

    @When("^user login with \"valid\" \"(.*)\" and \"(.*)\"$")
    public void loginWithValidData(String username,String password)throws InterruptedException
    {
        login.loginSteps(username,password);
        Thread.sleep(3000);
    }

    @When("^user login with \"invalid\" \"(.*)\" and \"(.*)\"$")
    public void loginWithInvalidData(String username , String password)
    {
        login.loginSteps(username,password);
    }

    @And("user press on login button")
    public void pressLoginButton(){
        login.loginButton().click();
    }

    @Then("user login to the system successfully")
    public void SuccessLogin() throws InterruptedException
    {
        SoftAssert soft = new SoftAssert();
        String expectedResult = "https://demo.nopcommerce.com/";
        String actualResult = Hooks.driver.getCurrentUrl();
        soft.assertEquals(actualResult,expectedResult,"URL");
        soft.assertAll();
        Thread.sleep(3000);
    }

    @Then("user could not login to the system")
    public void error()
    {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(login.ErrorMsg().getText().contains("Login was unsuccessful."));
        soft.assertAll();
    }
}


