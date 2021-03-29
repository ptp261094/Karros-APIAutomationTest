@demo	
Feature: Verify	

  Scenario: Happy path
    Given I set up happy path
    When I send a GET request with happy path
    Then The status code is 200
    And The id is 1
    And The title is "Post 1"

  Scenario: Negative path
    Given I set up negative path
    When I send a GET request with negative path
    Then The status code is 404
    And The response is empty