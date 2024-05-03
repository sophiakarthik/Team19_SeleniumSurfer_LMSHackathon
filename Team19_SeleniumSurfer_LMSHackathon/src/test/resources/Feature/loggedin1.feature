Feature: feature file for login functionality

  Scenario: Admins logs in with valid username and password
    Given Admins is on login page
    When Admins enters the Username "sdetorganizers@gmail.com"
    And Admins enters the password "UIHackathon@02"
    And Admins clicks on the login button
   And Admin clicks on Program
    
