@tag
Feature: Successful Login

  Scenario Outline: Check login is successful with valid credential
    Given User is on Home Page
    When User click on the Login button
    And enter the valid "<username>" and "<password>"
    Then click on the Login button
    And close the browser

    Examples: 
      | username   | password    |
      | Kartik1106 | Jaishreeram |
      | kartik123  | sharma123   |
