package MainTests;
/* Automation Testing PDI
 * Based on TestNG and Page Object model framework
 * Objective: Verifies the Derivative creation of an Entity is successful
 * QA Automation: Jose Valenzo
 * */

import org.testng.annotations.Test;

import com.beust.testng.TestNG;

import Pages.EntitiesPage;
import Pages.HomePage;
import Pages.LogIn;
import Pages.LogOut;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

@SuppressWarnings("deprecation")
public class TestCase1 {
	private WebDriver driver;
	public static void main(String[] args){
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { TestCase1.class });
		testng.addListener(tla);
		testng.run();
	}
//Main Test
  @Test
  public void main() throws InterruptedException {
	  //Page Object Model
	  LogIn login = new LogIn(driver);
	  HomePage homepage = new HomePage(driver);
	  EntitiesPage entitiespage = new EntitiesPage(driver);
	  LogOut logout = new LogOut(driver);
	  //Automated Test Case
	  System.out.println("Step 1. Login into the application and navigating to the Entity List page by searching an Entity in the Quick Search text box");
	  login.EnterCredentials("", "");
	  System.out.println("Step 2. Click on the Entity name link and navigate to the Entity overview page");
	  homepage.SelectAllEntities();
	  entitiespage.ClickEntity();
	  System.out.println("Step 3. Click on the Capital Structure section and verify that Section is expanded and displayed");
	  entitiespage.ClickCapitalStructure();
	  System.out.println("Step 4. Click on the Create Derivative button and verify that Create Derivative page is displayed ");
	  entitiespage.ClickCreateDerivativeBtn();
	  System.out.println("Step 5. Verify all the validations in  Create Derivative page are displayed properly(Negetive and positive)");
	  entitiespage.ClickSaveBtn();
	  entitiespage.VerifyDerivativeExpectedError();
	  System.out.println("Step 6. Create a Derivative successfully and verify Derivative is created successfully");
	  entitiespage.CreateDerivative("Test1", "Common");
	  entitiespage.ClickSaveBtn();
	  entitiespage.ValidateDerivative("Test1");
	  entitiespage.DeleteDerivative("Test1");
	  logout.ClickLogOutLink();
  }
  
  //Script Settings
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 driver.get("");
		 
  }
  @AfterTest
  public void afterTest() {
	  driver.close();
  }
  
  
  
  @AfterMethod 
  public void takeScreenShotOnFailure(ITestResult testResult) throws IOException { 
  	if (testResult.getStatus() == ITestResult.FAILURE) { 
  		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
  		FileUtils.copyFile(scrFile, new File("C:\\errorScreenshots\\" + testResult.getName() + "-" 
  				+ Arrays.toString(testResult.getParameters()) +  ".jpg"));
  	} 
  }

}


