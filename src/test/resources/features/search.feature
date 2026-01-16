@searchFromStorePage

Feature: Searching from Store page
  As a customer
  I want to search a product from the store page
  So that I can easily find products to buy

  Background: Customer is on the store page
    Given the customer is on the Store page

  Scenario Outline: Searching existing products
    When customer searches for <product>
    Then customer should see products that only relate to <product>

    Examples:
    |product|
    |"jeans"|
    |"shirt"|

    Scenario Outline: Searching non existent product
      When I search for non existent product <product>
      Then I should see a product not found message for <product>
      Examples:
      |product|
      |"non-existent product1"|
      |"Samsung Galaxy phone charger"|
