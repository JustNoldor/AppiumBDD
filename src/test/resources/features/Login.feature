Feature: Check user login app

  @login
  Scenario: User login to app
    Given I go to the Login Page
    When I select to shopping region
    When I log in with valid credentials
    Then I should be in the products page
