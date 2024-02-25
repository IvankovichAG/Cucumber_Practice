Feature: Homework_day18
  @hw18 @B2G2-294 @B2G2-219
  Scenario Outline: Login and verify information for different roles
    Given user is on docuport login page
    When user login as a "<role>"
    When user clicks on "Received docs" button from left side menu
    Then user validate search button is displayed
    And user validate download button is displayed
    And user validate "Received docs" is displayed
    When user clicks on "My uploads" button from left side menu
    Then user validate search button is displayed
    And user validate download button is displayed
    And user validate "My uploads" is displayed
    Then user logout as a "<role>"
    Examples:
    |role|
    |advisor|
    |supervisor|
    |employee  |
    |client    |
