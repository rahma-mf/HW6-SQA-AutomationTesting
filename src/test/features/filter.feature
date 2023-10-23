Feature: Filter Products

  @Login @Filter1
  Scenario: Filter products by name (Z to A)
	Given User on the product list page
	When User filter products by name (Z to A)
	Then User should see product list by name (Z to A)
