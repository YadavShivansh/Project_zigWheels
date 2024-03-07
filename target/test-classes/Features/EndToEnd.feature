Feature: ZigWheels End To End

  Scenario Outline: Zigwheels Web app functionalities
  
    Given Homepage of ZigWheels
    Then ZigWheels logo should be displayed
    And Searchbox should be displayed
    And Login button should be displayed
    And scrollbar is present
    
    When User hover on New Bikes Dropdown
    Then Dropdown options Should be displayed
    When user clicks on the "<Bike Category>"
    Then user is nevigated to the upcoming bikes page
    When user  mapulated to the manufacturer dropdown
    Then user select "<Manufacturer_name>" 
    When User scroll and click View More
    Then List of the bikes is displayed
    
    Given User is nevigated back to Zigwheels homepage
    When user Hover on Used Cars
    Then Dropdown is displayed
    When User Clicks on the search Bar
    Then Search Options is displayed
    
    Given User is nevigated back to ZigWheels homepage
    When User hover on Used Cars
    And User select "<Location>" in Location options
    Then User is nevigated to the Used Cars page 
    When User scroll till list of popular Brands
    Then User scoll popular model list 
    Then User selects brands and displays cars list
    
    
    
    Given User is nevigated back to Zigwheels homepage
    When the User clicks on New Bikes
    And the user clicks displacement filter
    Then the user selects bike a displacement range "<range>"
    Then Displays Bike name and Displacement
    
    Given User is nevigated back to Zigwheels homepage
    When The User clicks on New Cars
    And The User select Fuel Type filter
    Then The User selcet Fuel Type "<Fuel>"
    And Validate the Displayed result with "<Fuel>"
    
    Given User is nevigated back to Zigwheels homepage
    When User hover on More in Header
    And Select Sell Car to Cardekho Gaadi Store
    Then User is nevigated to the Car dekho home page

    Examples: 
      | Manufacturer_name | Bike Category  | Location | brands     |     range         | Fuel   |
      | Honda             | Upcoming Bikes | Chennai  | Maruti 800 |126cc - 150cc bikes| Diesel |

 
  Scenario Outline: Google login with Invalid mail 
    Given Homepage of ZigWheels
    When user clicks on Login button
    Then select google as login
    When user nevigates to login window
    Then User enter "<Invalid_Email>" email
    And click the Next button
    Then display the Error message
    
  Examples: 
    | Invalid_Email    |
    | werwer_gmail.com |
    
  Scenario Outline:  Google login with Valid mail  
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

  Scenario Outline: Facebook login Validations
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
			|    9983499384     | o85348jfe  |