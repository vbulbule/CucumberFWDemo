package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	WebDriver driver;
	public WebDriver WebDriverManager() throws IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("Url");
		
		String browser = prop.getProperty("browserName"); // from properties file
		
		String browser_from_system = System.getProperty("browserName"); //from system or command line null
		
		String URL_from_system = prop.getProperty("Url"); 
		
		
		url = URL_from_system!=null ? URL_from_system : url;
		
		browser = browser_from_system !=null ? browser_from_system  : browser ; 
			
		if(driver == null) {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
			if(browser.equalsIgnoreCase("firefox")) {
				//firefox code	
				System.setProperty("webdriver.gecko.drover","./drivers/geckodriver.exe");
				driver = new FirefoxDriver();	
				}
			if(browser.equalsIgnoreCase("edge")) {
				// edge browser code
			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		}
		return driver;
	}

}
