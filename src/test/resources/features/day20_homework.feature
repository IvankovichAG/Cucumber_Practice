Feature: validation rows per page advisor
@hw20 @B2G2-310 @B2G2-219
Scenario: login as advisor and validate rows per page
    Given user is on docuport login page
    When user login as a "advisor"
    And user clicks on "Leads" button from left side menu
    Then user validate that Rows per page shows by default 10
    And user change rows per page to 5
    And user validates rows per page is showing 5
    Then user clicks on "Users" button from left side menu
    And user validate that Rows per page shows by default 10
    And user change rows per page to 5
    And user validates rows per page is showing 5


