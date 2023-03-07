Feature: user login module
  Scenario: user login with valid credentials
    Given user is on login page
    When enter username
    Then enter password
    Then click login button