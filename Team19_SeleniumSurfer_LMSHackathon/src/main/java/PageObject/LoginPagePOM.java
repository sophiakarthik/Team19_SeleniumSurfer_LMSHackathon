package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoginPagePOM {
private WebDriver driver;
//By locator
private By username=By.id("username");
private By password=By.id("password");
private By signBtn=By.xpath("//*[@id=\"login\"]/span[1]");
private By program=By.xpath("//*[@id=\"program\"]/span[1]");
private By batch=By.xpath("//*[@id=\"batch\"]/span[1]");
private By addbatch=By.xpath("//*[@id=\"new\"]/span[2]");
private By dropdown=By.xpath("//*[@id=\"programName\"]/div/div[2]");
private By dropdowntext=By.xpath("//*[@id=\"programName\"]/div/div[3]/div/ul/p-dropdownitem[1]/li/span");
private By editbtn=By.xpath("//*[@id=\"editProgram\"]/span[1]");
private By deletebtn=By.xpath("//*[@id=\"deleteProgram\"]/span[1]");
private By addprogram=By.xpath("//*[@id=\"new\"]");
private By search=By.xpath("//*[@id=\"filterGlobal\"]");
private By NameTextBox=By.xpath("//*[@id=\"programName\"]");
private By DescriptionTExtBox=By.xpath("//*[@id=\"programDescription\"]");
private By statusradioactive=By.xpath("//*[@id=\"category\"]/div/div[2]");
private By save=By.xpath("//*[@id=\"saveProgram\"]");
private By header=By.xpath("");
private By footer=By.xpath("");
//constructor
public LoginPagePOM(WebDriver driver) {
	this.driver=driver;
}
//page actions:features()behaviour) of the page the form  of methods:
public void enteruser(String user) {
	driver.findElement(username).sendKeys(user);
	
}
	public void enterpass(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	public void signbutton() throws InterruptedException {
		driver.findElement(signBtn).click();
		Thread.sleep(3000);
		
	}
	public void programclick() throws InterruptedException {
		/*driver.findElement(batch).click();
		driver.findElement(addbatch).click();
		WebElement Dropdown=driver.findElement(dropdown);
		Dropdown.click();
				Select select =new Select(Dropdown);
				select.selectByVisibleText("Random123");
		Dropdown.sendKeys("Random123");
		//to get the size of elements
		List <WebElement> listofoptions=select.getOptions();
		int size =listofoptions.size();
		System.out.println("Number of elements");*/
		driver.findElement(program).click();
		driver.findElement(addprogram).click();
		
		driver.findElement(NameTextBox).sendKeys("AI");		
		driver.findElement(DescriptionTExtBox).sendKeys("Future course");		
		driver.findElement(statusradioactive).click();
		Thread.sleep(3000);
		driver.findElement(save).click();
		WebElement activeElement1=driver.switchTo().activeElement();
		   String msgStr1=activeElement1.getAttribute("validationMessage");
		   System.out.println("Message appeared"+msgStr1);
		
			Thread.sleep(3000);
			}
public ProgramPagePOM doLogin( String un,String pw) {
	System.out.println("login in with "+un+"and"+pw);
	driver.findElement(username).sendKeys(un);
	driver.findElement(password).sendKeys(pw);
	driver.findElement(signBtn).click();
	return new ProgramPagePOM(driver);
}
}
