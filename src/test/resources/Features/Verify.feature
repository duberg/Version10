Feature: I want to check our verify so I don't make mistakes

  @genderVerify
  Scenario Outline: I should only be able to enter a legal gender
    Given I have entered "<gender>"
    When I press enter
    Then gender "<result>" should be displayed on the screen "<gender>"
    Examples:
      | gender | result  |
      | FEMALE | valid   |
      |        | invalid |
      | MALE   | valid   |
      | M      | valid   |
      | F      | valid   |
      | G      | invalid |


  @stringVerify
  Scenario Outline: I should not be able to add an empty string
    Given I have entered firstname "<name>"
    When I press enter
    Then firstname "<result>" should be displayed on the screen "<name>"
    Examples:
      | name  | result  |
      | Hanna | valid   |
      |       | invalid |

  @stringlastnameVerify
  Scenario Outline: I should not be able to add an empty string
    Given I have entered lastname "<name>"
    When I press enter
    Then lastname "<result>" should be displayed on the screen "<name>"
    Examples:
      | name     | result  |
      | Karlsson | valid   |
      |          | invalid |

  @ssnVerify
  Scenario Outline: I should only be able to add 6 digits
    Given I have typed ssn <ssn>
    When I press enter
    Then ssn <result> should be displayed on the screen for ssn <ssn>
    Examples:
      | ssn     | result |
      | 5       | 404    |
      | 123456  | 200    |
      | 1234567 | 404    |
      | -1      | 404    |
      | -123456 | 404    |
