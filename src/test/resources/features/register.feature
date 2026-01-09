Feature: Registering a new customer

  As a customer
  I want to be able to register for an account
  So that I can do online shopping

  Scenario Outline: Successful registration
    Given I am on the account registration page
    When I enter valid <username> <email> and <password>
    Then I should be directed to the accounts information page
    Examples:
      |username|email|password|
      |"My-user1"|"myuser1@gmail.com"|"myuser1Password"|
