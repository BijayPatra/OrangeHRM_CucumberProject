@tag
Feature: NEW EMPLOYEE REGISTRATION
  I want to use this template for new Employee Registration

  @tag1
  Scenario: New Employee Registration with VALID INPUTS
  
    Given i open browser with url "http://orangehrm.qedgetech.com"
    Then i should see login page
    When i enter user name as "Admin"
    And i enter password as "Qedge123!@#"
    And i click login
    Then i should see admin module
    When i goto add employee page
    And i enter firstname as "<fname>"
    And i enter lasname as "<lname>"
    And i click save
    Then i should see new employee registered in employee list
    When i click logout
    Then i should see login page
    When i close browser

    Examples: 
      |fname   |lname  |
      |James   |Demo   | 
      |Smith	 |Hajari |
 