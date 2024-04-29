package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GreenKartPage {
	WebDriver driver;
	
	public GreenKartPage(WebDriver driver) {
		this.driver=driver;
	}
	//locators
	
	By search = By.xpath("//input[@type='search']");
	By productName = By.xpath("//h4[@class='product-name']");
	
	public void searchItem(String productName) {
		driver.findElement(search).sendKeys(productName);
	}
	
	public String getSearchText(String productName) {
		return driver.findElement(this.productName).getText();
	}

}
