@FIX10-258
Feature: US-001 Login Functionality [AutomationS1-MC]

  Background: user at login page
    Given user is on login page

  @FIX10-310 @wip
  Scenario: Users can log in with valid credentials
    Then enters password
    Then check password is hidden
