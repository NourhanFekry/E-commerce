package org.example.stepdefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D01_RegisterStepDefinition {
    P01_register register = new P01_register();

    @Given("user go to register page")
    public void goRegisterPage()
    {
        register.registerLink.click();
    }
    @When("user select gender type")
    public void selectGender()
    {
        register.gender.click();
    }
     @And("user enter first name and last name")
    public void setName()
    {
        register.fristName.sendKeys("nourhan");
        register.lastName.sendKeys("fekry");
    }
    @And("user enter date of birth")
    public void setDateOfBrith()
    {
        Select selectDay = new Select(register.dayOfDate);
        selectDay.selectByVisibleText("28");

        Select selectMonth = new Select(register.monthOfDate);
        selectMonth.selectByVisibleText("February");

        Select selectYear = new Select(register.yearOfDate);
        selectYear.selectByVisibleText("2000");
    }
    @And("user enter email and company Name")
    public void setEmail()
     {
         register.email.sendKeys("nourfekry28@gmail.com");
         register.company.sendKeys("Company Example");
     }
    @And("user fills Password fields")
    public void setPassword()
    {
      register.password.sendKeys("P@ssw0rd");
      register.confirmPassword.sendKeys("P@ssw0rd");
    }

    @Then("user clicks on register button")
    public void clicksRegister()
    {
      register.registerButton.click();
    }
    @And("success message is displayed")
    public void successMsg(){
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(register.successMsg.isDisplayed(),
                "Your registration completed");
        String expectedResult = "rgba(76, 177, 124, 1)";
        String actualResult = register.successMsg.getCssValue("color");
        soft.assertEquals(actualResult,expectedResult,"Msg Color");
        soft.assertAll();
    }
}
