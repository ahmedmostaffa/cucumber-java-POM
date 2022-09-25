package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

public class RegisterSteps {

    @Given("register page is loaded")
    public void register_page_is_loaded() {
        System.out.println("register page is loaded");
    }

    @When("user enter following details")
    public void user_enter_following_details(DataTable dataTable) {
        List<List<String>> userList=dataTable.asLists(String.class);
        userList.forEach((List<String> subList)->{
            System.out.println(subList);
        } );
    }

    @Then("user register successfully")
    public void user_register_successfully() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("user enter following details by following table")
    public void user_enter_following_details_by_following_table(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> registerTable=dataTable.asMaps(String.class,String.class);
        /*registerTable.forEach((Map<String,String> block)->{
            System.out.println(block.toString());
        });
       */

    }

}
