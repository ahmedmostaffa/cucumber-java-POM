@ApiAuth
Feature: as a user I wanna to create user successfully
          to get access token
  @CreateUser
  Scenario Outline: check the api authentication
    Given request body is set to be <index>
    When user set request header from ".//resources//TestData//Headers.json"
    Then status code should be 2000

    Examples: 
      | index |
      |     0 |
      |     1 |
      |     2 |
      |     3 |
      |     4 |
      |     5 |
      |     6 |
      |     7 |
      |     8 |
      |     9 |
