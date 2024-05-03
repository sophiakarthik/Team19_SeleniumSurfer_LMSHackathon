package StepDefinitions;

import java.util.List;
import java.util.Map;

import DriverFactory.BaseClass;
import PageObject.LoginPagePOM;
import PageObject.ProgramPagePOM;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramPageSteps {
	private  String title;
	private LoginPagePOM loginPagePom = new LoginPagePOM(BaseClass.getDriver());
	private ProgramPagePOM programPagePOM;
	@Given("Admins already logged in to application")
	public void admins_already_logged_in_to_application(DataTable dataTable) {
		List<Map<String,String>> credList=dataTable.asMaps();
		String userName=credList.get(0).get("username");
		String passWord=credList.get(0).get("password");
		BaseClass.getDriver().get("https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/");
		programPagePOM=loginPagePom.doLogin(userName, passWord);
	    }

	@Given("Admins is on dashboard page after Login")
	public void admins_is_on_dashboard_page_after_login() throws InterruptedException {
		title=programPagePOM.getDashboardTitle();
		System.out.println("PAge Title is: "+title);
		Thread.sleep(2000);
		 	}

	@When("Admins clicks Program on the navigation bar")
	public void admins_clicks_program_on_the_navigation_bar() throws InterruptedException {
		programPagePOM.PrgmClick();
		Thread.sleep(2000);
	    	}

	@Then("Admins should see URL with Manage Program")
	public void admins_should_see_url_with_manage_program() throws InterruptedException {
		title=programPagePOM.getManageProgramTitle();
//		System.out.println("Manage prgm Title is: "+title);
		Thread.sleep(2000);
	    	}
	/*@Then("Admins should see URL with {string}")
	public void admins_should_see_url_with(String expectedTitle) {
		String title=programPagePOM.HeadingManageProgram();
	    System.out.println("Program page heading is: "+title);
	}*/


	@Then("Admins should see a heading with text Manage Program on the page")
	public void admins_should_see_a_heading_with_text_manage_program_on_the_page() {
		
		boolean status=programPagePOM.HeadingManageProgram();
		
	    	}

}
