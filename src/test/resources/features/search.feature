Feature: Searching from Store page
  As a customer
  I want to search a product from the store page
  So that I can easily find products to buy

  Scenario Outline: Searching existing products
    Given I am on the Store page
    When I search for <product>
    Then I should see products that only relate to <product>

    Examples:
    |product|
    |"jeans"|
    |"shirt"|

    Scenario Outline: Searching non existent product
      Given I am on the Store page
      When I search for non existent product <product>
      Then I should see a product not found message for <product>
      Examples:
      |product|
      |"non-existent product1"|
      |"Samsung Galaxy phone charger"|
