package com.selenium.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class GoogleSearchTest {
    public static void main(String[] args) {
        // Set path to chromedriver.exe — adjust if your path is different
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arpan\\Pictures\\MyPersonalLearnings\\Selenium Learnings\\SeleniumDrivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        driver.get("https://duckduckgo.com");

        System.out.println("Page Title: " + driver.getTitle());
        
        driver.findElement(By.name("q")).sendKeys("Cars" +  Keys.ENTER);
        
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.g")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".results--main")));
        //driver.findElement(By.className("gNO89b")).click();
        if(driver.getTitle().toLowerCase().contains("cars")) {
        	System.out.println("\"✅ Search results page loaded successfully.\"");
        }
        else {
        	System.out.println("❌ Search results page title does not contain expected text.");
        }
        driver.quit();
        System.out.println("End of test, window closes");
    }
}