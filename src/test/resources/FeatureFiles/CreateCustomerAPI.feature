Feature: Validate Create User API
  This feature file have scenarios related to the create customer API

  Scenario: Validate create customer api with valid username and email
    Given I set the auth for the Create Customer API
    When I pass "testingbluestacksformyself@gmail.com" as the email
    And I pass the sample description "This is the sample description"
    And I send the "post" request to the customer
    Then I should be able to create the customer
    And the email id in the response should be "testingbluestacksformyself@gmail.com"
    And the details in the description should be "This is the sample description"