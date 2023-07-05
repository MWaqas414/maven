package Sucasa.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private By containerBy = By.xpath("/html/body/div[5]/div[2]/div");
    private By sucasaSectionTextBy = By.tagName("h4");
    private String[] expectedH4Texts = {
            "Work From Anywhere",
            "Transparent Pricing",
            "Premium Properties"
    };

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void verifySucasaSectionText() {
        WebElement container = wait.until(ExpectedConditions.visibilityOfElementLocated(containerBy));
        List<WebElement> sucasaSectionText = container.findElements(sucasaSectionTextBy);

        if (sucasaSectionText.size() == expectedH4Texts.length) {
            for (int i = 0; i < sucasaSectionText.size(); i++) {
                WebElement h4 = sucasaSectionText.get(i);
                String actualH4Text = h4.getText();
                String expectedH4Text = expectedH4Texts[i];

                if (actualH4Text.equals(expectedH4Text)) {
                    System.out.println("Test is passed");
                } else {
                    System.out.println("Test is failed");
                }
            }
        } else {
            System.out.println("Number of Sucasa section texts does not match");
        }
    }

    public void clickFindStaysButton() {
        WebElement btnFindStays = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Find Stays']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btnFindStays);
        System.out.println("Button is clicked");
    }
}
