@FIX10-258
Feature: US-001 Login Functionality [AutomationS1-MC]

  Background: user at login page
    Given user is on login page

  @FIX10-285 @wip
  Scenario: Users can log in with valid credentials
    When enters username
    Then enters password
    And clicks login button
    Then user logged in
