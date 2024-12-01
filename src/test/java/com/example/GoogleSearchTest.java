package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    @Test
    public void testGoogleSearch() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.google.com");

            WebElement searchBox = driver.findElement(By.name("q"));

            searchBox.sendKeys("Jenkins UI test");
            searchBox.submit();

            WebElement results = driver.findElement(By.id("search"));
            assertTrue(results.isDisplayed(), "Search results are not displayed!");

        } finally {
            driver.quit();
        }
    }
}
