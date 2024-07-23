@UsermanagementUsers @Tharav
Feature: User Management Create User
   Check the usermanagement functionality to create a new User

  Background: Open the Tharav URL
    Given user open  the URL for UserManagement
    And Validate the page is Tharav URL for UserManagement

  @smoke @regression @positive @createuser
  Scenario Outline: Verify the user can create a new User
    Given Login in the application with valid credentials
    And click on the UserMangement menu
    Then Validate  I can see the usermanagement page
    When click on the create user button
    And Enter the valid Firstname
    And Enter the valid Lastname
    And Enter the Email - id
    And Enter the SystemRole
    And Enter the Role
    And click on the create user button to save the user
    Then validate the User name is in the list
    And logout of the application

  @smoke @regression @negative @Invalidfirstname
  Scenario Outline: Verify the user can create a new User with Invalid firstname
    Given Login in the application with valid credentials
    And click on the UserMangement menu
    Then Validate  I can see the usermanagement page
    When click on the create user button
    And Enter the invalid Firstname <Firstname>l
    And Enter the valid Lastname
    And Enter the Email - id
    And Enter the SystemRole
    And Enter the Role
    And click on the create user button to save the user
    And validate the inlinealerts with the <actualmessage>
    And logout of the application

    Examples: 
      | Firstname | actualmessage                                 |
      | empty     | Enter First Name                              |
      | max       | First Name max length is not greater than 30  |
      | min       | Enter First Name Min of 3 Characters Required |

  @smoke @regression @negative @Invalidlastname
  Scenario Outline: Verify the user can create a new User with Invalid Lastname
    Given Login in the application with valid credentials
    And click on the UserMangement menu
    Then Validate  I can see the usermanagement page
    When click on the create user button
    And Enter the valid Firstname
    And Enter the invalid Lastname <Lastname>
    And Enter the Email - id
    And Enter the SystemRole
    And Enter the Role
    And click on the create user button to save the user
    And validate the inlinealerts with the <actualmessage>
    And logout of the application

    Examples: 
      | Lastname | actualmessage                               |
      | max      | Last Name max length is not greater than 30 |

  @smoke @regression @negative @Invalidemail
  Scenario Outline: Verify the user can create a new User with Invalid Email - ID
    Given Login in the application with valid credentials
    And click on the UserMangement menu
    Then Validate  I can see the usermanagement page
    When click on the create user button
    And Enter the valid Firstname
    And Enter the valid Lastname
    And Enter the invalid Emailid <E-mail>
    And Enter the SystemRole
    And Enter the Role
    And click on the create user button to save the user
    And validate the inlinealerts with the <actualmessage>
    And logout of the application

    Examples: 
      | E-mail        | actualmessage     |
      | Tharav@sdfsdf | Enter Valid Email |
      | Nallas.com    | Enter Valid Email |

  @smoke @regression @negative @InvalidSystemRole
  Scenario Outline: Verify the user can create a new User with empty System Role
    Given Login in the application with valid credentials
    And click on the UserMangement menu
    Then Validate  I can see the usermanagement page
    When click on the create user button
    And Enter the valid Firstname
    And Enter the valid Lastname
    And Enter the Email - id
    #And Enter the SystemRole
    #And Enter the Role
    And click on the create user button to save the user
    And validate the inlinealerts with the <actualmessage>
    And logout of the application

    Examples: 
      | Systemrole | actualmessage              |
      | empty      | Please Select System Roles |

  @smoke @regression @positive @deleteuser
  Scenario Outline: Verify the user can delete a new user
    Given Login in the application with valid credentials
    And click on the UserMangement menu
    Then Validate  I can see the usermanagement page
    When click on the create user button
    And Enter the valid Firstname
    And Enter the valid Lastname
    And Enter the Email - id
    And Enter the SystemRole
    And Enter the Role
    And click on the create user button to save the user
    Then validate the User name is in the list
    And click on the Delete option of user
    # Then validate the role name is deleted in the list
    And logout of the application

  @smoke @regression @positive @Updateuser
  Scenario Outline: Verify the user can update a user
    Given Login in the application with valid credentials
    And click on the UserMangement menu
    Then Validate  I can see the usermanagement page
    When click on the create user button
    And Enter the valid Firstname
    And Enter the valid Lastname
    And Enter the Email - id
    And Enter the SystemRole
    And Enter the Role
    And click on the create user button to save the user
    Then validate the User name is in the list
    Then click on the Edit option of user
    And update the Firstname and Lastname
    And click on the update user button to save the role
    # Then validate the role name is in the list
    And logout of the application
