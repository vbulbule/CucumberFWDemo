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
		String url = prop.getProperty("QAUrl");
		
		if(driver == null) {
			if(prop.getProperty("browserName").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
			if(prop.getProperty("browserName").equalsIgnoreCase("firefox")) {
				//firefox code
				
				System.setProperty("webdriver.gecko.drover","./drivers/geckodriver.exe");
				driver = new FirefoxDriver();	
				}
			if(prop.getProperty("browserName").equalsIgnoreCase("edge")) {
				// edge browser code
			}
			
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		}
		
		return driver;
	}

}
