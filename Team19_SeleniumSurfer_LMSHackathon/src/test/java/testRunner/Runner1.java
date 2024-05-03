package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		plugin = {"pretty","html:report/htmlreport","json:report/jsonreport.json","junit:report/xmlreport.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				
		features={"src/test/resources/Feature/loggedin1.feature"},
		glue={"StepDefinitions","ApplicationHooks"},
		dryRun=false,
		monochrome=true,
		publish=true
		)
public class Runner1 {

}

/*"pretty","html:target/cucumberreport.html",
				"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},*/
				

