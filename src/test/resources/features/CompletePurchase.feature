Feature: Validate Completing to Purchase Phase
  Background:
    Given I go to the Login Page
    When I select to shopping region
    When I log in with valid credentials

  @validateCompletePurchase
  Scenario: User Complete to Purchase
    Given I go to the Products Page
    When I add two product to cart
    Then I should see cart button value two increased
    When I click cart button
    Then I should be in the cart page
    Then I should see total items amount
    When I click complete purchase button
    Then I should be in the web view page

