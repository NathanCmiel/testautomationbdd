
Feature: Trello credential logics

    @new
    Scenario: Verified user can enter email and password
        Given User goes to the Trello homepage
        And User goes to the signup page
        And user clicks on login link
        When user enters email and password for verified users
            | nijatmn1@gmail.com | pass123! |
            | nathan2@gmail.com  | pass900! |
            | ebony9@gmail.com   | pass100! |
        Then user should not see any error

    @brandNew
    Scenario Outline: Blocked user login results in error message
        Given User goes to the Trello homepage
        And User clicks on login link
        When user enters credentials with "<username>" and "<password>"
        Then User should be able to see an error message
        Examples: Positive test cases
            | username | passsword |
            | dake131  | pass223!  |
            | make131  | pass323!  |
