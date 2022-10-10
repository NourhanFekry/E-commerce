package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.concurrent.TimeUnit;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;


public class D07_followUsStepDefinition
{
    P03_homePage homeFollowUs = new P03_homePage();

    @When("user opens facebook link")
    public void openFacebookLink() throws InterruptedException {
        homeFollowUs.facebook().click();
    }

    @When("user opens rss link")
    public void openRssLink()
    {
        homeFollowUs.rss().click();
    }

    @When("user opens youtube link")
    public void openYoutubeLink()
    {
        homeFollowUs.youtube().click();
    }

    @When("user opens twitter link")
    public void openTwitterLink()
    {
        homeFollowUs.twitter().click();
    }

    @Then("^\"(.*)\" is opened in new tab$")
    public void opensNewTab(String url)
    {
        WebDriverWait wait = new WebDriverWait(Hooks.driver,10);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        System.out.println(tabs.size());

        Hooks.driver.switchTo().window(tabs.get(1));
        System.out.println("tab 1 : actual url = "+Hooks.driver.getCurrentUrl());
        System.out.println("tab 1 : Expected url = "+url);
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),url);
        Hooks.driver.close();

        Hooks.driver.switchTo().window(tabs.get(0));
        System.out.println("tab 0 : actual url = "+Hooks.driver.getCurrentUrl());
        System.out.println("tab 1 : Expected url = "+url);
        //Hooks.driver.close();

        tabs = new ArrayList<>(Hooks.driver.getWindowHandles());

    }

}


