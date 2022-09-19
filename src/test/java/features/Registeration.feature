@regitser
Feature: reg
  @datatable_1
  Scenario: check the registeration functionality
    Given register page is loaded
    When user enter following details
      | navv  | kut   | nav@auto.com | 12366  |
      | rdagh | adada | ada          | dadada |
    Then user register successfully

    @datatable_2
  Scenario: check the registeration functionality with different data
    Given register page is loaded
    When user enter following details
      | toaa | mous | toaa@auto.com | 256963 |
      Then user register successfully