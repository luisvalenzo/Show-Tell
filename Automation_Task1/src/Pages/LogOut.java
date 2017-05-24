package Pages;
/* LogOut Page Class
 * Class and Methods used for LogOut Page
 * QA Automation: Jose Luis Diaz Valenzo
 * */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOut {
	WebDriver driver;
	By logoutlink = By.partialLinkText("Logout");
	 public LogOut(WebDriver driver){
		 this.driver = driver;
	 }
	 
	 public void ClickLogOutLink(){
		 driver.findElement(logoutlink).click();
	 }
}
