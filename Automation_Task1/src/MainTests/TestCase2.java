package MainTests;
/* Utility Script
 * Based on TestNG and Object Page model framework
 * Objective: Delete created Derivative from an Entity
 * QA Automation: Jose Luis Diaz Valenzo
 * */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.EntitiesPage;
import Pages.HomePage;
import Pages.LogIn;
import Pages.LogOut;

public class TestCase2 {
	WebDriver driver;
  @Test
  public void MainTestCase2() throws InterruptedException {
	  LogIn login = new LogIn(driver);
	  HomePage homepage = new HomePage(driver);
	  EntitiesPage entitiespage = new EntitiesPage(driver);
	  LogOut logout = new LogOut(driver);
	  
	  //
	  login.EnterCredentials("qaautomation1", "2apples");
	  
	  homepage.SelectAllEntities();
	  entitiespage.ClickEntity();
	  
	  entitiespage.ClickCapitalStructure();
	  entitiespage.DeleteDerivative("Test1");
	  logout.ClickLogOutLink();
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\U56996\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 driver.get("https://ptrp-ux-ctadmin.ctadvantage.com/");
		 
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }
}
