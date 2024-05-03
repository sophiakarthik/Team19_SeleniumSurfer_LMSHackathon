package StepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import DriverFactory.BaseClass;
import PageObject.LoginPagePOM;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class loginSteps {
	
	
	private LoginPagePOM loginPagePom = new LoginPagePOM(BaseClass.getDriver());
	@Given("Admins is on login page")
	public void admins_is_on_login_page() {
		  BaseClass.getDriver()
		   .get("https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/");
}
	    

	@When("Admins enters the Username {string}")
	public void admins_enters_the_username(String username) {
		loginPagePom.enteruser(username);
	   
	}

	@When("Admins enters the password {string}")
	public void admins_enters_the_password(String password) {
	 loginPagePom.enterpass(password);   
	}

	@When("Admins clicks on the login button")
	public void admins_clicks_on_the_login_button() throws InterruptedException {
		loginPagePom.signbutton();
	    
	}

	@When("Admin clicks on Program")
	public void admin_clicks_on_program() throws InterruptedException {
		loginPagePom.programclick();
	}

}