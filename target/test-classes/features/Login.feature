@login
Feature: As a user I want to login with username and password
  	 So that I can access my timesheets.

  @smoke
  Scenario: check the login functionality
    Given Login page is loaded
    When user enter username "standard_user" and Password "secret_sauce"
    Then user is navigated to the dashboard page

  @sanity
  Scenario Outline: check the login functionality with multiple username and Password
    Given Login page is loaded
    When user enter username "<user>" and Password "<password>"
    Then error message will be displayed

    Examples:
      | user  | password     |
      | Admin | admin1ADada  |
      | sda   | admin12DAdad |
