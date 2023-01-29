Feature: Registration Functionality

Scenario: User creates an account only with mandatory fields
Given User Navigates to Registration Page
When User Enters the details into below Fields
|FirstName|Pavan|
|LastName|KP|
|Telephone|9739369963|
|Password|12345|
|PasswordConfirm|12345|
And User Selects Privacy Policy
And User Clicks On ContinueButton
Then User Account Should get Created


Scenario: User creates an account with All fields
Given User Navigates to Registration Page
When User Enters the details into below Fields with new Email
|FirstName|Pavan|
|LastName|KP|
|Telephone|9739369963|
|Password|12345|
|PasswordConfirm|12345|
And User Selects YES for NewsLetter RadioButton
And User Selects Privacy Policy
And User Clicks On ContinueButton
Then User Account Should get Created


Scenario: User creates an Duplicate Account
Given User Navigates to Registration Page
When User Enters the details into below Fields with existing Email
|FirstName|Pavan|
|LastName|KP|
|Telephone|9739369963|
|Password|12345|
|PasswordConfirm|12345|
|Email|pavankp.ambi@gmail.com|
And User Selects YES for NewsLetter RadioButton
And User Selects Privacy Policy
And User Clicks On ContinueButton
Then User Must get Proper Warning Message


Scenario: User creates an Account Without Filling Any Details
Given User Navigates to Registration Page
When User Dont Enter any details into below Fields
And User Clicks On ContinueButton
Then User Must get Proper Warning Messages For All Mandatory Fields

