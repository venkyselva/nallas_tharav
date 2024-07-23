@Login @Tharav
Feature: Login Functionality
  Check my Login Functionality are working as excepted

  Background: Open the Tharav URL
    Given user open  the URL
    And Validate the page is Tharav URL

  @smoke @regression @positive
  Scenario Outline: Verify the user Sign in with valid credentials
    When Enter the valid <username> and <password> credentials
    And click on the signin button
    And Verfiy i can see the dashboard page
    Then Logout the Tharav application

    Examples: 
      | username            | password   |
      #| naliniadmin@nallas.com | Tharav@123 |
      | nalinimu@nallas.com | Nal@Tha@#123# |

  @negative
  Scenario Outline: Verfiy the user signin with invalid login credentials
    When Enter the Invalid <username> and <password> credentials
    And click on the signin button
    Then validate the login error <message>

    Examples: 
      | username            | password   | message                                                                    |
      | nalinimu@nallas.com | Tharav@12  | Incorrect password. Please try again.                                      |
      | nalinim@nallas.com  | Tharav@123 | Couldn't find your email address. Please register to create a new account. |

  @negative
  Scenario Outline: Verfiy the user signin with invalid Email  login credentials of inline alert
    When Enter the Invalid <username> and <password> credentials
    And click on the signin button
    And Validate the error inline alert <message>

    Examples: 
      | username           | password    | message           |
      |                    | Tharav@12   | Enter Email       |
      | nalinimunallas.com | Tharav@123  | Enter Valid Email |
      | nalinimu@nallascom | Tharav@123  | Enter Valid Email |
      | nalinimunallaascom | Tharav@1234 | Enter Valid Email |

  @showicon @negative
  Scenario Outline: Verify the Show  Password functionality
    When Enter the valid <username> and <password> credentials
    And click on the show and Hide Icon
    Then validate the user can show the text in password text <password>

    Examples: 
      | username               | password   |
      | naliniadmin@nallas.com | Tharav@123 |

 # @Registration @positive
 # Scenario: Verify the user navigate to Registration Page when link is clicked
 #   Given when user clicks on Register link
  #  Then Validate the user can see the Registration page
