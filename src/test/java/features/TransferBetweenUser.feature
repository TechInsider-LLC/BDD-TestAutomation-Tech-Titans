Feature: Transfer Between Users
  Scenario: User should be able to successfully transfer between users
    Given User successfully log in
    When User click on TransferBetweenUser
    When User fill out the form and confirm
    Then User get verify message