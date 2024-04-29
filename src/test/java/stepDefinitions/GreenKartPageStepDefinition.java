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
import pageObjects.GreenKartPage;
import utils.TestContextSetup;

public class GreenKartPageStepDefinition {
	TestContextSetup testContextSetup;
	
	public GreenKartPageStepDefinition(TestContextSetup testContextSetup) {
	
		this.testContextSetup=testContextSetup;
	}
	
	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
		
	    
	}
	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String productName) throws InterruptedException {
	    //GreenKartPage greenKartPage = new GreenKartPage(testContextSetup.driver);
		GreenKartPage greenKartPage=testContextSetup.pageObjectManager.getGreenKartPage();
	    greenKartPage.searchItem(productName);
		Thread.sleep(2000);
		testContextSetup.aproductName=greenKartPage.getSearchText(productName);
		testContextSetup.aproductName=testContextSetup.aproductName.split("-")[0].trim();
	}
	
}
