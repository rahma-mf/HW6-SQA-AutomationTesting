@All
Feature: Login

  @Login @Valid_Login
  Scenario: Login Valid user
	Given User is on login page
	When  User enter the valid credentials
	And   User click login button
	Then  User verify login result

	@Invalid_Login
  Scenario: Login Invalid user
	Given User is on login page
	When  User enter the invalid credentials
	And   User click login button
	Then  User get error message
