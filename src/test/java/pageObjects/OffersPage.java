package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.GenericUtils;

public class OffersPage {
	WebDriver driver;
	public GenericUtils genericUtils;
	
	public OffersPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	By offersPage = By.linkText("Top Deals");
	By search = By.id("search-field");
	By productName = By.xpath("//table//tbody/tr/td[1]");
	
	public void switchtoOffersPage() {
		
		driver.findElement(offersPage).click();
	}
	
	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText();
		
	}

}
