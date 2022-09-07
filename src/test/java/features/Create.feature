Feature : Create user
  @post-api-authentication
  scenario: check create user successfully
          Given base URL is set from "BaseURL"
          And request header set to value from
          When request body is set to be "TestData.json"
          Then response status code should be 200