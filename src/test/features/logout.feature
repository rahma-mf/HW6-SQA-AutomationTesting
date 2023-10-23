Feature: Logout

  @logout
  Scenario: Logout successful
	Given user is on homepage
	When user click burger button
	Then user logout was successful