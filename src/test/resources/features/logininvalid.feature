@FIX10-258
Feature: US-001 Login Functionality [AutomationS1-MC]

  Background: user at login page
    Given user is on login page

  @FIX10-287
  Scenario: Users cannot log in with invalid credentials
    When enters wrong username
    Then enters wrong password
    And clicks login button
    Then user cannot login warning