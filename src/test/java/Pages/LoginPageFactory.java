package Pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
    public WebDriver driver;
    @FindBy(css = "span.title")
    WebElement pageHeader;

    @FindBy(css = "input#user-name")
     WebElement username;

    @FindBy(css = "input#password")
      WebElement password;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
      WebElement errorMessage;

    public LoginPageFactory(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean getErrorMessage() {
        return errorMessage.isDisplayed();
    }

    public void SetLoginCredentials(String userName,String Password){
        username.sendKeys(userName);
        password.sendKeys(Password+ Keys.ENTER);
    }

    public boolean getPageHeader() {
        return pageHeader.isDisplayed();
    }




}
