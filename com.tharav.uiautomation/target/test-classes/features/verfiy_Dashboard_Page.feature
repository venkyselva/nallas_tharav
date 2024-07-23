@Dashboard @Tharav
Feature: Dashboard functionality

  @smoke @regression
  Scenario: Verify the user land on dashboard page on entering valid login credentials
    Given I open the tharav url
    And I enter the valid  username and password
    And I click on signup button
    When verify  I am in  Dashboard page
    Then I  should see the dashboard page details and text as "Dashboard"
    And logout of the application
