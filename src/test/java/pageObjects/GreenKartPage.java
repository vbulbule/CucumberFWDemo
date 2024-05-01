package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.GenericUtils;

public class GreenKartPage {
	WebDriver driver;
	public GenericUtils genericUtils;
	
	public GreenKartPage(WebDriver driver) {
		this.driver=driver;
		genericUtils = new GenericUtils(driver);
	}
	//locators
	
	By search = By.xpath("//input[@type='search']");
	By productName = By.xpath("//h4[@class='product-name']");
	By quantity=By.xpath("//input[@type='number']");
	By addToCart=By.xpath("//button[text()='ADD TO CART']");
	By cartIcon=By.xpath("//img[@alt='Cart']");
	By proceedToCheckout=By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	
	
	public void searchItem(String productName) {
		genericUtils.getElement(search).sendKeys(productName);
	}
	
	public String getSearchText(String productName) {
		return genericUtils.getElement(this.productName).getText();
	}
	public void enterQuantity(Integer number)
	{
		WebElement quan = driver.findElement(quantity);
		quan.clear();
		quan.sendKeys(number.toString());

	}
	
	public void addProductToCart()
	{
		driver.findElement(addToCart).click();
	}
	
	public void goToCart()
	{
		driver.findElement(cartIcon).click();
		
	}
	
	public void proceedToCheckout()
	{
		driver.findElement(proceedToCheckout).click();
	}
	
	public String getQuantityOfProduct()
	{
		String val = driver.findElement(quantity).getAttribute("value");
		return val;
	}
	
	public String getGreenKartPageTitle() {
		return genericUtils.getWebPageTitle();
	}

}
