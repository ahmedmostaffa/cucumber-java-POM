Feature: User Login

  @function
  Scenario Outline: User Login
    Given User on login page
    When  User enter valid username "<username>" and password "<password>"
    Then  User redirected to landing page

    Examples:

        | username      |  password     |
        | standard_user | secret_sauce  |

