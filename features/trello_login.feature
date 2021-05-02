@smoke
Feature: Trello login functionality

@bob
  Scenario: User can login to Trello with valid credentials
    Given User goes to the Trello homepage
    And User clicks on login link
    When User is on login page
    And User logs in with valid credentials
    Then User should be able to see Trello boards page

@dev
  Scenario: User cannot login to Trello with invalid credentials
    Given User goes to the Trello homepage
    And User clicks on login link
    When User is on login page
    And User logs in with invalid credentials
    Then User should be able to see an error message