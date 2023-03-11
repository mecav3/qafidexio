@FIX10-258
Feature: US-001 Login Functionality [AutomationS1-MC]

  Background: user at login page
    Given user is on login page

  @FIX10-311
  Scenario: Users can log in with valid credentials using ENTER key
    When enters username
    Then enters password
    And hits enter button
    Then user logged in
