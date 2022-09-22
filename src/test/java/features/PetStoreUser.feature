Feature: operations about user
  Scenario: Creating, uodating, getting, and deleting a user
    Given Admin has all the data from creating
    When admin creates a user
    When admin gets the user
    When admin updates the user
    When admin gets the user again
    When Admin deletes the user
    Then User account should no longer be available