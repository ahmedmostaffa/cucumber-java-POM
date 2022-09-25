Feature: List All resources

  Scenario: get all resources
    Given user navigated to baseURL "baseurl"
    When user query list of books path "path"
    Then books list is displayed
