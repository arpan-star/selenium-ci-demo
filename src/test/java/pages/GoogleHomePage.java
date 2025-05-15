package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage {
    WebDriver driver;

    By searchBox = By.name("q");

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void search(String query) {
        driver.findElement(searchBox).sendKeys(query);
        driver.findElement(searchBox).submit();
    }
}
