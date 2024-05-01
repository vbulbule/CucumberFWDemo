package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;		
	}
	
	By productName =By.xpath("//table//tbody//td[2]/p");
	By productQuantity =By.xpath("//table//tbody//td[3]/p");
	By applyBTN =By.xpath("//button[text()='Apply']");
	By placeOrderBTN =By.xpath("//button[text()='Place Order']");
	
	public String getProductNameAddedonCart()
	{
		return driver.findElement(productName).getText();
	}
	
	public String getProductQuantityPresentinCart()
	{
		return driver.findElement(productQuantity).getText();
	}
	
	public boolean isapplyBTNVisible()
	{
		boolean bln = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		try {
			 bln = wait.until(ExpectedConditions.presenceOfElementLocated(applyBTN)).isDisplayed();
		}
		catch (Exception e) {
			
		}
		return bln;
	}
	
	public String isPlaceOrderBTNVisible()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	    boolean element = wait.until(ExpectedConditions.presenceOfElementLocated(placeOrderBTN)).isDisplayed();
		
	    if(element==true)
	    	return "Element is visible on page";
	    
	    else
	    	return "Element is not visible on page";
	}
	

}