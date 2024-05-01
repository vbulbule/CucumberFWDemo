package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericUtils {
	WebDriver driver;
	
	public GenericUtils(WebDriver driver) {
		this.driver= driver;
	}
	
	
	public void switchToChild() {
		Set<String> win = driver.getWindowHandles();
		Iterator<String> itr = win.iterator();
		String parentWin = itr.next();
		String childWin = itr.next();
		driver.switchTo().window(childWin);
	}
	
	public WebElement getElement(By by) {
		return driver.findElement(by);
		
	}
	
	public String getWebPageTitle() {
		return driver.getTitle();
	}
	

}
