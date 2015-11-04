Feature: HomePage Objects
  As a Customer
  I want to explore all the products and info 
  So that I can sign up for the best package

  @Smoke
  Scenario Outline: Home Page products
    Given I open the home page
    When I explore the "<products>"
      | HEALTH INSURANCE | OTHER INSURANCE  | BETTER HEALTH        |
      | Singles          | Pet Insurance    | Healthy recipes      |
      | Couples          | Travel Insurance | Better health guides |
      | Families         | Life Insurance   | Betterhealthguides   |
    Then I should see all the required package info

    Examples: list of products
      | products         |
      | HEALTH INSURANCE |
      | OTHER INSURANCE  |
      | BETTER HEALTH    |
