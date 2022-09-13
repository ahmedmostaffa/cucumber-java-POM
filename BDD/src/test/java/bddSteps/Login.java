package bddSteps;

import Pages.LoginPage;
import TestCases.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class Login extends BaseTest {

    LoginPage loginObject;
    @Given("User on login page")
    public void userOnLoginPage() {
        loginObject = new LoginPage(driver);

       // Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/"));
    }

    @When("User enter valid username {string} and password {string}")
    public void userEnterValidCredentials(String username, String password) {
        loginObject.userLogin(username,password);
    }

    @Then("User redirected to landing page")
    public void userRedirectedToLandingPage() {
        Assert.assertTrue(loginObject.getPageHeader());
    }

}