package com.selenium.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {
    public static void main(String[] args) {
        // Set path to chromedriver.exe — adjust if your path is different
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arpan\\Pictures\\MyPersonalLearnings\\Selenium Learnings\\SeleniumDrivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        System.out.println("Page Title: " + driver.getTitle());

        driver.quit();
    }
}
