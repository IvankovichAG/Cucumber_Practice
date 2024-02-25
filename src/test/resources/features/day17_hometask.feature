Feature: Homework day 17
  @hw17 @B2G2-293 @B2G2-219
  Scenario: Login as advisor and create a new client
    Given user is login as an "advisor"
    Then user clicks on "Clients" button from left side menu
    When user create a new client
    |first name|Michael|
    |last name  |Jackson|
    |email     |Jackson5728@gmail.com|
    |phone number|123456789          |
    |password    |Password123        |
    Then user logout
    Then user login as a new client
      |email     |Jackson5728@gmail.com|
      |password   |Password123        |
    Then user validate that new client is created
    Then user logout



