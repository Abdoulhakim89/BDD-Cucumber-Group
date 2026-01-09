Feature: Login for customer
  As a registered customer
  I want to be able to login to AskOmDch website
  So that I can do online shopping

  Scenario Outline: Successful login
    Given I am on the account login page
    When I enter valid <username> and <password>
    Then I am directed to the account information page after login
    Examples:
    |username|password|
  |"My-user1"|"myuser1Password"|
  |"john_doe"|"Password@Doe"|

