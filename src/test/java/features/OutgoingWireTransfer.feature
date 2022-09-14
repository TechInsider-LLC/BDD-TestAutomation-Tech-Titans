@regression

Feature: Outgoing wire Transfer

  Scenario: Outgoing Wire Transferring
    Given User on the Ebanq page
    When User Logs in and click on transfers then click on Outgoing wire Transfer
    And Select account and fills the form then click on continue
    And User on Transfer details page Scrolls down end click on continue
    Then Users Transaction success

  Scenario: OutGoing Wire Transfer Unsuccessfully
    Given User on the Ebanq page
    When User Logs in and click on transfers then click on Outgoing wire Transfer
    And User Scroll down click on continue button
    Then User Should get error message