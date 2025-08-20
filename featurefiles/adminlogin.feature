@tag
Feature: ADMIN LOGIN
  I Want To use This Template for Admin Login With Valid and Invalid Credentials
Background:
		Given i open browser with url "http://orangehrm.qedgetech.com"
    Then i should see login page
  @tag1
  Scenario: Check Admin Login With VALID CREDENTIALS
    When i enter user name as "Admin"
    And i enter password as "Qedge123!@#"
    And i click login
    Then i should see admin module
    When i click logout
    Then i should see login page
    When i close browser
    
	@tag2
  Scenario Outline: Check Admin Login With INVALID CREDENTIALS
    When i enter user name as "<username>"
    And i enter password as "<password>"
    And i click login 
    Then i should see errormessage
    When i close browser   
    
    Examples: 
      |username|password    |
      |Admin   |asdff       | 
      | xyq	   |Qedge123!@# |
      |			   |Qedge123!!@#|
      |XYZ     |            |
      |        |            |
      |Admin   |            |
 