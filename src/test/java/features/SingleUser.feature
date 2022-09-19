
@GET_SINGLE_OF_USER
Feature: get a single user
  I want to use this template for my feature file

  @GetUser
  Scenario: Title of your scenario
    Given base URL is set to from "BaseURL"
    And request header is set from "headers" json file 
    When request method is set to GET
    Then the response status code is 200
    And the response body have id equals to 2

