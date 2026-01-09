Feature: Checkout Page Functionality
    In order to complete my purchase
    As a registered customer
    I want to be able to access the checkout page Successfully

  Scenario Outline: Access Checkout Page
    Given Customer has added items to the cart
    When Customer proceeds to checkout and fill in <firstName> and <lastName> and <address> and <city> and <postcode> and <email> properly
    Then Order is placed successfully
    Examples:
      | firstName | lastName | address       | city      | postcode | email |
      | "John"    | "Doe"    | "123 Main St" | "Anytown" | "12345"  | "myuser1@gmail.com" |