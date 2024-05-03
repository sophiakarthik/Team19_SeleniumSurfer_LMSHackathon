package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProgramPagePOM {
private WebDriver driver;
private By heading=By.xpath("//*text()=\" Manage Program\"]");
private By prgmButn=By.xpath("//*[@id=\"program\"]/span[1]");
public ProgramPagePOM(WebDriver driver) {
	this.driver=driver;
}
public String getDashboardTitle() {
	return driver.getTitle();
}
 public void PrgmClick() {
	 driver.findElement(prgmButn).click();
 }
 public String getManageProgramTitle() {
	 return driver.getTitle();
 }
 public boolean HeadingManageProgram() {
      return driver.findElement(heading).isDisplayed();
 }

}
