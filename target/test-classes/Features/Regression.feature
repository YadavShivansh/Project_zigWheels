Feature: ZigWheels Regressions

  @Regression
  Scenario: used car and search bar Hover validation
    Given Homepage of Zigwheels
    When user Hover on Used Cars
    Then Dropdown is displayed
    When User Clicks on the search Bar
    Then Search Options is displayed

  @Regresion
  Scenario Outline: Displays Bikes by Applying displcement filter
    Given Homepage of Zigwheels
    When the User clicks on New Bikes
    And the user clicks displacement filter
    Then the user selects bike a displacement range "<range>"
    Then Displays Bike name and Displacement

    Examples: 
      | range               |
      | 126cc - 150cc bikes |

  Scenario Outline: Validations of New Cars Fuel Type Filter
    Given Homepage of Zigwheels
    When The User clicks on New Cars
    And The User select Fuel Type filter
    Then The User selcet Fuel Type "<Fuel>"
    And Validate the Displayed result with "<Fuel>"

    Examples: 
      | Fuel   |
      | Diesel |

  Scenario: Validation of Cardekho Webpage
    Given Homepage of Zigwheels
    When User hover on More in Header
    And Select Sell Car to Cardekho Gaadi Store
    Then User is nevigated to the Car dekho home page

  Scenario Outline: Validate Login using Google option with valid email
    Given Homepage of Zigwheels
    When The user clicks on Login button
    Then The user select google as login
    When The user nevigates to login window
    When User enters "<valid_Email>" email
    Then User clicks the Next button
    When User enter the invalid "<Password>"
    Then User clicks the Next button
    Then display the Password error message

    Examples: 
      | valid_Email        | Password |
      | shiavm35@gmail.com | aldh@124 |

  Scenario Outline: validate Login using Facebook with Invalid credentials
    Given Homepage of Zigwheels
    When The user clicks on Login button
    Then select Facebook as login option
    When The user nevigates to login window
    When user Enters Invalid mail/ph "<fbcred>"
    And user Enters Invalid Password "<password>"
    Then clicks Login button
    Then displays the facebook message

    Examples: 
      | fbcred            | password   |
      | werst12@gmail.com | o85348jfej |
      |        9983499384 | o85348jfe  |
