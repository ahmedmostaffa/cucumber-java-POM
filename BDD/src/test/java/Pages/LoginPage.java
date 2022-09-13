package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginPage extends BasePage  {


	public LoginPage(WebDriver driver) {
		super(driver);
    }
	@FindBy(css = "span.title")
	public WebElement pageHeader;

	@FindBy(xpath = "//*[@id=\"user-name\"]")
	public WebElement usernameTxtBox;

	@FindBy(xpath = "//*[@id=\"password\"]")
	public WebElement passwordTxtBox;

	@FindBy(xpath = "//*[@id=\"login-button\"]")
	public WebElement loginBtn;

	@FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
	WebElement errorMessage;



	public boolean getErrorMessage() {
		return  errorMessage.isDisplayed();
	}
	
	public void userLogin(String userName,String password){


		setTextElement(usernameTxtBox,userName);
		setTextElement(passwordTxtBox,password);
		clickButton(loginBtn);

	}
	
	public boolean getPageHeader() {
		return pageHeader.isDisplayed();
	}
	
	
	
	
	
	
	
	
	

}
