
Feature: Home Page Form Validation and Navigation
  Scenario Outline: Validate Home Page Elements and Navigate to Manmandir Boys Hostel
    Given the user launches the home page application
    Then  the user validates the presence of the home page logo
    And   the user verifies the displayed mobile and email contact information
    And   the user hovers over the PG Location button
    When  the user clicks on Manmandir Boys Hostel
    Then  the user should be navigated to the details page for Manmandir Boys Hostel
    Then  the user should scroll to the Schedule a visit form
    And   the user should fill out the form "<firstname>","<lastname>","<email>","<mobile>","<Select_Gender>","<i_am>","<duration>",<date>,"<message>"
    Examples:
       |firstname|lastname|email|mobile|Select_Gender|i_am|duration|date|message|
       |Sergio|Perez|spf1@gmail.com|123123123|Male|Other|More than 6 months|23|Testing automation|

  Scenario: Compare words with the text of web elements
    Given the user already completed the form
    When The user gets a list of all the amenities
    Then the user will compare the text of the elements should match the following words:
      | expectedWords                                                                                                                                                                       |
      | Free Wifi,  FIRE SAFETY,LIFT FACILITY, CAR PARKING,24*7 ELECTRICITY,LAUNDRY,COOKING,AIR CONDITIONER, 24*7 WATER,ELECTRICITY INCLUDED IN RENT,FRIDGE, GYSER,CCTV, TWO WHEELER PARKING|
    And The user will click on the logo get to the home page again

  Scenario: Validate Home Page Insta logo and form
    Given the user is back to the home page
    Then The user will click on the instagram logo
    When The user is on instragram he would validate the logo
    And  The user should close the instagram page and go back to the home page
    When The user is back to the home page
    Then The user will click on the Schedule a visit
    And The user will validated the form label


