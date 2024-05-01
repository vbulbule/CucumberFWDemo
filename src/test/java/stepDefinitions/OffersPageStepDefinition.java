package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.OffersPage;
//  to share the object to another classes (dependency injection)
//Spring | picoconainer | EJB
import utils.TestContextSetup;

public class OffersPageStepDefinition {
	TestContextSetup testContextSetup;
	OffersPage offersPage;
	
	public OffersPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
		offersPage = testContextSetup.pageObjectManager.getOffersPage();
	}
	
	@Then("^user searched with shortname (.+) in offers page to check if product exist$")
	public void user_searched_with_shortname_in_offers_page_to_check_if_product_exist(String string) throws InterruptedException {
		//pageObjectManager = new PageObjectManager(testContextSetup.driver);
		//OffersPage offersPage = new OffersPage(testContextSetup.driver);
		offersPage.switchtoOffersPage();
		testContextSetup.genericUtils.switchToChild();
		offersPage.searchItem(string);
		Thread.sleep(2000);
		String expectedName=offersPage.getProductName();
		Assert.assertEquals(testContextSetup.aproductName, expectedName);
	}
	
	
	
}
