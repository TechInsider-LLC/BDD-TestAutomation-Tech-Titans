Feature: Operations about user
  Scenario: Creating, Updating, Getting and  Deleting User
    Given Admin has all the date for creating a user
    When Admin creates a user
    And Admin gets the user
    And Admin updates the user
    And Admin gets the user
    And Admin deletes the user
    Then Admin shoouldn't see the user