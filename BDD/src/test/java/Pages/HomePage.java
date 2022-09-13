package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(css = "span.title")
    WebElement pageHeader;

    @FindBy(css = "input#user-name")
     WebElement usernameTxtBox;

    @FindBy(css = "input#password")
      WebElement passwordTxtBox;

    @FindBy
      WebElement errorMessage;

    public boolean getErrorMessage() {
        return errorMessage.isDisplayed();
    }

    public void SetLoginCredentials(String userName,String password){
        setTextElement(usernameTxtBox,userName);
        setTextElement(passwordTxtBox,password);
    }

    public boolean getPageHeader() {
        return pageHeader.isDisplayed();
    }




}
