package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public GreenKartPage greenKartPage;
	public OffersPage offersPage;
	public WebDriver driver;
	
	
	public PageObjectManager (WebDriver driver) {
		this.driver =driver;
	}
	
	
	public GreenKartPage getGreenKartPage() {
		
		greenKartPage = new GreenKartPage(driver);
		return greenKartPage;
	}
	
	public OffersPage getOffersPage() {
		offersPage = new OffersPage(driver);
		return offersPage;
	}
	
	
	

}
