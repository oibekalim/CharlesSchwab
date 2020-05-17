
@smoke
Feature: Login feature

  Scenario Outline: Negative scenario. Login with wrong credentials
    Given User on the home page schwab.com
    Then User "<tabAccount>" logs in wrong password and wrong loginID

    Examples:
      | tabAccount    |
      | Accounts Summary  |
      | Positions              |
      | Order Status        |
