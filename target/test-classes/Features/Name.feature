Feature: I need to be able to add contestants so I can log their results

  @gender
  Scenario Outline: add your gender

    Given    I have also entered gender"<gender>" and <sheetNum> is assigned
    When    I press enter
    Then    result "<result>" should be displayed on the screen for gender "<gender>" and <sheetNum>
    Examples:
      | gender | result | sheetNum |
      | F      | F      | 1        |
      | M      | M      | 0        |

  @firstname
  Scenario Outline: add a firstname

    Given    I have entered firstname "<firstname>" and  <sheetNum> is assigned
    When    I press enter
    Then    then "<result>" should be displayed on the screen for firstname "<firstname>" and <sheetNum>

    Examples:
      | firstname | result | sheetNum |
      |           |        | 1        |
      | Lisa      | Lisa   | 1        |
      | Markus    | Markus | 0        |

  @lastname
  Scenario Outline: add a lastname

    Given    I have also entered lastname "<lastname>" and <sheetNum> is assigned
    When    I press enter
    Then    then "<result>" should be displayed on the screen for lastname "<lastname>" and <sheetNum>
    Examples:
      | lastname | result | sheetNum |
      |          |        | 1        |
      | Lisa     | Lisa   | 1        |

  @ssn
  Scenario Outline: add ssn

    Given    I have ssn<ssn> and <sheetNum> is assigned
    When    I press enter
    Then    <result> should be displayed on the screen for ssn <ssn> and <sheetNum>
    Examples:
      | ssn    | result | sheetNum |
      | 555555 | 555555 | 1        |
      | 444444 | 444444 | 1        |

