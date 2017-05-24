package Pages;
/* Home Page Class
 * Class and Methods used for Home Page
 * QA Automation: Jose Luis Diaz Valenzo
 * */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage {
	WebDriver driver;
	By entitiesdBtn = By.id("liEntities");
	By selectdropdown = By.id("drpFavoriteEntities");
	
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	public void ClickEntitiesBtn(){
		Assert.assertTrue(driver.findElements(entitiesdBtn).size()!=0, "Test");
		driver.findElement(entitiesdBtn).click();
	}
	
	public void SelectAllEntities(){
		Select select = new Select(driver.findElement(selectdropdown));
		Assert.assertTrue(driver.findElements(selectdropdown).size()!=0, "Select is displayed");
		select.selectByVisibleText("All Entities");
	}
}
