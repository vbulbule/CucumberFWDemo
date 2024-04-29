package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

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
	

}
