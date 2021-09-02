Feature: As a offical I want to be able to record branch results so I can get the points

@addresult
  Scenario Outline:    I want to be able to add results to a branch

    Given    I have registered <result> for "<branch>"
    When I press enter
    Then    The <points> should be written on the screen
    Examples:
      | result | branch | points |
      | 12     | 100m   | 651    |
