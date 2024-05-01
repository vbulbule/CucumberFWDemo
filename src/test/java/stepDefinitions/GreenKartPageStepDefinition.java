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
	GreenKartPage greenKartPage;
	
	public GreenKartPageStepDefinition(TestContextSetup testContextSetup) {
	
		this.testContextSetup=testContextSetup;
		greenKartPage=testContextSetup.pageObjectManager.getGreenKartPage();
	}
	
	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
	    Assert.assertTrue(greenKartPage.getGreenKartPageTitle().contains("GreenKart"), "The WebPage title is not GreenKart Please check");
	}
	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String productName) throws InterruptedException {
	    //GreenKartPage greenKartPage = new GreenKartPage(testContextSetup.driver);
		 
	    greenKartPage.searchItem(productName);
		Thread.sleep(2000);
		testContextSetup.aproductName=greenKartPage.getSearchText(productName);
		testContextSetup.aproductName=testContextSetup.aproductName.split("-")[0].trim();
	}
	
	@When("^User provided product quantity (.+) and Added product to cart$")
	public void user_provided_product_quantity_and_added_product_to_cart(Integer quantity) throws InterruptedException {
		greenKartPage.enterQuantity(quantity);
		
		Thread.sleep(2000);
		greenKartPage.addProductToCart();
		String entered_quantity = greenKartPage.getQuantityOfProduct();
		
		testContextSetup.aQuantity=Integer.parseInt(entered_quantity);
		System.out.println("entered quantity : "+ testContextSetup.aQuantity);
		
	}
	
	@When("User proceed to checkout")
	public void user_proceed_to_checkout() {
		greenKartPage.goToCart();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		greenKartPage.proceedToCheckout();
	}
	
}
