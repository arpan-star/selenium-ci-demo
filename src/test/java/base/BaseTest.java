package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arpan\\Pictures\\MyPersonalLearnings\\Selenium Learnings\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
