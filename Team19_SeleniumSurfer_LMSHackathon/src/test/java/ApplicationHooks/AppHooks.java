package ApplicationHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import ConfigFile.ConfigReader;
import DriverFactory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {
	private BaseClass driverInitialization;
	static WebDriver driver=null;
	private ConfigReader configReader;
	Properties prop;
	@Before(order=0)
	public void getProperty() {
		configReader= new ConfigReader();
		prop=configReader.init_prop();
	}
		@Before(order=1)
	public void launchBrowser() {
			String browserName=prop.getProperty("browser");
			driverInitialization=new BaseClass();
		driver = driverInitialization.init_driver(browserName);
		}
		@After(order=0)
		public void closeBrowser() {
		driver.quit();
	}
		@After(order=1)
		public void teaDown(Scenario scenario) {
			if(scenario.isFailed()) {
				//take screenshot;
				String screenshotName=scenario.getName().replaceAll("","_");
				byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(sourcePath,"image/png",screenshotName);
			}
			
		}

}
