@GetListUser
Feature: Get list of users

  @smokeapi
  Scenario: check endpoint get list of users
    Given the base url is navigated
    When user enter header content type equals to "application/json"
    And enter end point "users?page=2"
    Then the status code will be 200
    And response time is less than 200
