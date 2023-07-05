package Sucasa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class StaysPage extends BasePage {

    private String expectedUrl = "https://saucasa.zaptatech.com/index?#featured";

    public StaysPage(WebDriver driver) {
        super(driver);
    }

    public void verifyPageUrl() {
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        System.out.println("URL is verified");
    }
}
