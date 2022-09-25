package stepDefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.BaseTest;

public class LoginSteps extends BaseTest {
	LoginPage loginPage;
	@Given("Login page is loaded")
	public void login_page_is_loaded() {
		loginPage=new LoginPage(driver);
	}
	@When("user enter username {string} and Password {string}")
	public void user_enter_username_and_password(String username, String pass) {
	   loginPage.SetLoginCredentials(username, pass);
	}
	@Then("error message will be displayed")
	public void error_message_will_be_displayed() {
	   Assert.assertTrue(loginPage.getErrorMessage());
	}
	@Then("user is navigated to the dashboard page")
	public void user_is_navigated_to_the_dashboard_page() {
		 Assert.assertFalse(loginPage.getPageHeader());
	}


}
