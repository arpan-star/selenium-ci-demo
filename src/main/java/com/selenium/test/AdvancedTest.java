package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.time.Duration;
import java.nio.file.Files;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdvancedTest {
    public static void main(String[] args) {
        // Set the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arpan\\Pictures\\MyPersonalLearnings\\Selenium Learnings\\SeleniumDrivers\\chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        try {
            // 1. Navigate to the main site
            driver.get("https://www.webdriveruniversity.com/");
            
            // 2. Click Contact Us (opens in new tab)
            String mainWindow = driver.getWindowHandle();
            driver.findElement(By.xpath("//a[@href='Contact-Us/contactus.html']")).click();

            // 3. Switch to new tab
            Set<String> allWindows = driver.getWindowHandles();
            for (String win : allWindows) {
                if (!win.equals(mainWindow)) {
                    driver.switchTo().window(win);
                    break;
                }
            }

            // 4. Fill and submit Contact Us form
            driver.findElement(By.name("first_name")).sendKeys("John");
            driver.findElement(By.name("last_name")).sendKeys("Doe");
            driver.findElement(By.name("email")).sendKeys("john.doe@example.com");
            driver.findElement(By.name("message")).sendKeys("This is a Selenium automation test!");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            // 5. Verify success
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h1"), "Thank You for your Message!"));
            System.out.println("✅ Form submitted successfully!");

            // 6. Close contact us tab and switch back
            driver.close();
            driver.switchTo().window(mainWindow);

            // 7. Click on Dropdowns/Checkboxes/Radio Buttons
            driver.findElement(By.xpath("//a[@href='Dropdown-Checkboxes-RadioButtons/index.html']")).click();

            // 8. Switch to new tab
            allWindows = driver.getWindowHandles();
            for (String win : allWindows) {
                if (!win.equals(mainWindow)) {
                    driver.switchTo().window(win);
                    break;
                }
            }

            // 9. Interact with dropdown
            Select dropdown = new Select(driver.findElement(By.id("dropdowm-menu-1")));
            dropdown.selectByVisibleText("Python");

            // 10. Check a checkbox
            WebElement checkbox = driver.findElement(By.cssSelector("input[value='option-2']"));
            if (!checkbox.isSelected()) checkbox.click();

            // 11. Choose a radio button
            WebElement radio = driver.findElement(By.cssSelector("input[value='yellow']"));
            if (!radio.isSelected()) radio.click();

            // 12. Take screenshot
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File("selenium-advanced-test.png");
            Files.copy(src.toPath(), dest.toPath());

            // 13. Go back to main tab and click Alerts
            driver.close();
            driver.switchTo().window(mainWindow);
            driver.findElement(By.xpath("//a[@href='Popup-Alerts/index.html']")).click();

            // 14. Switch to alerts tab
            allWindows = driver.getWindowHandles();
            for (String win : allWindows) {
                if (!win.equals(mainWindow)) {
                    driver.switchTo().window(win);
                    break;
                }
            }

            // 15. Handle JS alert
            driver.findElement(By.id("button1")).click();
            Alert alert = driver.switchTo().alert();
            System.out.println("🔔 Alert says: " + alert.getText());
            alert.accept();

            // 16. Done!
            System.out.println("🎉 Advanced test completed successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
