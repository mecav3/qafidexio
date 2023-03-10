@FIX10-258
Feature: US-001 Login Functionality [AutomationS1-MC]

  Background: user at login page
    Given user is on login page

  @FIX10-300
  Scenario: Users cannot log in with empty user input field
    When enters username
    And clicks login button
    Then user get empty field warning