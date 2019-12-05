Feature: Wales medical check eligibility journey

  As a person from Wales
  I need to know what help I can get with my NHS costs
  So that I can get the treatment I need

   Scenario: 1- Wales individual medical check eligibility request
    Given I am a person from Wales
    When I put my circumstances into the Checker tool
      | Bday | Bmonth | Byear | Partner | benefits | pregnant | injury | diabetes | glaucoma | carehome | savings |
      | 03   | 11     | 1976  | Yes     | No       | Yes      | No     | Yes      | No       | No       | No      |
     Then I should get a result of whether I will get help or not
