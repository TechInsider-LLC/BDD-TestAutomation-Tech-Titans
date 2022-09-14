@regression


Feature: Wire Transfer
  Scenario: Incoming Wire Transfer
    Given User on Ebanq page
    When User Logs in and click on transfers then click on Incoming wire transfer
    And User Select account and click on continue button
    Then User sees bank details
    