Feature: Login functionality

Scenario: Login with valid credentials
Given User has to Navigate To LoginPage
When User Enters Valid Email Address "pavankp.ambi@gmail.com" into username text box
And  User Has Entered Valid Password "Pavan@123" into password textbox
And User Clicks on Loginbutton
Then User Should Get Successfully Logged in


Scenario Outline: Login with valid credentials
Given User has to Navigate To LoginPage
When User Enters Valid Email Address <email> into username text box field
And  User Has Entered Valid Password <password> into password textbox field
And User Clicks on Loginbutton
Then User Should Get Successfully Logged in
Examples:
|email|password|
|pavankp.ambi@gmail.com|Pavan@123|
|pavankp.ambi@gmail.com|Pavan@12|


Scenario: Login with Invalid credentials
Given User has to Navigate To LoginPage
When User Enters Invalid Email Address into username text box
And  User Has Entered Invalid Password "Pavan@12" into password textbox
And User Clicks on Loginbutton
Then User Should Get Warning Message


Scenario: Login with Valid username and Invalid password credentials
Given User has to Navigate To LoginPage
When User Enters Valid Email Address "pavankp.ambi@gmail.com" into username text box
And  User Has Entered Invalid Password "Pavan@12" into password textbox
And User Clicks on Loginbutton
Then User Should Get Warning Message

Scenario: Login with Invalid username and Valid password credentials
Given User has to Navigate To LoginPage
When User Enters Invalid Email Address into username text box
And  User Has Entered Valid Password "Pavan@123" into password textbox
And User Clicks on Loginbutton
Then User Should Get Warning Message


Scenario: Login without credentials
Given User has to Navigate To LoginPage
When User Dont Enter Email into username text box
And  User Dont Enter Password into password textbox
And User Clicks on Loginbutton
Then User Should Get Warning Message