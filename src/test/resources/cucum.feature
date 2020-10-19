Feature: Supermarket Operations

  Scenario: Successfully add a product that is in the supermarket
    #    True means that its in the supermarket product list
    Given Supermarket with 3 products
    When Adding one true product
    Then Nothing happens

  Scenario: Cannot add a product to the cart that is not in the Supermarket
    #    False means that its not in the supermarket product list
    Given Supermarket with 3 products
    When Adding one false product
    Then UnknownItemException raises

  Scenario: Correct cart value after adding some items
    Given Supermarket with 3 products
    When Adding one true product
    Then total value must be 15