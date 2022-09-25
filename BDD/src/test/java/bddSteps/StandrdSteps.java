package bddSteps;

import Pages.LoginPageHrm;
import TestCases.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Cookie;
import org.testng.Assert;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class StandrdSteps extends BaseTest {

        LoginPageHrm hrmObjct;

        @Given("User on HRM login page")
        public void user_on_hrm_login_page() {
                hrmObjct= new LoginPageHrm(driver);
        }
        @When("User logging in with valid username {string} and password {string}")
        public void user_logging_in_with_valid_username_and_password(String username, String password) {

                hrmObjct.userLogin(username,password);

        }

        @Then("user logged in successfully")
        public void userLoggedInSuccessfully() {
                Assert.assertTrue(driver.getCurrentUrl().contains("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList"));
        }

        @And("authentication cookie is created and stored")
        public void authentication_cookie_is_created_and_stored() {
                File file =new File("cookie.data");
                try
                {
                        file.delete();
                        file.createNewFile();
                        FileWriter fileWrite = new FileWriter(file);
                        BufferedWriter Bwrite = new BufferedWriter(fileWrite);
                        for(Cookie ck : driver.manage().getCookies())
                        {
                                Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));
                                Bwrite.newLine();
                        }
                        Bwrite.close();
                        fileWrite.close();
                } catch (IOException e) {
                        throw new RuntimeException(e);
                }

        }
}