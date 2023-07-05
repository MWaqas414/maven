package Sucasa.tests;

import Sucasa.pages.HomePage;
import Sucasa.pages.StaysPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SeleniumTest {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Downloads\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to URL
        driver.get("https://saucasa.zaptatech.com/");

        HomePage homePage = new HomePage(driver);
        System.out.println("Verifying Sucasa section texts");
        homePage.verifySucasaSectionText();

        homePage.clickFindStaysButton();

        StaysPage staysPage = new StaysPage(driver);
        staysPage.verifyPageUrl();

        // Take a picture of the page
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH-mm-ss"));
        FileUtils.copyFile(src, new File("FIRST_" + timestamp + ".png"));
        System.out.println("Picture is taken and saved with the required name");

        driver.quit();
    }
}
