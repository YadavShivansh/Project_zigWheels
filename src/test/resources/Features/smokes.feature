Feature: ZigWheels smokes

  @Sanity @smoke
  Scenario: Fundamental Elements Validation
    Given Homepage of ZigWheels
    Then ZigWheels logo should be displayed
    And Searchbox should be displayed
    And Login button should be displayed
    And scrollbar is present

  @Smoke
  Scenario Outline: Varification of NewBikes DropDown
    Given Homepage of ZigWheels
    When User hover on New Bikes Dropdown
    Then Dropdown options Should be displayed
    When user clicks on the "<Bike Category>"
    Then user is nevigated to the upcoming bikes page
    When user  mapulated to the manufacturer dropdown
    Then user select "<Manufacturer_name>"
    When User scroll and click View More
    Then List of the bikes is displayed

    Examples: 
      | Manufacturer_name | Bike Category  |
      | Honda             | Upcoming Bikes |

  @Smoke
  Scenario Outline: Displays used Cars in perticular location 
    Given Homepage of ZigWheels
    When User hover on Used Cars
    And User select "<Location>" in Location options
    Then User is nevigated to the Used Cars page 
    When User scroll till list of popular Brands
    Then User scoll popular model list 
    Then User selects brands and displays cars list

    Examples: 
      | Location |
      | Chennai  |

  @Smoke
  Scenario Outline: Validate Login using Google option with invalid credential
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
