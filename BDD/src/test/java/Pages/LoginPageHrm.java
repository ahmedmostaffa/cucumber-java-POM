package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageHrm extends BasePage {

    public LoginPageHrm(WebDriver driver)
    {
        super(driver);
    }

    @FindBy (xpath ="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")
    public WebElement usernameTxtBox;

    @FindBy (xpath ="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")
    public WebElement passwordTxtBox;

    @FindBy (xpath ="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
    public WebElement loginBtn;

    public void userLogin(String userName,String password){


        setTextElement(usernameTxtBox,userName);
        setTextElement(passwordTxtBox,password);
        clickButton(loginBtn);

    }

}
