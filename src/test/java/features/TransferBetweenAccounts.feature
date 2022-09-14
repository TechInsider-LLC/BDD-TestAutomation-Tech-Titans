@regression
Feature: Transferring money
  Scenario: Transferring money between accounts
    Given user has given credentials
    When user transfers money between accounts
    Then User sees success transfer message
    When user logs out
    Then user is back to home page