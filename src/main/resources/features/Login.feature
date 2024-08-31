Feature: Login functionality

  @End2EndTest @RegressionTest
  Scenario: Successful login with valid credentials
    Given I am on the OrangeHRM login page
    When I enter a valid username and password
    And I click on the login button
    Then I should be redirected to the dashboard

  @RegressionTest
  Scenario: Unsuccessful login with invalid username
    Given I am on the OrangeHRM login page
    When I enter an invalid username and a valid password
    And I click on the login button
    Then I should see an error message for invalid credentials
