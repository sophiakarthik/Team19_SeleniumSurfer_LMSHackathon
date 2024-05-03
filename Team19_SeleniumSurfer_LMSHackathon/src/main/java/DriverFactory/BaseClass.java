package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public static ThreadLocal<WebDriver>tlDriver=new ThreadLocal<>();
	public WebDriver init_driver(String browser) {
		System.out.println("Browser value is: "+browser);
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		   }
		else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
			}
		else if (browser.equals("safari")) {
			WebDriverManager.safaridriver().setup();
			tlDriver.set(new SafariDriver());
			}
		else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
			}
		else {
			System.out.println("PLease pass correct browser value:"+browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	public static synchronized WebDriver getDriver() { 				//for multi thread "synch.."
		return tlDriver.get();
	}
	
	
	
	

}
