package com.selenium.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FullFeatureTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arpan\\Pictures\\MyPersonalLearnings\\Selenium Learnings\\SeleniumDrivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        driver.get("https://www.webdriveruniversity.com/");
        driver.findElement(By.id("contact-us")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contact-us")));
        System.out.println("New tab visible");
        
        //Switch to the new tab that opened
        Object[] windowHandles=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
        /*
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        } */
        
        WebElement nameField = driver.findElement(By.name("first_name"));
        WebElement lastnameField = driver.findElement(By.name("last_name"));
        WebElement emailField = driver.findElement(By.name("email"));
        WebElement messageField = driver.findElement(By.name("message"));
        
        nameField.sendKeys("John");
        lastnameField.sendKeys("Doe");
        emailField.sendKeys("johndoe@example.com");
        messageField.sendKeys("This is a test message!");
        
        
        driver.findElement(By.xpath("/html/body/div[1]/div/div/section/div/div[2]/form/div/input[2]")).click();
        
        
        String successMessage = driver.findElement(By.id("contact_reply")).getText();
        //System.out.println(successMessage);
        if(successMessage.equals("Thank You for your Message!"))  {
        	System.out.println("✅ Form submitted successfully.");
        }
        else {
        	System.out.println("❌ Form submission failed.");
        }
        
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File("screenshot.png");
        try {
            Files.copy(screenshot.toPath(), destination.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Step 10: Close the new tab and switch back to the original window
        driver.close();  // Close the new tab
        //driver.switchTo().window(originalWindow);  // Switch back to the original window

        // Step 11: Close the browser
        Thread.sleep(3000);
        driver.quit();
	}

}
