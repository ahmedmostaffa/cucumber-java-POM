package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;



public class LoginPage  {
	public WebDriver driver;
	By pageHeader = By.cssSelector("span.title");
	By username = By.cssSelector("input#user-name");
	By password = By.cssSelector("input#password");
	By errorMessage=By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean getErrorMessage() {
		return driver.findElement(errorMessage).isDisplayed();
	}
	
	public void SetLoginCredentials(String userName,String Password){
		driver.findElement(username).sendKeys(userName);
		driver.findElement(password).sendKeys(Password+ Keys.ENTER);
	}
	
	public boolean getPageHeader() {
		return driver.findElement(pageHeader).isDisplayed();
	}
	
	
	
	
	
	
	
	
	

}
