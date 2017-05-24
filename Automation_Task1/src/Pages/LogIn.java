package Pages;
/* LogIn Page Class
 * Class and Methods used for LogIn Page
 * QA Automation: Jose Luis Diaz Valenzo
 * */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogIn {
	WebDriver driver;
	 By username = By.id("ctl00_cntPublicMain_loginname");
	 By password = By.id("ctl00_cntPublicMain_password");
	 By loginBtn = By.id("ctl00_cntPublicMain_imgBtnLogin");
	 
	 public LogIn(WebDriver driver){
		 this.driver = driver;
	 }
	 
	 public void EnterCredentials(String user, String pwd){
		 driver.findElement(username).sendKeys(user);
		 driver.findElement(password).sendKeys(pwd);
		 driver.findElement(loginBtn).click();
	 }

}
