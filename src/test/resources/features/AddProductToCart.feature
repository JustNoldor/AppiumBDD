Feature: Validate Add Product to Cart
  Background:
    Given I go to the Login Page
    When I select to shopping region
    When I log in with valid credentials

  @validateAddProductToCart
  Scenario: User Add Product to Cart
    Given I go to the Products Page
    When I add a product to cart
    Then I should see cart button value increased
