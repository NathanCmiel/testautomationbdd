Feature: Trello login functionality

  Scenario: User can login to Trello with valid credentials
    Given User goes to the Trello homepage
    And User clicks on login link
    When User is on login page
    And User logs in with valid credentials
    Then User should be able to see Trello boards page