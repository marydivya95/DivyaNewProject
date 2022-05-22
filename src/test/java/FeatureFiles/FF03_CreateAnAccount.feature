Feature: Create an Account
  Scenario Outline: Creating an account with valid data
    Given User navigates to Create an account screen
    Then Enter Valid "<FirstName>", "<LastName>", "<emailAddress>"
    Examples:
    |FirstName|LastName|emailAddress|
    |FirstName01|LastName01|test01@gmail.com|
    |FirstName02|LastName02|test02@gmail.com|