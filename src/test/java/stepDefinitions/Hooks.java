package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	TestContextSetup testContextSetup;
	
	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
	
	@After
	public void afterScenario() {
		testContextSetup.driver.quit();
	}
	
	
	@AfterStep
	public void addScreenshotIfFailedStep(Scenario scenario) throws IOException {
		
		WebDriver driver = testContextSetup.driver;
		
		if(scenario.isFailed()) {
			System.out.println(" ---  in After step failed --- ");
			//screenshot need to captures
			File sourcePath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			// sourcepath needs to convert in bytestream
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");;
			
		}
		
	}
	

}
