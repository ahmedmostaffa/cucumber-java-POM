package stepDefinitions;

import org.testng.Assert;

import Pages.DashboardPage;
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
	    // Write code here that turns the phrase above into concrete actions
	   loginPage.SetLoginCredentials(username, pass); 
	
	}
	@Then("error message will be displayed")
	public void error_message_will_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	   Assert.assertTrue(loginPage.getErrorMessage());
	}
	@Then("user is navigated to the dashboard page")
	public void user_is_navigated_to_the_dashboard_page() {
	    // Write code here that turns the phrase above into concrete actions
		 Assert.assertFalse(loginPage.getPageHeader());
	}
	

}
