package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.GoogleHomePage;

public class GoogleSearchTest extends BaseTest {

    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com");
        GoogleHomePage home = new GoogleHomePage(driver);
        home.search("Selenium WebDriver");
        System.out.println("Page title is: " + driver.getTitle());
    }
}
