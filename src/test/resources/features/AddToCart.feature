Feature: Add to cart functionality

  Scenario: User adds a product to the cart successfully
    Given the customer is on the product page
    When the customer clicks on the Add to Cart button
    Then the product should be added to the cart