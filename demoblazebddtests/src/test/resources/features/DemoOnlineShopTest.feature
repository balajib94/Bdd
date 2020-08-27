Feature: This Feature is to validate if the user is able to place an order in Demoblaze

  Background: Launching the Browser
    Given the browser is launched
  Scenario: Adding Laptops and Placing an order as a guest user
    Given the user is on home page
    When the user searches for 'Laptops'
    And the user adds the given products
      |Sony vaio i5|
      |Dell i7 8gb|
    And the user navigates to cart
    And the user deletes the product from cart
      |Dell i7 8gb|
    And the user clicks on Place Order
      |Name|TestUser|
      |Country|India|
      |City   |Chennai|
      |Credit card| 5231XXXXXXXXX123 |
      |Month      | 12               |
      |Year       | 2022             |
    Then the purchase id should be generated
    And the purchase amount should match with expected value
    And the user clicks on OK
