package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class FlightSearchTest extends BaseTest {


    @Test(enabled = true)
    public void testFlightSearchResults() throws InterruptedException {
        HomePage homePage = new HomePage(driver);

        homePage.goToFlightsTab();
        //System.out.println("Before from city");
        homePage.enterFromCity("New York");
        //System.out.println("After from city");
        homePage.enterToCity("London");
        //System.out.println("After to city");
        homePage.enterDate("30-06-2025");
        System.out.println("Before clicking search");
        //Thread.sleep(5000);
        //System.out.println("waited 5 sec");
        homePage.clickSearch();
        System.out.println("Clicked search");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ng-scope")));
        System.out.println("wait condition executed");
        
        boolean resultsVisible = driver.findElements(By.className("ng-scope")).size() > 0;
        Assert.assertTrue(resultsVisible, "Flight search results are not displayed!");
    }
    
    @Test
    public void noFlightResults() {
    	HomePage homePage = new HomePage(driver);
    	
    	homePage.goToFlightsTab();
        //System.out.println("Before from city");
        homePage.enterFromCity("New York");
        //System.out.println("After from city");
        homePage.enterToCity("London");
        //System.out.println("After to city");
        homePage.enterDate("30-06-2025");
        System.out.println("Before clicking search");
        //Thread.sleep(5000);
        //System.out.println("waited 5 sec");
        homePage.clickSearch();
        System.out.println("Clicked search");
    	String status = homePage.isNoFlightsMessageVisible();
    	System.out.println("Status =" + status);
    	Assert.assertTrue(status.contains("No Flights Available"), "No Flights are shown");
    }
}
