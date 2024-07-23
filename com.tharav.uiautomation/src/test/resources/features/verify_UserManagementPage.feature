@UsermanagementRoles @Tharav
Feature: User Management Create Role
   Check the usermanagement functionality to create a new role

  Background: Open the Tharav URL
    Given user open  the URL for UserManagement
    And Validate the page is Tharav URL for UserManagement

  @smoke @regression @positive @createrole
  Scenario Outline: Verify the user can create a new role
    Given Login in the application with valid credentials
    And click on the UserMangement menu
    Then Validate  I can see the usermanagement page
    When click on the create role button
    And Enter the valid Rolename
    And Enter the valid Role Description
    And Select the system role
    And select the permissions
    And click on the create role button to save the role
    Then validate the role name is in the list
    And logout of the Tharav application

  @regression @negativerolename
  Scenario Outline: Verify the Rolename with Empty,Maxlength,Minlength,Consecutive spaces,only fullstop,.at start
    Given Login in the application with valid credentials
    And click on the UserMangement menu
    Then Validate  I can see the usermanagement page
    When click on the create role button
    Then Enter the invalid rolename <rolename>
    And Enter the valid Role Description
    And Select the system role
    And select the permissions
    Then click on the create role button to save the role
    And validate the  inlinealert with the <actualmessage>
    And logout of the Tharav application

    Examples: 
      | rolename | actualmessage                                |
      |          | Enter Role Name                              |
      | min      | Enter Role Name Min of 3 Characters Required |
      | max      | Role Name max length is not greater than 50  |

  # | Consecutive   spaces                                 |                                              |
  #| .fullstop                                            |                                              |
  #| ....                                                 |                                              |
  @regression @negativeroledesc
  Scenario Outline: Verify the Roledescription with empty and Maxlength
    Given Login in the application with valid credentials
    And click on the UserMangement menu
    Then Validate  I can see the usermanagement page
    When click on the create role button
    And Enter the valid Rolename
    And Enter the Invalid Role Description <roledescription>
    And Select the system role
    And select the permissions
    Then click on the create role button to save the role
    And validate the  inlinealert with the <actualmessage>
    And logout of the Tharav application

    Examples: 
      | roledescription | actualmessage                                       |
      | empty           | Enter the Role Description                          |
      | max             | Role Description max length is not greater than 256 |

  @regression @negativesystemrole
  Scenario Outline: Verify the SystemRole with empty select
    Given Login in the application with valid credentials
    And click on the UserMangement menu
    Then Validate  I can see the usermanagement page
    When click on the create role button
    Then Enter the valid Rolename
    Then Enter the valid Role Description
    And select the permissions
    Then click on the create role button to save the role
    And validate the  inlinealert of systemrole with the <actualmessage>
    And logout of the Tharav application

    Examples: 
      | Systemrole | actualmessage              |
      | empty      | Please Select System Roles |

  @smoke @regression @positive @deleterole
  Scenario Outline: Verify the user can delete a new role
    Given Login in the application with valid credentials
    And click on the UserMangement menu
    Then Validate  I can see the usermanagement page
    When click on the create role button
    And Enter the valid Rolename
    And Enter the valid Role Description
    And Select the system role
    And select the permissions
    And click on the create role button to save the role
    Then validate the role name is in the list
    And click on the Delete option
    # Then validate the role name is deleted in the list
    And logout of the application

  @smoke @regression @positive @Updaterole
  Scenario Outline: Verify the user can update a  role
    Given Login in the application with valid credentials
    And click on the UserMangement menu
    Then Validate  I can see the usermanagement page
    When click on the create role button
    And Enter the valid Rolename
    And Enter the valid Role Description
    And Select the system role
    And select the permissions
    And click on the create role button to save the role
    Then validate the role name is in the list
    And click on the update option
    And update the Role description and role name
    And click on the update role button to save the role
    # Then validate the role name is in the list
    And logout of the application

  @smoke @regression @positive @Roleswithallpermissions
  Scenario Outline: Verify the user can create a new role of account admin with all the permissions
    Given Login in the application with valid credentials
    And click on the UserMangement menu
    Then Validate  I can see the usermanagement page
    When click on the create role button
    And Enter the valid Rolename
    And Enter the valid Role Description
    And Select the system role of all roles <Systemrole>
    And select all the permissions
    And click on the create role button to save the role
    Then validate the role name is in the list
    And logout of the application

    Examples: 
      | Systemrole    |
      | Account admin |
      | System admin  |
      | Product admin |
      | Guest         |
