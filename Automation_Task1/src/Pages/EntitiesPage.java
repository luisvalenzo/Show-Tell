package Pages;
/* Entities Page Class
 * Class and Methods used for Entities Page
 * QA Automation: Jose Luis Diaz Valenzo
 * */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.google.common.base.Verify;

public class EntitiesPage {
	WebDriver driver;
	By EntityName = By.linkText("!!!!!! A Tool Company");
	By EntityOverview = By.id("lblContent");
	By CapitalStructure = By.id("CapitalStructureListSpan");
	By CSTable = By.id("tblEntityCapitalStructureList");
	By CreateDerivativeBtn = By.id("CreateDerv");
	By DerivativeSecurityDetail = By.cssSelector(".contentBoxHeader.personnelSummaryPadding");
	By DerivativeSaveBtn = By.id("btnEntityDerivativeDetailSave");
	By ExpectedErrorsHead = By.xpath("//*[@id='validationMessageHeader']");
	By ExpectedErrorSecurityName = By.xpath("//*[@id='DerivativeSecurityDetailErrorList']/ul/li[1]");
	By ExpectedErrorUnderlyingSecurity = By.xpath("//*[@id='DerivativeSecurityDetailErrorList']/ul/li[2]");
	By DerivativeName = By.id("txtEntityDerivativeSecurityName");
	By UnderlyingSecurity = By.id("ddUnderlyingSecurityList");
	
	 public EntitiesPage(WebDriver driver){
		 this.driver = driver;
	 }
	 
	 public void ClickEntity(){
		 driver.findElement(EntityName).click();
		 Verify.verify(driver.findElements(EntityOverview).size()!=0);
	 }
	 
	 public void ClickCapitalStructure() throws InterruptedException{
		 Thread.sleep(2000);
		 driver.findElement(CapitalStructure).click();
		 Verify.verify(driver.findElements(CSTable).size()!=0);
	 }
	 
	 public void ClickCreateDerivativeBtn() throws InterruptedException{
		 Thread.sleep(2000);
		 driver.findElement(CreateDerivativeBtn).click();
		 Verify.verify(driver.findElements(DerivativeSecurityDetail).size()!=0);
	 }
	 
	 public void ClickSaveBtn(){
		 driver.findElement(DerivativeSaveBtn).click();
	 }
	 
	 public void VerifyDerivativeExpectedError(){
		 Verify.verify(driver.findElements(ExpectedErrorsHead).size()!=0);
		/* if (driver.findElements(ExpectedErrorsHead).size()!=0){
			 System.out.println("Error Head is displayed successfully");
		 }*/
		 Assert.assertTrue(driver.findElements(ExpectedErrorsHead).size()!=0);
		 Assert.assertTrue(driver.findElements(ExpectedErrorSecurityName).size()!=0);
		 Assert.assertTrue(driver.findElements(ExpectedErrorUnderlyingSecurity).size()!=0);
	 }
	 
	 public void CreateDerivative(String name, String underlingsec){
		 driver.findElement(DerivativeName).sendKeys(name);
		 Select select = new Select(driver.findElement(UnderlyingSecurity));
			select.selectByVisibleText(underlingsec); 
	 }

	public void ValidateDerivative(String derivativename) {
		By DerivativeName = By.linkText(derivativename);
		Assert.assertTrue(driver.findElements(DerivativeName).size()!=0);
	}
	
	public void DeleteDerivative(String derivativename) throws InterruptedException{
		By DerivativeName = By.linkText(derivativename);
		driver.findElement(DerivativeName).click();
		By DerivativeDeleteBtn = By.id("btnDeleteRefType1");
		driver.findElement(DerivativeDeleteBtn).click();
		driver.findElement(By.xpath("//*[@id='btnOk']")).click();
		Thread.sleep(2000);	
	}
	 
}
