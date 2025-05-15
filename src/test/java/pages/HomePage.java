package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage{
	private WebDriver driver;
	private WebDriverWait wait;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
    private By flightsTab = By.xpath("//*[@id=\"tab\"]/li[1]/button/span");
    private By fromInput = By.xpath("//*[@id=\"onereturn\"]/div[1]/div/input");
    private By toInput = By.xpath("//*[@id=\"onereturn\"]/div[2]/div[2]/input");
    private By dateInput = By.xpath("//*[@id=\"departure\"]");
    private By searchButton = By.className("search_button");
    
    public void goToFlightsTab() {
        driver.findElement(flightsTab).click();
    }
    
    public void enterFromCity(String from) {
    	try {
            WebElement fromField = driver.findElement(fromInput);
            fromField.clear();
            fromField.sendKeys(from);
            
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"onereturn\"]/div[1]/div/div/div[2]/button"))).click();
            
            //WebElement fromSuggest = driver.findElement(By.xpath("//div[@class='result-option' and @data-code='JFK']"));
            //fromSuggest.click();
            
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}

    }
    
    public void enterToCity(String to) {
    	try {
            WebElement toField = driver.findElement(toInput);
            toField.clear();
            toField.sendKeys(to);
            
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"onereturn\"]/div[2]/div[2]/div/div[2]/button"))).click();
            
    	}
    	catch(Exception e) {
    		//e.printStackTrace();
    	}

    }
    
    public void enterDate(String date) {
        try {
            WebElement dateField = driver.findElement(dateInput);
            System.out.println("Date input found");
            dateField.clear();
            Thread.sleep(1000); // Small wait before sending
            dateField.sendKeys(date);
            Thread.sleep(1000); // Let input settle
            System.out.println("Date entered: " + date);
            driver.findElement(By.xpath("//*[@id=\"fadein\"]/main/div[1]/div[2]/div[2]/div/div")).click();
        } catch (Exception e) {
            System.out.println("Issue in enterDate()");
            e.printStackTrace();
        }
    }
    
    public void clickSearch() {
    	try {
    		driver.findElement(searchButton).click();
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
        
    }
    
    public String isNoFlightsMessageVisible() {
    	String status = null;
    	try {
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/section/div[2]/div[2]/div[3]/div/div")));
    		status = driver.findElement(By.xpath("/html/body/main/section/div[2]/div[2]/div[3]/div/div")).getText();
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return status;
    }
    
}