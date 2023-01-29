Feature: Search Functionality

Scenario: User searches a valid product
Given User Opens the Application
When User Enters valid product "HP" into search box field
And User clicks on Search button
Then User should get valid product displayed in search results

Scenario: User searches a invalid product
Given User Opens the Application
When User Enters invalid product "Honda" into search box field
And User clicks on Search button
Then User should get Message about No product matching

Scenario: User searches without entering any product
Given User Opens the Application
When User Dont Enter any product insearch box field
And User clicks on Search button
Then User should get Message about No product matching