package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D08_WishlistStepDefinition
{
   P03_homePage homeWishlistObj = new P03_homePage();
    SoftAssert soft = new SoftAssert();

   @When("user clicks on wishlist button on product")
    public void clickOnWishlist () throws InterruptedException {
       homeWishlistObj.wishlistButtons.get(2).click();
       Thread.sleep(2000);
   }

   @Then("success message is visible")
    public void seeGreenMessage() throws InterruptedException {
       Assert.assertTrue(homeWishlistObj.notificationBar().isDisplayed());
       Thread.sleep(3000);
       soft.assertTrue(homeWishlistObj.successMessage.getText().contains("The product has been added to your wishlist"),"First Assertion");
       String actual = homeWishlistObj.successMessage.getCssValue("background-color");
       String expected = "rgba(75, 176, 122, 1)";
       soft.assertEquals(actual, expected, "color-Second Assertion");
       soft.assertAll();
   }
    int number;
    @And ("user get the number wishlist items")
    public void getNumberItems()
    {
      String text = homeWishlistObj.getWishlistQty().getText();
      text= text.replaceAll("[^0-9]","");
      number = Integer.parseInt(text);
    }

    @Then ("number of wishlist increased")
    public void numIncreased()
    {
        Assert.assertTrue(number>0);

    }


//    @And("user clicks on wishlist on Notification bar")
//    public void wait_and_click() {
//        WebDriverWait wait = new WebDriverWait(Hooks.driver, 20);
//        wait.until(ExpectedConditions.invisibilityOf(homeWishlistObj.barNotification));
//        homeWishlistObj.wishlistLabel.click();
//    }
//
//    @Then("user will see product in wishlist")
//    public void verify_qty(){
//        soft.assertNotEquals(homeWishlistObj.getWishlistQty().getText(),"0");
//        soft.assertAll();
//    }

}


