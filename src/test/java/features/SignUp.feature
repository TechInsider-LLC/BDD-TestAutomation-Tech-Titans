@regression
  Feature: User sing up for EBANQ account
    Scenario: User sing up successfully
      Given Customer go to EBANQ homepage
      When Customer enter all the requirements
      Then Customer see success message

    Scenario: Sign up as Corporate
      Given User go to EBANQ page
      When User enter all requirements
      Then User see success message

    Scenario: Sign up failed
      Given User at EBANQ page
      When User signup without info
      Then User see message