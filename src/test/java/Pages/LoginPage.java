package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;



public class LoginPage extends BasePage {

	By pageHeader = By.cssSelector("span.title");
	By username = By.cssSelector("input#user-name");
	By password = By.cssSelector("input#password");
	
	
	public By errorMessage=By.xpath("//*[@id=\'login_button_container\']/div/form/div[3]/h3/text()");
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	public boolean getErrorMessage() {
		return driver.findElement(errorMessage).isDisplayed();
	}
	
	public DashboardPage SetLoginCredentials(String userName,String Password){
		driver.findElement(username).sendKeys(userName);
		driver.findElement(password).sendKeys(Password+ Keys.ENTER);
		return new DashboardPage(driver);
	}
	public boolean getPageHeader() {
		return driver.findElement(pageHeader).isDisplayed();
	}
	
	
	
	
	
	
	
	
	

}
