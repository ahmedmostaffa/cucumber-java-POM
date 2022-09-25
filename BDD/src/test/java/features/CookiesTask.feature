Feature: Login with cookie without UI

  Scenario: Standard Login
    Given User on HRM login page
    When User logging in with valid username "Admin" and password "admin123"
    Then user logged in successfully
    And authentication cookie is created and stored

