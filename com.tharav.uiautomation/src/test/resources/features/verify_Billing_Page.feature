@Billing
Feature: Billing functionality

  @smoke @regression
  Scenario: Verify the user land successfully on billing  page with valid login credentials
    Given I open the tharav url in browser
    And I  enter the valid  <username> and <password> credentials
    When I click on signup
    When verify  I am landed in dashboard  page
    Then I  click on Billing link
    And verfiy  I am in billing page
    Then I should see the billing page and text as "Billing"

  Scenario: Verify the user navigate to subscription tab
    Given verfiy i am in subscription tab
    When Verify  I can see company name as "datacat"
    Then I can click  on the contact sales to upgrade

  Scenario: Verify the user navigate to usage tab
    Given when i click on usage tab
    When I Verify see  "Yearly Credit" and "Daily Credit"
    Then logout of the application
