package org.example.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver=null;
    @Before
    public static void openBrowser() {
        String chromePath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/");

    }
    @After
    public static void closeBrowser() throws InterruptedException {
     Thread.sleep(3000);
     driver.quit();
    }

}
