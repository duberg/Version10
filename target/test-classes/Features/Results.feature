Feature: As an official I want to be able to record branch results so I can get the points Decathlon

  @trackMen
  Scenario Outline: I want to record track and get results

    Given    I have entered track <results> in seconds for "<branch>"
    When    I ask for results
    Then    I should get track <points> back
    Examples:
      | results | points | branch |
      | 12      | 651    | 100m   |
      | 18      | 0      | 100m   |
      | 50      | 815    | 400m   |
      | 82      | 0      | 400m   |
      | 15      | 850    | 110mH  |
      | 29      | 0      | 110mH  |


  @lengthMen
  Scenario Outline:I want to record cm
    Given I ask for cm <result> for "<branch>"
    When I ask for cm results
    Then I should get cm <points> back
    Examples:
      | result | points | branch        |
      | 750    | 935    | Long jump     |
      | 224    | 0      | Long jump     |
      | 14.35  | 750    | Shot put      |
      | 1.5    | 0      | Shot put      |
      | 190    | 714    | High jump     |
      | 76     | 0      | High jump     |
      | 50     | 870    | Discus throw  |
      | 4.0    | 0      | Discus throw  |
      | 450    | 760    | Pole vault    |
      | 102    | 0      | Pole vault    |
      | 66.6   | 838    | Javelin throw |
      | 7.1    | 0      | Javelin throw |

  @trackWomen
  Scenario Outline:I want to record track for women and get results

    Given    I have entered women track <results> in seconds for "<branch>"
    When    I ask for results
    Then    I should get track <points> back
    Examples:
      | results | points | branch |
      | 15      | 842    | 100mH  |
      | 26.5    | 0      | 100mH  |
      | 25      | 887    | 200m   |
      | 42.1    | 0      | 200m   |


  @lengthWomen
  Scenario Outline:  I want to record cm for length branches
    Given I ask for cm <result> for women "<branch>"
    When I ask for cm results
    Then I should get cm <points> back
    Examples:
      | result | points | branch        |
      | 150    | 621    | High jump     |
      | 75.6   | 0      | High jump     |
      | 15     | 861    | Shot put      |
      | 1.5    | 0      | Shot put      |
      | 600    | 850    | Long jump     |
      | 213    | 0      | Long jump     |
      | 55.5   | 967    | Javelin throw |
      | 3.8    | 0      | Javelin throw |

  @m/ss
  Scenario Outline: I want to record minutes and seconds for hurdles
    Given I ask for <minutes> and <seconds> for "<branch>" for "<gender>"
    When I ask for results
    Then    I should get track <points> back
    Examples:
      | minutes | seconds | points | branch | gender |
      | 4       | 10      | 881    | 1500m  | Male   |
      | 7       | 55      | 0      | 1500m  | Male   |
      | 2       | 20      | 824    | 800m   | Female |
      | 4       | 11      | 0      | 800m   | Female |











