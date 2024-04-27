package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GreenKartStepDefinition {
	WebDriver driver;
	String aproductName;

	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    
	}
	@When("user searched with Shortname {string} and extracted actual name of product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String productName) {
	    
		
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(productName);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		aproductName=driver.findElement(By.xpath("//h4[@class='product-name']")).getText();
		
		aproductName=aproductName.split("-")[0].trim();
	}
	@Then("user searched with shortname {string} in offers page to check if product exist")
	public void user_searched_with_shortname_in_offers_page_to_check_if_product_exist(String string) {
	    
		driver.findElement(By.linkText("Top Deals")).click();
		Set<String> win = driver.getWindowHandles();
		
		Iterator<String> itr = win.iterator();
		String parentWin = itr.next();
		String childWin = itr.next();
		
		driver.switchTo().window(childWin);
		
		driver.findElement(By.id("search-field")).sendKeys(string);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String expectedName=driver.findElement(By.xpath("//table//tbody/tr/td[1]")).getText();
		
		Assert.assertEquals(aproductName, expectedName);
		
		driver.switchTo().window(parentWin);
		
		
	}
	
}
